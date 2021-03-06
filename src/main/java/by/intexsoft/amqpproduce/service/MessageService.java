package by.intexsoft.amqpproduce.service;

import by.intexsoft.amqpproduce.pojo.Call;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.UUID;

import static by.intexsoft.amqpproduce.constant.Constant.SCHEDULER_TIME;

/**
 * Class that implements the method of sending data to the RabbitMQ queue
 */
@AllArgsConstructor
@Slf4j
public class MessageService {
    private final RabbitTemplate template;

    /**
     * Method for sending built {@link Call} object in RabbitMQ queue
     *
     * @see #buildCall()
     */
    @Scheduled(fixedRate = SCHEDULER_TIME)
    public void sendMessage() {
        template.convertAndSend("info", buildCall());
        template.convertAndSend("error", "cant send call object");
        log.info("send success");
    }

    private Call buildCall() {
        return Call.builder().id(UUID.randomUUID()).message("Test message").date(new Date()).build();
    }
}
