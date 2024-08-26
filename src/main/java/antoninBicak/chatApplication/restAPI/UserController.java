package antoninBicak.chatApplication.restAPI;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import antoninBicak.chatApplication.dto.userProfileDTO;
import antoninBicak.chatApplication.dto.userSearchProfileDTO;

@RestController
public class UserController{


	public ResponseEntity<?> updateUserProfile(userProfileDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}


	public ResponseEntity<List<userSearchProfileDTO>> searchUser(String serName, String lastName, boolean similar) {
		return null;
	}


	public ResponseEntity<userSearchProfileDTO> getUserProfile(long userID) {
		return null;

	}

}
