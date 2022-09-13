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
    //UC4
    private static final String MOBILE_PATTERN = "^[0-9]{2}\\p{Space}[0-9]{10}";
    //UC5 UC6 UC7 UC8
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$";

    public void setNamePattern(){
        pattern = Pattern.compile(NAME_PATTERN);
    }
    public void setEmailPattern(){
        pattern = Pattern.compile(EMAIL_PATTERN);
    }
    public void setMobilePattern(){
        pattern = Pattern.compile(MOBILE_PATTERN);
    }
    public void setPasswordPattern(){
        pattern = Pattern.compile(PASSWORD_PATTERN);
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
    public boolean validateMobileNo(String mobNo){
        setMobilePattern();
        matcher = pattern.matcher(mobNo);
        return matcher.matches();
    }
    public boolean validatePassword(String password){
        setPasswordPattern();
        matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public void fillUpUserDetails(){
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first name");
        String fName = sc.next();
        System.out.println("Enter last name");
        String lName = sc.next();
        if(!validateName(fName) && validateName(lName)){
            flag = false;
            System.out.println("Invalid Fist Name and last both should Start with caps and have minimum 2 characters");
        }

        System.out.println("Enter Email_Id");
        String email = sc.next();
        if(!validateEmail(email)){
            flag = false;
            System.out.println("Invalid Email_Id, Email should be in format of abc5@gmail.com or abc1.xyz2@yahoo.com.in");
        }

        sc = new Scanner(System.in);
        System.out.println("Enter mobile no with country code");
        String mobileNo = sc.nextLine();
        if(!validateMobileNo(mobileNo)){
            flag = false;
            System.out.println("Invalid mobile_No, Mobile no should start with country code as (country_code space numberHaving10Digit)");
        }
        sc = new Scanner(System.in);
        System.out.println("Enter password");
        String password = sc.next();
        if(!validatePassword(password)){
            flag = false;
            System.out.println("Invalid password, password should contains 1 upper_Case, 1 lower_case, 1 special character and 1 digit");
        }
        if(flag){
            System.out.println("User is successfully register");
        }

    }
    public static void main(String[] args) {
        UserRegistration registration = new UserRegistration();
        System.out.println("Enter user details");
        registration.fillUpUserDetails();
    }
}
