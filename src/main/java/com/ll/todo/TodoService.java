package com.ll.todo;

import java.util.List;

public class TodoService {

    TodoRepository todoRepository = new TodoRepository();

    public  int create(Todo todo) {
        return todoRepository.create(todo);
    }

    public  List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public  void delete(Todo todo) {
        todoRepository.delete(todo);
    }

    public int getIntParam(String command){
        return todoRepository.getIntParam(command);
    }

    public Todo FindById(int id) {
        return  todoRepository.FindById(id);
    }

    public void complete(Todo todo) {
        todoRepository.complete(todo);
    }
}
