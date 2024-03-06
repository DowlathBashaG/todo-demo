package dowlath.io.demo.service;


import dowlath.io.demo.domain.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ToDoService {

    private static List<Todo> todos = new ArrayList<>();

    private static long idCount = 0;

    static{

        todos.add(new Todo(++idCount,"Dowlath", "Learn Spring", new Date(),false));
        todos.add(new Todo(++idCount,"Basha", "Learn Rest", new Date(),false));
        todos.add(new Todo(++idCount,"Anil", "Learn Quarkus", new Date(),false));

    }

    public List<Todo>  findAll(){
        return todos;
    }

    public Todo save(Todo todo){
        if(todo.getId() == -1 || todo.getId()==0){
            todo.setId(++idCount);
            todos.add(todo);

        } else {
            deleteById(todo.getId());
            todos.add(todo);
        }
        return todo;
    }

    public Todo deleteById(long id){
        Todo todo = findById(id);

        if(todo == null){
            return null;
        }
        if (todos.remove(todo)) {

            return todo;
        }

        return null;

    }

    public Todo findById(long id){
        for(Todo todo : todos){
            if(todo.getId() == id){
                return todo;
            }

        }
        return null;
    }
}
