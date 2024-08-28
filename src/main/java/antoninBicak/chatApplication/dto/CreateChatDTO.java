package antoninBicak.chatApplication.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
@Getter
@AllArgsConstructor
@Builder(setterPrefix="set")
public class CreateChatDTO {
	//if duplicate error happen, it return error and client try to again
	private final String chatID;
	private final ChatNameDTO chatName;

	private final long createdBy;
	private final boolean isGroupChat;
	private final List<Long> chatMemberID;


	/**Metod set new chatID and return new instance*/
	public CreateChatDTO setChatID(String chatID) {
		return CreateChatDTO.builder()
				.setChatID(chatID)
				.setChatName(this.chatName)
				.setIsGroupChat(this.isGroupChat)
				.setChatMemberID(this.chatMemberID)
				.setCreatedBy(this.createdBy)
				.build();
	}
}
