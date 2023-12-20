package com.anju.demo1.controller;

import com.anju.demo1.service.CalculatorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/calculator")
    @AllArgsConstructor
    public class CalculatorController {
        private final CalculatorService calculatorservice;

        @GetMapping("/add")
        public int add(@RequestParam int a,@RequestParam int b)
        {
            return calculatorservice.add(a,b);
        }
        @GetMapping("/subtract")
        public int subtract(@RequestParam int a, @RequestParam int b) {
            return calculatorservice.subtract(a, b);
        }

        @GetMapping("/multiply")
        public int multiply(@RequestParam int a, @RequestParam int b) {
            return calculatorservice.multiply(a, b);
        }

        @GetMapping("/divide")
        public double divide(@RequestParam int a, @RequestParam int b) {
            return calculatorservice.divide(a, b);
        }




    }

