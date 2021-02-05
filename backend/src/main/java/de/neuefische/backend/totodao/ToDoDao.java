package de.neuefische.backend.totodao;

import de.neuefische.backend.model.ToDo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
@NoArgsConstructor
public class ToDoDao {

    private ToDo newToDo;
    private List<ToDo> toDoList = new ArrayList<>();

    public Optional<List> getAllToDos() {

        return Optional.of(toDoList);

    }

    public void deleteById(String id){

        Optional<ToDo> deleteToDo = getById(id);
        if (deleteToDo.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        toDoList.remove(deleteToDo.get());
    }

    public ToDo addToDo(String description, String status) {
        ToDo newTodo = new ToDo(description, status);
        toDoList.add(newTodo);
        return newTodo;
    }

    public Optional<ToDo> getById(String id) {
        List<ToDo> newToDoList = toDoList.stream().filter(toDo -> toDo.getId().equals(id)).collect(Collectors.toList());
        ToDo foundToDo = newToDoList.get(0);
        return Optional.of(foundToDo);
    }

    public Optional<ToDo> getByDescription(String description) {

        return null;

    }

    public Optional<ToDo> getByStatus(String status) {

        return null;

    }

}
