package com.mursalsamad.controller;

import com.mursalsamad.dao.entity.CustomerEntity;
import com.mursalsamad.model.request.SaveCustomerRequest;
import com.mursalsamad.model.response.CustomerResponse;
import com.mursalsamad.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/customers")
public class CustomerController {

    private final ICustomerService customerService;

    @PostMapping("/save")
    @ResponseStatus(CREATED)
    public void saveCustomer(@RequestBody SaveCustomerRequest request){
        customerService.saveCustomer(request);
    }

    @GetMapping
    public CustomerResponse findByPin(String pin){
        return customerService.findByPin(pin);
    }

}
