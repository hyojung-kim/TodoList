package com.ll;

import com.ll.db.DBConnection;
import com.ll.todo.TodoController;


public class App {
    TodoController todoController;

    App(){
        DBConnection.DB_NAME = "hj1";
        DBConnection.DB_PORT = 3306;
        DBConnection.DB_USER = "root";
        DBConnection.DB_PASSWORD = "";

        Container.getDBConnection().connect();

        todoController= new TodoController();
    }
    public void run() {
        System.out.print("=== TODO 메뉴 ===\n1. 할 일 추가\n2. 전체 보기\n3. 완료 체크\n4. 삭제\n5. 종료\n");
        todoController.run();
    }
}
