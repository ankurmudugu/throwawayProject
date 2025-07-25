package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.TaskRepo;

@Service
public class TaskService {
    @Autowired
    private TaskRepo taskrepo;

    public List<Task> getAllTasks() {
        return taskrepo.findAll();
    }

    public Optional<Task> getTask(String id) {
        return taskrepo.findById(id);
    }

    public Task createTask(Task task) {
        return taskrepo.save(task);
    }

    public Task updateTask(String id, Task updatedTask) {
        Optional<Task> optionalTask = taskrepo.findById(id);

        if (optionalTask.isPresent()) {
            Task existingTask = optionalTask.get();
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setCompleted(updatedTask.getCompleted());
            return taskrepo.save(existingTask);
        } else {
            throw new RuntimeException("Task with id " + id + " not found");
        }
    }

    public Optional<List<Task>> getByCompleted(boolean completed){
        return taskrepo.findByCompleted(completed);
    }

    public void deleteTask(String id) {
        taskrepo.deleteById(id);
    }

    public void deleteTaskTitle(String title) {
        taskrepo.deleteByTitle(title);
    }
}
