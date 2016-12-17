/********************************************************************************************************************
 * ftom.java
 * Created by: Phillip Benoit 9-23-16
 * CIS 131 - Programming and Problem Solving II 
 * Pima Community College - Fall 2016 
 ******************************************************************************************************************** 
 * Introduction to Java Programming: Comprehensive Version 10th Edition
 * Exercise 2.3 page 69
 ******************************************************************************************************************** 
 * This program takes a distance in feet and converts it to meters
 ********************************************************************************************************************/

import java.util.Scanner;

public class ftom {

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		displayProgramInformation();
		float feet=getFeet();
		System.out.println("The measument in meters is: "+ Float.toString(feet*0.305f) );
	}
	
	static float getFeet(){
		float inputFeet;
		String inputString;
		do {
			do {
				System.out.print("Please input a measument in Feet up to 100: ");
				inputString=input.nextLine();
			} while (floatTry(inputString));//tests for proper float from input
			inputFeet = Float.parseFloat(inputString);
		} while (inputFeet<=0 | inputFeet>100);//defined minimum and maximum
		return inputFeet;
	}
	
	static boolean floatTry(String test){
		try{
			Float.parseFloat(test);
			return false;
		} catch (NumberFormatException e) {
			return true;
		}
	}

	private static void displayProgramInformation() {
	    System.out.println("****************************************************************************************");
	    System.out.println("* ftom.java                                                                            *");
	    System.out.println("* Created by: Phillip Benoit 9-23-16                                                   *");
		System.out.println("* CIS 131 - Programming and Problem Solving II                                         *"); 
		System.out.println("* Pima Community College - Fall 2016                                                   *");
		System.out.println("****************************************************************************************"); 
		System.out.println("* Introduction to Java Programming: Comprehensive Version 10th Edition                 *");
		System.out.println("* Exercise 2.3 page 69                                                                 *");
		System.out.println("****************************************************************************************"); 
		System.out.println("* This program takes a distance in feet and converts it to meters                      *");
		System.out.println("****************************************************************************************");
		System.out.println("");
	}
}
