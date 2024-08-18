package antoninBicak.chatApplication.chatManagement;

import org.springframework.beans.factory.annotation.Autowired;

import antoninBicak.chatApplication.dto.message.MessageDTO;
import antoninBicak.chatApplication.mongoDB.MongoDbDatabaseService;
import antoninBicak.chatApplication.rabbitMQ.messagePublisher.RabbitMQMessagePublisher;
import antoninBicak.chatApplication.util.sessionData.SessionRequestData;

public class MessagePublisherFacade {

	@Autowired
	private MessageIDGenerator messageIDGenerator;
	@Autowired
	private MongoDbDatabaseService mongoDatabaseService;
	@Autowired
	private RabbitMQMessagePublisher rabbitMQPublisher;
	public void sendMessage(MessageDTO message,SessionRequestData sessionData) {
		long messageOrder=this.messageIDGenerator.getMessageOrder(message.getChatID());
		message=message.setMessageOrder(messageOrder);
		this.mongoDatabaseService.saveMessage(message);
		this.rabbitMQPublisher.pushMessage(message, sessionData.getUserID());
		
	}
}
