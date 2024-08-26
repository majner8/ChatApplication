package antoninBicak.chatApplication.restAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import antoninBicak.chatApplication.dto.AddUserToChatDTO;
import antoninBicak.chatApplication.dto.ChatInformationDTO;
import antoninBicak.chatApplication.dto.ChatNameDTO;
import antoninBicak.chatApplication.dto.ChatPermissionDTO;
import antoninBicak.chatApplication.dto.CreateChatDTO;
import antoninBicak.chatApplication.dto.LeaveUserFromChatDTO;
import antoninBicak.chatApplication.dto.UserChatNameDTO;
import antoninBicak.chatApplication.util.SessionRequestData;
@RestController
public class ChatAdministrationController {

	@Autowired
	private ChatAdministrationControllerFacade facade;
	
	public ResponseEntity<?> changeChatName(SessionRequestData requestData,String chatID, ChatNameDTO chatName) {
		this.facade.changeChatName(chatID, chatName, requestData);
		return ResponseEntity.ok().build();
	}

	public ResponseEntity<?> changeUserChatNickName(SessionRequestData requestData,String chatID, long userID, UserChatNameDTO userNickName) {
		this.facade.changeUserChatNickName(chatID, userID, userNickName, requestData);
		return ResponseEntity.ok().build();
	}


	public ResponseEntity<?> addUserToChat(SessionRequestData requestData,String chatID, AddUserToChatDTO userID) {
		this.facade.addUserToChat(chatID, userID, requestData);
		return ResponseEntity.ok().build();
	}

	public ResponseEntity<?> kickUserFromChat(SessionRequestData requestData,String chatID, LeaveUserFromChatDTO userID, long kickBy) {
		this.facade.kickUserFromChat(chatID, userID, kickBy, requestData);
		return ResponseEntity.ok().build();
	}

	public ResponseEntity<?> leaveUserFromChat(SessionRequestData requestData,String chatID, LeaveUserFromChatDTO userID) {
		this.facade.leaveUserFromChat(chatID, userID, requestData);
		return ResponseEntity.ok().build();
	}


	public ResponseEntity<?> addPermission(SessionRequestData requestData,String chatID, long userID, ChatPermissionDTO permission) {
		this.facade.addPermission(chatID, userID, permission, requestData);
		return ResponseEntity.ok().build();
	}

	public ResponseEntity<?> removePermission(SessionRequestData requestData,String chatID, long userID, ChatPermissionDTO permission) {
		this.facade.removePermission(chatID, userID, permission, requestData);
		return ResponseEntity.ok().build();
	}

	public ResponseEntity<?> createChat(SessionRequestData requestData,CreateChatDTO dto) {
		this.facade.createChat(dto, requestData);
		return ResponseEntity.ok().build();
	}
	
	public ResponseEntity<ChatInformationDTO> getChatInformation(String chatID) {
		// TODO Auto-generated method stub
		return null;
	}
}
