package com.atsin.TodoApp.controllers;

import com.atsin.TodoApp.entities.Tasks;
import com.atsin.TodoApp.services.TasksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path="/tasks")
public class TasksController {

    private final TasksService tasksService;

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping
    public String getTasks(Model model){
        List<Tasks> tasks = tasksService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @PostMapping
    public String getTasks(@RequestParam String title){
        tasksService.addTask(title);
        return "redirect:/tasks";
    }

    @GetMapping(path = "/{id}/delete")
    public String deleteTask(@PathVariable Long id){
        tasksService.deleteTask(id);
        return "redirect:/tasks";
    }

    @GetMapping(path = "/{id}/toggle")
    public String toggleTask(@PathVariable Long id){
        tasksService.toggleTask(id);
        return "redirect:/tasks";
    }

}
