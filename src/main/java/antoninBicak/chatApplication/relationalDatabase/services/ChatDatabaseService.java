package antoninBicak.chatApplication.relationalDatabase.services;

import antoninBicak.chatApplication.dto.chat.ChatInformationDTO;
import antoninBicak.chatApplication.dto.chat.CreateChatDTO;
import antoninBicak.chatApplication.security.ChatPermission;

public interface ChatDatabaseService {

	public void changeChatName(String chatID,String chatName);

	public void changeUserChatNickName(String chatID,long affectedUserID,String chatName);
	
	public void addUserToChat(String chatID,long userID);
	
	public void removeUserFromChat(String chatID,long userID);
	
	public void addUserPermission(String chatID, long affectedUserID,ChatPermission permission);
	/**return generated chatID */
	public String createChat(CreateChatDTO dto);
	
	public ChatInformationDTO getChatInformation(String chatID);
}


