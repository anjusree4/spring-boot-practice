package com.anju.demo1.controller;
import com.anju.demo1.Model.Stock;
import com.anju.demo1.controller.StockController;
import com.anju.demo1.service.StockService;import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
@ExtendWith(MockitoExtension.class)
public class StockControllerTest {

        @Mock
        private StockService stockService;

        @InjectMocks
        private StockController stockController;

        @Test
        public void testGetStockData() throws Exception {
            List<Stock> expectedStocks = new ArrayList<>();
            // Add some sample Stock objects to the expected list

            // Mocking stockService behavior
            when(stockService.getCompanyData()).thenReturn(expectedStocks);

            List<Stock> actualStocks = stockController.getStockData();
            assertEquals(expectedStocks.size(), actualStocks.size());
            // Add more assertions based on the expected behavior
        }
    }

