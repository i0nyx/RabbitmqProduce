package by.intexsoft.amqpproduce.service;

import by.intexsoft.amqpproduce.pojo.Call;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.UUID;

import static by.intexsoft.amqpproduce.constant.Const.SCHEDULER_TIME;

@AllArgsConstructor
public class MessageService {

    private final Logger log = LoggerFactory.getLogger(MessageService.class);

    private RabbitTemplate template;

    @Scheduled(fixedRate = SCHEDULER_TIME)
    public void sendMessage() {
        Call call = new Call();
        call.setId(UUID.randomUUID());
        call.setMessage("Test message");
        call.setDate(new Date());
        template.convertAndSend(call);
        log.info("send success");
    }
}
