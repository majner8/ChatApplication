package antoninBicak.chatApplication.restAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import antoninBicak.chatApplication.dto.userProfileDTO;
import antoninBicak.chatApplication.dto.userSearchProfileDTO;
import antoninBicak.chatApplication.relationalDatabase.services.UserDatabaseService;
import antoninBicak.chatApplication.security.jwtTokenService;
import antoninBicak.chatApplication.util.SessionRequestData;

public class UserFacadeController {
	@Autowired
	private jwtTokenService jwtTokenService;
	@Autowired
	private UserDatabaseService userDatabaseService;
	
	public void updateUserProfile(SessionRequestData sessionData,userProfileDTO dto) {
		this.userDatabaseService.updateUserProfile(sessionData,dto);
		this.jwtTokenService.logout(sessionData, true);
		return;
	}


	public List<userSearchProfileDTO> searchUser(SessionRequestData sessionData,String firstName, String lastName, boolean similar) {
		List<userSearchProfileDTO> result=this.userDatabaseService.findUser(firstName, lastName, similar);
		return result;
	}


	public userSearchProfileDTO getUserProfile(SessionRequestData sessionData,long userID) {
		userSearchProfileDTO result=this.userDatabaseService.getUserProfile(userID);
		return result;
	}
}
