package com.bridgeLabz.userRegistration;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {
    private Pattern pattern;
    private Matcher matcher;
    //UC1,UC2
    private static final String NAME_PATTERN = "^\\p{Lu}([A-Za-z]{2,})";
    public void setNamePattern(){
        pattern = Pattern.compile(NAME_PATTERN);
    }
    public boolean validateName(String name){
        setNamePattern();
        matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public void fillUpUserDetails(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first name");
        String fName = sc.next();
        System.out.println("Enter the last name");
        String lName = sc.next();
        if(validateName(fName) && validateName(lName)){
            System.out.println("Valid user Name");
        }else{
            System.out.println("Invalid Fist Name and last both should Start with caps and have minimum 2 characters");
        }
    }

    public static void main(String[] args) {
        UserRegistration registration = new UserRegistration();
        System.out.println("Enter the user details");
        registration.fillUpUserDetails();
    }
}
