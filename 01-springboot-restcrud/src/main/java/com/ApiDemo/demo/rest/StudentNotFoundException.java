package com.ApiDemo.demo.rest;

//  A class for custom exceptions
public class StudentNotFoundException extends RuntimeException {

//    Constructors from 'super class;
    public StudentNotFoundException(String message) {
        super(message);
    }
    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }
}
