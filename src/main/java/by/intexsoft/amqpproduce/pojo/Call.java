package by.intexsoft.amqpproduce.pojo;


import lombok.Data;

import java.util.Date;

@Data
public class Call {

    private int id;
    private Date date;
    private String message;

}
