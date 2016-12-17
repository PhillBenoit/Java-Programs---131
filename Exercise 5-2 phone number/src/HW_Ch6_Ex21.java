/********************************************************************************************************************
 * HW_Ch6_Ex21.java
 * Created by: Phillip Benoit 10-23-16
 * CIS 131 - Programming and Problem Solving II 
 * Pima Community College - Fall 2016 
 ******************************************************************************************************************** 
 * Introduction to Java Programming: Comprehensive Version 10th Edition
 * Exercise 6.21 page 239
 ******************************************************************************************************************** 
 * This program asks the user for a phone number
 * and returns it with the letters replaced with numbers.
 ********************************************************************************************************************/

public class HW_Ch6_Ex21 {
    
    static final String INPUT_QUESTION = "Please enter a phone number with letters: (Example: 1-800-COLLECT)";
    static final String OUTPUT = "This is the number after being converted:";

    public static void main(String[] args) {
        IR.displayProgramInformation("HW_Ch6_Ex21", "10-23-16",
                "Introduction to Java Programming: Comprehensive Version 10th Edition", "Exercise 6.21 page 239",
                "This program asks the user for a phone number",
                "and returns it with the letters replaced with numbers.");
        String numberString = IR.getString(INPUT_QUESTION);
        numberString = convertToNumbers(numberString);
        displayNumber(numberString);
        IR.displayEndOfProgram();
    }
    
    static String convertToNumbers(String numberToConvert) {
        String returnString = "";
        for (int step=0;step<numberToConvert.length();step++) {
            String test = Character.toString(numberToConvert.charAt(step));
            test = Character.isLetter(test.charAt(0)) ? test = convertToNumber(test) : test;
            returnString += test;
        }
        return returnString;
    }
    
    static void displayNumber(String number) {
        System.out.println(OUTPUT);
        System.out.println(number);
    }
    
    static String convertToNumber(String test) {
        switch (test.toUpperCase()) {
        case "A":
        case "B": 
        case "C":  test="2";
                   break;
        case "D":
        case "E": 
        case "F":  test="3";
                   break;
        case "G":
        case "H": 
        case "I":  test="4";
                   break;
        case "J":
        case "K": 
        case "L":  test="5";
                   break;
        case "M":
        case "N": 
        case "O":  test="6";
                   break;
        case "P":
        case "Q": 
        case "R":
        case "S":  test="7";
                   break;
        case "T":
        case "U": 
        case "V":  test="8";
                   break;
        case "W":
        case "X": 
        case "Y":
        case "Z":  test="9";
                   break;
        }
        return test;
    }

}