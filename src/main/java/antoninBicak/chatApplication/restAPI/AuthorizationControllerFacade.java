package antoninBicak.chatApplication.restAPI;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import antoninBicak.chatApplication.dto.AuthorizationDTO;
import antoninBicak.chatApplication.dto.FinishRegistrationDTO;
import antoninBicak.chatApplication.dto.PasswordDTO;
import antoninBicak.chatApplication.dto.TokenDTO;
import antoninBicak.chatApplication.relationalDatabase.services.AuthorizationDatabaseService;
import antoninBicak.chatApplication.relationalDatabase.services.AuthorizationDatabaseService.AuthorizationResultDTO;
import antoninBicak.chatApplication.security.jwtTokenService;
import antoninBicak.chatApplication.security.jwtToken.jwtTokenGenerator;
import antoninBicak.chatApplication.util.SessionRequestData;

public class AuthorizationControllerFacade {
	@Autowired
	private jwtTokenService jwtTokenService;
	@Autowired
	private AuthorizationDatabaseService databaseService;
	@Autowired 
	
	public Optional<TokenDTO> login(AuthorizationDTO authorization) {
		Optional<AuthorizationResultDTO>result=this.databaseService.login(authorization);
		if(!result.isPresent()) {
			return Optional.empty();
		}
		AuthorizationResultDTO r=result.get();
		TokenDTO token=this.jwtTokenService.generateToken(r.getUserID(), r.getVersion());
		return Optional.of(token);
	}

	public Optional<TokenDTO> register(AuthorizationDTO authorization) {
		Optional<AuthorizationResultDTO>result=this.databaseService.register(authorization);
		if(result.isEmpty()) {
			return Optional.empty();
		}
		AuthorizationResultDTO r=result.get();
		TokenDTO token=this.jwtTokenService.generateToken(r.getUserID(), r.getVersion());
		return Optional.of(token);
	}

	public void changePassword(PasswordDTO passwordDTO,SessionRequestData sessionData) {
		this.databaseService.changePassword(passwordDTO, sessionData);
		this.logoutAll(sessionData);
	}

	public void finishRegistration(FinishRegistrationDTO dto,SessionRequestData sessionData) {
		this.databaseService.finishRegistration(dto, sessionData);
	}

	public void logout(SessionRequestData sessionData) {
		this.jwtTokenService.logout(sessionData, false);
	}

	public void logoutAll(SessionRequestData sessionData) {
		this.jwtTokenService.logout(sessionData, true);

	}
}
