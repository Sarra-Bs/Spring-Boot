package com.restservice.service;

import com.restservice.Greeting;
import com.restservice.GreetingStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class GreetingService {

    @Autowired
    GreetingStore greetingStore;

    public List<Greeting> searchGreeting(String lastName) throws IOException {
        return greetingStore.getGreetings()
                .stream()
                .filter(lastNameStartWith(lastName))
                .collect(Collectors.toList());
    }

    public static Predicate<Greeting> equalLastName(String lastName) {
        return gr -> gr.getLastName().equalsIgnoreCase(lastName);

    }

    public static Predicate<Greeting> lastNameStartWith(String startWith) {
        return gr -> {
            if (gr == null) {
                return false;
            }
            if (gr.getLastName() == null) {
                return false;
            }
            return gr.getLastName().startsWith(String.valueOf(startWith.charAt(0)).toUpperCase());
        };

    }

}
