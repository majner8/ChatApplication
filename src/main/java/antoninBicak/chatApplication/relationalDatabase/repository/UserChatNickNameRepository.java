package antoninBicak.chatApplication.relationalDatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import antoninBicak.chatApplication.relationalDatabase.entity.chat.UserChatNickNameEntity;
import antoninBicak.chatApplication.relationalDatabase.entity.chat.UserChatNickNameEntity.CompositeKey;

public interface UserChatNickNameRepository extends JpaRepository<UserChatNickNameEntity,CompositeKey> {

	
	public void updateUserChatNickName(String chatName,CompositeKey primaryKey);
}
