package com.mursalsamad.mapper;

import com.mursalsamad.dao.entity.CreditEntity;
import com.mursalsamad.model.request.SaveCreditRequest;
import com.mursalsamad.model.response.CreditResponse;
import com.mursalsamad.model.response.CustomerResponse;

import static com.mursalsamad.mapper.CustomerMapper.buildCustomerEntity;

public class CreditMapper {


    public static CreditEntity buildCreditEntity(SaveCreditRequest request, CustomerResponse response){
        var customer = buildCustomerEntity(response);
        customer.setId(request.getCustomerId());
        return CreditEntity.builder()
                .amount(request.getAmount())
                .term(request.getTerm())
                .interest(request.getInterest())
                .monthlyPayment(request.getMonthlyPayment())
                .requestedAmount(request.getRequestedAmount())
                .customer(customer)
                .build();
    }

    public static CreditResponse mapCreditEntityToDto(CreditEntity creditEntity){
        return CreditResponse.builder()
                .amount(creditEntity.getAmount())
                .requestedAmount(creditEntity.getRequestedAmount())
                .monthlyPayment(creditEntity.getMonthlyPayment())
                .checkDate(creditEntity.getCheckDate())
                .customerFullName(creditEntity.getCustomer().getFullName())
                .interest(creditEntity.getInterest())
                .status(creditEntity.getStatus().name())
                .term(creditEntity.getTerm())
                .term(creditEntity.getTerm())
                .build();
    }
}
