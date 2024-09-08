package com.example.calculator.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Operations {
    private Double operand1;
    private Double operand2;
    private String operationType;
    private Double result;
}
