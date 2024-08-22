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
		MessageDTO mes=this.messageConvertor.createChangeChatNameMessage(requestData,chatID, chatName.getChatName());
		this.messagePublisher.sendMessage(mes, requestData);
	}

	@CheckChatAccess(role=ChatPermission.Admin,allowItself=true)
	public void changeUserChatNickName(String chatID, long affectedUserID, UserChatNameDTO userNickName,SessionRequestData requestData) {
		this.databaseService.changeUserChatNickName(chatID, affectedUserID,userNickName.getNickName().getChatName());
		MessageDTO mes=this.messageConvertor.createChangeUserChatNickNameMessage(requestData,chatID, userNickName.getNickName().getChatName(),affectedUserID,userNickName.getChangeBy());
		this.messagePublisher.sendMessage(mes, requestData);
	}

	@CheckChatAccess(role=ChatPermission.Admin)
	public void addUserToChat(String chatID, AddUserToChatDTO userID,SessionRequestData requestData) {
		this.databaseService.addUserToChat(chatID, userID.getUserID());
		MessageDTO mes=this.messageConvertor.createUserWasAddedToChatMessage(requestData,chatID, userID.getUserID(), userID.getAddedBy());
		this.messagePublisher.sendMessage(mes, requestData);
		}
	@CheckChatAccess(role=ChatPermission.Admin)
	public void kickUserFromChat(String chatID, LeaveUserFromChatDTO userID, long kickBy,SessionRequestData requestData) {
		this.databaseService.addUserToChat(chatID, userID.getUserID());
		MessageDTO mes=this.messageConvertor.createUserWasKickedMessage(requestData,chatID, userID.getUserID(), kickBy);
		this.messagePublisher.sendMessage(mes, requestData);
	}
	@CheckChatAccess()
	public void leaveUserFromChat(String chatID, LeaveUserFromChatDTO userID,SessionRequestData requestData) {
		this.databaseService.addUserToChat(chatID, userID.getUserID());
		MessageDTO mes=this.messageConvertor.createUserLeftChatMessage(requestData,chatID, userID.getUserID());
		this.messagePublisher.sendMessage(mes, requestData);
	}

	@CheckChatAccess(role=ChatPermission.Owner)
	public void addPermission(String chatID, long userID, ChatPermissionDTO permission,SessionRequestData requestData) {
		this.databaseService.addUserPermission(chatID, userID, permission.getPermission());
		MessageDTO mes=this.messageConvertor.createUserGotPermissionMessage(requestData,chatID, permission.getPermission(), userID);
				this.messagePublisher.sendMessage(mes, requestData);
	}
	@CheckChatAccess(role=ChatPermission.Owner)
	public void removePermission(String chatID, long userID, ChatPermissionDTO permission,SessionRequestData requestData) {
		this.databaseService.addUserPermission(chatID, userID, permission.getPermission());
		MessageDTO mes=this.messageConvertor.createUserGotPermissionMessage(requestData,chatID, permission.getPermission(), userID);
				this.messagePublisher.sendMessage(mes, requestData);
	}

	public void createChat(CreateChatDTO dto,SessionRequestData requestData) {
		String chatID =
		this.databaseService.createChat(dto);
		
		MessageDTO mes=this.messageConvertor.createChat(requestData,chatID, dto.getChatID(), requestData.getUserID());
		this.messagePublisher.sendMessage(mes, requestData);
		
	}
}
