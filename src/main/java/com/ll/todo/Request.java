package com.ll.todo;

import java.util.HashMap;
import java.util.Map;

public class Request {
    private String actionCode;
    private Map<String, String> params =  new HashMap<>();



    void ReqSplit(String command){
        String[] commandList = command.split("\\?",2);//modify?id=1
        actionCode = commandList[0];
        if(commandList.length == 1) return;
    }

    public String getActionCode() {
        return actionCode;
    }
}
