package antoninBicak.chatApplication.dto.chat;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
@Getter
@AllArgsConstructor
@Builder
public class AddUserToChatDTO {

	private final long userID;
	@NotNull
	private final String chatID;
	private final long addedBy;
	
	
	
}
