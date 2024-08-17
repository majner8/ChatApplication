package antoninBicak.chatApplication.dto.message;

public interface MessageConvertor {

	public messageDTO createChangeChatNameMessage(String chatID, String chatName);
}
