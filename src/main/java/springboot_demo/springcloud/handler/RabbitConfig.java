package springboot_demo.springcloud.handler;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

	@Bean
    public Queue Queue() {
        return new Queue("hello");
    }
	
	@Bean
    public Queue queueMessage() {
        return new Queue("topic.message");
    }

    @Bean
    public Queue queueMessages() {
        return new Queue("topic.messages");
    }
    
    @Bean
    public Queue queueEventAnnotionListener() {
        return new Queue("com.xier.rabbit.rmq.mq.model.EventAnnotionListener");
    }
    
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("lxjExchange");
    }
    
    @Bean
    TopicExchange exchangePersonRecognizeLog() {
        return new TopicExchange("com.xier.rabbit.rmq.mq.model.PersonRecognizeLog");
    }
    
    /**
     * 将队列topic.messages与exchange绑定，binding_key为topic.#,模糊匹配
     * @param queueMessage
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }
    
    /**
     * 将队列topic.message与exchange绑定，binding_key为topic.message,就是完全匹配
     * @param queueMessage
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }
    
    @Bean
    Binding bindingExchangeEventAnnotionListener(Queue queueMessage, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessage).to(exchange).with("com.xier.rabbit.rmq.mq.model.PersonRecognizeLog");
    }
}
