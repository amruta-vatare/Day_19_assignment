package com.bridgeLabz.userRegistration;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegistration {
    private Pattern pattern;
    private Matcher matcher;
    //UC1,UC2
    private static final String NAME_PATTERN = "^\\p{Lu}([A-Za-z]{2,})";
    //UC3
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9\\.]+([A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9-]+)+(\\.[A-Za-z0-9-]+)*";
    public void setNamePattern(){
        pattern = Pattern.compile(NAME_PATTERN);
    }
    public void setEmailPattern(){
        pattern = Pattern.compile(EMAIL_PATTERN);
    }
    public boolean validateName(String name){
        setNamePattern();
        matcher = pattern.matcher(name);
        return matcher.matches();
    }
    public boolean validateEmail(String email){
        setEmailPattern();
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void fillUpUserDetails(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first name");
        String fName = sc.next();
        System.out.println("Enter last name");
        String lName = sc.next();
        if(!validateName(fName) && validateName(lName)){
            System.out.println("Invalid Fist Name and last both should Start with caps and have minimum 2 characters");
        }
        System.out.println("Enter Email_Id");
        String email = sc.next();
        if(!validateEmail(email)){
            System.out.println("Invalid Email_Id Email should be in format of abc5@gmail.com or abc1.xyz2@yahoo.com.in");
        }
    }

    public static void main(String[] args) {
        UserRegistration registration = new UserRegistration();
        System.out.println("Enter user details");
        registration.fillUpUserDetails();
    }
}
