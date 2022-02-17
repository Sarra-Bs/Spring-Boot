package com.restservice;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.restservice.Greeting;
import com.restservice.service.GreetingService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


@Component
public class GreetingStore implements InitializingBean {
    public ArrayList<Greeting> greetings;

    @Override
    public void afterPropertiesSet() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        FileInputStream inputStream = new FileInputStream("src/main/resources/model.json");
        greetings = objectMapper.readValue(inputStream, new TypeReference<ArrayList<Greeting>>() {
        });

    }

    public List<Greeting> getGreetings() {
        return greetings;
    }
}
