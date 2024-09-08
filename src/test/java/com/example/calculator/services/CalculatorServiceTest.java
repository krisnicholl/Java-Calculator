package com.example.calculator.services;

import com.example.calculator.helpers.CalculationHelper;
import com.example.calculator.models.Operations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CalculatorServiceTest {

    @Mock
    private CalculationHelper calculationHelper;

    @InjectMocks
    private CalculatorService calculatorService;

    private Double a;
    private Double b;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        a = 5.0;
        b = 2.0;
    }

    @Test
    void add() {
        Double expectedResult = 7.0;

        when(calculationHelper.performOperation(a, b, "add")).thenReturn(expectedResult);

        Operations result = calculatorService.add(a, b);

        assertNotNull(result);
        assertEquals(expectedResult, result.getResult());
        assertEquals("add", result.getOperationType());
        verify(calculationHelper, times(1)).performOperation(a, b, "add");

    }

    @Test
    void subtract() {
        Double expectedResult = 3.0;

        when(calculationHelper.performOperation(a, b, "subtract")).thenReturn(expectedResult);

        Operations result = calculatorService.subtract(a, b);

        assertNotNull(result);
        assertEquals(expectedResult, result.getResult());
        assertEquals("subtract", result.getOperationType());
        verify(calculationHelper, times(1)).performOperation(a, b, "subtract");
    }

    @Test
    void multiply() {
        Double expectedResult = 10.0;

        when(calculationHelper.performOperation(a, b, "multiply")).thenReturn(expectedResult);

        Operations result = calculatorService.multiply(a, b);

        assertNotNull(result);
        assertEquals(expectedResult, result.getResult());
        assertEquals("multiply", result.getOperationType());
        verify(calculationHelper, times(1)).performOperation(a, b, "multiply");
    }

    @Test
    void divide() {
        Double expectedResult = 2.5;

        when(calculationHelper.performOperation(a, b, "divide")).thenReturn(expectedResult);

        Operations result = calculatorService.divide(a, b);

        assertNotNull(result);
        assertEquals(expectedResult, result.getResult());
        assertEquals("divide", result.getOperationType());
        verify(calculationHelper, times(1)).performOperation(a, b, "divide");
    }

    @Test
    void clear() {
        calculatorService.clearResult();

        assertThrows(ArithmeticException.class, () -> calculatorService.add(null, b), "No previous result available to use for the first operand.");
    }
}