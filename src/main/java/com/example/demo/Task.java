package com.example.demo;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    boolean done;
    public Task() {}
    private String category;
    private String priority;
    @Column(name="due_date")
    private LocalDate dueTime;

    public Task(String title){
        this.title=title;
        this.done=false;
    }

    public UUID getID() {return id;}
    public String getTitle() {return title;}
    public boolean isDone() {return done;}
    public String getCategory() {return category;}
    public String getPriority(){return priority;}
    public LocalDate getDueTime() {return dueTime;}

    public void setTitle(String title) {this.title = title;}
    public void setDone(boolean done) {this.done = done;}
    public void setCategory(String category) {this.category = category;}
    public void setDueTime(LocalDate dueTime) {this.dueTime = dueTime;}
    public void setPriority(String priority) {this.priority = priority;}
}
