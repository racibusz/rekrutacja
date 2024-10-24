package com.example.app;

public class CurrencyDoesntExistException extends Exception{
    public CurrencyDoesntExistException(String msg){
        System.out.println(msg);
    }
}
