package com.bridgeLabz.moodAnalyser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CheckMsgInputTest {

     @Test
    public void testIfMsgInputIsNull(){
         try{
             MoodAnalyser analyser = new MoodAnalyser(null);
             analyser.analyseMood();
         }catch (MoodAnalysisException e){
             MoodAnalysisException.EXCEPTIONS expected = MoodAnalysisException.EXCEPTIONS.EXCEPTIONS_INVALID_NULL_INPUT;
             Assert.assertEquals(expected.name(),e.exception.name());
         }

     }
    @Test
    public void testIfMsgInputIsEmptyString(){
        try{
            MoodAnalyser analyser = new MoodAnalyser(" ");
            analyser.analyseMood();
        }catch (MoodAnalysisException e){
            MoodAnalysisException.EXCEPTIONS expected = MoodAnalysisException.EXCEPTIONS.EXCEPTIONS_INVALID_EMPTY_INPUT;
            Assert.assertEquals(expected.name(),e.exception.name());
        }

    }
}
