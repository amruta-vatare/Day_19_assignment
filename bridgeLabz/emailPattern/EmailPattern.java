package com.bridgeLabz.emailPattern;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* \\p{Punct} */
public class EmailPattern {
    private  Pattern pattern;
    private  Matcher matcher;
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9-\\+\\-\\_]+(\\.[A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public void setEmailPattern(){
        pattern = Pattern.compile(EMAIL_PATTERN);
    }
    public boolean validateEmail(String email){
        setEmailPattern();
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public static void main(String[] args) {
        EmailPattern check = new EmailPattern();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Email_Id");
        String email = sc.next();
        boolean flag = check.validateEmail(email);
        if(flag){
            System.out.println(email+" : is valid email-id");
        }else{
            System.out.println(email+" : is invalid email-id");
        }
    }
}
