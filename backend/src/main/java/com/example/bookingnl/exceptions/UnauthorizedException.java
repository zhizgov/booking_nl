package com.example.bookingnl.exceptions;

public class UnauthorizedException extends RuntimeException{
    public UnauthorizedException(){super("You are not authorized for this action!");}
}
