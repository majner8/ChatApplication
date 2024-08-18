package antoninBicak.chatApplication.dto.message;

public interface MessageConvertor {

	public MessageDTO createChangeChatNameMessage(String chatID, String chatName);
}
