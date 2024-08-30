package antoninBicak.chatApplication.rabbitMQ;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.rabbitmq.client.Channel;

public class RabbitMQMessageListener implements ChannelAwareMessageListener {

	@Override
	public void onMessage(Message message, Channel channel) throws Exception {
		// TODO Auto-generated method stub
	    SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
	    ThreadPoolTaskExecutor x;
	    
	    x.setpr
	}

}
