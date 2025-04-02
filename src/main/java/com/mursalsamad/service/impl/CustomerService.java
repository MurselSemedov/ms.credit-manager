package com.mursalsamad.service.impl;

import com.mursalsamad.dao.entity.CustomerEntity;
import com.mursalsamad.dao.repository.CustomerRepository;
import com.mursalsamad.exception.NotFoundException;
import com.mursalsamad.mapper.CustomerMapper;
import com.mursalsamad.model.criteria.CustomerCriteria;
import com.mursalsamad.model.request.SaveCustomerRequest;
import com.mursalsamad.model.response.CustomerResponse;
import com.mursalsamad.service.ICustomerService;
import com.mursalsamad.service.specification.CustomerSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

//    public CustomerResponse findByPin(String pin){
//        return mapCustomerEntityToDto(customerRepository.findByPin(pin)
//                .orElseThrow(() -> new NotFoundException(String.format(NO_DATA_FOUND.getMessage(),"pin:"+pin))));
//    }

    public List<CustomerResponse> searchCustomers(CustomerCriteria criteria){
        var specification = new CustomerSpecification(criteria);
        var customerList = customerRepository.findAll(specification);
        return customerList.stream().map(CustomerMapper::mapCustomerEntityToDto).toList();
    }

    public CustomerResponse getById(Long id){
        return mapCustomerEntityToDto(fetchCustomerIfExist(id));
    }

    private CustomerEntity fetchCustomerIfExist(Long id){
        return customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format(NO_DATA_FOUND.getMessage(),"id:" + id)));
    }
}
