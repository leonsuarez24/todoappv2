package org.leon.todoapp.controller;

import org.leon.todoapp.dto.ToDoListDto;
import org.leon.todoapp.entity.ToDoList;
import org.leon.todoapp.service.ToDoListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todolist")
public class ToDoListController {

    private final ToDoListService toDoListService;

    public ToDoListController(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    @GetMapping
    public ResponseEntity<List<ToDoList>> getAll(){
        return new ResponseEntity<>(toDoListService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ToDoList> getOne(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(toDoListService.getOne(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ToDoList> save(@RequestBody ToDoList toDoList){
        return new ResponseEntity<>(toDoListService.save(toDoList), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDoList> update(@PathVariable(name = "id") Long id, @RequestBody ToDoListDto toDoListDto){
        return new ResponseEntity<>(toDoListService.update(id, toDoListDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ToDoList> delete(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(toDoListService.delete(id), HttpStatus.OK);
    }
}
