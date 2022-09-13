package com.bridgeLabz.userRegistration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class UserRegistrationTest {
    UserRegistration registration;
    @BeforeEach
    void beforeEachInit(){
        registration = new UserRegistration();
    }

    @Test
    @DisplayName("Name validation")
    void validateName() {
        assertAll(
                ()->assertEquals(false,registration.validateName("amruta")),
                ()->assertEquals(true,registration.validateName("Nisha")),
                ()->assertEquals(false,registration.validateName("niSha")),
                ()->assertEquals(true,registration.validateName("Ram")),
                ()->assertEquals(false,registration.validateName("Hi"))
        );
    }

    @Test
    @DisplayName("Email validation")
    void validateEmail() {
        assertAll(
                ()->assertEquals(false,registration.validateEmail("amruta")),
                ()->assertEquals(true,registration.validateEmail("Nisha@gmail.com")),
                ()->assertEquals(false,registration.validateEmail("niSha.sv@gmail")),
                ()->assertEquals(true,registration.validateEmail("Nisha.sv@gmail.com")),
                ()->assertEquals(true,registration.validateEmail("Ram.shree@gmail.com.in")),
                ()->assertEquals(false,registration.validateEmail("Hi.gmail.com"))
        );
    }

    @Test
    @DisplayName("Mobile_No validation")
    void validateMobileNo() {
        assertAll(
                ()->assertEquals(false,registration.validateMobileNo("8967565656")),
                ()->assertEquals(false,registration.validateMobileNo("918978896745")),
                ()->assertEquals(true,registration.validateMobileNo("91 9089998877")),
                ()->assertEquals(false,registration.validateMobileNo("91 89674567")),
                ()->assertEquals(false,registration.validateMobileNo("91 898989342143"))
        );
    }

    @Test
    @DisplayName("Password validation")
    void validatePassword() {
        assertAll(
                ()->assertEquals(false,registration.validatePassword("amruta")),
                ()->assertEquals(false,registration.validatePassword("Ra9@")),
                ()->assertEquals(true,registration.validatePassword("Nisha99@")),
                ()->assertEquals(false,registration.validatePassword("niSha")),
                ()->assertEquals(false,registration.validatePassword("Ram99")),
                ()->assertEquals(false,registration.validatePassword("Ram@")),
                ()->assertEquals(false,registration.validatePassword("Hi"))
        );

    }
}