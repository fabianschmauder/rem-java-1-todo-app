package de.neuefische.todo.db;

import de.neuefische.todo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ToDoDB {

    Map<UUID, Todo> dataBase = new HashMap<>();

    public Optional<List<Todo>> getDB() {
        List<Todo> list = new ArrayList<>(dataBase.values());
        //
        return Optional.of(list);
        //
    }
    // Post - Add
    public Optional<Todo> add(Todo toDo) {
        Todo returnValue = dataBase.putIfAbsent(toDo.getUuid(), toDo);
        //
        if(returnValue == null){
            return Optional.of(toDo);
        } return Optional.empty();
        //
    }
    // Put - Update
    public Optional<Todo> update(String id, Todo updateToDo) {
        UUID stringID = UUID.fromString(id);
        Todo response = dataBase.put(stringID, updateToDo); // null if new one has been created
        return Optional.of(response);
    }

    public void delete(String id) {
        dataBase.remove(UUID.fromString(id));
    }
}
