/********************************************************************************************************************
 * HW_Ch6_Ex5.java
 * Created by: Phillip Benoit 10-23-16
 * CIS 131 - Programming and Problem Solving II 
 * Pima Community College - Fall 2016 
 ******************************************************************************************************************** 
 * Introduction to Java Programming: Comprehensive Version 10th Edition
 * Exercise 6.5 page 234
 ******************************************************************************************************************** 
 * This program asks the user for 3 double precision floating point numbers
 * and returns them sorted ascending order.
 ********************************************************************************************************************/

public class HW_Ch6_Ex5 {
    
    static final String[] NUMBER_NAMES = {"first", "second", "third"};
    static final String INPUT_MSG = "Please enter the %s number: (1 - 1 million)";
    

    public static void main(String[] args) {
        IR.displayProgramInformation("HW_Ch6_Ex5", "10-23-16",
                "Introduction to Java Programming: Comprehensive Version 10th Edition", "Exercise 6.5 page 234",
                "This program asks the user for 3 double precision floating point numbers",
                "and returns them sorted ascending order.");
        double[] numbersToSort = getDoubles();
        numbersToSort=sortNumbers(numbersToSort);
        displaySortedNumbers(numbersToSort[0],numbersToSort[1],numbersToSort[2]);
        IR.displayEndOfProgram();
    }
    
    static double[] getDoubles() {
        double[] returnDoubles = new double[3];
        for (int step = 0;step<3;step++) {
            returnDoubles[step] = IR.getDoubleBetweenLowAndHigh(String.format(INPUT_MSG, NUMBER_NAMES[step]), 1, 1000000);
            System.out.println(IR.CONFIRMATION + returnDoubles[step]);
        }
        return returnDoubles;
    }
    
    static double[] sortNumbers(double numbers[]) {
        double sorted[] = new double[3];
        if (numbers[0] <= numbers[1] && numbers[1] <= numbers[2]) {sorted[0]=numbers[0];sorted[1]=numbers[1];sorted[2]=numbers[2];}
        if (numbers[0] <= numbers[2] && numbers[2] <= numbers[1]) {sorted[0]=numbers[0];sorted[1]=numbers[2];sorted[2]=numbers[1];}
        if (numbers[1] <= numbers[0] && numbers[0] <= numbers[2]) {sorted[0]=numbers[1];sorted[1]=numbers[0];sorted[2]=numbers[2];}
        if (numbers[1] <= numbers[2] && numbers[2] <= numbers[0]) {sorted[0]=numbers[1];sorted[1]=numbers[2];sorted[2]=numbers[0];}
        if (numbers[2] <= numbers[0] && numbers[0] <= numbers[1]) {sorted[0]=numbers[2];sorted[1]=numbers[0];sorted[2]=numbers[1];}
        if (numbers[2] <= numbers[1] && numbers[1] <= numbers[0]) {sorted[0]=numbers[2];sorted[1]=numbers[1];sorted[2]=numbers[0];}
        return sorted;
    }
    
    public static void displaySortedNumbers(double num1,double num2,double num3) {
        System.out.println("The sorted order is:");
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
    }

}