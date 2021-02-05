package de.neuefische.backend.controller;

import de.neuefische.backend.model.ToDo;
import de.neuefische.backend.model.ToDoInput;
import de.neuefische.backend.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api")
public class ToDoController {

    ToDoService toDoService;

    @Autowired
    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping("all")
    public List<ToDo> getAllToDos() {
        if (toDoService.getAllToDos().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return toDoService.getAllToDos().get();
    }

    @GetMapping("Description")
    public ToDo getToDoByDesctiption(String description) {
        if (toDoService.getToDoByDescription(description).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return toDoService.getToDoByDescription(description).get();
    }

    @GetMapping("Status")
    public ToDo getToDoByStatus(String status) {
        if (toDoService.getToDoByStatus(status).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return toDoService.getToDoByStatus(status).get();
    }

    @GetMapping("Id")
    public ToDo getToDoById(String id) {
        if (toDoService.getToDoById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return toDoService.getToDoById(id).get();
    }

    @PostMapping("todo")
    public ToDo addToDo (@RequestBody ToDoInput toDoInput){
        return toDoService.addToDo(toDoInput);
    }

    @DeleteMapping("todo/{id}")
    public void deleteToDo (@PathVariable String id ){
        toDoService.deleteById(id);
    }
}
