package com.bridgeLabz.moodAnalyser;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MoodAnalyser {
    private String msg;
    String [] words;
    public MoodAnalyser(){

    }
    public MoodAnalyser(String msg){
        this .msg = msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public boolean checkMsgInput()throws NullPointerException{
        try{
            if(msg.length() != 0) {
                msg = this.msg.toLowerCase(Locale.ROOT);
                String[] words = msg.split("\\s");
                try {
                    if (words.length == 0) {
                        throw new MoodAnalysisException(MoodAnalysisException.EXCEPTIONS.EXCEPTIONS_INVALID_EMPTY_INPUT);
                    }
                }catch (MoodAnalysisException e) {
                    System.out.println(MoodAnalysisException.EXCEPTIONS.EXCEPTIONS_INVALID_EMPTY_INPUT.name());
                }
            }
        }catch (NullPointerException e1){
            throw new MoodAnalysisException(MoodAnalysisException.EXCEPTIONS.EXCEPTIONS_INVALID_NULL_INPUT);
        }
        return true;
    }

    public String analyseMood(){
        try {
            if (!checkMsgInput()){
                return "EMPTY";
            }
            for(int i  = 0; i<words.length;i++){
                if (checkMoodIsSad(words[i])){
                    return "SAD";
                }else if (checkMoodIsHappy(words[i])){
                    return "HAPPY";
                }
            }
        }catch (NullPointerException e){
            System.out.println(MoodAnalysisException.EXCEPTIONS.EXCEPTIONS_INVALID_NULL_INPUT.name());
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
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter message");
        String msg  = sc.nextLine();
        MoodAnalyser analyser = new MoodAnalyser(msg);
        System.out.println("Your mood is "+analyser.analyseMood());
    }
}
