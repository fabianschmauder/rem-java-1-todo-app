package de.neuefische.todo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {

    @JsonProperty("id")
    private UUID uuid;
    private String description;
    private String status;

    public Todo (String description, String status){
        this.description = description;
        this.status = status;
    }

}
