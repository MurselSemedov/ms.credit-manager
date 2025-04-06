package com.mursalsamad.controller;

import com.mursalsamad.model.criteria.CustomerCriteria;
import com.mursalsamad.model.request.SaveCustomerRequest;
import com.mursalsamad.model.response.CustomerResponse;
import com.mursalsamad.service.abstraction.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/save")
    @ResponseStatus(CREATED)
    public void saveCustomer(@RequestBody SaveCustomerRequest request){
        customerService.saveCustomer(request);
    }

//    @GetMapping
//    public CustomerResponse findByPin(String pin){
//        return customerService.findByPin(pin);
//    }

    @GetMapping("/{id}")
    public CustomerResponse findById(@PathVariable Long id){
        return customerService.getById(id);
    }
    @GetMapping
    public List<CustomerResponse> searchCustomers(CustomerCriteria criteria){
        return customerService.searchCustomers(criteria);
    }
}
