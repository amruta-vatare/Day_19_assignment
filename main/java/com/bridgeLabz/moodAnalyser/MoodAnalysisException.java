package com.bridgeLabz.moodAnalyser;

public class MoodAnalysisException extends RuntimeException {
    public enum EXCEPTIONS {
        EXCEPTIONS_INVALID_EMPTY_INPUT,
        EXCEPTIONS_INVALID_NULL_INPUT;
    }
    EXCEPTIONS exception;
    public MoodAnalysisException(EXCEPTIONS exceptions){
        super(exceptions.name());
        exception = exceptions;
    }
}
