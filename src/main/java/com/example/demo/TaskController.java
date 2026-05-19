package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        // save() returns the saved object, now with its auto-generated UUID
        return taskRepository.save(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable UUID id, @RequestBody Task updatedTask) {
        //@PathVariable associates id with {id} because of the same name
        //@RequestBody translates incoming json data from Front-end changes back to Task Object

        // Find the existing task by ID, update its fields, save and return it
        Task task = taskRepository.findById(id).orElseThrow();
        task.setTitle(updatedTask.getTitle());
        task.setDone(updatedTask.isDone());
        return taskRepository.save(task);

    }

    @DeleteMapping("/{id}")
    public void delTask(@PathVariable UUID id){
        taskRepository.deleteById(id);
    }
}
