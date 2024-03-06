package dowlath.io.demo.domain;

/*
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;
import java.util.Objects;
*/
//@Entity

import java.util.Date;
import java.util.Objects;

public class Todo {

   // @Id
    //@GeneratedValue
    private Long id ;
    private String userName;
    private String description;
    private Date targetDate;
    private boolean isDone;


    public Todo() {
    }

    public Todo(Long id, String userName, String description, Date targetDate, boolean isDone) {
        this.id = id;
        this.userName = userName;
        this.description = description;
        this.targetDate = targetDate;
        this.isDone = isDone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Todo)) return false;
        Todo todo = (Todo) o;
        return isDone() == todo.isDone() && Objects.equals(getId(), todo.getId()) && Objects.equals(getUserName(), todo.getUserName()) && Objects.equals(getDescription(), todo.getDescription()) && Objects.equals(getTargetDate(), todo.getTargetDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserName(), getDescription(), getTargetDate(), isDone());
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", description='" + description + '\'' +
                ", targetDate=" + targetDate +
                ", isDone=" + isDone +
                '}';
    }
}
