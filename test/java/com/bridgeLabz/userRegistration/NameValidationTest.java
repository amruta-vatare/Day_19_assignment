package com.bridgeLabz.userRegistration;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.*;
import org.junit.runners.*;
import org.junit.runners.Parameterized.*;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class NameValidationTest {
    private String name;
    private boolean result;
    UserRegistration userRegistration;
    public NameValidationTest(String name, boolean result){
        this.name = name;
        this.result = result;
    }
    @Before
    public void beforeEachInit(){
     this.userRegistration = new UserRegistration();
    }

    @Parameters
    public static Collection nameInputs(){
        return Arrays.asList(new Object[][]{{"amRuta",false},{"Ram",true},
                {"Pu",false},{"Pihu",true},
                {"Nikita",true},{"12Nikhil",false},
                {"1233",false},{"Sham12",false},
                {"Swapnil",true}
        });
    }
    @Test
    public void validateName()throws InValidUserDetails{

    }
}
