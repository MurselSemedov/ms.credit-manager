package com.mursalsamad.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveCustomerRequest {

    private String pin;
    private String fullName;
    private String phoneNumber;
}
