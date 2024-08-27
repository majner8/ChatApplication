package antoninBicak.chatApplication.relationalDatabase.services;

import java.util.List;

import antoninBicak.chatApplication.dto.userProfileDTO;
import antoninBicak.chatApplication.dto.userSearchProfileDTO;
import antoninBicak.chatApplication.util.SessionRequestData;

public interface UserDatabaseService {

	/**return false if update would not be sucesfull-optimistic locking */
	public userProfileDTO updateUserProfile(SessionRequestData requestData,userProfileDTO dto);
	
	public List<userSearchProfileDTO> findUser(String serName,String lastName, boolean similar);
	
	public userSearchProfileDTO getUserProfile(long userID);
}
