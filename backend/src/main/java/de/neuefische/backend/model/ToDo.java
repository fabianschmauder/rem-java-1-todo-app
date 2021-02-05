package de.neuefische.backend.model;

import lombok.Data;

import java.util.UUID;

@Data
public class ToDo {

    private String id;
    private String description;
    private String status;

    public ToDo(String description, String status) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.status = status;
    }
}
