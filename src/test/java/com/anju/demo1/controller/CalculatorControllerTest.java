package com.anju.demo1.controller;


import com.anju.demo1.service.CalculatorService;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

   private MockMvc mockMvc;

    @Mock
    private CalculatorService calculatorService;

    @InjectMocks
    private CalculatorController calculatorController;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(calculatorController).build();
    }

    @Test
    public void testAddEndpoint() throws Exception {
        when(calculatorService.add(3, 5)).thenReturn(8);
        mockMvc.perform(MockMvcRequestBuilders.get("/calculator/add?a=3&b=5"))
                .andExpect(status().isOk())
                .andExpect(content().string("8"));
    }

    @Test
    public void testSubtractEndpoint() throws Exception {
        when(calculatorService.subtract(10, 4)).thenReturn(6);
        mockMvc.perform(MockMvcRequestBuilders.get("/calculator/subtract?a=10&b=4"))
                .andExpect(status().isOk())
                .andExpect(content().string("6"));
    }

    @Test

    public void testMultiplyEndpoint() throws Exception {
        when(calculatorService.multiply(3, 5)).thenReturn(15);
        mockMvc.perform(MockMvcRequestBuilders.get("/calculator/multiply?a=3&b=5"))
                .andExpect(status().isOk())
                .andExpect(content().string("15"));
    }

    @Test

    public void testDivideEndpoint() throws Exception {
        when(calculatorService.divide(10, 2)).thenReturn(5.0);
        mockMvc.perform(MockMvcRequestBuilders.get("/calculator/divide?a=10&b=2"))
                .andExpect(status().isOk())
                .andExpect(content().string("5.0"));
    }

    @Test
    public void testDivideByZero() throws Exception {
        when(calculatorService.divide(10, 0)).thenThrow(new IllegalArgumentException("cannot divide by zero"));
        mockMvc.perform(MockMvcRequestBuilders.get("/calculator/divide?a=10&b=0"))
                .andExpect(status().isBadRequest());
    }
}
