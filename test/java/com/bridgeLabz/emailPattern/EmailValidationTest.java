package com.bridgeLabz.emailPattern;
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
    private EmailPattern emailPattern;

    public EmailValidationTest(String email, boolean result){
        this.email = email;
        this.result = result;
    }
    @Before
    public void beforeEachInit(){
        emailPattern = new EmailPattern();
    }

    @Parameters
    public static Collection emailInputs(){
        return Arrays.asList(new Object[][] {{"Ram@gmail.com",true},{"ram.@gmail",false},
                {"ram.sv87@gmail.com",true},{"ram.34.@gmail.com",false},
                {"ram12.sv2@gmail.com.in",true},{"ram@.com",false},
                {"12Ram.12sv@gmail.com",true},{"12Ram@gmail.com12",false},
                {"Ram.sv@gmail.com.in",true},{"Ram@gmail12.com",false},
                {"Ram+.sv@gmail.com.in",true},{"Ram-@gmail12.com",false},
                {"Ram_.sv@gmail.com.in",true},{"Ram._@gmail12.com",false}
        });
    }
    @Test
    public void validateEmail(){
        assertEquals(result,emailPattern.validateEmail(email));
    }
}
