package antoninBicak.chatApplication.restAPI;

import java.net.URI;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import antoninBicak.chatApplication.dto.AuthorizationDTO;
import antoninBicak.chatApplication.dto.FinishRegistrationDTO;
import antoninBicak.chatApplication.dto.PasswordDTO;
import antoninBicak.chatApplication.dto.TokenDTO;
import antoninBicak.chatApplication.util.SessionRequestData;

@RestController
public class AuthorizationController {

	@Value("getUserCreditals")
	private String getUserAuthorization;
	
	@Autowired
	private AuthorizationControllerFacade facade;

	public ResponseEntity<?> login(AuthorizationDTO authorization) {
		Optional<TokenDTO> result=this.facade.login(authorization);
		if(!result.isPresent()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		TokenDTO token=result.get();
		if(!token.isUserFinishRegistration()) {
		return	ResponseEntity
			.status(HttpStatus.FORBIDDEN).body(token);
		}
		return	ResponseEntity
				.status(HttpStatus.OK).body(token);
	
		
		
	}

	public ResponseEntity<?> register(AuthorizationDTO authorization) {	
	
		Optional<TokenDTO> result=this.facade.register(authorization);
		if(!result.isPresent()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		TokenDTO token=result.get();
		 URI location = ServletUriComponentsBuilder
				 .fromPath(getUserAuthorization)
				 .buildAndExpand(token.getUserID()).toUri();
		 return ResponseEntity.created(location).body(token);
	}

	public ResponseEntity<?> changePassword(SessionRequestData sessionData,PasswordDTO passwordDTO) {
		this.facade.changePassword(passwordDTO, sessionData);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	public ResponseEntity<?> finishRegistration(SessionRequestData sessionData,FinishRegistrationDTO dto) {
		this.facade.finishRegistration(dto, sessionData);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	public ResponseEntity<?> logout(SessionRequestData sessionData) {
		this.facade.logout(sessionData);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	public ResponseEntity<?> logoutAll(SessionRequestData sessionData) {
		this.facade.logoutAll(sessionData);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	public ResponseEntity<?> getUserCredialt(SessionRequestData sessionData, long userID) {
		this.facade.logoutAll(sessionData);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	
}
