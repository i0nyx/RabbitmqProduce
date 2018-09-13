package by.intexsoft.amqpproduce.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

/**
 * TODO Javadoc
 */
@Builder
@Getter
@Setter
public class Call {
    private UUID id;
    private Date date;
    private String message;
}
