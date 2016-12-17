/******************************************************************************
* Lab_8.java                                                                  *
* Created by: Phillip Benoit 11-19-16                                         *
* CIS 131 - Programming and Problem Solving II                                * 
* Pima Community College - Fall 2016                                          *
******************************************************************************* 
* Lab 8                                                                       *
* Publication Class                                                           *
*******************************************************************************
* This program demonstrates the publication class and inheritance.            *
* It creates 3 subclass variables and adds them to a list.                    *
*******************************************************************************/

import java.util.ArrayList;

public class Lab_8 {

    public static void main(String[] args) {
        IR.displayProgramInformation("Lab_8", "11-19-16", "Lab 8", "Publication Class",
                "This program demonstrates the publication class and inheritance.",
                "It creates 3 subclass variables and adds them to a list.");
        ArrayList<Publication> library = getLibrary();
        printLibrary(library);
        IR.displayEndOfProgram();
    }
    
    public static ArrayList<Publication> getLibrary() {
        ArrayList<Publication> library = new ArrayList<Publication>();
        
        Book myBook = new Book("Stan Lee: Conversations","Jackson: University Press of Mississippi",
                "July 6, 2007","Cartoonist -- Interviews -- Marvel Comics",
                "Jeff McLaughlin","9781578069842","2007004983",224,2007,1);
        library.add(myBook);
        
        Magazine myMagazine = new Magazine("Strange Tales", "Marvel Comics","July 1963",
                "Comic Book -- Mystery -- First Apperance","Monthly","Stan Lee");
        library.add(myMagazine);
        
        Newsletter myNewsletter = new Newsletter("Bullpen Bulletins", "Marvel Comics",
                "December 1965", "Comic Book -- Editorial -- First Edition",
                "Every Marvel Imprint","Stan Lee","Martin Goodman");
        library.add(myNewsletter);
        
        return library;
    }
    
    static void printLibrary(ArrayList<Publication> library) {
        for (Publication p : library) {
            System.out.println(p.toString());
        }
    }
    
}
