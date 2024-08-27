package antoninBicak.chatApplication.relationalDatabase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import antoninBicak.chatApplication.relationalDatabase.entity.ChatInformationEntity;

public interface ChatInformationEntityRepository extends ChatApplicationCrudeRepository<ChatInformationEntity,String>,JpaRepository<ChatInformationEntity,String>
,ChatCustomRepository{

}
