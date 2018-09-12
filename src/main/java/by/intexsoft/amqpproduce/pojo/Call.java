package by.intexsoft.amqpproduce.pojo;


import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class Call {

    private UUID id;
    private Date date;
    private String message;

}
