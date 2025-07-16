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

        String[] paramList = commandList[1].split("&"); //id=2 & title=제목1 & content=가나다
        for(String paramsRow :  paramList) {
            String[] paramStr = paramsRow.split("=",2);
            String key = paramStr[0];
            String value = paramStr[1];
            params.put(key, value);
        }
    }

    public String getActionCode() {
        return actionCode;
    }
    public String getParam(String key) {
        return params.get(key);
    }
}
