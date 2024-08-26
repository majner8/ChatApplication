package antoninBicak.chatApplication.rabbitMQ;

import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import antoninBicak.chatApplication.dto.message.MessageDTO;
import antoninBicak.chatApplication.mongoDB.MongoDbDatabaseService;
import antoninBicak.chatApplication.util.SessionRequestData;

public class RabbitMQMessagePublisherImplementation implements RabbitMQMessagePublisherFacade {

	@Autowired
	private MongoDbDatabaseService mongoDatabaseService;

	@Autowired
    private RabbitTemplate rabbitTemplate;
	 @Value("${rabbitmq.exchange}")
	 private String exchange;

	 @Value("${rabbitmq.messagePath}")
	 private String rabbitMQPath;
	

		@Override
		public void sendMessage(MessageDTO message, SessionRequestData sessionData) {
			long messageOrder=this.mongoDatabaseService.getMessageOrder(message.getChatID());
			message=message.setMessageOrder(messageOrder);
			this.mongoDatabaseService.saveMessage(message);
			this.rabbitTemplate.convertAndSend(exchange, String.format(this.rabbitMQPath, message.getChatID()), message, this.setRabbitMQMessageProperties());
					
		}


	
	private MessagePostProcessor setRabbitMQMessageProperties() {
		return (x)->{
			
			return x;}
		
		;		
	}



}
