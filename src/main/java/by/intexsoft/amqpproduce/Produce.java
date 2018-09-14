package by.intexsoft.amqpproduce;

import by.intexsoft.amqpproduce.config.ProduceConfig;
import by.intexsoft.amqpproduce.service.MessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Produce {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ProduceConfig.class);
        MessageService messageService = context.getBean(MessageService.class);
        messageService.sendMessage();
    }
}
