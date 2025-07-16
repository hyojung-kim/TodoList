package com.ll.todo;
import com.ll.Container;
import java.util.ArrayList;
import java.util.List;

public class TodoController {
    Request request;

    String command;
    TodoService todoService;
    public TodoController(){
        todoService = new TodoService();
        request = new Request();
    }

    public void run() {
        while (true) {
            int getInt;
            System.out.print("선택 > ");
            command = Container.getSc().nextLine();
            request.ReqSplit(command);
            getInt = _getIntParam(command);//유효검사
            if (getInt == -1) {
                System.out.println("숫자로 입력!");
            }
            else if(request.getActionCode().equals("1")){ //할일 추가
                write();
            }
            else if(request.getActionCode().equals("2")){ //전체 보기
                list();
            }
            else if(request.getActionCode().equals("4")){ //할일 삭제
                delete();
            }
        }



    }

    void write(){
        System.out.print("할일(추가): ");
        command = Container.getSc().nextLine();
        Todo todo = new Todo(command);

        int id = TodoService.create(todo);
        System.out.printf("%d번 등록되었습니다\n",id);
    }
    void list(){
        List<Todo> todoList = TodoService.findAll();
        System.out.println("번호/할일/상태");
        System.out.println("------------");
        for (int i = todoList.size() - 1; i >= 0; i--) {
            Todo todo = todoList.get(i);
            System.out.printf("%d / %s / %s\n", todo.getId(), todo.getContent(), todo.getIsDone() ? "O":"X");
        }
    }
    void delete(){
        System.out.print("삭제?id= : ");
        command = "삭제?id=" + Container.getSc().nextLine();
        request.ReqSplit(command);
        int id = _getIntParam(request.getParam("id"));
        Todo todo = _FindById(id);
        if (todo == null) {
            System.out.printf("%d번 글이 존재하지 않습니다.\n", id);
        }
        else {
            //todoList.remove(todo);
            System.out.printf("%d번 글이 삭제되었습니다.\n", id);
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
    private Todo _FindById(int id) {
        List<Todo> todoList = null;
        for (Todo todo : todoList) {
            if (todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }



}
