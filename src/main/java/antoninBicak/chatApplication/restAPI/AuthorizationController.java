package antoninBicak.chatApplication.restAPI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import antoninBicak.chatApplication.dto.AuthorizationDTO;
import antoninBicak.chatApplication.dto.FinishRegistrationDTO;
import antoninBicak.chatApplication.dto.PasswordDTO;

@RestController
public class AuthorizationController {

	public ResponseEntity<?> login(AuthorizationDTO authorization) {
		return null;
	}

	public ResponseEntity<?> register(AuthorizationDTO authorization) {		return null;
	}

	public ResponseEntity<?> changePassword(PasswordDTO passwordDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<?> finishRegistration(FinishRegistrationDTO dto) {
		// TODO Auto-generated method stub
		return null;
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
