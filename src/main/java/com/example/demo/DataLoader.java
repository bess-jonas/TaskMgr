package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// @Component tells Spring to manage this class automatically,
// meaning it gets created and run by Spring on startup without us doing it manually
@Component
// CommandLineRunner is an interface that forces us to implement a run() method
// Spring calls that run() method automatically after the app has fully started
public class DataLoader implements CommandLineRunner {

    // @Autowired tells Spring to automatically inject the TaskRepository here
    // meaning we don't create it with "new TaskRepository()" ourselves,
    // Spring finds the existing instance and plugs it in for us
    @Autowired
    private TaskRepository taskRepository;

    // This method is called automatically by Spring after startup
    // String... args are command line arguments passed to the app, we don't use them here
    @Override
    public void run(String... args) {
        // Save three test tasks to the database using our repository
        // UUIDs are generated automatically by JPA, we don't touch them
        taskRepository.save(new Task("Buy groceries"));
        taskRepository.save(new Task("Walk the dog"));
        taskRepository.save(new Task("Learn Spring Boot"));
    }
    // POST endpoint - receives a Task as JSON and saves it to the database
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        // save() returns the saved object, now with its auto-generated UUID
        return taskRepository.save(task);
    }
}