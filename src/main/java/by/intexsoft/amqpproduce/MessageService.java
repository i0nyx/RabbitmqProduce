package by.intexsoft.amqpproduce;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private final Logger log = LoggerFactory.getLogger(MessageService.class);

    private RabbitTemplate template;

    public MessageService(RabbitTemplate template){
        this.template = template;
    }

    @Scheduled(fixedDelay = 10000L)
    public void sendMessage(){
        template.convertAndSend(new Call("test messages"));
        log.info("send success");
    }
}
