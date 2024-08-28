package antoninBicak.chatApplication.relationalDatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import antoninBicak.chatApplication.relationalDatabase.entity.ChatInformationEntity;

public interface ChatInformationEntityRepository extends ChatApplicationCrudeRepository<ChatInformationEntity,String>,JpaRepository<ChatInformationEntity,String>
/*,ChatCustomRepository*/{

	 @Modifying
	 @Query("UPDATE ChatInformationEntity e SET e.chatName = :newValue WHERE e.chatID = :id")
	 public int updateChatName(@Param("id") String chatID, @Param("newValue") String chatName);

}
