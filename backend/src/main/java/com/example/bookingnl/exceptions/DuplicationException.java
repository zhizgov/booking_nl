package com.example.bookingnl.exceptions;

public class DuplicationException extends RuntimeException{
    public DuplicationException(){
        super("There is already such existing data!");
    }
}
