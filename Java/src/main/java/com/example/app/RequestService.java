package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {
    private final RequestDatabase requestDatabase;
    @Autowired
    public RequestService(RequestDatabase requestDatabase){
        this.requestDatabase = requestDatabase;
    }
    public Request saveRequest(Request request){
        return this.requestDatabase.save(request);
    }
    public List<Request> getRequests(){
        return this.requestDatabase.findAll();
    }
}
