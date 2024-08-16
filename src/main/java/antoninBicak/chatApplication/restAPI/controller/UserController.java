package antoninBicak.chatApplication.restAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import antoninBicak.chatApplication.dto.user.userProfileDTO;
import antoninBicak.chatApplication.dto.user.userSearchProfileDTO;

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
