package antoninBicak.chatApplication.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder(setterPrefix="set")
public class ChatInformationDTO {

	private final LocalDateTime created;
	private final long createdBy;
	private final ChatNameDTO chatName;
	private final String chatID;
	private final List<UserChatNameDTO> userChatNames;

}
