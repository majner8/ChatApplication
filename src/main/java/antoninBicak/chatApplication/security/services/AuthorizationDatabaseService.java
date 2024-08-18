package antoninBicak.chatApplication.security.services;

import java.util.Optional;

import javax.security.auth.login.CredentialException;

import antoninBicak.chatApplication.dto.authorization.AuthorizationDTO;
import antoninBicak.chatApplication.dto.authorization.FinishRegistrationDTO;
import antoninBicak.chatApplication.dto.authorization.PasswordDTO;
import antoninBicak.chatApplication.util.sessionData.SessionRequestData;
import lombok.AllArgsConstructor;
import lombok.Getter;

public interface AuthorizationDatabaseService {
	public Optional<AuthorizationResultDTO> login(AuthorizationDTO dto);
	public Optional<AuthorizationResultDTO> register(AuthorizationDTO dto);
	public void changePassword(PasswordDTO password,SessionRequestData sessionData);
	public void finishRegistration(FinishRegistrationDTO dto,SessionRequestData sessionData); 
	
	@Getter
	@AllArgsConstructor()
	public static class AuthorizationResultDTO{
		private final long userID;
		private final long version;
		
		public static AuthorizationResultDTO of(long userID,long version) {
			return new AuthorizationResultDTO(userID,version);
		}
	}
}
