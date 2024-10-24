package com.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/currencies/get-current-currency-value-command")
public class RequestController {
    RestTemplate restTemplate;
    private String NBP_URL = "https://api.nbp.pl/api/exchangerates/rates/a/";
    private final RequestService requestService;
//    A better endpoint, currency code needs to be added at the end of url
//    format=json
    @Autowired
    public RequestController(RestTemplate restTemplate, RequestService requestService){
        this.restTemplate = restTemplate;
        this.requestService = requestService;
    }

    @PostMapping
    public ResponseEntity<String> responseEntity(@RequestBody Request request) throws CurrencyDoesntExistException {
        ResponseEntity<NbpResult> response;
        try {
            request.setTimestamp(new Timestamp(new Date().getTime()));
            response = restTemplate.getForEntity(NBP_URL + request.getCurrency() + "?format=json", NbpResult.class);
        } catch (HttpClientErrorException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getStatusCode().toString());
        }

        NbpResult result = response.getBody();
        request.setRate(result.getRate().getMid());
        Request savedRequest = requestService.saveRequest(request);
        return ResponseEntity.ok(String.valueOf(result.getRate().getMid()));
    }
}