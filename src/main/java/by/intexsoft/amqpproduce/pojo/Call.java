package by.intexsoft.amqpproduce.pojo;


import java.util.Date;
import java.util.Objects;

public class Call {

    private int id;
    private Date date;
    private String message;

    @Override
    public String toString() {
        return "Call{" +
                "id=" + id +
                ", date=" + date +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Call call = (Call) o;
        return id == call.id &&
                Objects.equals(date, call.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
