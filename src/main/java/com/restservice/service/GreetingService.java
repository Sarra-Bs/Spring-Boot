package com.restservice.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.restservice.Greeting;
import com.restservice.controller.GreetingController;
import org.springframework.stereotype.Component;

import java.io.DataInput;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class GreetingService {

    private static List<Greeting> greetings = new ArrayList<>();
    Greeting greeting = null;


    public List<Greeting> getAllGreeting() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        String path ="/model.json";

        InputStream inputStream= GreetingService.class.getResourceAsStream(path);
        ArrayNode arrayNode = (ArrayNode)  objectMapper.readTree(inputStream);

        if(arrayNode.isArray()) {
            for(JsonNode jsonNode : arrayNode) {
                    greeting = new Greeting(jsonNode);
                    greetings.add(greeting);

            }
        }
    return greetings;
}
public Greeting searchGreeting(String lastName) throws IOException {

        greetings=  getAllGreeting();

        for (Greeting greeting1 :greetings) {
            if (lastName.equals(greeting1.getLastName())) {
                greeting= greeting1;
            }

        }
        return greeting;
}

}
