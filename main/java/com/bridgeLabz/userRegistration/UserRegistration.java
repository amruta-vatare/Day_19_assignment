package com.bridgeLabz.userRegistration;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FunctionalInterface
interface UserValidation{
    boolean check(String field) throws InValidUserDetails;
}

public class UserRegistration {
    private static Pattern pattern;
    private static Matcher matcher;
    static String fName,lName,email,mobileNo,password;
    //UC1,UC2
    private static final String NAME_PATTERN = "^\\p{Lu}([A-Za-z]{2,})";
    //UC3
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9]+(\\.[A-Za-z0-9-]+)*@[A-Za-z]+(\\.[A-Za-z]+)+(\\.[A-Za-z]+)*";
    //UC4
    private static final String MOBILE_PATTERN = "^[0-9]{2}\\p{Space}[0-9]{10}";
    //UC5 UC6 UC7 UC8
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$";

    public static void setNamePattern(){
        pattern = Pattern.compile(NAME_PATTERN);
    }
    public static void setEmailPattern(){
        pattern = Pattern.compile(EMAIL_PATTERN);
    }
    public static void setMobilePattern(){
        pattern = Pattern.compile(MOBILE_PATTERN);
    }
    public static void setPasswordPattern(){
        pattern = Pattern.compile(PASSWORD_PATTERN);
    }

    public void fillUpUserDetails() throws InValidUserDetails{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first name");
        this.fName = sc.next();
        System.out.println("Enter last name");
        this.lName = sc.next();
        System.out.println("Enter Email_Id");
        this.email = sc.next();
        sc = new Scanner(System.in);
        System.out.println("Enter mobile no with country code");
        this.mobileNo = sc.nextLine();
        sc = new Scanner(System.in);
        System.out.println("Enter password");
        this.password = sc.next();
    }

    UserValidation validateFName =(fName)->{
        try {
            setNamePattern();
            matcher = pattern.matcher(fName);
            if(matcher.matches()){
                return true;
            }else{
                return false;
            }
        }catch (NullPointerException e){
            throw new InValidUserDetails("");
        }
    };
    UserValidation validateLName =(lName)->{
        try {
            setNamePattern();
            matcher = pattern.matcher(lName);
            if(matcher.matches()){
                return true;
            }else{
                return false;
            }
        }catch (NullPointerException e){
            throw new InValidUserDetails("");
        }
    };

    UserValidation validateEmail = (email)->{
        try {
            setEmailPattern();
            matcher = pattern.matcher(email);
            if(matcher.matches()){
                return true;
            }else{
                return false;
            }
        }catch (NullPointerException e){
            throw new InValidUserDetails("");
        }
    };
    UserValidation validateMobileNo =(mobileNo)->{
        try {
            setMobilePattern();
            matcher = pattern.matcher(mobileNo);
            if(matcher.matches()){
                return true;
            }else{
                return false;
            }
        }catch (NullPointerException e){
            throw new InValidUserDetails("");
        }

    };
    UserValidation validatePassword = (password)->{
        try {
            setPasswordPattern();
            matcher = pattern.matcher(password);
            if(matcher.matches()){
                return true;
            }else{
                return false;
            }
        }catch (NullPointerException e){
            throw new InValidUserDetails("");
        }
    };

    public static void main(String[] args)throws InValidUserDetails,NullPointerException {

        UserRegistration registration = new UserRegistration();
        System.out.println("Enter user details");
        registration.fillUpUserDetails();

        try {
            if (!registration.validateFName.check(fName) && !registration.validateLName.check(lName)){
                throw new InValidUserDetails("Invalid Fist Name and last both should Start with caps and have minimum 3 characters");
            }else if(!registration.validateEmail.check(email)){
                throw new InValidUserDetails("Invalid Email_Id, Email should be in format of abc5@gmail.com or abc1.xyz2@yahoo.com.in");
            }else if(!registration.validateMobileNo.check(mobileNo)){
                throw new InValidUserDetails("Invalid mobile_No, Mobile no should start with country code as (country_code space numberHaving10Digit)");
            }else if(!registration.validatePassword.check(password)){
                throw new InValidUserDetails("Invalid password, password should contains 1 upper_Case, 1 lower_case, 1 special character and 1 digit");
            }else {
                System.out.println("User is successfully register");
            }
        } catch (InValidUserDetails inValidUserDetails) {
            inValidUserDetails.printStackTrace();
        }

    }
}