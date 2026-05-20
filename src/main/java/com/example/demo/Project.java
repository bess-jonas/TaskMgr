package com.example.demo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    // One project can contain many tasks
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();

    public Project() {}

    public Project(String name) {
        this.name = name;
    }

    // Getters
    public UUID getId() { return id; }
    public String getName() { return name; }
    public List<Task> getTasks() { return tasks; }
}