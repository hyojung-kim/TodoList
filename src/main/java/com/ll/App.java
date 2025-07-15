package com.ll;

import com.ll.todo.TodoController;


public class App {
    TodoController todoController;

    App(){
        todoController= new TodoController();
    }
    public void run() {
        System.out.print("=== TODO 메뉴 ===\n1. 할 일 추가\n3. 완료 체크\n4. 삭제\n5. 종료\n");
        todoController.run();
    }
}
