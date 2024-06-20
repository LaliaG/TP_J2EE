package org.example.tp_j2ee.exception;

public class UserAlreadyExists extends RuntimeException {
    public UserAlreadyExists(String message){
        super(message);
    }
}
