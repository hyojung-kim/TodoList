package com.ll.todo;

import com.ll.Container;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TodoRepository {
    public static int create(Todo todo) {
        String sql = String.format("INSERT INTO todo (content, isDone)\n" +
                "values('%s', %b)", todo.getContent(), todo.getIsDone());

        int id = Container.getDBConnection().insert(sql);

        return id;
    }

    public static List<Todo> findAll() {
        List<Todo> todoList = new ArrayList<>();
        List<Map<String, Object>> rows = Container.getDBConnection().selectRows("select * from Todo");
        for ( Map<String, Object> row : rows ) {
            Todo todo = new Todo(row);
            todoList.add(todo);
        }

        return todoList;

    }
}
