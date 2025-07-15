package com.ll.todo;


public class Todo {
    private static int sequence = 1;
    private int id;
    private String content;
    private boolean isDone;



    public Todo(String content) {
        this.id = sequence++;
        this.content = content;
        this.isDone = false;

    }

    public int getId() { return id; }
    public String getContent() { return content; }
    public String getIsDone() { return isDone ? "O" : "X"; }


}


