package com.fiap.paquimetro.services.exceptions;

public class MethodArgumentNotValidException extends RuntimeException{

    public MethodArgumentNotValidException(String msg){
        super(msg);
    }

}
