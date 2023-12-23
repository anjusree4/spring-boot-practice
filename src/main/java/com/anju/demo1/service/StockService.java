package com.anju.demo1.service;

import com.anju.demo1.Model.Stock;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class StockService {
    private static final String API_KEY = "8fe99b7f31faeb8b9fe5539dfc0531f3"; // Replace with your API key

    public List<Stock> getCompanyData() throws IOException {
        List<Stock> stocks = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        String[] symbols = {"AAPL", "GOOGL", "MSFT"}; // Symbols for Apple, Google, and Microsoft

        for (String symbol : symbols) {
            String apiUrl = "https://financialmodelingprep.com/api/v3/profile/" + symbol + "?apikey=" + API_KEY;
            URL url = new URL(apiUrl);

            JsonNode rootNode = mapper.readTree(url);
            JsonNode node = rootNode.get(0);

            Stock stock = new Stock();
            stock.setCompanyName(node.get("companyName").asText());
            stock.setSymbol(node.get("symbol").asText());
            // Set other fields based on the API response

            stocks.add(stock);
        }
        return stocks;
    }
}

