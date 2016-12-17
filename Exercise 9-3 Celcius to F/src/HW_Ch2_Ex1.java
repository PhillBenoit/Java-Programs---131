/********************************************************************************************************************
 * HW_Ch2_Ex1.java
 * Created by: Phillip Benoit 11-19-16
 * CIS 131 - Programming and Problem Solving II 
 * Pima Community College - Fall 2016 
 ******************************************************************************************************************** 
 * Introduction to Java Programming: Comprehensive Version 10th Edition
 * Exercise 2.1 page 69
 ******************************************************************************************************************** 
 * This program asks the user for a temperature in Celsius
 * and returns the temperature in Fahrenheit.
 ********************************************************************************************************************/

public class HW_Ch2_Ex1 {

    public static void main(String[] args) {
        IR.displayProgramInformation("HW_Ch2_Ex1", "11-19-16",
                "Introduction to Java Programming: Comprehensive Version 10th Edition", "Exercise 2.1 page 69",
                "This program asks the user for a temperature in Celsius",
                "and returns the temperature in Fahrenheit.");
        Double temp = IR.getDoubleBetweenLowAndHigh("Please input a temprature in Celsius: (-270 - 10000)", -270, 10000);
        System.out.println("You entered: " + temp);
        temp = toFarenheit(temp);
        System.out.println("Temprature in Farenheit: " + temp);
        IR.displayEndOfProgram();
    }
    
    static double toFarenheit(double temp) {
        return (9.0/5) * temp + 32;
    }

}