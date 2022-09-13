package com.bridgeLabz.emailPattern;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailPatternTest {
    EmailPattern emailPattern;
    @BeforeEach
    void beforeEachInit(){
        emailPattern = new EmailPattern();
    }

    @Test
    void validateEmail() {
       assertAll(
               ()->assertEquals(true,emailPattern.validateEmail("vatare.as95@gmail.com.in"),"valid email"),
               ()->assertEquals(true,emailPattern.validateEmail("vatare@gmail.com.in"),"valid email"),
               ()->assertEquals(true,emailPattern.validateEmail("vatare95@gmail.com"),"valid email"),
               ()->assertEquals(false,emailPattern.validateEmail("vatare.as95@.com.in"),"Invalid email"),
               ()->assertEquals(false,emailPattern.validateEmail("vatare95.as95@gmail"),"Invalid email"),
               ()->assertEquals(true,emailPattern.validateEmail("vatare11.as95@gmail.com.in"),"valid email")
       );
    }
}