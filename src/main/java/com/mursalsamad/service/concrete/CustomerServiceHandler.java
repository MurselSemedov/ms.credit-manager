package com.mursalsamad.service.concrete;

import com.mursalsamad.dao.entity.CustomerEntity;
import com.mursalsamad.dao.repository.CustomerRepository;
import com.mursalsamad.exception.NotFoundException;
import com.mursalsamad.mapper.CustomerMapper;
import com.mursalsamad.model.criteria.CustomerCriteria;
import com.mursalsamad.model.request.CustomerQueueRequest;
import com.mursalsamad.model.request.SaveCustomerRequest;
import com.mursalsamad.model.response.CustomerResponse;
import com.mursalsamad.service.specification.CustomerSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.mursalsamad.exception.ErrorMessage.NO_DATA_FOUND;
import static com.mursalsamad.mapper.CustomerMapper.buildCustomerEntity;
import static com.mursalsamad.mapper.CustomerMapper.mapCustomerEntityToDto;

@Service
@RequiredArgsConstructor
public class CustomerServiceHandler implements com.mursalsamad.service.abstraction.CustomerService {

    private final CustomerRepository customerRepository;


    public void saveCustomer(SaveCustomerRequest request) {
        customerRepository.save(buildCustomerEntity(request));
    }

//    public CustomerResponse findByPin(String pin){
//        return mapCustomerEntityToDto(customerRepository.findByPin(pin)
//                .orElseThrow(() -> new NotFoundException(String.format(NO_DATA_FOUND.getMessage(),"pin:"+pin))));
//    }

    public List<CustomerResponse> searchCustomers(CustomerCriteria criteria){
        var customerList = customerRepository.findAll(new CustomerSpecification(criteria));
        return customerList.stream().map(CustomerMapper::mapCustomerEntityToDto).toList();
    }

    public void testRabbitMQ(CustomerQueueRequest request) {
        System.out.println("Men isledim : " + request.getId());
    }

    public CustomerResponse getById(Long id){
        return mapCustomerEntityToDto(fetchCustomerIfExist(id));
    }


    private CustomerEntity fetchCustomerIfExist(Long id){
        return customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(NO_DATA_FOUND.getMessage(),"id:" + id));
    }
}
