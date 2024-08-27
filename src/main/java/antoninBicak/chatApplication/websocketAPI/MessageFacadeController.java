package antoninBicak.chatApplication.websocketAPI;

import org.springframework.beans.factory.annotation.Autowired;

import antoninBicak.chatApplication.dto.message.MessageDTO;
import antoninBicak.chatApplication.rabbitMQ.RabbitMQMessagePublisherFacade;
import antoninBicak.chatApplication.security.CheckChatAccess;
import antoninBicak.chatApplication.util.SessionRequestData;

public class MessageFacadeController {
	@Autowired
	private RabbitMQMessagePublisherFacade rbmFacade;
	
	@CheckChatAccess()
	public void sendMessage(SessionRequestData requestData,MessageDTO message) {
		this.rbmFacade.sendMessage(message, requestData);
	}

}
