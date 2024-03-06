package dowlath.io.demo.controller;


import dowlath.io.demo.domain.Todo;
import dowlath.io.demo.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class TodoController {

    @Autowired
    private ToDoService toDoService;

    @GetMapping("/users/{userName}/todos")
    public List<Todo> getAllTodos(@PathVariable String userName){
        return toDoService.findAll();
    }

    @GetMapping("/users/{userName}/todos/{id}")
    public Todo getTodo(@PathVariable String userName,@PathVariable long id){
        return toDoService.findById(id);
    }

    @PostMapping("users/{userName}/todos")
    public ResponseEntity<Void>  updateTodo( @PathVariable String userName,@RequestBody Todo todo){
        Todo createTodo = toDoService.save(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createTodo.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @PutMapping("/users/{userName}/todos/{id}")
    public ResponseEntity<Todo> updateTood(@PathVariable String userName, @PathVariable long id,@RequestBody Todo todo){
        Todo  todoUpdated = toDoService.save(todo);
        return new ResponseEntity<Todo>(todo, HttpStatus.OK);

    }


}
