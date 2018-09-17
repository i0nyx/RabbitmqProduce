import by.intexsoft.amqpproduce.service.MessageService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Class tests for class {@link MessageService}
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({MessageService.class, LoggerFactory.class})
public class MessageServiceTest {
    private MessageService messageService;
    private RabbitTemplate template;

    /**
     * Stub for {@link RabbitTemplate} and create new object {@link MessageService}
     */
    @Before
    public void setUp() {
        template = mock(RabbitTemplate.class);
        messageService = new MessageService(template);
    }

    /**
     * Check the call to the log method
     */
    @Test
    public void testSend() {
        messageService.sendMessage();
        mockStatic(LoggerFactory.class);
        Logger log = mock(Logger.class);
        when(LoggerFactory.getLogger(MessageService.class)).thenReturn(log);
        verify(log);
    }
}
