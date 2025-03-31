package com.mursalsamad.service.impl;

import com.mursalsamad.dao.entity.CustomerEntity;
import com.mursalsamad.dao.repository.CustomerRepository;
import com.mursalsamad.exception.NotFoundException;
import com.mursalsamad.model.request.SaveCustomerRequest;
import com.mursalsamad.model.response.CustomerResponse;
import com.mursalsamad.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.mursalsamad.exception.ErrorMessage.NO_DATA_FOUND;
import static com.mursalsamad.mapper.CustomerMapper.buildCustomerEntity;
import static com.mursalsamad.mapper.CustomerMapper.mapCustomerEntityToDto;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;


    public void saveCustomer(SaveCustomerRequest request) {
        customerRepository.save(buildCustomerEntity(request));
    }

    public CustomerResponse findByPin(String pin){
        return mapCustomerEntityToDto(customerRepository.findByPin(pin)
                .orElseThrow(() -> new NotFoundException(String.format(NO_DATA_FOUND.getMessage(),"pin:"+pin))));
    }

    public CustomerResponse getById(Long id){
        return mapCustomerEntityToDto(fetchCustomerIfExist(id));
    }

    private CustomerEntity fetchCustomerIfExist(Long id){
        return customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format(NO_DATA_FOUND.getMessage(),"id:" + id)));
    }
}
