package antoninBicak.chatApplication.relationalDatabase.services;

public interface ChatDatabaseService {

	public void changeChatName(String chatID,String chatName);

	public void changeUserChatNickName(String chatID,String chatName, long affectedUserID);
}


