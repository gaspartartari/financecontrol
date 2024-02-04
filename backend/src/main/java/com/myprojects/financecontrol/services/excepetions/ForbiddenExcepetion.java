package com.myprojects.financecontrol.services.excepetions;

public class ForbiddenExcepetion extends RuntimeException {
    
    public ForbiddenExcepetion(String msg){
        super(msg);
    }
}
