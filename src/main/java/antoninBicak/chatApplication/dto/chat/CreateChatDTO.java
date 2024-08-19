package antoninBicak.chatApplication.dto.chat;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
@Getter
@AllArgsConstructor
@Builder
public class CreateChatDTO {
	//if duplicate error happen, it return error and client try to again
	private String chatID;
	private long userIDCreated;
	private List<Long> member;
	private ChatNameDTO chatName;




}
