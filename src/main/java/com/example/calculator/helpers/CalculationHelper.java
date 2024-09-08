package com.example.calculator.helpers;

import org.springframework.stereotype.Component;

@Component
public class CalculationHelper {

    public Double performOperation(Double a, Double b, String operationType) {
        return switch (operationType) {
            case "add" -> a + b;
            case "subtract" -> a - b;
            case "multiply" -> a * b;
            case "divide" -> {
                if (b == 0) throw new ArithmeticException("Cannot divide by zero!");
                yield a / b;
            }
            default -> throw new ArithmeticException("Invalid operation type!");
        };
    }
}