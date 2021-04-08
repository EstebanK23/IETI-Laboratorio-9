package eci.ieti.data.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Todo {

    @Id
    private Long id;

    private String description;

    private int priority;

    private Date duaDate;

    private String responsible;

    private String status;

    public Todo(){}

    public Todo(String description, int priority, Date duaDate, String responsible, String status){
        this.description = description;
        this.priority = priority;
        this.duaDate = duaDate;
        this.responsible = responsible;
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format(
                "Todo[id=%s, description='%s', priority='%s', duaDate='%s', responsible='%s', status='%s']",
                id, description, priority,duaDate,responsible,status);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Date getDuaDate() {
        return duaDate;
    }

    public void setDuaDate(Date duaDate) {
        this.duaDate = duaDate;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
