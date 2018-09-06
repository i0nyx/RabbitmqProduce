package by.intexsoft.amqpproduce;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Produce {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProduceConfig.class);
        MessageService messageService = new MessageService(context.getBean(RabbitTemplate.class));
        messageService.sendMessage();
    }
}
