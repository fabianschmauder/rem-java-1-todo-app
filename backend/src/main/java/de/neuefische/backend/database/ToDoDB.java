package de.neuefische.backend.database;

import de.neuefische.backend.model.ToDo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
@NoArgsConstructor
public class ToDoDB {

    private ToDo newTodo;
    private List<ToDo> toDoList = new ArrayList<>();

    public Optional<List> getAllTodos() {

        return Optional.of(toDoList);
    }

    public Optional<ToDo> getToDoByDescription(String description) {

        return null;
    }

    public Optional<ToDo> getToDoByID(String id) {

        return null;
    }

    public Optional<ToDo> getToDoByStatus(String status) {

        return null;
    }

    public ToDo addToDo(String description, String status) {
        ToDo newTodo = new ToDo(description, status);
        toDoList.add(newTodo);
        return newTodo;
    }

}
