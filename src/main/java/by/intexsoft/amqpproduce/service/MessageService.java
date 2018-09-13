package by.intexsoft.amqpproduce.service;

import by.intexsoft.amqpproduce.pojo.Call;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.UUID;

import static by.intexsoft.amqpproduce.constant.Const.SCHEDULER_TIME;

@AllArgsConstructor
@Slf4j
public class MessageService {
    private RabbitTemplate template;

    @Scheduled(fixedRate = SCHEDULER_TIME)
    public void sendMessage() {
        Call call = new Call();
        call.setId(UUID.randomUUID());
        call.setMessage("Test message");
        call.setDate(new Date());
        template.convertAndSend("info", call);
        template.convertAndSend("error", "cant send call object");
        log.info("send success");
    }
}
