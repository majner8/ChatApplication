package antoninBicak.chatApplication.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import antoninBicak.chatApplication.dto.ChatInformationDTO;
import antoninBicak.chatApplication.dto.CreateChatDTO;
import antoninBicak.chatApplication.dto.UserChatNameDTO;
import antoninBicak.chatApplication.relationalDatabase.entity.ChatInformationEntity;
import antoninBicak.chatApplication.relationalDatabase.entity.UserChatNickNameEntity;

@Mapper
public interface ChatEntityDTOMapper {

	@Mapping(source="chatMember",target="userChatNames")
	public ChatInformationDTO toChatInformationDTO(ChatInformationEntity entity);
	@Mapping(source="primaryKey.userID",target="userID")
	@Mapping(source="primaryKey.chatID",target="chatID")
	public UserChatNameDTO toUserChatNameDTO(UserChatNickNameEntity entity);
	
    @Mapping(target = "chatMemberID", ignore = true)
    @Mapping(source="chatName.chatName",target="chatName")
	public ChatInformationEntity toChatInformationEntity(CreateChatDTO dto);
}
