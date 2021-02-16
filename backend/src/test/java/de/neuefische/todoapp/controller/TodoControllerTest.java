package de.neuefische.todoapp.controller;

import de.neuefische.todoapp.db.TodoDB;
import de.neuefische.todoapp.model.AddTodoDto;
import de.neuefische.todoapp.model.Status;
import de.neuefische.todoapp.model.Todo;
import de.neuefische.todoapp.util.IdUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TodoControllerTest {

    @LocalServerPort
    private int port;

    private String getUrl(){
        return "http://localhost:" + port + "/api/todo";
    }

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private TodoDB todoDB;

    @MockBean
    private IdUtil idUtil;

    @BeforeEach
    public void clearDB(){
        todoDB.clear();
    }

    @Test
    @DisplayName("GET to /api/todo returns list with todos")
    public void getAllTodos(){
        // GIVEN
        todoDB.addTodo(new Todo("976f37f4-8aa7-481d-ad2c-2120613f3347","Write tests", Status.OPEN ));
        todoDB.addTodo(new Todo("61084198-b1b7-4d7c-837c-62f458ce765a","Drink coffee", Status.OPEN ));
        todoDB.addTodo(new Todo("4f5cf145-d5f7-430f-8e0e-048ea3c1fc687","Buy milk", Status.OPEN ));

        // WhEN
        ResponseEntity<Todo[]> response = restTemplate.getForEntity(getUrl(), Todo[].class);

        // THEN
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), arrayContainingInAnyOrder(
                new Todo("976f37f4-8aa7-481d-ad2c-2120613f3347","Write tests", Status.OPEN ),
                new Todo("61084198-b1b7-4d7c-837c-62f458ce765a","Drink coffee", Status.OPEN ),
                new Todo("4f5cf145-d5f7-430f-8e0e-048ea3c1fc687","Buy milk", Status.OPEN )
        ));
    }

    @Test
    @DisplayName("POST to /api/todos adds a new todo to the database")
    public void addTodo(){
        // GIVEN
        AddTodoDto todoToPost = new AddTodoDto("Write tests", Status.IN_PROGRESS);
        when(idUtil.generateId()).thenReturn("some-id");

        // WHEN
        ResponseEntity<Todo> response = restTemplate.postForEntity(getUrl(), todoToPost, Todo.class);

        // THEN
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        Todo expectedTodo = new Todo("some-id","Write tests", Status.IN_PROGRESS);
        assertThat(response.getBody(), is(expectedTodo));
        assertThat(todoDB.findById(expectedTodo.getId()).get(), is(expectedTodo));
    }

    @Test
    @DisplayName("PUT to /api/todo/<id> updates the todo")
    public void updateTodo(){
        // GIVEN
        todoDB.addTodo(new Todo("976f37f4-8aa7-481d-ad2c-2120613f3347","Write tests", Status.OPEN ));
        Todo updatedTodo = new Todo("976f37f4-8aa7-481d-ad2c-2120613f3347","Write tests", Status.IN_PROGRESS );

        // WHEN
        HttpEntity<Todo> requestEntity = new HttpEntity<>(updatedTodo);
        ResponseEntity<Todo> response = restTemplate.exchange(
                getUrl()+"/976f37f4-8aa7-481d-ad2c-2120613f3347",
                HttpMethod.PUT,
                requestEntity,
                Todo.class);

        // THEN
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        Todo expectedTodo = new Todo("976f37f4-8aa7-481d-ad2c-2120613f3347","Write tests", Status.IN_PROGRESS );
        assertThat(response.getBody(), is(expectedTodo));
        assertThat(todoDB.findById(expectedTodo.getId()).get(), is(expectedTodo));
    }

    @Test
    @DisplayName("DElETE to /api/todo/<id> deletes the todo")
    public void deleteTodo(){
        // GIVEN
        todoDB.addTodo(new Todo("976f37f4-8aa7-481d-ad2c-2120613f3347","Write tests", Status.OPEN ));

        // WHEN
        restTemplate.delete(getUrl()+"/976f37f4-8aa7-481d-ad2c-2120613f3347");

        // THEN
        assertTrue(todoDB.findById("976f37f4-8aa7-481d-ad2c-2120613f3347").isEmpty());
    }
}