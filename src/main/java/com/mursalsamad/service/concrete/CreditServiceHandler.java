package com.mursalsamad.service.concrete;
import com.mursalsamad.dao.repository.CreditRepository;
import com.mursalsamad.model.request.SaveCreditRequest;
import com.mursalsamad.model.response.CreditResponse;
import com.mursalsamad.service.abstraction.CreditService;
import com.mursalsamad.service.abstraction.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static com.mursalsamad.mapper.CreditMapper.CREDIT_MAPPER;
import static com.mursalsamad.mapper.StatusHistoryMapper.buildStatusHistoryEntity;
import static com.mursalsamad.model.enums.CreditStatus.DRAFT;

@Service
@RequiredArgsConstructor
public class CreditServiceHandler implements CreditService {

    private final CreditRepository creditRepository;
    private final CustomerService customerService;

    @Transactional
    public void saveCredit(SaveCreditRequest request,Long customerId){
        var customer = customerService.getById(customerId);
        var credit = CREDIT_MAPPER.buildCreditEntity(request,customer,customerId);
        credit.setStatus(DRAFT);
        credit.setCheckDate(LocalDateTime.now().plusDays(2L));
        var statusHistory = buildStatusHistoryEntity(credit);
        creditRepository.save(credit);
        credit.setStatusHistories(List.of(statusHistory));
    }

    public List<CreditResponse> getAllCreditByStatus(String status){
        var creditList = creditRepository.findAllByStatus(status);
        return creditList.stream().map(CREDIT_MAPPER::mapCreditEntityToDto).toList();
    }
}
