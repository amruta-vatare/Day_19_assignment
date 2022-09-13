package com.bridgeLabz.userRegistration;

public class InValidUserDetails extends Exception{
    public InValidUserDetails(String errorMessage){
        super(errorMessage);
    }
}
