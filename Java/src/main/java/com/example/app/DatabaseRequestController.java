package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/currencies/requests")
@CrossOrigin(origins = "http://localhost:4200")
public class DatabaseRequestController {
    RequestService requestService;
    @Autowired
    public DatabaseRequestController(RequestService requestService){
        this.requestService = requestService;
    }
    @GetMapping
    public List<Request> requestList(){
        return requestService.getRequests();
    }
}
