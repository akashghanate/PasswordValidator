package com.company;

import java.util.Scanner;

public class Main {

   static int numberOfCriteria;
    public static void main(String[] args) {
        String Password;
        Scanner sc=new Scanner(System.in);
        Password=sc.nextLine();
        isValidatePassword(Password);
        sc.close();
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
        char[] passChars=Password.toCharArray();
        if(Password.length()>=8){numberOfCriteria++;}
        if(Password.length()<=16){numberOfCriteria++;}
        if(isUppercase(passChars)){ numberOfCriteria++; }
        if(isLowercase(passChars)){ numberOfCriteria++; }
        if(isNumeric(passChars)){ numberOfCriteria++; }
        if(isSpecialCharacter(passChars)){ numberOfCriteria++;}
        if(isnoConsecutiveUpper_LowerCase(passChars)){ numberOfCriteria++; }
        if (isNumeric(passChars)) {
            if(isnoConsecutiveDigits(passChars)){ numberOfCriteria++;}
            }
        System.out.println(isCriteria(numberOfCriteria));
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
    public static boolean isNumeric(char[] passChars){
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
            //checks for first occurrence of special character
            if (String.valueOf(ch).matches("[^A-Za-z0-9 ]"))
                {
                    status=true;
                }
            //checks for blank space
            if(String.valueOf(ch).matches("[ ]"))
                return false;
        }
        return status;
    }
    public static boolean isnoConsecutiveDigits(char[] passChars){
        for (int i = 0; i <passChars.length-1 ; i++) {
            if(Character.isDigit(passChars[i]) && Character.isDigit(passChars[i+1])){
                //check for consecutive numbers both in ascending and descending order
                if((passChars[i] +1)== passChars[i + 1]
                || (passChars[i] ==(passChars[i + 1] +1))){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isnoConsecutiveUpper_LowerCase(char[] passChars){

        for (int i = 0; i <passChars.length-2 ; i++) {
            if (Character.isLetter(passChars[i])) {
                //check for more than 2 uppercase in consecutive order
                if(Character.isUpperCase(passChars[i]) && Character.isUpperCase(passChars[i+1])
                        && Character.isUpperCase(passChars[i+1]) && Character.isUpperCase(passChars[i+2]))
                {
                    return false;
                }
                //check for more than 2 lowercase in consecutive order
                else if(Character.isLowerCase(passChars[i]) && Character.isLowerCase(passChars[i+1])
                        && Character.isLowerCase(passChars[i+1]) && Character.isLowerCase(passChars[i+2])){
                    return false;
                }
            }
        }
        return true;
    }
}
