package by.intexsoft.amqpproduce.service;

import by.intexsoft.amqpproduce.pojo.Call;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

import static by.intexsoft.amqpproduce.constant.Const.SCHEDULER_TIME;

@AllArgsConstructor
public class MessageService {

    private final Logger log = LoggerFactory.getLogger(MessageService.class);

    private RabbitTemplate template;

    @Scheduled(fixedRate = SCHEDULER_TIME)
    public void sendMessage() {
        Call c = new Call();
        c.setMessage("Test message");
        c.setDate(new Date());
        template.convertAndSend(c);
        log.info("send success");
    }
}
