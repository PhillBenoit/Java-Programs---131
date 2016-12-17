/********************************************************************************************************************
 * HW_Ch4_Ex15.java
 * Created by: Phillip Benoit 10-16-16
 * CIS 131 - Programming and Problem Solving II 
 * Pima Community College - Fall 2016 
 ******************************************************************************************************************** 
 * Introduction to Java Programming: Comprehensive Version 10th Edition
 * Exercise 4.15 page 154
 ******************************************************************************************************************** 
 * This program converts a character to its dial pad equivalent
 ********************************************************************************************************************/

public class HW_Ch4_Ex15 {

    public static void main(String[] args) {
        IR.displayProgramInformation("HW_Ch4_Ex15", "10-16-16",
                "Introduction to Java Programming: Comprehensive Version 10th Edition", "Exercise 4.15 page 154",
                "This program converts a character to its dial pad equivalent.",
                "");
        Character input = IR.getLetter("Please enter a letter:");
        int dialpadNumber = 0;
        switch (input.toString()) {
        case "A":
        case "B": 
        case "C":  dialpadNumber=2;
                   break;
        case "D":
        case "E": 
        case "F":  dialpadNumber=3;
                   break;
        case "G":
        case "H": 
        case "I":  dialpadNumber=4;
                   break;
        case "J":
        case "K": 
        case "L":  dialpadNumber=5;
                   break;
        case "M":
        case "N": 
        case "O":  dialpadNumber=6;
                   break;
        case "P":
        case "Q": 
        case "R":
        case "S":  dialpadNumber=7;
                   break;
        case "T":
        case "U": 
        case "V":  dialpadNumber=8;
                   break;
        case "W":
        case "X": 
        case "Y":
        case "Z":  dialpadNumber=9;
                   break;
        }
        System.out.println("The dialpad number equivalent of " + input + " is " + dialpadNumber);
        System.out.println("\"`-._,-'\"`-._,-'\"`-._,-'\"`-._,-'END OF PROGRAM\"`-._,-'\"`-._,-'\"`-._,-'\"`-._,-'");
    }
    

}

