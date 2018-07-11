package springboot_demo.springcloud.handler;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.message")
public class TopicReceiver1 {

	@RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver1  : " + hello);
    }
	
}
