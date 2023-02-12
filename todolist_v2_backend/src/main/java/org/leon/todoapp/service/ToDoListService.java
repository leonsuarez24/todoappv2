package org.leon.todoapp.service;

import org.leon.todoapp.dto.ToDoListDto;
import org.leon.todoapp.entity.ToDoList;

import java.util.List;

public interface ToDoListService {

    List<ToDoList> getAll();
    ToDoList getOne(Long id);
    ToDoList save(ToDoList toDoList);
    ToDoList update(Long id, ToDoListDto toDoListDto);
    ToDoList delete(Long id);
}
