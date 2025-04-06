package com.mursalsamad.controller;

import com.mursalsamad.model.request.SaveCreditRequest;
import com.mursalsamad.model.response.CreditResponse;
import com.mursalsamad.service.abstraction.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/credits")
@RequiredArgsConstructor
public class CreditController {

    private final CreditService creditService;

    @PostMapping
    @ResponseStatus(CREATED)
    public void saveCredit(@RequestBody @Valid SaveCreditRequest request, @PathVariable Long customerId){
        creditService.saveCredit(request,customerId);
    }

    @GetMapping
    public List<CreditResponse> getAllByStatus(String status){
        return creditService.getAllCreditByStatus(status);
    }
}
