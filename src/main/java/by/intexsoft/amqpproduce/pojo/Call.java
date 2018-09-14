package by.intexsoft.amqpproduce.pojo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

/**
 * Class of calls with property id, date, message
 */
@Builder
@Getter
@Setter
public class Call {
    private UUID id;
    private Date date;
    private String message;
}
