package antoninBicak.chatApplication.relationalDatabase.services;

import org.springframework.beans.factory.annotation.Autowired;

import antoninBicak.chatApplication.relationalDatabase.repository.ChatInformationEntityRepository;

public class ChatDatabaseServiceImplementation implements ChatDatabaseService {

	@Autowired
	private ChatInformationEntityRepository repo;
	@Override
	public void changeChatName(String chatID, String chatName) {
		this.repo.updateChatName(chatID, chatName);
		
	}

}
