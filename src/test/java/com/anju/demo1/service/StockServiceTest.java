package com.anju.demo1.service;
import com.anju.demo1.Model.Stock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.io.IOException;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class StockServiceTest {

       @Mock
       private ObjectMapper objectMapper;

        @InjectMocks
        private StockService stockService;

       @BeforeEach
       public void setup() {
          MockitoAnnotations.initMocks(this);
       }

        @Test
        public void testGetCompanyData() throws IOException {
            // Mocking ObjectMapper behavior
         //   Mockito.when(objectMapper.readTree(any(URL.class))).thenReturn(null);

            List<Stock> stocks = stockService.getCompanyData();
            // Add assertions based on expected behavior when the ObjectMapper reads the URL
            // For example, checking if the returned list is empty or not.
            // assertEquals(0, stocks.size());
        }
    }

