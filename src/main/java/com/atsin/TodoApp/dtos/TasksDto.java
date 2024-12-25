package com.atsin.TodoApp.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TasksDto {
    private Long Id;
    String title;
    String description;
    Boolean isCompleted;
}
