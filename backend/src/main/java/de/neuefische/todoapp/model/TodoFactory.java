package de.neuefische.todoapp.model;

import de.neuefische.todoapp.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoFactory {

    private final IdUtil idUtil;

    @Autowired
    public TodoFactory(IdUtil idUtil) {
        this.idUtil = idUtil;
    }

    public Todo createTodo(AddTodoDto dto){
       return new Todo(idUtil.generateId(), dto.getDescription(), dto.getStatus());
    }
}
