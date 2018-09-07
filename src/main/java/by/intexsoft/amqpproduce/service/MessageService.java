package by.intexsoft.amqpproduce.service;

import by.intexsoft.amqpproduce.pojo.Call;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;


public class MessageService {

    private final Logger log = LoggerFactory.getLogger(MessageService.class);

    @Autowired
    private RabbitTemplate template;

    @Scheduled(fixedRate = 10000L)
    public void sendMessage() {
        Call c = new Call();
        c.setMessage("Test messagE");
        c.setDate(new Date());
        template.convertAndSend(c);
        log.info("send success");
    }
}
