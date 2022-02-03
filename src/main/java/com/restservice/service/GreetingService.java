package com.restservice.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.restservice.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class GreetingService {

    @Autowired static GreetingStore greetingStore;
public static  List<Greeting> searchGreeting(String lastName) throws IOException {
   return greetingStore.getGreetings()
                .stream()
                .filter(equalLastName(lastName))
                .collect(Collectors.toList());
}

    private static Predicate<Greeting> equalLastName(String lastName) {
        return gr -> gr.getLastName().equalsIgnoreCase(lastName);
    }

}
