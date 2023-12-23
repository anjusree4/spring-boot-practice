package com.anju.demo1.controller;

import com.anju.demo1.Model.Stock;
import com.anju.demo1.service.CalculatorService;
import com.anju.demo1.service.StockService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stocks")
@AllArgsConstructor
public class StockController {
    private final StockService stockservice;
    @GetMapping("/getStockData")
    public List<Stock> getStockData() throws Exception
    {
        return stockservice.getCompanyData();
    }
}
