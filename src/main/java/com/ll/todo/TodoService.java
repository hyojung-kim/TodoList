package com.ll.todo;

import java.util.List;

public class TodoService {
    public static int create(Todo todo) {
        return TodoRepository.create(todo);
    }

    public static List<Todo> findAll() {
        return TodoRepository.findAll();
    }
}
