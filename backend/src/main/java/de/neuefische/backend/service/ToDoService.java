package de.neuefische.backend.service;

import de.neuefische.backend.model.ToDo;
import de.neuefische.backend.model.ToDoInput;
import de.neuefische.backend.totodao.ToDoDao;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    private ToDoDao toDoDao;

    @Autowired
    public ToDoService(ToDoDao toDoDao) {
        this.toDoDao = toDoDao;
    }

    public Optional<List> getAllToDos() {
        return toDoDao.getAllToDos();

    }

    public Optional<ToDo> getToDoByDescription(String description) {

        return toDoDao.getByDescription(description);
    }

    public Optional<ToDo> getToDoByStatus(String status) {

        return toDoDao.getByStatus(status);
    }

    public Optional<ToDo> getToDoById(String id) {

        return toDoDao.getById(id);
    }

    public ToDo addToDo(ToDoInput toDoInput) {
        String description = toDoInput.getDescription();
        String status = toDoInput.getStatus();

        return toDoDao.addToDo(description, status);
    }


}
