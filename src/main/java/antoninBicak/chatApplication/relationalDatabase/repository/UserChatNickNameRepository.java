package antoninBicak.chatApplication.relationalDatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import antoninBicak.chatApplication.relationalDatabase.entity.UserChatNickNameEntity;
import antoninBicak.chatApplication.relationalDatabase.entity.UserChatNickNameEntity.CompositeKey;
import antoninBicak.chatApplication.security.ChatPermission;

public interface UserChatNickNameRepository extends ChatApplicationCrudeRepository<UserChatNickNameEntity,CompositeKey>,
JpaRepository<UserChatNickNameEntity,CompositeKey> {

	
	 @Modifying
	 @Query("UPDATE UserChatNickNameEntity e SET e.nickName = :newValue WHERE e.primaryKey.chatID = :chatID and "
	 		+ "e.primaryKey.userID = :userID")
	public int updateUserChatNickName(@Param("newValue")String chatName,long userID,String chatID);
	
	 @Modifying
	 @Query("UPDATE UserChatNickNameEntity e SET e.permission = :newValue WHERE e.primaryKey.chatID = :chatID and "
	 		+ "e.primaryKey.userID = :userID")
	public int updateUserPermission(@Param("newValue")ChatPermission permission,long userID,String chatID);
	
	
}
