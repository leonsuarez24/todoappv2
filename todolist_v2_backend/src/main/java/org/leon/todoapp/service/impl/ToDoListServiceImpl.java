package org.leon.todoapp.service.impl;

import org.leon.todoapp.dto.ToDoListDto;
import org.leon.todoapp.entity.ToDoList;
import org.leon.todoapp.repository.ToDoListRepository;
import org.leon.todoapp.service.ToDoListService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoListServiceImpl implements ToDoListService {

    private final ToDoListRepository toDoListRepository;

    public ToDoListServiceImpl(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    @Override
    public List<ToDoList> getAll() {
        return toDoListRepository.findAll();
    }

    @Override
    public ToDoList getOne(Long id) {
        return toDoListRepository.findById(id).get();
    }

    @Override
    public ToDoList save(ToDoList toDoList) {
        return toDoListRepository.save(toDoList);
    }

    @Override
    public ToDoList update(Long id, ToDoListDto toDoListDto) {
        ToDoList toDoList = toDoListRepository.findById(id).get();
        toDoList.setName(toDoListDto.name());
        toDoList.setContent(toDoListDto.content());
        return toDoListRepository.save(toDoList);
    }

    @Override
    public ToDoList delete(Long id) {
        ToDoList toDoList = toDoListRepository.findById(id).get();
        toDoListRepository.delete(toDoList);
        return toDoList;
    }
}
