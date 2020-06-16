package com.company;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        String Password;
        Scanner sc=new Scanner(System.in);
        Password=sc.nextLine();
        isValidatePassword(Password);
    }

    public static int isCriteria(int numberOfCriteria){
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
         int numberOfCriteria=0;
          char[] passChars=Password.toCharArray();
        System.out.println(Password.length());
            if(Password.length()>=8){numberOfCriteria++;
                System.out.println("minlen :"+numberOfCriteria);}
        if(Password.length()<=16){numberOfCriteria++;
            System.out.println("maxlen :"+numberOfCriteria);}
            if(isUppercase(passChars)){ numberOfCriteria++; System.out.println("uppercase :"+numberOfCriteria);}
            if(isLowercase(passChars)){ numberOfCriteria++; System.out.println("lowercase :"+numberOfCriteria);}
            if(isNumberic(passChars)){ numberOfCriteria++; System.out.println("Nummeric :"+numberOfCriteria);}
            if(isSpecialCharacter(passChars)){ numberOfCriteria++; System.out.println("Special :"+numberOfCriteria);}
            if (isNumberic(passChars)) {
                if(isConsecutiveDigits(passChars)){ numberOfCriteria++; System.out.println("ConDigit :"+numberOfCriteria);}
            }
        System.out.println("Criteria :"+isCriteria(numberOfCriteria));
        System.out.println("last :"+ numberOfCriteria);

    }

    public static boolean isUppercase(char[] passChars){
        for (char ch: passChars
             ) {
            if(Character.isUpperCase(ch))
            {
                return true;
            }
        }
        return false;
    }
    public static boolean isLowercase(char[] passChars){
        for (char ch: passChars
        ) {
            if(Character.isLowerCase(ch))
            {
                return true;
            }
        }
        return false;
    }
    public static boolean isNumberic(char[] passChars){
        for (char ch: passChars
        ) {
            if(Character.isDigit(ch))
            {
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
                return false;
        }
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
        return true;
    }

}
