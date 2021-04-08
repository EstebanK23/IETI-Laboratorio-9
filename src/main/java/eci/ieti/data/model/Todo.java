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

    private Date dueDate;

    private String responsible;

    private String status;

    public Todo(){}

    public Todo(String description, int priority, Date dueDate, String responsible, String status){
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
        this.responsible = responsible;
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format(
                "Todo[id=%s, description='%s', priority='%s', dueDate='%s', responsible='%s', status='%s']",
                id, description, priority,dueDate,responsible,status);
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
        return dueDate;
    }

    public void setDuaDate(Date dueDate) {
        this.dueDate = dueDate;
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
