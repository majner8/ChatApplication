package antoninBicak.chatApplication.restAPI.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import antoninBicak.chatApplication.chatManagement.MessagePublisherFacade;
import antoninBicak.chatApplication.dto.chat.AddUserToChatDTO;
import antoninBicak.chatApplication.dto.chat.ChatNameDTO;
import antoninBicak.chatApplication.dto.chat.ChatPermissionDTO;
import antoninBicak.chatApplication.dto.chat.CreateChatDTO;
import antoninBicak.chatApplication.dto.chat.LeaveUserFromChatDTO;
import antoninBicak.chatApplication.dto.chat.UserChatNameDTO;
import antoninBicak.chatApplication.dto.message.MessageConvertor;
import antoninBicak.chatApplication.dto.message.MessageDTO;
import antoninBicak.chatApplication.relationalDatabase.services.ChatDatabaseService;
import antoninBicak.chatApplication.security.ChatPermission;
import antoninBicak.chatApplication.security.accessValidator.CheckChatAccess;
import antoninBicak.chatApplication.util.sessionData.SessionRequestData;

public class ChatAdministrationControllerFacade {

	@Autowired
	private ChatDatabaseService databaseService;
	@Autowired
	private MessageConvertor messageConvertor;
	@Autowired
	private MessagePublisherFacade messagePublisher;
	@CheckChatAccess(role=ChatPermission.Admin)
	public void changeChatName(String chatID, ChatNameDTO chatName,SessionRequestData requestData) {
		this.databaseService.changeChatName(chatID, chatName.getChatName());
		MessageDTO mes=this.messageConvertor.createChangeChatNameMessage(chatID, chatName.getChatName());
		this.messagePublisher.sendMessage(mes, requestData);
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
