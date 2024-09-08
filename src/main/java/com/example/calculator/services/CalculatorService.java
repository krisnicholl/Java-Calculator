package com.example.calculator.services;

import com.example.calculator.helpers.CalculationHelper;
import com.example.calculator.models.Operations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CalculatorService {

    private Operations lastOperation;
    private final CalculationHelper calculationHelper;

    @Autowired
    public CalculatorService(CalculationHelper calculationHelper) {
        this.calculationHelper = calculationHelper;
    }

    public Operations add(Double a, Double b) {
        return processOperation(a, b, "add");
    }

    public Operations subtract(Double a, Double b) {
        return processOperation(a, b, "subtract");
    }

    public Operations multiply(Double a, Double b) {
        return processOperation(a, b, "multiply");
    }

    public Operations divide(Double a, Double b) {
        return processOperation(a, b, "divide");
    }

    public void clearResult() {
        lastOperation = null;
    }

    private Operations processOperation(Double a, Double b, String operationType) {
        Double firstOperand = Optional.ofNullable(a).orElseGet(() -> Optional.ofNullable(lastOperation)
                .map(Operations::getResult)
                .orElseThrow(() -> new ArithmeticException("No previous result available to use for the first operand.")));

        Double secondOperand = Optional.ofNullable(b)
                .orElseThrow(() -> new ArithmeticException("Second operand cannot be null"));

        Double result = calculationHelper.performOperation(firstOperand, secondOperand, operationType);

        lastOperation = new Operations(firstOperand, secondOperand, operationType, result);

        return lastOperation;
    }
}
