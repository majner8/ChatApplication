package antoninBicak.chatApplication.rabbitMQ;

import antoninBicak.chatApplication.dto.message.MessageDTO;
import antoninBicak.chatApplication.util.SessionRequestData;

 public interface RabbitMQMessagePublisherFacade {

	public void sendMessage(MessageDTO message,SessionRequestData sessionData);
}
