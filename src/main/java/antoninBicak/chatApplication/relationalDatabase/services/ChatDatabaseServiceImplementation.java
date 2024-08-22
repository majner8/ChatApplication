package antoninBicak.chatApplication.relationalDatabase.services;

import org.springframework.beans.factory.annotation.Autowired;

import antoninBicak.chatApplication.dto.chat.ChatInformationDTO;
import antoninBicak.chatApplication.dto.chat.CreateChatDTO;
import antoninBicak.chatApplication.relationalDatabase.entity.chat.UserChatNickNameEntity.CompositeKey;
import antoninBicak.chatApplication.relationalDatabase.repository.ChatInformationEntityRepository;
import antoninBicak.chatApplication.relationalDatabase.repository.UserChatNickNameRepository;
import antoninBicak.chatApplication.security.ChatPermission;

public class ChatDatabaseServiceImplementation implements ChatDatabaseService {

	@Autowired
	private ChatInformationEntityRepository repo;
	@Autowired
	private UserChatNickNameRepository userChatRepo;
	@Override
	public void changeChatName(String chatID, String chatName) {
		this.repo.updateChatName(chatID, chatName);

	}
	
	@Override
	public void changeUserChatNickName(String chatID, long affectedUserID, String chatName) {
		this.userChatRepo.updateUserChatNickName(chatName, CompositeKey.of(affectedUserID, chatID));
		
	}

	@Override
	public void addUserToChat(String chatID, long userID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeUserFromChat(String chatID, long userID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addUserPermission(String chatID, long affectedUserID, ChatPermission permission) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String createChat(CreateChatDTO dto) {
		return null;
	}

	@Override
	public ChatInformationDTO getChatInformation(String chatID) {
		// TODO Auto-generated method stub
		return null;
	}

}
