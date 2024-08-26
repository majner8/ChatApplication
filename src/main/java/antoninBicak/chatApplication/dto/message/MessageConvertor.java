package antoninBicak.chatApplication.dto.message;

import java.util.List;

import antoninBicak.chatApplication.security.ChatPermission;
import antoninBicak.chatApplication.util.SessionRequestData;

public interface MessageConvertor {

	public MessageDTO createChangeChatNameMessage(SessionRequestData data,String chatID, String chatName);
	
	public MessageDTO createChangeUserChatNickNameMessage(SessionRequestData data,String chatID, String chatName,long affectedUserID,long changeByUserID);

	
	public MessageDTO createUserLeftChatMessage(SessionRequestData data,String chatID, long userID);
	
	public MessageDTO createUserWasKickedMessage(SessionRequestData data,String chatID, long affectedUserID,long kickByUserID);
	
	public MessageDTO createUserWasAddedToChatMessage(SessionRequestData data,String chatID, long affectedUserID,long addedByUserID);

	public MessageDTO createUserGotPermissionMessage(SessionRequestData data,String chatID,ChatPermission permission,long affectedUserID);
	
	public MessageDTO createChat(SessionRequestData data,String chatID, String chatName,long createdBy);

}
