/********************************************************************************************************************
 * HW_Ch11_Ex7.java
 * Created by: Phillip Benoit 11-27-16
 * CIS 131 - Programming and Problem Solving II 
 * Pima Community College - Fall 2016 
 ******************************************************************************************************************** 
 * Introduction to Java Programming: Comprehensive Version 10th Edition
 * Exercise 11.7 page 446
 ******************************************************************************************************************** 
 * This program demonstrates shuffling an array list.
 * It calls the driver to generate and display the list.
 ********************************************************************************************************************/

import java.util.ArrayList;
import java.util.Collections;

public class HW_Ch11_Ex7 {
    
    public static void main(String[] args) {
        IR.displayProgramInformation("HW_Ch11_Ex7", "11-27-16",
                "Introduction to Java Programming: Comprehensive Version 10th Edition", "Exercise 11.7 page 446",
                "This program demonstrates shuffling an array list.",
                "It calls the driver to generate and display the list.");

        ArrayList<Integer> list = EX10_driver.generateList();
        EX10_driver.printList(list);
        System.out.println("This is the randomly generated list.");
        IR.pause();
        
        shuffle(list);
        EX10_driver.printList(list);
        System.out.println("This is the list after being shuffled.");
        IR.pause();
        
        IR.displayEndOfProgram();
    }
    
    public static void shuffle(ArrayList<Integer> list){
        Collections.shuffle(list);
    }

}