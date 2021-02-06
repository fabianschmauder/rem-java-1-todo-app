package de.neuefische.backend.service;

import de.neuefische.backend.database.ToDoDB;
import de.neuefische.backend.model.ToDo;
import de.neuefische.backend.model.ToDoInput;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    private ToDoDB toDoDB;

    @Autowired
    public ToDoService(ToDoDB toDoDB) {
        this.toDoDB = toDoDB;
    }

    public Optional<ToDo[]> getAllTodos() {
        return toDoDB.getAllTodos();
    }

    public Optional<ToDo> getToDoByID(String id) {

        return toDoDB.getToDoByID(id);
    }

    public ToDo addToDo(ToDoInput toDoInput) {
        String description = toDoInput.getDescription();
        String status = toDoInput.getStatus();

       return toDoDB.addToDo(description, status);
    }

    public void deleteToDo(String id) {
        toDoDB.deleteToDo(id);
    }

    public Optional<ToDo> advanceStatusOfToDo(String id) {
        return toDoDB.advanceStatusOfToDo(id);
    }
}
