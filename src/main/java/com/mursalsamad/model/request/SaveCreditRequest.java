package com.mursalsamad.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaveCreditRequest {

    private BigDecimal amount;
    @Min(value = 6 , message = "The loan term must not be less than 6 months.")
    private Integer term;
    private BigDecimal interest;
    private BigDecimal monthlyPayment;
    @DecimalMin(value = "3000" , message = "The required amount should not be less than 3000.")
    private BigDecimal requestedAmount;
}
