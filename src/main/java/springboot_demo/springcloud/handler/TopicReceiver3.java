package springboot_demo.springcloud.handler;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "com.xier.rabbit.rmq.mq.model.EventAnnotionListener")
public class TopicReceiver3 {

	@RabbitHandler
    public void process(Object obj) {
        System.out.println("Receiver3  : " + obj.toString());
    }
	
}
