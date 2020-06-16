package com.company;

import java.util.Scanner;

public class Main {

    private static int numberOfCriteria=0;
    public static void main(String[] args) {
        String Password;
        Scanner sc=new Scanner(System.in);
        Password=sc.next();
        isValidatePassword(Password);
        System.out.println(isCriteria());
        System.out.println(numberOfCriteria);
    }
    public static int isCriteria(){
        if(numberOfCriteria==8)
            return 3;
        else if(numberOfCriteria>=5)
            return 2;
        else if(numberOfCriteria>=2)
            return 1;
        else if(numberOfCriteria<2)
            return 0;
       return 0;
    }
    public static void isValidatePassword(String Password){
          char[] passChars=Password.toCharArray();
          System.out.println(isSpecialCharacter(passChars));
            if(isValidateLength(Password)){ numberOfCriteria++; }
            if(isUppercase(passChars)){ status = true; }
            if(isLowercase(passChars)){ status=true; }
            if(isNumberic(passChars)){ status= true; }
            if(isSpecialCharacter(passChars)){ status= true; }
            if(isConsecutiveDigits(passChars)){ status= true; }

    }
    public static boolean isValidateLength(String Password){
        if(Password.length()>=8 && Password.length()<=16) {
            numberOfCriteria=numberOfCriteria+2;
            return true;
        }
        return false
    }
    public static boolean isUppercase(char[] passChars){
        for (char ch: passChars
             ) {
            if(Character.isUpperCase(ch))
            {
                numberOfCriteria++;
            }
        }
        return false;
    }
    public static boolean isLowercase(char[] passChars){
        for (char ch: passChars
        ) {
            if(Character.isLowerCase(ch))
            {
                numberOfCriteria++;
                return true;
            }
        }
        return false;
    }
    public static void isNumberic(char[] passChars){
        for (char ch: passChars
        ) {
            if(Character.isDigit(ch))
            {
                numberOfCriteria++;
                return true;
            }
        }
        return false;
    }
    public static boolean isSpecialCharacter(char[] passChars) {
        boolean status=false;
        for (char ch: passChars) {
            //checks for first
            if (String.valueOf(ch).matches("[^A-Za-z0-9 ]"))
                {
                    status=true;
                }
            if(String.valueOf(ch).matches("[ ]"))
                status=false;
        }
        if(status){ numberOfCriteria++;}
        return status;
    }
    //        String regex= "([a-z]*)(?<![A-Z])[A-Z]{2}(?![A-Z])([a-z]*)";
//        if(password.matches(regex)){
//            return true;
//        }
// public static boolean isConsecutiveUpper_LowerCase(char[] passChars){
//
//        for (int i = 0; i <passChars.length-2 ; i++) {
//            if(Character.isUpperCase(passChars[i])==Character.isUpperCase(passChars[i+1])
//            && (Character.isUpperCase(passChars[i+1])==Character.isUpperCase(passChars[i+2])))
//            {
//                return false;
//            }
//            else if(Character.isLowerCase(passChars[i])==Character.isLowerCase(passChars[i+1])
//            && (Character.isLowerCase(passChars[i+1])==Character.isLowerCase(passChars[i+2]))){
//                return false;
//            }
//        }
//        numberOfCriteria++;
//        return true;
//    }
    public static boolean isConsecutiveDigits(char[] passChars){
        for (int i = 0; i <passChars.length-1 ; i++) {
            if(Character.isDigit(passChars[i]) && Character.isDigit(passChars[i+1])){
                if((Character.valueOf(passChars[i])+1)==Character.valueOf(passChars[i+1])
                || (Character.valueOf(passChars[i])==(Character.valueOf(passChars[i+1])+1))){
                    return false;
                }
                else
                    continue;
            }
        }
        numberOfCriteria++;
        return true;
    }

}
