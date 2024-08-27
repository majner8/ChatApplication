package antoninBicak.chatApplication.relationalDatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import antoninBicak.chatApplication.relationalDatabase.entity.UserChatNickNameEntity;
import antoninBicak.chatApplication.relationalDatabase.entity.UserChatNickNameEntity.CompositeKey;

public interface UserChatNickNameRepository extends ChatApplicationCrudeRepository<UserChatNickNameEntity,CompositeKey>,
JpaRepository<UserChatNickNameEntity,CompositeKey> {

	
	public void updateUserChatNickName(String chatName,CompositeKey primaryKey);
}
