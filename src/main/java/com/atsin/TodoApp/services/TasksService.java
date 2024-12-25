package com.atsin.TodoApp.services;

import com.atsin.TodoApp.entities.Tasks;
import com.atsin.TodoApp.repositories.TasksRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TasksService {

    private final TasksRepository tasksRepository;

    public TasksService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public List<Tasks> getAllTasks() {
        return tasksRepository.findAll();
    }

    public void addTask(String title) {
        Tasks task = Tasks.builder()
                .title(title)
                .completed(false)
                .build();
        tasksRepository.save(task);
    }

    public void deleteTask(Long id) {
        tasksRepository.deleteById(id);
    }

    public void toggleTask(Long id) {
        Tasks task = tasksRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());
        task.setCompleted(!task.isCompleted());
        tasksRepository.save(task);
    }
}
