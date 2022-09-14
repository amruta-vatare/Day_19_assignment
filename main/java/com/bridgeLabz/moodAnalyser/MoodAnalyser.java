package com.bridgeLabz.moodAnalyser;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoodAnalyser {
    private String msg;

    public String analyseMood(String msg){
        this.msg = msg.toLowerCase(Locale.ROOT);
        String[] words=msg.split("\\s");
        if(words.length == 0){
            return "INVALID INPUT";
        }
        for(int i  = 0; i<words.length;i++){
            if (checkMoodIsSad(words[i])){
                return "SAD";
            }else if (checkMoodIsHappy(words[i])){
                return "HAPPY";
            }
        }
        return "HAPPY";
    }

    public boolean checkMoodIsSad(String msg){
        return Pattern.matches("sad",msg);
    }

    public boolean checkMoodIsHappy(String msg){
        return Pattern.matches("happy",msg);
    }

    public static void main(String[] args) {
        MoodAnalyser analyser = new MoodAnalyser();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter message");
        String msg  = sc.nextLine();
        System.out.println(analyser.analyseMood(msg));
    }
}
