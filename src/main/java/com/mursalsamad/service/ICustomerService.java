package com.mursalsamad.service;

import com.mursalsamad.model.request.SaveCustomerRequest;
import com.mursalsamad.model.response.CustomerResponse;

public interface ICustomerService {

    void saveCustomer(SaveCustomerRequest request);

//    CustomerResponse findByPin(String pin);

    CustomerResponse getById(Long id);
}
