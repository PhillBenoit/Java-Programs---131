/******************************************************************************
 * Lab_10.java                                                                 *
 * Created by: Phillip Benoit 11-30-16                                         *
 * CIS 131 - Programming and Problem Solving II                                * 
 * Pima Community College - Fall 2016                                          *
 ******************************************************************************* 
 * Lab 10                                                                      *
 * Books Inventory File                                                        *
 *******************************************************************************
 * This program uses a book class to demonstrate random access                 *
 * to a binary file while performing operations on it.                         *
 *******************************************************************************/

import java.io.EOFException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Lab_10 {

    private static final String FILE_NAME = "test.bin";
    private static final Path FILE_PATH = Paths.get(FILE_NAME);
    
    private static final String[] ERROR_TYPE = {
            "EOF",
            "IO",
            "Generic "
    };
    
    private static final String[] ERROR_ACTIVITY = {
            "writing data to",
            "reading data from",
            "trying to delete"
    };
    
    private static final String ERROR_MSG = "%sException occured while %s the test file.\n";

    public static void main(String[] args) {
        IR.displayProgramInformation("Lab_10", "11-30-16", "Lab 10", "Books Inventory File",
                "This program uses a book class to demonstrate random access",
                "to a binary file while performing operations on it.");
        runtestFiles();
        IR.displayEndOfProgram();
    }

    static void runtestFiles(){
        generateFile();
        readFile();
        System.out.println("These are the results witten to the file.");
        IR.pause();
        updateTitle(4, "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        updatePrice(5, 999.99);
        System.out.println("Pausing after updates.");
        IR.pause();
        readFile();
        System.out.println("These are the results after changing the records.");
    }
    
    static void generateFile(){
        destroyExisting();
        InventoryFile testFile = new InventoryFile(FILE_NAME, "rw");
        InventoryBook bookToAdd = new InventoryBook();

        bookToAdd.setISBN("9780439708180");
        bookToAdd.setPrice(12.7);
        bookToAdd.setTitle("Sorcerer's Stone");
        bookToAdd.setYearPublished(1999);
        bookToAdd.setQuantityOnHand(IR.getRandomNumber(5, 50));
        testFile.writeBookData(bookToAdd);

        bookToAdd.setISBN("9780439064873");
        //bookToAdd.setISBN("12345678901234567890");
        //bookToAdd.setISBN("1");
        bookToAdd.setPrice(17.43);
        bookToAdd.setTitle("Chamber of Secrets");
        //bookToAdd.setTitle("1234567890123456789012345678901234567890");
        bookToAdd.setYearPublished(2000);
        bookToAdd.setQuantityOnHand(IR.getRandomNumber(5, 50));
        testFile.writeBookData(bookToAdd);

        bookToAdd.setISBN("9780439136365");
        bookToAdd.setPrice(15.24);
        bookToAdd.setTitle("Prisoner of Azkaban");
        bookToAdd.setYearPublished(2001);
        bookToAdd.setQuantityOnHand(IR.getRandomNumber(5, 50));
        testFile.writeBookData(bookToAdd);

        bookToAdd.setISBN("9780439139601");
        bookToAdd.setPrice(18.28);
        bookToAdd.setTitle("Goblet of Fire");
        bookToAdd.setYearPublished(2002);
        bookToAdd.setQuantityOnHand(IR.getRandomNumber(5, 50));
        testFile.writeBookData(bookToAdd);

        bookToAdd.setISBN("9780439358071");
        bookToAdd.setPrice(29.95);
        bookToAdd.setTitle("Order of the Phoenix");
        bookToAdd.setYearPublished(2004);
        bookToAdd.setQuantityOnHand(IR.getRandomNumber(5, 50));
        testFile.writeBookData(bookToAdd);

        bookToAdd.setISBN("9780439785969");
        bookToAdd.setPrice(16.94);
        bookToAdd.setTitle("Half-Blood Prince");
        bookToAdd.setYearPublished(2006);
        bookToAdd.setQuantityOnHand(IR.getRandomNumber(5, 50));
        testFile.writeBookData(bookToAdd);

        testFile.closeFile();
    }

    static void updatePrice(int recordNumber, double price){
        InventoryFile testFile = new InventoryFile(FILE_NAME, "rw");
        InventoryBook book = new InventoryBook();
        readRecord(testFile, recordNumber, book);
        book.setPrice(price);
        writeRecord(testFile, recordNumber, book);
        testFile.closeFile();
    }

    static void updateTitle(int recordNumber, String title){
        InventoryFile testFile = new InventoryFile(FILE_NAME, "rw");
        InventoryBook book = new InventoryBook();
        readRecord(testFile, recordNumber, book);
        book.setTitle(title);
        writeRecord(testFile, recordNumber, book);
        testFile.closeFile();
    }

    static void writeRecord(InventoryFile testFile, int recordNumber, InventoryBook book){
        try {
            testFile.updateRecord(recordNumber, book);
        } catch (EOFException e) {
            exceptionStop(ERROR_TYPE[0], ERROR_ACTIVITY[0]);
        } catch (IOException e) {
            exceptionStop(ERROR_TYPE[1], ERROR_ACTIVITY[0]);
        } catch (Exception e) {
            exceptionStop(ERROR_TYPE[2], ERROR_ACTIVITY[0]);
        }
    }

    static void readRecord(InventoryFile testFile, int recordNumber, InventoryBook book){
        try {
            testFile.readBookData(recordNumber, book);
        } catch (EOFException e) {
            exceptionStop(ERROR_TYPE[0], ERROR_ACTIVITY[1]);
        } catch (IOException e) {
            exceptionStop(ERROR_TYPE[1], ERROR_ACTIVITY[1]);
        } catch (Exception e) {
            exceptionStop(ERROR_TYPE[2], ERROR_ACTIVITY[1]);
        }
    }

    static void readFile(){
        InventoryFile testFile = new InventoryFile(FILE_NAME, "r");
        InventoryBook book = new InventoryBook();
        for (int step = 0; step < testFile.length()/book.bytes(); step++){
            try {
                testFile.readBookData(book);
            } catch (EOFException e) {
                exceptionStop(ERROR_TYPE[0], ERROR_ACTIVITY[1]);
            } catch (IOException e) {
                exceptionStop(ERROR_TYPE[1], ERROR_ACTIVITY[1]);
            } catch (Exception e) {
                exceptionStop(ERROR_TYPE[2], ERROR_ACTIVITY[1]);
            }
            System.out.println(book.toString());
        }
        testFile.closeFile();
    }

    static void destroyExisting(){
        try {
            Files.deleteIfExists(FILE_PATH);
        } catch (IOException e) {
            exceptionStop(ERROR_TYPE[1], ERROR_ACTIVITY[2]);
        } catch (Exception e) {
            exceptionStop(ERROR_TYPE[2], ERROR_ACTIVITY[2]);
        }
    }
    
    static void exceptionStop(String type, String activity){
        System.err.format(ERROR_MSG, type, activity);
        System.exit(-1);
    }
}
