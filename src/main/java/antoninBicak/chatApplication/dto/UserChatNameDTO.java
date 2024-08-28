package antoninBicak.chatApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class UserChatNameDTO {


	private final long userID;
	private final String chatID;
	private final ChatNameDTO nickName;
	private long changeBy;

}
