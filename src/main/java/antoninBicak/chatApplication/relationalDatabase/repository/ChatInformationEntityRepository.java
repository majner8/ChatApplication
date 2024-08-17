package antoninBicak.chatApplication.relationalDatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import antoninBicak.chatApplication.relationalDatabase.entity.chat.ChatInformationEntity;
import antoninBicak.chatApplication.relationalDatabase.repository.customRepository.ChatCustomRepository;

public interface ChatInformationEntityRepository extends ChatApplicationCrudeRepository<ChatInformationEntity,String>,JpaRepository<ChatInformationEntity,String> 
,ChatCustomRepository{

}
