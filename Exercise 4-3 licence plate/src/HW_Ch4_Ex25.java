/********************************************************************************************************************
 * HW_Ch4_Ex25.java
 * Created by: Phillip Benoit 10-16-16
 * CIS 131 - Programming and Problem Solving II 
 * Pima Community College - Fall 2016 
 ******************************************************************************************************************** 
 * Introduction to Java Programming: Comprehensive Version 10th Edition
 * Exercise 4.25 page 156
 ******************************************************************************************************************** 
 * This program generates a list of random license plates.
 * They start with a series of random letters and end with numbers.
 ********************************************************************************************************************/

public class HW_Ch4_Ex25 {

    public static void main(String[] args) {
        IR.displayProgramInformation("HW_Ch4_Ex25", "10-16-16",
                "Introduction to Java Programming: Comprehensive Version 10th Edition", "Exercise 4.25 page 156",
                "This program generates a list of random license plates.",
                "They start with a series of random letters and end with numbers.");
        drawTable();
        System.out.println("\"`-._,-'\"`-._,-'\"`-._,-'\"`-._,-'END OF PROGRAM\"`-._,-'\"`-._,-'\"`-._,-'\"`-._,-'");
    }
    
    static void drawTable() {
        for (int row = 0; row<12; row++) {
            for (int column = 0; column<10; column++) {
                for (int letter=0; letter<3; letter++) {
                    System.out.print((char)('A'+IR.getRandomNumber(0, 25)));
                }
                for (int number=0; number<4; number++) {
                    System.out.print(IR.getRandomNumber(0, 9));
                }
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }
    

}

