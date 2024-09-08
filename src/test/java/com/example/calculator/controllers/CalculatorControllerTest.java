package com.example.calculator.controllers;

import com.example.calculator.models.Operations;
import com.example.calculator.services.CalculatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CalculatorController.class)
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorService calculatorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks before each test
    }

    private Operations createOperation(Double a, Double b, String operationType, Double result) {
        return new Operations(a, b, operationType, result);
    }

    @Test
    void testAddOperation() throws Exception {
        when(calculatorService.add(3.0, 2.0)).thenReturn(createOperation(3.0, 2.0, "add", 5.0));

        mockMvc.perform(get("/add")
                        .param("a", "3.0")
                        .param("b", "2.0"))
                .andExpect(status().isOk())
                .andExpect(content().string("5.0"));
    }

    @Test
    void testSubtractOperation() throws Exception {
        when(calculatorService.subtract(5.0, 3.0)).thenReturn(createOperation(5.0, 3.0, "subtract", 2.0));

        mockMvc.perform(get("/subtract")
                        .param("a", "5.0")
                        .param("b", "3.0"))
                .andExpect(status().isOk())
                .andExpect(content().string("2.0"));
    }

    @Test
    void testMultiplyOperation() throws Exception {
        when(calculatorService.multiply(4.0, 3.0)).thenReturn(createOperation(4.0, 3.0, "multiply", 12.0));

        mockMvc.perform(get("/multiply")
                        .param("a", "4.0")
                        .param("b", "3.0"))
                .andExpect(status().isOk())
                .andExpect(content().string("12.0"));
    }

    @Test
    void testDivideOperation() throws Exception {
        when(calculatorService.divide(6.0, 2.0)).thenReturn(createOperation(6.0, 2.0, "divide", 3.0));

        mockMvc.perform(get("/divide")
                        .param("a", "6.0")
                        .param("b", "2.0"))
                .andExpect(status().isOk())
                .andExpect(content().string("3.0"));
    }

    @Test
    void testClearOperation() throws Exception {
        mockMvc.perform(post("/clear"))
                .andExpect(status().isOk())
                .andExpect(content().string("Last results cleared"));

        verify(calculatorService, times(1)).clearResult();
    }
}
