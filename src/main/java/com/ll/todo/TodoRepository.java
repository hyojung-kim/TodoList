package com.ll.todo;

import com.ll.Container;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TodoRepository {
    public  int create(Todo todo) {
        String sql = String.format("INSERT INTO todo (content, isDone)\n" +
                "values('%s', %b)", todo.getContent(), todo.getIsDone());

        int id = Container.getDBConnection().insert(sql);

        return id;
    }

    public  List<Todo> findAll() {
        List<Todo> todoList = new ArrayList<>();
        List<Map<String, Object>> rows = Container.getDBConnection().selectRows("select * from Todo");
        for ( Map<String, Object> row : rows ) {
            Todo todo = new Todo(row);
            todoList.add(todo);
        }

        return todoList;

    }

    public  void delete(Todo todo) {
        String sql = String.format("DELETE FROM todo WHERE id = %d", todo.getId() );
        Container.getDBConnection().delete(sql);
    }

    public int getIntParam(String command) {
        int defaultValue = -1;
        try{
            return  Integer.parseInt(command);
        }catch (NumberFormatException e){
            return defaultValue; //변환 불가능
        }
    }

    public Todo FindById(int id) {
        List<Todo> todoList = findAll();
        for (Todo todo : todoList) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }
}
