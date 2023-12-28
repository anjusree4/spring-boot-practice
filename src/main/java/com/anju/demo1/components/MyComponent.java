package com.anju.demo1.components;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MyComponent {

    @Value("${API_KEY}")
    private String apiKey;

    public void useApiKey() {
        // Use apiKey in your code
        System.out.println("API Key: " + apiKey);
        // Your logic using the API key goes here
    }
}
