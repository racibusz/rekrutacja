package com.example.app;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.sql.Timestamp;

@Entity
public class Request {
    private @Id @GeneratedValue Long id;
    private String name;
    private String currency;
    private Timestamp timestamp;
    private double rate;
    private String error;

    Request(){}
    Request(String name, String currency){
        this.name = name;
        this.currency = currency;
        this.error = "";
    }

    @Override
    public String toString(){
        return(String.format("Request{\"id\":\"%d\", \"name\":\"%s\", \"currency\":\"%s\", \"timestamp\":\"%s\", \"value\":\"%f\"}", id,name,currency,timestamp,rate));
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getCurrency() {
        return currency;
    }

    public String getName() {
        return name;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public double getRate() {
        return this.rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
    public void setRate(CurrencyDoesntExistException e){
        this.rate = 0.0;
        this.error = e.getMessage();
    }
}
