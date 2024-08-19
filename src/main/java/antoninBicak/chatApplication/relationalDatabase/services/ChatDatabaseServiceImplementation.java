package antoninBicak.chatApplication.relationalDatabase.services;

import org.springframework.beans.factory.annotation.Autowired;

import antoninBicak.chatApplication.relationalDatabase.repository.ChatInformationEntityRepository;
import antoninBicak.chatApplication.relationalDatabase.repository.UserEntityJpaRepository;

public class ChatDatabaseServiceImplementation implements ChatDatabaseService {

	@Autowired
	private ChatInformationEntityRepository repo;
	@Autowired
	private UserEntityJpaRepository userRepo;
	@Override
	public void changeChatName(String chatID, String chatName) {
		this.repo.updateChatName(chatID, chatName);

	}
	@Override
	public void changeUserChatNickName(String chatID, String chatName, long affectedUserID) {

	}

}
