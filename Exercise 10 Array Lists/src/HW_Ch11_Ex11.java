/********************************************************************************************************************
 * HW_Ch11_Ex11.java
 * Created by: Phillip Benoit 11-27-16
 * CIS 131 - Programming and Problem Solving II 
 * Pima Community College - Fall 2016 
 ******************************************************************************************************************** 
 * Introduction to Java Programming: Comprehensive Version 10th Edition
 * Exercise 11.11 page 447
 ******************************************************************************************************************** 
 * This program demonstrates sorting an array list.
 * It calls the driver to generate and display the list.
 ********************************************************************************************************************/

import java.util.ArrayList;
import java.util.Collections;

public class HW_Ch11_Ex11 {
    
    public static void main(String[] args) {
        IR.displayProgramInformation("HW_Ch11_Ex11", "11-27-16",
                "Introduction to Java Programming: Comprehensive Version 10th Edition", "Exercise 11.11 page 447",
                "This program demonstrates sorting an array list.",
                "It calls the driver to generate and display the list.");

        ArrayList<Integer> list = EX10_driver.generateList();
        EX10_driver.printList(list);
        System.out.println("This is the randomly generated list.");
        IR.pause();
        
        sort(list);
        EX10_driver.printList(list);
        System.out.println("This is the list after being sorted.");
        IR.pause();
        
        IR.displayEndOfProgram();
    }
    
    public static void sort(ArrayList<Integer> list){
        Collections.sort(list);
    }

}