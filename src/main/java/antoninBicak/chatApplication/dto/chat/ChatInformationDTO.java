package antoninBicak.chatApplication.dto.chat;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ChatInformationDTO {

	private LocalDateTime created;
	private long createdBy;
	private ChatNameDTO chatName;
	private String chatID;
	private List<UserChatNameDTO> userChatNames;
	
}
