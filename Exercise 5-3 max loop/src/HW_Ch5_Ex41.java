/********************************************************************************************************************
 * HW_Ch5_Ex41.java
 * Created by: Phillip Benoit 10-23-16
 * CIS 131 - Programming and Problem Solving II 
 * Pima Community College - Fall 2016 
 ******************************************************************************************************************** 
 * Introduction to Java Programming: Comprehensive Version 10th Edition
 * Exercise 5.41 page 199
 ******************************************************************************************************************** 
 * This program counts integers in a loop until the user enters 0 to end counting.
 * At the end, it displays statistics about the numbers counted.
 ********************************************************************************************************************/

public class HW_Ch5_Ex41 {

    public static void main(String[] args) {
        IR.displayProgramInformation("HW_Ch5_Ex41", "10-23-16",
                "Introduction to Java Programming: Comprehensive Version 10th Edition", "Exercise 5.41 page 199",
                "This program counts integers in a loop until the user enters 0 to end counting.",
                "At the end, it displays statistics about the numbers counted.");
        int total=0,totalLoops=0,positiveNumbers=0,negativeNumbers=0,input=0,min=101,max=-101,minOccurrences=0,maxOccurrences=0;
        do {
            input = IR.getIntegerBetweenLowAndHigh("Please enter a whole number: (-100 to 100, 0 will end counting)", -100, 100, "The number you entered is out of range");
            if (input!=0) {
                if (input < 0) {negativeNumbers++;}
                if (input > 0) {positiveNumbers++;}
                if (input > max) {max = input;maxOccurrences=0;}
                if (input == max) {maxOccurrences++;}
                if (input < min) {min = input;minOccurrences=0;}
                if (input == min) {minOccurrences++;}
                totalLoops++;
                total+=input;
            }
        } while (input != 0);
        
        if (totalLoops==0) {
            System.out.println("You did not enter any numbers to count.");
        } else {
            System.out.println("Number of positive numbers counted: " + positiveNumbers);
            System.out.println("Number of negative numbers counted: " + negativeNumbers);
            System.out.println("Lowest number: " + min);
            System.out.println("Number of times it was counted counted: " + minOccurrences);
            System.out.println("Highest number: " + max);
            System.out.println("Number of times it was counted counted: " + maxOccurrences);
            System.out.println("Numbers counted: " + totalLoops);
            System.out.println("Total of all numbers entered: " + total);
            System.out.println("Average of all numbers entered: " + ((float)total/totalLoops));
        }
        IR.displayEndOfProgram();
    }
    

}
