package com.bridgeLabz.moodAnalyser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MoodAnalyserTest {
    private String msg;
    private String result;
    MoodAnalyser moodAnalyser;

    public MoodAnalyserTest(String result,String msg){
        this.result = result;
        this.msg = msg;
    }

    @Before
    public void beforeEachInit(){
        moodAnalyser = new MoodAnalyser(msg);
    }
    @Test
    public void moodAnalyseTest(){
        assertEquals(result,moodAnalyser.analyseMood());
    }
    @Parameterized.Parameters
    public static Collection moodAnalyseTestInputs(){
        return Arrays.asList(new Object[][] {{"HAPPY","how happy she is!"},
                {"SAD","how sad he is?"},
                {"HAPPY","I am in any mood"},
                {"HAPPY"," "}});
    }

}
