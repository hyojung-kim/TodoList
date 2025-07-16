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
            else if(request.getActionCode().equals("4")){ //전체 보기
                delete();
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
    private Todo _getAclFindById(int id) {
        for (Todo todo : todoList) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
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
    void delete(){
        System.out.print("삭제?id= : ");
        command = Container.getSc().nextLine();
        request.ReqSplit(command);
        int id = _getIntParam(request.getParam("id"));
        Todo todo = _getAclFindById(id);
        if (todo == null) {
            System.out.printf("%d번 글이 존재하지 않습니다.\n", id);
        }
        else {
            todoList.remove(todo);
            System.out.printf("%d번 글이 삭제되었습니다.\n", id);
        }
    }



}
