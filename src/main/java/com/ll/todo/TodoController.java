package com.ll.todo;
import com.ll.Container;
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
            getInt = todoService.getIntParam(command);//유효검사
            if (getInt == -1) {
                System.out.println("숫자로 입력!");
            }
            else if(request.getActionCode().equals("1")){ //할일 추가
                write();
            }
            else if(request.getActionCode().equals("2")){ //전체 보기
                list();
            }
            else if(request.getActionCode().equals("3")){ //할일 삭제
                complete();
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

        int id = todoService.create(todo);
        System.out.printf("%d번 등록되었습니다\n",id);
    }
    void list(){
        List<Todo> todoList = todoService.findAll();
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
        int id = todoService.getIntParam(request.getParam("id"));
        Todo todo = todoService.FindById(id);
        todoService.delete(todo);

        if (todo == null) {
            System.out.printf("%d번 글이 존재하지 않습니다.\n", id);
        }
        else {
            System.out.printf("%d번 글이 삭제되었습니다.\n", id);
        }
    }
    void complete(){
        List<Todo> todoList = todoService.findAll();
        System.out.println("번호/할일/상태");
        System.out.println("------------");
        for (int i = todoList.size() - 1; i >= 0; i--) {
            Todo todo = todoList.get(i);
            System.out.printf("%d / %s / %s\n", todo.getId(), todo.getContent(), todo.getIsDone() ? "O":"X");
        }

        System.out.println(" ");
        System.out.println("id&isDone= : ");
        command = "수정?id=" + Container.getSc().nextLine();
        request.ReqSplit(command);
        int id = todoService.getIntParam(request.getParam("id"));
        Todo todo = todoService.FindById(id);
        todoService.complete(todo);

        if (todo == null) {
            System.out.printf("%d번 글이 존재하지 않습니다.\n", id);
        }
        else {
            System.out.printf("%d번 글이 수정되었습니다.\n", id);
        }
    }



}
