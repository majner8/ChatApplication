package antoninBicak.chatApplication.dto.message;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import antoninBicak.chatApplication.security.ChatPermission;
import antoninBicak.chatApplication.util.SessionRequestData;

@Component
class MessageConvertorImplementation implements MessageConvertor {

	@Override
	public MessageDTO createChangeChatNameMessage(SessionRequestData data, String chatID, String chatName) {
		SystemGeneratedMessageEventType type=
				SystemGeneratedMessageEventType.ChangeChatName;
		HashMap<String,String> value=new HashMap<String,String>();
		value.put("chatID", chatID);
		value.put("chatName", chatName);
		value.put("userID_init", data.getUserIDAsString());

		MessageSystemGeneratedMessage message=
				MessageSystemGeneratedMessage.create()
				.setChatID(chatID)
				.setEventType(type)
				.setMessageValue(value)
				.build();
		return message;
	}

	@Override
	public MessageDTO createChangeUserChatNickNameMessage(SessionRequestData data, String chatID, 
			String nickName,
			long affectedUserID, long changeByUserID) {
		SystemGeneratedMessageEventType type=
				SystemGeneratedMessageEventType.ChangeUserChatName;
		HashMap<String,String> value=new HashMap<String,String>();
		value.put("chatID", chatID);
		value.put("nickName", nickName);
		value.put("userID_init", data.getUserIDAsString());
		value.put("userID_owner", String.valueOf(affectedUserID));


		MessageSystemGeneratedMessage message=
				MessageSystemGeneratedMessage.create()
				.setChatID(chatID)
				.setEventType(type)
				.setMessageValue(value)
				.build();
		return message;
	}

	@Override
	public MessageDTO createUserLeftChatMessage(SessionRequestData data, String chatID, long userID) {
		// TODO Auto-generated method stub
		SystemGeneratedMessageEventType type=
				SystemGeneratedMessageEventType.UserLeftChat;
		HashMap<String,String> value=new HashMap<String,String>();
		value.put("chatID", chatID);
		value.put("userID", data.getUserIDAsString());

		MessageSystemGeneratedMessage message=
				MessageSystemGeneratedMessage.create()
				.setChatID(chatID)
				.setEventType(type)
				.setMessageValue(value)
				.build();
		return message;	}

	@Override
	public MessageDTO createUserWasKickedMessage(SessionRequestData data, String chatID, long affectedUserID,
			long kickByUserID) {
		SystemGeneratedMessageEventType type=
				SystemGeneratedMessageEventType.UserWasKick;
		HashMap<String,String> value=new HashMap<String,String>();
		value.put("chatID", chatID);
		value.put("userID_init", data.getUserIDAsString());
		value.put("userID_owner", String.valueOf(kickByUserID));
		MessageSystemGeneratedMessage message=
				MessageSystemGeneratedMessage.create()
				.setChatID(chatID)
				.setEventType(type)
				.setMessageValue(value)
				.build();
		return message;		
	}

	@Override
	public MessageDTO createUserWasAddedToChatMessage(SessionRequestData data, String chatID, long affectedUserID,
			long addedByUserID) {
		SystemGeneratedMessageEventType type=
				SystemGeneratedMessageEventType.UserWasAdded;
		HashMap<String,String> value=new HashMap<String,String>();
		value.put("chatID", chatID);
		value.put("userID_init", data.getUserIDAsString());
		value.put("userID_owner", String.valueOf(addedByUserID));


		MessageSystemGeneratedMessage message=
				MessageSystemGeneratedMessage.create()
				.setChatID(chatID)
				.setEventType(type)
				.setMessageValue(value)
				.build();
		return message;
	}

	@Override
	public MessageDTO createUserGotPermissionMessage(SessionRequestData data, String chatID, ChatPermission permission,
			long affectedUserID) {
		SystemGeneratedMessageEventType type=
				SystemGeneratedMessageEventType.UserGotPermission;
		HashMap<String,String> value=new HashMap<String,String>();
		value.put("chatID", chatID);
		value.put("permissionType", permission.name());
		value.put("userID_init", data.getUserIDAsString());
		value.put("userID_owner", String.valueOf(affectedUserID));
		MessageSystemGeneratedMessage message=
				MessageSystemGeneratedMessage.create()
				.setChatID(chatID)
				.setEventType(type)
				.setMessageValue(value)
				.build();
		return message;		
	}

	@Override
	public MessageDTO createChat(SessionRequestData data, String chatID, String chatName, long createdBy) {
		throw new UnsupportedOperationException("Method createChat has not been implement yet");
	}

}
