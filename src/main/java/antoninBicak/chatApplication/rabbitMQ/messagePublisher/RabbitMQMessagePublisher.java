package antoninBicak.chatApplication.rabbitMQ.messagePublisher;

import antoninBicak.chatApplication.dto.message.MessageDTO;

public interface RabbitMQMessagePublisher {

	public void pushMessage(MessageDTO message,long senderID);
}
