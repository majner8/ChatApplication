package antoninBicak.chatApplication.rabbitMQ.messagePublisher;

import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import antoninBicak.chatApplication.dto.message.MessageDTO;

public class RabbitMQMessagePublisherImplementation implements RabbitMQMessagePublisher {

	@Autowired
    private RabbitTemplate rabbitTemplate;
	 @Value("${rabbitmq.exchange}")
	 private String exchange;

	 @Value("${rabbitmq.messagePath}")
	 private String rabbitMQPath;
	
	@Override
	public void pushMessage(MessageDTO message, long senderID) {
		this.rabbitTemplate.convertAndSend(exchange, String.format(this.rabbitMQPath, message.getChatID()), message, this.setRabbitMQMessageProperties());
	}
	
	private MessagePostProcessor setRabbitMQMessageProperties() {
		return (x)->{
			
			return x;}
		
		;		
	}

}
