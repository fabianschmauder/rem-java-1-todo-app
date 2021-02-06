package de.neuefische.backend.model;

import lombok.*;

import java.util.UUID;

@Data
@Getter
@Setter

public class ToDo {

    private String id;
    private String description;
    private String status;

    public ToDo(String description, String status) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.status = status;

    }

    public ToDo() {
    }

}
