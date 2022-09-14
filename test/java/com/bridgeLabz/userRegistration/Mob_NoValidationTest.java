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
public class Mob_NoValidationTest {
    private String mob_no;
    private boolean result;
    private UserRegistration mobileValidation;

    public Mob_NoValidationTest(String mob_no, boolean result){
        this.mob_no = mob_no;
        this.result = result;
    }

    @Before
    public void beforeEachInit(){
        mobileValidation = new UserRegistration();
    }

    @Parameters
    public static Collection mob_NoInputs(){
        return Arrays.asList(new Object[][]{{"89788990",false},{"81 8978908978",true},
                {"21 897867",false},{"91 908990996655",false},
                {"913 9807605403",false},{"91 876587gfhgj",false},
                {"hg 8978679988",false},{"81 9922334455",true}
        });
    }

    @Test
    public void mobileValidation(){
        assertEquals(result,mobileValidation.validateMobileNo(mob_no));
    }
}
