package by.intexsoft.amqpproduce.config;

import by.intexsoft.amqpproduce.service.MessageService;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import static by.intexsoft.amqpproduce.constant.QueueConst.*;

/**
 * Class configuration RabbitMQ
 */
@Configuration
@ComponentScan("by.intexsoft.amqpproduce")
@EnableScheduling
public class ProduceConfig {
    /**
     * Create a {@link CachingConnectionFactory}
     */
    @Bean
    public CachingConnectionFactory connectionFactory() {
        return new CachingConnectionFactory("localhost");
    }

    /**
     * Create a {@link RabbitAdmin}
     *
     * @return {@link AmqpAdmin}
     */
    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    /**
     * Create a {@link Queue}
     */
    @Bean
    public Queue queueOne() {
        return new Queue(QUEUE_ONE);
    }

    /**
     * Create a {@link Queue}
     */
    @Bean
    public Queue queueTwo() {
        return new Queue(QUEUE_TWO);
    }

    /**
     * Create a {@link DirectExchange}.
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(EXCHANGE);
    }

    /**
     * Create a {@link BindingBuilder}.
     *
     * @return {@link Binding}
     * @see #queueOne()
     * @see #directExchange()
     */
    @Bean
    public Binding errorBindingOne() {
        return BindingBuilder.bind(queueOne()).to(directExchange()).with(ERROR);
    }

    /**
     * Create a {@link BindingBuilder}.
     *
     * @return {@link Binding}
     * @see #queueOne()
     * @see #directExchange()
     */
    @Bean
    public Binding errorBindingTwo() {
        return BindingBuilder.bind(queueTwo()).to(directExchange()).with(ERROR);
    }

    /**
     * Create a {@link BindingBuilder}.
     *
     * @return {@link Binding}
     * @see #queueTwo()
     * @see #directExchange()
     */
    @Bean
    public Binding infoBinding() {
        return BindingBuilder.bind(queueTwo()).to(directExchange()).with(INFO);
    }

    /**
     * Create a {@link RabbitTemplate}.
     *
     * @see #connectionFactory()
     * @see #jsonMessageConverter()
     */
    @Bean
    public RabbitTemplate template() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        template.setExchange(EXCHANGE);
        template.setMessageConverter(jsonMessageConverter());
        return template;
    }

    /**
     * Create a {@link JsonMessageConverter}
     *
     * @return {@link MessageConverter}
     */
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new JsonMessageConverter();
    }

    /**
     * Create a {@link MessageService}
     *
     * @see #template()
     */
    @Bean
    public MessageService messageService() {
        return new MessageService(template());
    }


}
