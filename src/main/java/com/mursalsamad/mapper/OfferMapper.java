package com.mursalsamad.mapper;

import com.mursalsamad.dao.entity.OfferEntity;

public class OfferMapper {

    public static OfferEntity buildOfferEntity(){
        return OfferEntity.builder().build();
    }
}
