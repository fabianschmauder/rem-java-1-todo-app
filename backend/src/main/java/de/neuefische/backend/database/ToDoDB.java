package de.neuefische.backend.database;

import de.neuefische.backend.model.ToDo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
@NoArgsConstructor
public class ToDoDB {

    private ToDo newTodo;
    private ArrayList<ToDo> toDoList = new ArrayList<>();


    public Optional<ToDo[]> getAllTodos() {
        return Optional.of(toDoList.toArray(new ToDo[toDoList.size()]));
    }

    public Optional<ToDo> getToDoByID(String id) {
        for (ToDo toDo : toDoList) {
            if(toDo.getId().equals(id)) {
                return Optional.of(toDo);
            }
        }
        return Optional.empty();
    }

    public ToDo addToDo(String description, String status) {
        ToDo newTodo = new ToDo(description, status);
        toDoList.add(newTodo);
        return newTodo;
    }

    public void deleteToDo (String id) {
        ToDo toDoToRemove = new ToDo();
        for (ToDo toDo : toDoList) {
            if(toDo.getId().equals(id)) {
                toDoToRemove = toDo;
            }
        }
        toDoList.remove(toDoToRemove);
    }

    public Optional<ToDo> advanceStatusOfToDo(String id) {
       if(getToDoByID(id).isEmpty()) {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND);
       }
       if(getToDoByID(id).get().getStatus().equals("OPEN")) {
           getToDoByID(id).get().setStatus("IN_PROGRESS");
       } else if(getToDoByID(id).get().getStatus().equals("IN_PROGRESS")) {
           getToDoByID(id).get().setStatus("DONE");
       }
       return getToDoByID(id);
    }
}
