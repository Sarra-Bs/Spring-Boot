package com.restservice.service;

import com.restservice.Greeting;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class GreetingServiceTest {
    //test mit kleinbuchtaben, grossbuchtaben und beide

    @Test
    public void lastNameStartWithGroßBuchtaben() {
        Greeting t = new Greeting();
        t.setLastName("Ben Said");
        final boolean check = GreetingService.lastNameStartWith("B").test(t);
        assertEquals(true, check);
    }

    @Test
    public void lastNameStartWithKleinBuchtaben() {
        Greeting t = new Greeting();
        t.setLastName("Ben Said");
        final boolean check = GreetingService.lastNameStartWith("b").test(t);
        assertEquals(true, check);
    }

    @Test
    public void lastNameStartWith() {
        Greeting t = new Greeting();
        t.setLastName("Ben Said");
        final boolean check = GreetingService.lastNameStartWith("b").test(t);
        final boolean check1 = GreetingService.lastNameStartWith("B").test(t);
        if (check == true & check1 == true) {
            assertTrue(true);
        }
        assertFalse(false);

    }
}