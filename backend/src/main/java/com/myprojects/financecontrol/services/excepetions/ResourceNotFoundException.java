package com.myprojects.financecontrol.services.excepetions;

public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(String msg){
        super(msg);
    }
}
