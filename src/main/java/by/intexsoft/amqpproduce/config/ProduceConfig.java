package by.intexsoft.amqpproduce.config;

import by.intexsoft.amqpproduce.service.MessageService;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import static by.intexsoft.amqpproduce.constant.QueueConst.QUEUE1;


@Configuration
@ComponentScan("by.intexsoft.amqpproduce")
@EnableScheduling
public class ProduceConfig {

    @Bean
    public CachingConnectionFactory connectionFactory() {
        return new CachingConnectionFactory("localhost");
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate template() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        template.setRoutingKey(QUEUE1);
        template.setQueue(QUEUE1);
        template.setMessageConverter(jsonMessageConverter());
        return template;
    }

    @Bean
    public MessageService messageService() {
        return new MessageService();
    }


}
