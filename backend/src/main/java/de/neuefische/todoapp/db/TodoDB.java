package de.neuefische.todoapp.db;

import de.neuefische.todoapp.model.Status;
import de.neuefische.todoapp.model.Todo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;


@Repository
public class TodoDB {

    private final List<Todo> todos;

    public TodoDB(){
        todos = new ArrayList<>();
    }

    public List<Todo> getAllTodos() {
        return Collections.unmodifiableList(todos);
    }

    public Todo addTodo(Todo newTodo) {
        if(findById(newTodo.getId()).isPresent()){
            throw new RuntimeException("Id already present: "+newTodo.getId());
        }
        todos.add(newTodo);
        return newTodo;
    }

    public Optional<Todo> findById(String id){
        return todos.stream().filter(todo -> todo.getId().equals(id)).findAny();
    }

    public void clear(){
        todos.clear();
    }

    public Optional<Todo> updateTodo(Todo updatedTodo) {
        Optional<Todo> optionalTodo = findById(updatedTodo.getId());

        if(optionalTodo.isPresent()){
            Todo foundTodo = optionalTodo.get();
            foundTodo.setStatus(updatedTodo.getStatus());
            foundTodo.setDescription(updatedTodo.getDescription());
            return Optional.of(foundTodo);
        }
        return Optional.empty();
    }

    public void deleteTodo(String id) {
        findById(id).ifPresent(todo -> todos.remove(todo));
    }
}
