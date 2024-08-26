package antoninBicak.chatApplication.restAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import antoninBicak.chatApplication.dto.message.MessageDTO;
import antoninBicak.chatApplication.mongoDB.MongoDbDatabaseService;
import antoninBicak.chatApplication.security.CheckChatAccess;
import antoninBicak.chatApplication.util.SessionRequestData;

public class MessageManagementFacadeController {
	@Autowired
	private MongoDbDatabaseService mongoService;

	
	@CheckChatAccess()
	public MessageDTO getMessage(SessionRequestData requestData,String chatID, int order) {
		return this.mongoService.loadMessage(chatID, order);
	}

	@CheckChatAccess()
	public List<MessageDTO> getMessages(SessionRequestData requestData,String chatID, long startOffset, long endOffSet) {
		return this.mongoService.loadMessages(chatID, startOffset, endOffSet);
	}
}
