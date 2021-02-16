package de.neuefische.todoapp.service;

import de.neuefische.todoapp.db.TodoDB;
import de.neuefische.todoapp.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoDB todoDB;

    @Autowired
    public TodoService(TodoDB todoDB) {
        this.todoDB = todoDB;
    }

    public List<Todo> getTodos() {
        return todoDB.getAllTodos();
    }

    public Todo addTodo(Todo todoToAdd) {
        return todoDB.addTodo(todoToAdd);
    }

    public Optional<Todo> updateTodo(Todo updatedTodo) {
        return todoDB.updateTodo(updatedTodo);
    }

    public void deleteTodo(String id) {
        todoDB.deleteTodo(id);
    }
}
