package antoninBicak.chatApplication.mongoDB;

import java.util.List;

import antoninBicak.chatApplication.dto.message.MessageDTO;

public interface MongoDbDatabaseService {

	public void saveMessage(MessageDTO message);
	
	public MessageDTO loadMessage(String chatID, long order);
	
	public List<MessageDTO>loadMessages(String chatID,long offSetStart, long offSetEnd);
	
	public long getMessageOrder(String chatID);

}
