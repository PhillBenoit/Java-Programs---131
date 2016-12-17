/********************************************************************************************************************
 * HW_Ch2_Ex7.java.java
 * Created by: Phillip Benoit 10-08-16
 * CIS 131 - Programming and Problem Solving II 
 * Pima Community College - Fall 2016 
 ******************************************************************************************************************** 
 * Introduction to Java Programming: Comprehensive Version 10th Edition
 * Exercise 2.7 page 70
 ******************************************************************************************************************** 
 * This program calculates the number of years and days in a number of minutes
 ********************************************************************************************************************/
import java.util.Scanner;

public class HW_Ch2_Ex7 {
    
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        displayProgramInformation();
        long input = getLong();
        closeScanner();
        short days = (short)((input % 525600)/1440);
        int years = (int)(input / 525600);
        System.out.format("You entered: %s minutes\nThat equals %d year(s)\nand %s day(s)\n", Long.toString(input), years, String.valueOf(days));
        System.out.println("\"`-._,-'\"`-._,-'\"`-._,-'\"`-._,-'END OF PROGRAM\"`-._,-'\"`-._,-'\"`-._,-'\"`-._,-'");
    }

    public static long getLong() {
        long number = inputLong("Please enter a large number (1440 - 9 trillion)");
        while (number < 1440L || number > 9000000000000L) {
           System.err.println("Number out of range");
           number = inputLong("Please enter a large number (1440 - 9 trillion)");
        }
        return number;
    }
    
    public static long inputLong(String msg) {
        System.out.println(msg);
        while (!keyboard.hasNextLong()) {
           keyboard.nextLine();
           System.err.println("Invalid long integer. Try again.");
        }
        long number = keyboard.nextLong();
        keyboard.nextLine();
        return number;
     }
    
    public static void closeScanner() {
        try { 
           if(keyboard != null) {
              keyboard.close(); 
           }
        } 
        catch (Exception e) { 
           System.err.println("Error closing reader.");
        }
     }
    
    private static void displayProgramInformation() {
        System.out.println("****************************************************************************************");
        System.out.println("* HW_Ch2_Ex7.java.java                                                                 *");
        System.out.println("* Created by: Phillip Benoit 10-08-16                                                  *");
        System.out.println("* CIS 131 - Programming and Problem Solving II                                         *"); 
        System.out.println("* Pima Community College - Fall 2016                                                   *");
        System.out.println("****************************************************************************************"); 
        System.out.println("* Introduction to Java Programming: Comprehensive Version 10th Edition                 *");
        System.out.println("* Exercise 2.7 page 70                                                                 *");
        System.out.println("****************************************************************************************"); 
        System.out.println("* This program calculates the number of years and days in a number of minutes          *");
        System.out.println("****************************************************************************************");
        System.out.println("");
    }
}
