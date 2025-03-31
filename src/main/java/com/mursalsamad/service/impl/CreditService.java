package com.mursalsamad.service.impl;
import com.mursalsamad.dao.repository.CreditRepository;
import com.mursalsamad.mapper.CreditMapper;
import com.mursalsamad.model.request.SaveCreditRequest;
import com.mursalsamad.model.response.CreditResponse;
import com.mursalsamad.service.ICreditService;
import com.mursalsamad.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import static com.mursalsamad.mapper.CreditMapper.buildCreditEntity;
import static com.mursalsamad.mapper.StatusHistoryMapper.buildStatusHistoryEntity;
import static com.mursalsamad.model.enums.CreditStatus.DRAFT;

@Service
@RequiredArgsConstructor
public class CreditService implements ICreditService {

    private final CreditRepository creditRepository;
    private final ICustomerService customerService;

    @Transactional
    public void saveCredit(SaveCreditRequest request){
        var customer = customerService.getById(request.getCustomerId());
        var credit = buildCreditEntity(request,customer);
        credit.setStatus(DRAFT);
        credit.setCheckDate(LocalDateTime.now().plusDays(2L));
        var statusHistory = buildStatusHistoryEntity(credit);
        creditRepository.save(credit);
        credit.setStatusHistories(List.of(statusHistory));
    }

    public List<CreditResponse> getAllCreditByStatus(String status){
        var creditList = creditRepository.findAllByStatus(status);
        return creditList.stream().map(CreditMapper::mapCreditEntityToDto).toList();
    }
}
