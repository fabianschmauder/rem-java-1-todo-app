package de.neuefische.todoapp.util;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IdUtil {

    public String generateId(){
        return UUID.randomUUID().toString();
    }

}
