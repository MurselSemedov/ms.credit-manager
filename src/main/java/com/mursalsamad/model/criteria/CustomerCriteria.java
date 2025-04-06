package com.mursalsamad.model.criteria;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCriteria {
    private String pin;
    private String fullName;
    private String phoneNumber;
}
