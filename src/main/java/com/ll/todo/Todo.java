package com.ll.todo;


import java.util.Map;

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
    public Todo(Map<String, Object> row) {
        this.id = (int)row.get("id");
        this.content = (String)row.get("content");
        this.isDone = (boolean)row.get("isDone");
    }

    public int getId() { return id; }
    public String getContent() { return content; }
    public boolean getIsDone() { return isDone; }


}


