package com.mursalsamad.service.abstraction;

import com.mursalsamad.model.criteria.CustomerCriteria;
import com.mursalsamad.model.request.CustomerQueueRequest;
import com.mursalsamad.model.request.SaveCustomerRequest;
import com.mursalsamad.model.response.CustomerResponse;

import java.util.List;

public interface CustomerService {

    void saveCustomer(SaveCustomerRequest request);

//    CustomerResponse findByPin(String pin);

    CustomerResponse getById(Long id);

    List<CustomerResponse> searchCustomers(CustomerCriteria criteria);

    void testRabbitMQ(CustomerQueueRequest request);
}
