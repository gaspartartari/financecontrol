package com.myprojects.financecontrol.services.excepetions;

public class DatabaseException extends RuntimeException {

    public DatabaseException(String msg){
        super(msg);
    }
    
}
