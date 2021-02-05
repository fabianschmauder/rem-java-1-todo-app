package de.neuefische.todo.controller;

import de.neuefische.todo.model.Todo;
import de.neuefische.todo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/todo")
//
public class ToDoController {
    //
    private ToDoService toDoService;
    //
    @Autowired
    public ToDoController(ToDoService toDoService){
      this.toDoService = toDoService;
    }
    // Put Mapping
    @PutMapping("{id}")
    public Todo updateToDo(@PathVariable String id, @RequestBody Todo toDo){
        Optional<Todo> updatedToDo = toDoService.updateToDo(id, toDo);
        if(updatedToDo.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nothing to Update!");
        }
        return updatedToDo.get();
    }
    // Post Mapping
    @PostMapping
    public Todo createToDo(@RequestBody Todo toDo){
        Optional<Todo> newToDo = toDoService.addToDo(toDo);
        if(newToDo.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nothing to create!");
        }
        return newToDo.get();
    }
    // Get Mapping
    @GetMapping
    public List<Todo> getTodos(){
        Optional<List<Todo>> allToDos = toDoService.getAllToDos();
        if(allToDos.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nothing found!");
        } return allToDos.get();
    }
    // Delete Mapping
    @DeleteMapping("{id}")
    public void deleteToDo(@PathVariable String id){
        toDoService.deleteToDo(id);
    }

    }
