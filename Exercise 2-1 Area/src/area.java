/********************************************************************************************************************
 * area.java
 * Created by: Phillip Benoit 9-23-16
 * CIS 131 - Programming and Problem Solving II 
 * Pima Community College - Fall 2016 
 ******************************************************************************************************************** 
 * Introduction to Java Programming: Comprehensive Version 10th Edition
 * Exercise 1.9 page 31
 ******************************************************************************************************************** 
 * This program calculates the area of a rectangle
 ********************************************************************************************************************/
import java.util.Scanner;

public class area {
	
	private static Scanner input = new Scanner(System.in);//Eclipse likes declaring this here

	public static void main(String[] args) {
		displayProgramInformation();
		Float length, width;
		length = side();
		System.out.println("The Length has been recorded as: "+ Float.toString(length) );
		width = side();
		System.out.println("The Width has been recorded as: "+ Float.toString(width) );
		System.out.println("The Area is: "+ Float.toString(width*length) );
	}
	
	static Float side(){
		Float inputSide;
		String inputString;
				
		do {
			do {
				System.out.print("Please input a side length greater than 0 and up to 100: ");
				inputString=input.nextLine();
			} while (floatTry(inputString));//makes sure input is a valid float
			inputSide = Float.parseFloat(inputString);
		} while (inputSide<=0 | inputSide>100);//makes sure the input conforms to value limits

		return inputSide;
	}
	
	static boolean floatTry(String test){//boolean test for valid float data
		try{
			Float.parseFloat(test);
			return false;
		} catch (NumberFormatException e) {
			return true;
		}
	}
	
   private static void displayProgramInformation() {
	      System.out.println("****************************************************************************************");
	      System.out.println("* area.java                                                                            *");
	      System.out.println("* Created by: Phillip Benoit 9-23-16                                                   *");
	      System.out.println("* CIS 131 - Programming and Problem Solving II                                         *"); 
	      System.out.println("* Pima Community College - Fall 2016                                                   *");
	      System.out.println("****************************************************************************************"); 
	      System.out.println("* Introduction to Java Programming: Comprehensive Version 10th Edition                 *");
	      System.out.println("* Exercise 1.9 page 31                                                                 *");
	      System.out.println("****************************************************************************************"); 
	      System.out.println("* This program calculates the area of a rectangle                                      *");
	      System.out.println("****************************************************************************************");
	      System.out.println("");
	   }


}
