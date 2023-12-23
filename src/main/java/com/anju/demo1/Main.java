package com.anju.demo1;

import com.anju.demo1.service.StockService;
import com.anju.demo1.Model.Stock;

import java.io.IOException;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        StockService stockService = new StockService();
        try {
            List<Stock> stocks = stockService.getCompanyData();
            for (Stock stock : stocks) {
                System.out.println("Company: " + stock.getCompanyName() + ", Symbol: " + stock.getSymbol());
                // Output other stock details as needed
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exceptions
        }
    }
}
