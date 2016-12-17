/********************************************************************************************************************
 * HW_Ch11_Ex13.java
 * Created by: Phillip Benoit 11-27-16
 * CIS 131 - Programming and Problem Solving II 
 * Pima Community College - Fall 2016 
 ******************************************************************************************************************** 
 * Introduction to Java Programming: Comprehensive Version 10th Edition
 * Exercise 11.13 page 447
 ******************************************************************************************************************** 
 * This program demonstrates removing duplicates from an array list.
 * It calls the driver to generate and display the list.
 ********************************************************************************************************************/

import java.util.ArrayList;

public class HW_Ch11_Ex13 {
    
    public static void main(String[] args) {
        IR.displayProgramInformation("HW_Ch11_Ex13", "11-27-16",
                "Introduction to Java Programming: Comprehensive Version 10th Edition", "Exercise 11.13 page 447",
                "This program demonstrates removing duplicates from an array list.",
                "It calls the driver to generate and display the list.");

        ArrayList<Integer> list = EX10_driver.generateList();
        EX10_driver.printList(list);
        System.out.println("This is the randomly generated list.");
        IR.pause();
        
        removeDuplicate(list);
        EX10_driver.printList(list);
        System.out.println("This is the list after having the duplicates removed.");
        IR.pause();
        
        IR.displayEndOfProgram();
    }
    
    public static void removeDuplicate(ArrayList<Integer> list){
        ArrayList<Integer> sortedList = new ArrayList<Integer>();
        for (Integer i : list) {
            if (!sortedList.contains(i)) {sortedList.add(i);}
        }
        list.clear();
        list.addAll(sortedList);
    }

}