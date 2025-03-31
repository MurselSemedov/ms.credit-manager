package com.mursalsamad.service;

import com.mursalsamad.model.request.SaveCreditRequest;
import com.mursalsamad.model.response.CreditResponse;

import java.util.List;

public interface ICreditService {

    void saveCredit(SaveCreditRequest request);
    List<CreditResponse> getAllCreditByStatus(String status);
}
