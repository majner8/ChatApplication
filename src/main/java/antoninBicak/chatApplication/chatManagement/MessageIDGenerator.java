package antoninBicak.chatApplication.chatManagement;

public interface MessageIDGenerator {

	public long getMessageOrder(String chatID);
}
