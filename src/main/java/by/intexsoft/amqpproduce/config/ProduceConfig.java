package by.intexsoft.amqpproduce.config;

import by.intexsoft.amqpproduce.service.MessageService;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import static by.intexsoft.amqpproduce.constant.QueueConst.*;


@Configuration
@ComponentScan("by.intexsoft.amqpproduce")
@EnableScheduling
public class ProduceConfig {

    @Bean
    public CachingConnectionFactory connectionFactory() {
        return new CachingConnectionFactory("localhost");
    }

    @Bean
    public AmqpAdmin amqpAdmin(@Autowired CachingConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public Queue queueOne() {
        return new Queue(QUEUE_ONE);
    }

    @Bean
    public Queue queueTwo(){
        return new Queue(QUEUE_TWO);
    }

    @Bean
    public DirectExchange topicExchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Binding errorBindingOne(@Autowired Queue queueOne, @Autowired DirectExchange directExchange) {
        return BindingBuilder.bind(queueOne).to(directExchange).with(ERROR);
    }

    @Bean
    public Binding errorBindingTwo(@Autowired Queue queueTwo, @Autowired DirectExchange directExchange){
        return BindingBuilder.bind(queueTwo).to(directExchange).with(ERROR);
    }

    @Bean
    public Binding infoBinding(@Autowired Queue queueTwo, @Autowired DirectExchange directExchange){
        return BindingBuilder.bind(queueTwo).to(directExchange).with(INFO);
    }

    @Bean
    public RabbitTemplate template() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        template.setExchange(EXCHANGE);
        template.setMessageConverter(jsonMessageConverter());
        return template;
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new JsonMessageConverter();
    }

    @Bean
    public MessageService messageService() {
        return new MessageService(template());
    }


}
