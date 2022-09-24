package com.bridgeLabz.userRegistration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class EmailValidationTest {
    private String email;
    private boolean result;
    private UserRegistration emailValidation;

    public EmailValidationTest(String email, boolean result){
        this.email = email;
        this.result = result;
    }
    @Before
    public void beforeEachInit(){
        emailValidation = new UserRegistration();
    }

    @Parameters
    public static Collection emailInputs(){
        return Arrays.asList(new Object[][] {{"Ram@gmail.com",true},{"ram.@gmail",false},
                {"ram.sv87@gmail.com",true},{"ram.34.@gmail.com",false},
                {"ram12.sv2@gmail.com.in",true},{"ram@.com",false},
                {"12Ram.12sv@gmail.com",true},{"12Ram@gmail.com12",false},
                {"Ram.sv@gmail.com.in",true},{"Ram@gmail12.com",false},
                {"Ram+.sv@gmail.com.in",false},{"Ram-@gmail12.com",false},
        });
    }
    @Test
    public void testValidateEmailExceptionIsThrown() throws InValidUserDetails {
        emailValidation.validateEmail.check(email);
    }
    @Test
    public void validateEmail() throws InValidUserDetails {
       assertEquals(result,emailValidation.validateEmail.check(email));
    }
}
