package by.intexsoft.amqpproduce;


import java.util.Date;
import java.util.Objects;

public class Call {

    private int id;
    private Date date;
    private String message;

    public Call(String message){
        this.date = new Date();
        this.message = message;
    }

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

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
