package com.restservice.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.restservice.Greeting;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


@Component
public  class GreetingStore implements InitializingBean {
    private static ArrayList<Greeting> greetings;

    @Override
    public  void afterPropertiesSet() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        String path ="/model.json";

        InputStream inputStream= GreetingService.class.getResourceAsStream(path);
        ArrayNode arrayNode = (ArrayNode)  objectMapper.readTree(inputStream);

        if (!arrayNode.isArray()) {
            return;
        }
            this.greetings = new ArrayList<>();

            for (JsonNode jsonNode : arrayNode) {
                greetings.add(new Greeting(jsonNode));

            }

    }

    public static List<Greeting> getGreetings() {
        return greetings;
    }
}
