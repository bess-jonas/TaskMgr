package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    boolean done;
    public Task() {}

    public Task(String title){
        this.title=title;
        this.done=false;
    }

    public UUID getUUID() {return id;}
    public String getTitle() {return title;}
    public boolean isDone() {return done;}

    public void setTitle(String title) {this.title = title;}
    public void setDone(boolean done) {this.done = done;}
}
