package com.anju.demo1.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

    @Service
    public class CalculatorService {
        private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorService.class);
        public int add(int a,int b)
        {
            int result=a+b;
            LOGGER.info("addition operation:{} +{}={}",a,b,result);
            return result;
        }
        public int subtract(int a,int b)
        {
            int result=a-b;
            LOGGER.info("subtraction operation:{} -{}={}",a,b,result);
            return result;
        }
        public int multiply(int a,int b)
        {
            int result=a*b;
            LOGGER.info("multiplication operation:{}*{}={}",a,b,result);
            return result;
        }
       public double divide(int a,int b)
        {
            if(b==0)
            {
                LOGGER.error("Division by zero attempted with values: {} / {}", a, b);
                throw new IllegalArgumentException("cannot divide by zero");
            }
            double result=(double)a/b;
            LOGGER.info("division  operation:{}/{}={}",a,b,result);
            return result;
        }


    }

