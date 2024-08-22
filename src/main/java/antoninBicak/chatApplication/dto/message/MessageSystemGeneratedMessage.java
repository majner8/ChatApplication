package antoninBicak.chatApplication.dto.message;

import java.util.Map;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder(builderMethodName="create",setterPrefix="set")
public class MessageSystemGeneratedMessage extends MessageDTO {
	
	private SystemGeneratedMessageEventType eventType;
	private Map<String,String>messageValue;
	public MessageSystemGeneratedMessage(String chatID, long messageOrder,
			SystemGeneratedMessageEventType eventType, Map<String,String>messageValue) {
		super(chatID, messageOrder);
		this.eventType=eventType;
		this.messageValue=messageValue;
	}

	@Override
	public MessageDTO setMessageOrder(long messageOrder) {
		// TODO Auto-generated method stub
		return new MessageSystemGeneratedMessage(this.getChatID(),messageOrder,this.getEventType(),
				this.getMessageValue());
	}
	
	

	
	
}
