package de.neuefische.todo.service;


import de.neuefische.todo.controller.ToDoController;
import de.neuefische.todo.db.ToDoDB;
import de.neuefische.todo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ToDoService {
    //
    private ToDoDB toDoDB;
    //
    @Autowired
    public ToDoService(ToDoDB toDoDB){
        this.toDoDB = toDoDB;
    }
    // Get All ToDos as List
    public Optional<List<Todo>> getAllToDos (){
        Optional<List<Todo>> dataBaseList = toDoDB.getDB();
        return dataBaseList;
    }

    public Optional<Todo> addToDo(Todo toDo) {
        UUID uuid = UUID.randomUUID();
        toDo.setUuid(uuid);
        Optional<Todo> response = toDoDB.add(toDo);
        return response;
    }

    public Optional<Todo> updateToDo(String id, Todo updateToDo) {
        Optional<Todo> response = toDoDB.update(id, updateToDo);
        return response;
    }

    public void deleteToDo(String id) {
        toDoDB.delete(id);
    }
}
