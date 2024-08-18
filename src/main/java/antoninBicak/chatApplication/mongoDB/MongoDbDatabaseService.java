package antoninBicak.chatApplication.mongoDB;

import antoninBicak.chatApplication.dto.message.MessageDTO;

public interface MongoDbDatabaseService {

	public void saveMessage(MessageDTO message);
}
