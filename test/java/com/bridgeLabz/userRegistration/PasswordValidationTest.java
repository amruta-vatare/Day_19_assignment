package com.bridgeLabz.userRegistration;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PasswordValidationTest {
    private String password;
    private boolean result;
    private UserRegistration passwordValidation;

    public PasswordValidationTest(String password, boolean result){
        this.password = password;
        this.result = result;
    }

    @Before
    public void beforeEachInit(){
        passwordValidation = new UserRegistration();
    }
    @Parameters
    public static Collection passwordInputs(){
        return Arrays.asList(new Object[][]{{"amrutasv",false},{"amrutA",false},
                {"amrutA9",false},{"amrutA9@",true},
                {"As@8",false},{"Amr$9uta#",true},
                {"#As+mr@sd",false},{"#aS%md23sv",true}
        });
    }
    @Test
    public void validatePassword() throws InValidUserDetails {
        assertEquals(result, passwordValidation.validatePassword.check(password));
    }
}
