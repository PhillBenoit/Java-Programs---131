/********************************************************************************************************************
 * HW_Ch3_Ex17.java
 * Created by: Phillip Benoit 10-08-16
 * CIS 131 - Programming and Problem Solving II 
 * Pima Community College - Fall 2016 
 ******************************************************************************************************************** 
 * Introduction to Java Programming: Comprehensive Version 10th Edition
 * Exercise 3.17 page 111
 ******************************************************************************************************************** 
 * This program lets you play a game of rock, paper, scissors against the computer
 ********************************************************************************************************************/

public class HW_Ch3_Ex17 {

    public static void main(String[] args) {
        displayProgramInformation();
        int player = IR4.getIntegerBetweenLowAndHigh("Make your move! (0=rock 1=paper 2=scissors)", 0, 2, "That is not a valid move.");
        int computer = IR4.getRandomNumber(0, 2);
        determineWinner(player, computer);
        System.out.println("\"`-._,-'\"`-._,-'\"`-._,-'\"`-._,-'END OF PROGRAM\"`-._,-'\"`-._,-'\"`-._,-'\"`-._,-'");
    }
    
    private static void determineWinner(int player, int computer) {
        if (player == 0 && computer == 0) {System.out.println("You both selected rock.  It is a draw.");}
        if (player == 0 && computer == 1) {System.out.println("You selected rock.  The computer chose paper.  You lose.");}
        if (player == 0 && computer == 2) {System.out.println("You selected rock.  The computer chose scissors.  You win!");}
        if (player == 1 && computer == 1) {System.out.println("You both selected paper.  It is a draw.");}
        if (player == 1 && computer == 0) {System.out.println("You selected paper.  The computer chose rock.  You win!");}
        if (player == 1 && computer == 2) {System.out.println("You selected paper.  The computer chose scissors.  You lose.");}
        if (player == 2 && computer == 2) {System.out.println("You both selected scissors.  It is a draw.");}
        if (player == 2 && computer == 0) {System.out.println("You selected scissors.  The computer chose rock.  You win!");}
        if (player == 2 && computer == 1) {System.out.println("You selected scissors.  The computer chose paper.  You lose.");}
    }
    
    private static void displayProgramInformation() {
        System.out.println("****************************************************************************************");
        System.out.println("* HW_Ch3_Ex17.java                                                                     *");
        System.out.println("* Created by: Phillip Benoit 10-08-16                                                  *");
        System.out.println("* CIS 131 - Programming and Problem Solving II                                         *"); 
        System.out.println("* Pima Community College - Fall 2016                                                   *");
        System.out.println("****************************************************************************************"); 
        System.out.println("* Introduction to Java Programming: Comprehensive Version 10th Edition                 *");
        System.out.println("* Exercise 3.17 page 111                                                               *");
        System.out.println("****************************************************************************************"); 
        System.out.println("* This program lets you play a game of rock, paper, scissors against the computer      *");
        System.out.println("****************************************************************************************");
        System.out.println("");
    }

}
