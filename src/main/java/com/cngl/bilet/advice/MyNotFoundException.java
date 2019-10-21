package com.cngl.bilet.advice;


public class MyNotFoundException extends RuntimeException  {
    
    private static final long serialVersionUID = -1529297551064009631L;

    public MyNotFoundException(String Message) {
        super(Message);
    }
    
}