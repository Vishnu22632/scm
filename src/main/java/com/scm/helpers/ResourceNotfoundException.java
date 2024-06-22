package com.scm.helpers;

public class ResourceNotfoundException extends RuntimeException {


    public ResourceNotfoundException(String message){
        super(message);
    }

    public ResourceNotfoundException(){
        super();
    }

}
