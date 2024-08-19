package antoninBicak.chatApplication.restAPI.controller;

import org.springframework.http.ResponseEntity;

import antoninBicak.chatApplication.dto.chat.AddUserToChatDTO;
import antoninBicak.chatApplication.dto.chat.ChatNameDTO;
import antoninBicak.chatApplication.dto.chat.ChatPermissionDTO;
import antoninBicak.chatApplication.dto.chat.CreateChatDTO;
import antoninBicak.chatApplication.dto.chat.LeaveUserFromChatDTO;
import antoninBicak.chatApplication.dto.chat.UserChatNameDTO;
public class ChatAdministrationController {


	public ResponseEntity<?> changeChatName(String chatID, ChatNameDTO chatName) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<?> changeUserChatNickName(String chatID, long userID, UserChatNameDTO userNickName) {
		// TODO Auto-generated method stub
		return null;
	}


	public ResponseEntity<?> addUserToChat(String chatID, AddUserToChatDTO userID) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<?> kickUserFromChat(String chatID, LeaveUserFromChatDTO userID, long kickBy) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<?> leaveUserFromChat(String chatID, LeaveUserFromChatDTO userID) {
		// TODO Auto-generated method stub
		return null;
	}


	public ResponseEntity<?> addPermission(String chatID, long userID, ChatPermissionDTO permission) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<?> removePermission(String chatID, long userID, ChatPermissionDTO permission) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseEntity<?> createChat(CreateChatDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
}
