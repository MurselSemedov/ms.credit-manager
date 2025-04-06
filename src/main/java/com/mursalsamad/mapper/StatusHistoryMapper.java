package com.mursalsamad.mapper;

import com.mursalsamad.dao.entity.CreditEntity;
import com.mursalsamad.dao.entity.StatusHistoryEntity;

public class StatusHistoryMapper {

    public static StatusHistoryEntity buildStatusHistoryEntity(CreditEntity creditEntity){
        return StatusHistoryEntity.builder()
                .status(creditEntity.getStatus())
                .credit(creditEntity)
                .build();
    }
}
