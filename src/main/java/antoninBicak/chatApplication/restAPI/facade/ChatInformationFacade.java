package antoninBicak.chatApplication.restAPI.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import antoninBicak.chatApplication.dto.chat.ChatInformationDTO;
import antoninBicak.chatApplication.dto.message.MessageDTO;
import antoninBicak.chatApplication.mongoDB.MongoDbDatabaseService;
import antoninBicak.chatApplication.relationalDatabase.services.ChatDatabaseService;
import antoninBicak.chatApplication.security.accessValidator.CheckChatAccess;
import antoninBicak.chatApplication.util.sessionData.SessionRequestData;

public class ChatInformationFacade {

	@Autowired
	private ChatDatabaseService databaseService;
	@Autowired
	private MongoDbDatabaseService mongoService;
	@CheckChatAccess()
	public ChatInformationDTO getChatInformation(SessionRequestData requestData,String chatID) {
		ChatInformationDTO dto=this.databaseService.getChatInformation(chatID);
		return dto;
	}
	
	@CheckChatAccess()
	public MessageDTO getMessage(SessionRequestData requestData,String chatID, int order) {
		return this.mongoService.loadMessage(chatID, order);
	}

	@CheckChatAccess()
	public List<MessageDTO> getMessages(SessionRequestData requestData,String chatID, long startOffset, long endOffSet) {
		return this.mongoService.loadMessages(chatID, startOffset, endOffSet);
	}

}
