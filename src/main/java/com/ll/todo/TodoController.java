package com.ll.todo;

import com.ll.Container;

import java.util.ArrayList;
import java.util.List;

public class TodoController {
    Request request;
    List<Todo> todoList;

    public TodoController(){
        request = new Request();
        todoList = new ArrayList<>();
    }

    public void run() {
        while (true) {
            System.out.print("선택 > ");
            String command = Container.getSc().nextLine();
            request.ReqSplit(command);
            if(request.getActionCode().equals("1")){ //할일 추가
                System.out.print("할일(추가): ");
                command = Container.getSc().nextLine();
                Todo todo = new Todo(command);
                todoList.add(todo);
                System.out.println("등록되었습니다");
            }
            else if(request.getActionCode().equals("2")){ //전체 보기
                System.out.println("번호/할일/상태");
                System.out.println("------------");
                for (int i = todoList.size() - 1; i >= 0; i--) {
                    Todo todo = todoList.get(i);
                    System.out.printf("%d / %s / %s\n", todo.getId(), todo.getContent(), todo.getIsDone());
                }
            }
        }


    }
}
