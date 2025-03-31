package com.mursalsamad.mapper;

import com.mursalsamad.dao.entity.CustomerEntity;
import com.mursalsamad.model.request.SaveCustomerRequest;
import com.mursalsamad.model.response.CustomerResponse;

public class CustomerMapper {

    public static CustomerEntity buildCustomerEntity(SaveCustomerRequest request){
        return CustomerEntity.builder()
                .pin(request.getPin())
                .fullName(request.getFullName())
                .phoneNumber(request.getPhoneNumber())
                .build();
    }

    public static CustomerResponse mapCustomerEntityToDto(CustomerEntity entity){
        return CustomerResponse.builder()
                .pin(entity.getPin())
                .fullName(entity.getFullName())
                .phoneNumber(entity.getPhoneNumber())
                .build();
    }
}
