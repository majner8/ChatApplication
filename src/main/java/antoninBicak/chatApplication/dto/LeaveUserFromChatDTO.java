package antoninBicak.chatApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class LeaveUserFromChatDTO {

	private long userID;
}
