/********************************************************************************************************************
 * tip.java
 * Created by: Phillip Benoit 9-23-16
 * CIS 131 - Programming and Problem Solving II 
 * Pima Community College - Fall 2016 
 ******************************************************************************************************************** 
 * Introduction to Java Programming: Comprehensive Version 10th Edition
 * Exercise 2.5 page 70
 ******************************************************************************************************************** 
 * This program calculates a tip based on a bill total and a tip percentage
 ********************************************************************************************************************/
import java.util.Scanner;
import java.text.DecimalFormat;

public class tip {

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		displayProgramInformation();
		DecimalFormat moneyFormatter = new DecimalFormat("$###.00");//creates a format for output
		float Total=getFloat("Please Input the bill total (up to $100) $");
		float Tip=getFloat("Please Input the precentage you'd like to tip (up to %100) %");
		System.out.println("The amount to tip is: "+ moneyFormatter.format(Total*(Tip/100)) );
		System.out.println("The total including tip is: "+ moneyFormatter.format(Total*((Tip/100)+1)) );
	}
	
	static float getFloat(String request){
		float inputTotal;
		String inputString;
		do {
			do {
				System.out.print(request);
				inputString=input.nextLine();
			} while (floatTry(inputString));
			inputTotal = Float.parseFloat(inputString);
		} while (inputTotal<=0 | inputTotal>100);
		return inputTotal;
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
	    System.out.println("* tip.java                                                                            *");
	    System.out.println("* Created by: Phillip Benoit 9-23-16                                                   *");
		System.out.println("* CIS 131 - Programming and Problem Solving II                                         *"); 
		System.out.println("* Pima Community College - Fall 2016                                                   *");
		System.out.println("****************************************************************************************"); 
		System.out.println("* Introduction to Java Programming: Comprehensive Version 10th Edition                 *");
		System.out.println("* Exercise 2.5 page 70                                                                 *");
		System.out.println("****************************************************************************************"); 
		System.out.println("* This program calculates a tip based on a bill total and a tip percentage             *");
		System.out.println("****************************************************************************************");
		System.out.println("");
	}

}