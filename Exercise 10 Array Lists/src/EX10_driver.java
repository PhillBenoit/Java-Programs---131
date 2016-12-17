/********************************************************************************************************************
 * EX10_driver.java
 * Created by: Phillip Benoit 11-27-16
 * CIS 131 - Programming and Problem Solving II 
 * Pima Community College - Fall 2016 
 ******************************************************************************************************************** 
 * Introduction to Java Programming: Comprehensive Version 10th Edition
 * Exercise 11.7, 11.11, and 11.13
 ******************************************************************************************************************** 
 * This program holds methods used by all 3 exercises and
 * demonstrates them. They can also be run individually.
 ********************************************************************************************************************/

import java.util.ArrayList;

public class EX10_driver {
    
    private static final int LIST_SIZE = 25;
    
    private static final int MIN = 1;
    private static final int MAX = 20;
    private static final int MAX_SIZE = Integer.toString(MAX).length() + 1;

    public static void main(String[] args) {
        IR.displayProgramInformation("EX10_driver", "11-27-16",
                "Introduction to Java Programming: Comprehensive Version 10th Edition", "Exercise 11.7, 11.11, and 11.13",
                "This program holds methods used by all 3 exercises and",
                "demonstrates them. They can also be run individually.");
        
        ArrayList<Integer> list = generateList();
        printList(list);
        System.out.println("This is the randomly generated list.");
        IR.pause();
        
        HW_Ch11_Ex11.sort(list);
        printList(list);
        System.out.println("This is the list after being sorted.");
        IR.pause();
        
        HW_Ch11_Ex7.shuffle(list);
        printList(list);
        System.out.println("This is the list after being shuffled.");
        IR.pause();
        
        HW_Ch11_Ex13.removeDuplicate(list);
        EX10_driver.printList(list);
        System.out.println("This is the list after having the duplicates removed.");
        IR.pause();
        
        IR.displayEndOfProgram();
    }
    
    static ArrayList<Integer> generateList() {
        ArrayList<Integer> returnList = new ArrayList<Integer>();
        for (int step = 0; step < LIST_SIZE; step++) {
            returnList.add(IR.getRandomNumber(MIN, MAX));
        }
        return returnList;
    }
    
    static void printList(ArrayList<Integer> l){
        int counter = 0;
        for (Integer i : l) {
            if (counter % 5 == 0) {System.out.print("\n");}
            counter++;
            IR.displayCell(MAX_SIZE, i.toString());
        }
        System.out.print("\n");
    }
}