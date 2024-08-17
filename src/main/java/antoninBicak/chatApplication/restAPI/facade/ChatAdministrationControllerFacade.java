package antoninBicak.chatApplication.restAPI.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import antoninBicak.chatApplication.dto.chat.AddUserToChatDTO;
import antoninBicak.chatApplication.dto.chat.ChatNameDTO;
import antoninBicak.chatApplication.dto.chat.ChatPermissionDTO;
import antoninBicak.chatApplication.dto.chat.CreateChatDTO;
import antoninBicak.chatApplication.dto.chat.LeaveUserFromChatDTO;
import antoninBicak.chatApplication.dto.chat.UserChatNameDTO;
import antoninBicak.chatApplication.relationalDatabase.services.ChatDatabaseService;
import antoninBicak.chatApplication.security.ChatPermission;
import antoninBicak.chatApplication.security.accessValidator.CheckChatAccess;

public class ChatAdministrationControllerFacade {
	
	@Autowired
	private ChatDatabaseService databaseService;
	
	@CheckChatAccess(role=ChatPermission.Admin)
	public void changeChatName(String chatID, ChatNameDTO chatName) {
		this.databaseService.changeChatName(chatID, chatName.getChatName());
		
	}
	
	@CheckChatAccess(role=ChatPermission.Admin,allowItself=true)
	public ResponseEntity<?> changeUserChatNickName(String chatID, long userID, UserChatNameDTO userNickName) {
		// TODO Auto-generated method stub
		return null;
	}

	@CheckChatAccess(role=ChatPermission.Admin)
	public ResponseEntity<?> addUserToChat(String chatID, AddUserToChatDTO userID) {
		// TODO Auto-generated method stub
		return null;
	}
	@CheckChatAccess(role=ChatPermission.Admin)
	public ResponseEntity<?> kickUserFromChat(String chatID, LeaveUserFromChatDTO userID, long kickBy) {
		// TODO Auto-generated method stub
		return null;
	}
	@CheckChatAccess()
	public ResponseEntity<?> leaveUserFromChat(String chatID, LeaveUserFromChatDTO userID) {
		// TODO Auto-generated method stub
		return null;
	}

	@CheckChatAccess(role=ChatPermission.Owner)
	public ResponseEntity<?> addPermission(String chatID, long userID, ChatPermissionDTO permission) {
		// TODO Auto-generated method stub
		return null;
	}
	@CheckChatAccess(role=ChatPermission.Owner)
	public ResponseEntity<?> removePermission(String chatID, long userID, ChatPermissionDTO permission) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<?> createChat(CreateChatDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
}
