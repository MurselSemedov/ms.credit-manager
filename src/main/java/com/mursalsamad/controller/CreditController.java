package com.mursalsamad.controller;

import com.mursalsamad.model.request.SaveCreditRequest;
import com.mursalsamad.model.response.CreditResponse;
import com.mursalsamad.service.ICreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/v1/api/credits")
@RequiredArgsConstructor
public class CreditController {

    private final ICreditService creditService;

    @PostMapping("/save")
    @ResponseStatus(CREATED)
    public void saveCredit(@RequestBody SaveCreditRequest request){
        creditService.saveCredit(request);
    }

    @GetMapping
    public List<CreditResponse> getAllByStatus(String status){
        return creditService.getAllCreditByStatus(status);
    }
}
