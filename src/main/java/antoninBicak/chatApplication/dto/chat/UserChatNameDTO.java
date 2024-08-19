package antoninBicak.chatApplication.dto.chat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class UserChatNameDTO {


	private long userID;
	private String chatID;
	private ChatNameDTO nickName;

	private Long changeBy;
}
