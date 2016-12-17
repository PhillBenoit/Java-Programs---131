/********************************************************************************************************************
 * HW_Ch3_Ex14.java
 * Created by: Phillip Benoit 10-08-16
 * CIS 131 - Programming and Problem Solving II 
 * Pima Community College - Fall 2016 
 ******************************************************************************************************************** 
 * Introduction to Java Programming: Comprehensive Version 10th Edition
 * Exercise 3.14 page 110
 ******************************************************************************************************************** 
 * This program lets you guess heads or tails then simulates a coin flip.
 ********************************************************************************************************************/

public class HW_Ch3_Ex14 {
    public static void main(String[] args) {
        displayProgramInformation();
        int playerGuess = IR4.getIntegerBetweenLowAndHigh("Make a selection (0=heads 1=tails)", 0, 1, "Please select only 1 or 0");
        int computerFlip = IR4.getRandomNumber(0, 1);
        String result = playerGuess == computerFlip ? "win!" : "lose.";
        System.out.println("You selected: " + getFace(playerGuess));
        System.out.println("The result was: " + getFace(computerFlip));
        System.out.println("You " + result);
        System.out.println("\"`-._,-'\"`-._,-'\"`-._,-'\"`-._,-'END OF PROGRAM\"`-._,-'\"`-._,-'\"`-._,-'\"`-._,-'");
    }
    
    static String getFace(int index) {
        return index == 0 ? "heads" : "tails";
    }
    
    private static void displayProgramInformation() {
        System.out.println("****************************************************************************************");
        System.out.println("* HW_Ch3_Ex14.java                                                                     *");
        System.out.println("* Created by: Phillip Benoit 10-08-16                                                  *");
        System.out.println("* CIS 131 - Programming and Problem Solving II                                         *"); 
        System.out.println("* Pima Community College - Fall 2016                                                   *");
        System.out.println("****************************************************************************************"); 
        System.out.println("* Introduction to Java Programming: Comprehensive Version 10th Edition                 *");
        System.out.println("* Exercise 3.14 page 110                                                               *");
        System.out.println("****************************************************************************************"); 
        System.out.println("* This program lets you guess heads or tails then simulates a coin flip.               *");
        System.out.println("****************************************************************************************");
        System.out.println("");
    }

}