package antoninBicak.chatApplication.relationalDatabase.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import antoninBicak.chatApplication.dto.ChatInformationDTO;
import antoninBicak.chatApplication.dto.CreateChatDTO;
import antoninBicak.chatApplication.relationalDatabase.entity.ChatInformationEntity;
import antoninBicak.chatApplication.relationalDatabase.entity.UserChatNickNameEntity;
import antoninBicak.chatApplication.relationalDatabase.entity.UserChatNickNameEntity.CompositeKey;
import antoninBicak.chatApplication.relationalDatabase.repository.ChatInformationEntityRepository;
import antoninBicak.chatApplication.relationalDatabase.repository.UserChatNickNameRepository;
import antoninBicak.chatApplication.security.ChatPermission;
import antoninBicak.chatApplication.util.IdGenerator;
import antoninBicak.chatApplication.util.mapper.ChatEntityDTOMapper;

public class ChatDatabaseServiceImplementation implements ChatDatabaseService {

	@Autowired
	private ChatInformationEntityRepository repo;
	@Autowired
	private UserChatNickNameRepository userChatRepo;
	@Autowired
	private ChatInformationEntityRepository chatInformationRepo;
	@Autowired
	private ChatEntityDTOMapper chatMapper;
	@Autowired
	private IdGenerator idGenerator;
	@Override
	public void changeChatName(String chatID, String chatName) {
		this.repo.updateChatName(chatID, chatName);

	}
	
	@Override
	public void changeUserChatNickName(String chatID, long affectedUserID, String chatName) {
		this.userChatRepo.updateUserChatNickName(chatName, affectedUserID, chatID);
		
	}

	@Override
	public void addUserToChat(String chatID, long userID) {
		UserChatNickNameEntity entity=new UserChatNickNameEntity();
		entity.setPrimaryKey(CompositeKey.of(userID, chatID));
		this.userChatRepo.saveOrIgnore(entity);
	}

	@Override
	public void removeUserFromChat(String chatID, long userID) {
		this.userChatRepo.deleteById(CompositeKey.of(userID, chatID));
	}

	@Override
	public void addUserPermission(String chatID, long affectedUserID, ChatPermission permission) {
		this.userChatRepo.updateUserPermission(permission, affectedUserID, chatID);
	}

	

	@Override
	public ChatInformationDTO getChatInformation(String chatID) {
		ChatInformationEntity entity=this.chatInformationRepo.getById(chatID);
		return this.chatMapper.toChatInformationDTO(entity);
	}

	@Override
	@Transactional
	public String createChat(CreateChatDTO dto) {
		ChatInformationEntity entity=this.chatMapper.toChatInformationEntity(dto);
		if(dto.isGroupChat()) entity.setChatID(this.idGenerator.generateChatID());
		//duplicate primary key have to be catch and thrown to custom exception
		this.chatInformationRepo.persist(entity);
		
		List<UserChatNickNameEntity> nickName=
		dto.getChatMemberID().stream()
		.map(v->{
			UserChatNickNameEntity e= new UserChatNickNameEntity()
				.setPrimaryKey(
						CompositeKey.of(v, dto.getChatID()));
			if(!dto.isGroupChat()) {
				e.setPermission(ChatPermission.UserToUserChat);
				return e;
			}
			if(dto.getCreatedBy()==v) e.setPermission(ChatPermission.Owner);
			else e.setPermission(ChatPermission.Member);
		
		return e;}
		).toList();
		this.userChatRepo.saveAll(nickName);
		entity.setChatMemberID(nickName);
		return entity.getChatID();
	}

}
