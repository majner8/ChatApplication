package antoninBicak.chatApplication.restAPI.facade;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import antoninBicak.chatApplication.dto.authorization.AuthorizationDTO;
import antoninBicak.chatApplication.dto.authorization.FinishRegistrationDTO;
import antoninBicak.chatApplication.dto.authorization.PasswordDTO;
import antoninBicak.chatApplication.dto.authorization.TokenDTO;
import antoninBicak.chatApplication.security.jwtToken.jwtTokenGenerator;
import antoninBicak.chatApplication.security.services.AuthorizationDatabaseService;
import antoninBicak.chatApplication.security.services.AuthorizationDatabaseService.AuthorizationResultDTO;

public class AuthorizationControllerFacade {
	@Autowired
	private jwtTokenGenerator jwtGenerator;
	@Autowired
	private AuthorizationDatabaseService databaseService;
	public Optional<TokenDTO> login(AuthorizationDTO authorization) {
		Optional<AuthorizationResultDTO>result=this.databaseService.login(authorization);
		if(result.isEmpty()) return Optional.empty();
		AuthorizationResultDTO r=result.get();
		TokenDTO token=this.jwtGenerator.generateToken(r.getUserID(), r.getVersion());
		return Optional.of(token);
	}

	public Optional<TokenDTO> register(AuthorizationDTO authorization) {	
		Optional<AuthorizationResultDTO>result=this.databaseService.register(authorization);
		if(result.isEmpty()) return Optional.empty();
		AuthorizationResultDTO r=result.get();
		TokenDTO token=this.jwtGenerator.generateToken(r.getUserID(), r.getVersion());
		return Optional.of(token);
	}

	public void changePassword(PasswordDTO passwordDTO) {
		this.databaseService.changePassword(passwordDTO);
		this.logoutAll();
	}

	public void finishRegistration(FinishRegistrationDTO dto) {
		this.databaseService.finishRegistration(dto);
	}

	public ResponseEntity<?> logout() {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<?> logoutAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
