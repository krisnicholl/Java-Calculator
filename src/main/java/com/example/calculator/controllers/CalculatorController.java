package com.example.calculator.controllers;

import com.example.calculator.models.Operations;
import com.example.calculator.services.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/add")
    public ResponseEntity<Double> add(@RequestParam(required = false) Double a, @RequestParam Double b) {
        Operations operations = calculatorService.add(a, b);
        return ResponseEntity.ok(operations.getResult());
    }

    @GetMapping("/subtract")
    public ResponseEntity<Double> subtract(@RequestParam(required = false) Double a, @RequestParam Double b) {
        Operations operations = calculatorService.subtract(a, b);
        return ResponseEntity.ok(operations.getResult());
    }

    @GetMapping("/multiply")
    public ResponseEntity<Double> multiply(@RequestParam(required = false) Double a, @RequestParam Double b) {
        Operations operations = calculatorService.multiply(a, b);
        return ResponseEntity.ok(operations.getResult());
    }

    @GetMapping("/divide")
    public ResponseEntity<Double> divide(@RequestParam(required = false) Double a, @RequestParam Double b) {
        Operations operations = calculatorService.divide(a, b);
        return ResponseEntity.ok(operations.getResult());
    }

    @PostMapping("/clear")
    public ResponseEntity<String> clear() {
        calculatorService.clearResult();
        return ResponseEntity.ok("Last results cleared");
    }

}
