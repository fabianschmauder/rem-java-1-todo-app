package de.neuefische.backend.totodao;

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
public class ToDoDao {

    private ToDo newToDo;
    private List<ToDo> toDoList =new ArrayList<>();

    public Optional<List> getAllToDos() {

        return Optional.of(toDoList);

    }

    public ToDo addToDo(String description, String status) {
        ToDo newTodo = new ToDo(description, status);
        toDoList.add(newTodo);
        return newTodo;
    }

    public Optional<ToDo> getById(String id) {

        return null;
    }

    public Optional<ToDo> getByDescription(String description) {

        return null;

    }

    public Optional<ToDo> getByStatus(String status) {

        return null;

    }
}
