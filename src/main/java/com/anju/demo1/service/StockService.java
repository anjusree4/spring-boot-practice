package com.anju.demo1.service;

import com.anju.demo1.Model.Stock;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class StockService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StockService.class);

    @Value("${API_KEY}") // Replace YOUR_ENV_VARIABLE_NAME with the name of your environment variable
    private String apiKey;

    public List<Stock> getCompanyData() {
        List<Stock> stocks = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            String[] symbols = {"AAPL", "GOOGL", "MSFT"}; // Symbols for Apple, Google, and Microsoft

            for (String symbol : symbols) {
                String apiUrl = "https://financialmodelingprep.com/api/v3/profile/" + symbol + "?apikey=" + apiKey;
                URL url = new URL(apiUrl);

                JsonNode rootNode = mapper.readTree(url);
                JsonNode node = rootNode.get(0);

                Stock stock = new Stock();
                stock.setCompanyName(node.get("companyName").asText());
                stock.setSymbol(node.get("symbol").asText());
                // Set other fields based on the API response

                stocks.add(stock);
                LOGGER.info("Fetched data for symbol: {}", symbol);
            }
        } catch (IOException e) {
            LOGGER.error("Error fetching stock data:{}", e.getMessage());
        }
        return stocks;
    }
}