package com.ll.todo;
import com.ll.Container;
import java.util.ArrayList;
import java.util.List;

public class TodoController {
    Request request;
    List<Todo> todoList;
    String command;
    public TodoController(){
        request = new Request();
        todoList = new ArrayList<>();
    }

    public void run() {
        while (true) {
            int getInt = -1;
            System.out.print("선택 > ");
            command = Container.getSc().nextLine();
            request.ReqSplit(command);
            getInt = _getIntParam(command);
            if (getInt == -1) {
                System.out.println("숫자로 입력!");
            }


            if(request.getActionCode().equals("1")){ //할일 추가
                write();
            }
            else if(request.getActionCode().equals("2")){ //전체 보기
                list();
            }
        }



    }

    private int _getIntParam(String command) {
        int defaultValue = -1;
        try{
            return  Integer.parseInt(command);
        }catch (NumberFormatException e){
            return defaultValue; //변환 불가능
        }

    }

    void write(){
        System.out.print("할일(추가): ");
        command = Container.getSc().nextLine();
        Todo todo = new Todo(command);
        todoList.add(todo);
        System.out.println("등록되었습니다");
    }
    void list(){
        System.out.println("번호/할일/상태");
        System.out.println("------------");
        for (int i = todoList.size() - 1; i >= 0; i--) {
            Todo todo = todoList.get(i);
            System.out.printf("%d / %s / %s\n", todo.getId(), todo.getContent(), todo.getIsDone());
        }
    }



}
