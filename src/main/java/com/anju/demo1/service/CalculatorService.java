package com.anju.demo1.service;


import org.springframework.stereotype.Service;

    @Service
    public class CalculatorService {
        public int add(int a,int b)
        {
            return a+b;
        }
        public int subtract(int a,int b)
        {
            return a-b;
        }
        public int multiply(int a,int b)
        {
            return a*b;
        }
        public double divide(int a,int b)
        {
            if(b==0)
            {
                throw new IllegalArgumentException("cannot divide by zero");
            }
            return (double)a/b;
        }
    }

