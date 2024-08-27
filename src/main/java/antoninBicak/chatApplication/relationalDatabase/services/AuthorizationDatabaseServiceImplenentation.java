package antoninBicak.chatApplication.relationalDatabase.services;

import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.OptimisticLockException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.stereotype.Service;

import antoninBicak.chatApplication.dto.AuthorizationDTO;
import antoninBicak.chatApplication.dto.EmailAuthorizationDTO;
import antoninBicak.chatApplication.dto.FinishRegistrationDTO;
import antoninBicak.chatApplication.dto.PasswordDTO;
import antoninBicak.chatApplication.dto.PhoneAuthorizationDTO;
import antoninBicak.chatApplication.relationalDatabase.entity.UserEntity;
import antoninBicak.chatApplication.relationalDatabase.repository.UserEntityJpaRepository;
import antoninBicak.chatApplication.relationalDatabase.repository.UserEntityJpaRepository.AuthorizationProjection;
import antoninBicak.chatApplication.security.services.HashPassword;
import antoninBicak.chatApplication.util.SessionRequestData;
@Service
public class AuthorizationDatabaseServiceImplenentation implements AuthorizationDatabaseService {

	@Autowired
	private UserEntityJpaRepository repository;
	@Autowired
	private HashPassword hashPassword;

	@Override
	public Optional<AuthorizationResultDTO> login(AuthorizationDTO dto) {
		Optional<AuthorizationProjection> projection=
				switch(dto.getType()) {
				case EmailAuthorization->{
					EmailAuthorizationDTO emailAut=(EmailAuthorizationDTO) dto;
					yield this.repository.findByEmail(emailAut.getEmail());
				}
				case PhoneAuthorization->{
					PhoneAuthorizationDTO phoneAut=(PhoneAuthorizationDTO) dto;
					yield this.repository.findAByPhonePreflixAndPhoneNumber(phoneAut.getCountryPreflix(), phoneAut.getNumber());
					}
				default -> throw new UnsupportedOperationException(
					    String.format("Unsupported AuthorizationDTOEnumType: '%s'. Check and ensure that this type is implemented", dto.getType().name())

						);
				};
				if(projection.isEmpty()) {
					return Optional.empty();
				}
				AuthorizationProjection	 pr=projection.get();
				if(!this.hashPassword.comparePassword(dto.getPassword().getPassword(), pr.getPassword())) {
					return Optional.empty();
				}
				return Optional.of(AuthorizationResultDTO.of(pr.getUserID(), pr.getVersion()));

	}

	@Override
	public Optional<AuthorizationResultDTO> register(AuthorizationDTO dto) {
		Optional<UserEntity> entity=
				switch(dto.getType()) {
				case EmailAuthorization->{
					EmailAuthorizationDTO emailAut=(EmailAuthorizationDTO) dto;
					if(this.repository.existsByEmail(emailAut.getEmail())){yield Optional.empty();}

					UserEntity ent=new UserEntity();
					ent.setEmail(emailAut.getEmail());
					ent.setPassword(this.hashPassword.hashPassword(emailAut.getPassword().getPassword()));
					yield Optional.of(ent);
				}
				case PhoneAuthorization->{
					PhoneAuthorizationDTO phoneAut=(PhoneAuthorizationDTO) dto;
					if(this.repository.existsByPhonePreflixAndPhoneNumber(phoneAut.getCountryPreflix(),phoneAut.getNumber())){yield Optional.empty();}

					UserEntity ent=new UserEntity();
					ent.setPhonePreflix(phoneAut.getCountryPreflix());
					ent.setPhoneNumber(phoneAut.getNumber());
					ent.setPassword(this.hashPassword.hashPassword(phoneAut.getPassword().getPassword()));
					yield Optional.of(ent);					}
				default -> throw new UnsupportedOperationException(
					    String.format("Unsupported AuthorizationDTOEnumType: '%s'. Check and ensure that this type is implemented", dto.getType().name())

						);
				};
				long userID;
				long version;
				try {
					UserEntity ent=this.repository
							.persist(entity.get());
					userID=ent.getUserID();
					version=ent.getVersion();
				} catch (EntityExistsException e) {
					return Optional.empty();
				}
				return Optional.of(AuthorizationResultDTO.of(userID, version));

	}


	@Override
	public void changePassword(PasswordDTO password,SessionRequestData sessionData) {
		long version=sessionData.getAuthorizationVersion();
		long userID=sessionData.getUserID();
		String hashPassword=this.hashPassword.hashPassword(password.getPassword());
		try {
			this.repository.updatePassword(hashPassword, userID, version);
		} catch (OptimisticLockException e) {
            throw new CredentialsExpiredException("Your session has expired because your credentials are no longer valid. Please log in again.", e);
		}
	}

	@Override
	public void finishRegistration(FinishRegistrationDTO dto,SessionRequestData sessionData) {
		try {
			this.repository.updateUserRegistrationData(dto);
		} catch (OptimisticLockException e) {
            throw new CredentialsExpiredException("Your session has expired because your credentials are no longer valid. Please log in again.", e);
		}
	}

}
