package com.mursalsamad.service.abstraction;

import com.mursalsamad.model.request.SaveCreditRequest;
import com.mursalsamad.model.response.CreditResponse;

import java.util.List;

public interface CreditService {

    void saveCredit(SaveCreditRequest request,Long customerId);
    List<CreditResponse> getAllCreditByStatus(String status);
}
