package antoninBicak.chatApplication.relationalDatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import antoninBicak.chatApplication.relationalDatabase.entity.UserChatNickNameEntity;
import antoninBicak.chatApplication.relationalDatabase.entity.UserChatNickNameEntity.CompositeKey;
import antoninBicak.chatApplication.security.ChatPermission;

public interface UserChatNickNameRepository extends ChatApplicationCrudeRepository<UserChatNickNameEntity,CompositeKey>,
JpaRepository<UserChatNickNameEntity,CompositeKey> {

	
	public void updateUserChatNickName(String chatName,CompositeKey primaryKey);
	
	public void updateUserPermission(ChatPermission permission,CompositeKey primaryKey);
	
	
}
