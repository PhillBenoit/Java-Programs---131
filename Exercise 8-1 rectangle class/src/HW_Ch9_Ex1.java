/********************************************************************************************************************
 * HW_Ch9_Ex1.java
 * Created by: Phillip Benoit 11-13-16
 * CIS 131 - Programming and Problem Solving II 
 * Pima Community College - Fall 2016 
 ******************************************************************************************************************** 
 * Introduction to Java Programming: Comprehensive Version 10th Edition
 * Exercise 9.1 page 360
 ******************************************************************************************************************** 
 * This program demonstrates the Rectangle class using numbers defined in the
 * book. The Rectangle class demonstrates class structure and functionality.
 ********************************************************************************************************************/

public class HW_Ch9_Ex1 {

    public static void main(String[] args) {
        IR.displayProgramInformation("HW_Ch9_Ex1", "11-13-16",
                "Introduction to Java Programming: Comprehensive Version 10th Edition", "Exercise 9.1 page 360",
                "This program demonstrates the Rectangle class using numbers defined in the",
                "book. The Rectangle class demonstrates class structure and functionality.");
        displayRectangle(4,40);
        System.out.println("***********************************************************************");
        displayRectangle(3.5,35.9);
        IR.displayEndOfProgram();
    }
    
    static void displayRectangle(double width, double height) {
        Rectangle myRectangle = new Rectangle(width,height);
        System.out.println("width: " + myRectangle.width);
        System.out.println("height: " + myRectangle.height);
        System.out.println("area: " + myRectangle.getArea());
        System.out.println("perimeter: " + myRectangle.getPerimeter());
    }

}
