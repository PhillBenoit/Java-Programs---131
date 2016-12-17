/******************************************************************************
* Lab_4.java                                                                  *
* Created by: Phillip Benoit 10-22-16                                         *
* CIS 131 - Programming and Problem Solving II                                * 
* Pima Community College - Fall 2016                                          *
******************************************************************************* 
* Lab 4                                                                       *
* Array Sorter                                                                *
*******************************************************************************
* This program generates an array and fills it based on declared constants    *
* it also sorts and collects data about the array                             *
*******************************************************************************/

public class Lab_4 {
    //-----Initialize-------------------------------------------------------------------
    //constants that limit the minimum and maximum size of and values in the grid
    static final int ROWS = 10;
    static final int COLUMNS = 10;
    static final int RND_MIN = 1;
    static final int RND_MAX = 300;
    
    //-----Main-------------------------------------------------------------------------
    public static void main(String[] args) {
        IR.displayProgramInformation("Lab_4", "10-22-16", "Lab 4", "Array Sorter",
                "This program generates an array and fills it based on declared constants",
                "it also sorts and collects data about the array");
        //main variable
        int[][] grid = new int[ROWS][COLUMNS];
        //array that holds the value, location and occurrences of the minimum value in the grid
        //Initialized using the RND_MAX value for comparison
        int[] minimumValue = new int[] {RND_MAX,0,0,0};
        //array that holds the value, location and occurrences of the maximum value in the grid
        //Initialized using the RND_MIN value for comparison
        int[] maximumValue = new int[] {RND_MIN,0,0,0};
        //generates the grid, returns the total of all cells, and keeps track of the min and max value
        int total = generateGrid(grid, minimumValue, maximumValue);
        double average = getAverage(total);
        System.out.println("Unsorted:");
        displayGrid(grid);
        displayStatistics(minimumValue, maximumValue, total, average);
        sortGrid(grid);
        System.out.println("Sorted:");
        displayGrid(grid);
        IR.displayEndOfProgram();
    }
    
    //-----Sorting----------------------------------------------------------------------------------
    static void sortGrid(int[][] grid) {
        //first column must be declared outside of the loop so subsequent column loops can start at 0
        int columnCounter = 1;
        for (int rowCounter=0;rowCounter<ROWS;rowCounter++) {
            for (columnCounter=columnCounter;columnCounter<COLUMNS;columnCounter++) {
                reverseStep(rowCounter, columnCounter, grid);
            }
            //resets columns for subsequent loops
            columnCounter=0;
        }
    }
    
    //reverse stepping for the actual sort
    static void reverseStep(int rowStart, int columnStart, int[][] grid) {
        //value to be compared for sorting
        int sortValue = grid[rowStart][columnStart];
        //array that holds the address of the cell before the one currently being indexed with counters
        //also used to keep track of the current cell focus
        int[] previousCell = new int[] {rowStart, columnStart};
        getPreviousCell(previousCell);
        //starting column must be declared outside of the loop so subsequent column loops can start at the last column
        int columnCounter = previousCell[1];
        for (int rowCounter = previousCell[0];
                rowCounter >= 0 && grid[previousCell[0]][previousCell[1]] > sortValue;
                rowCounter--) {
            for (columnCounter=columnCounter;
                    columnCounter >= 0 && grid[previousCell[0]][previousCell[1]] > sortValue;
                    columnCounter--) {
                //variable holds the address of the cell after the one currently being indexed with counters
                //keeps track of the destination for the values being copied
                int[] nextCell = new int[] {rowCounter, columnCounter};
                getNextCell(nextCell);
                //previous cell is used here to compare values to exit the loop once sorting is complete
                previousCell[0]=rowCounter;
                previousCell[1]=columnCounter;
                getPreviousCell(previousCell);
                //copies the current cell before testing the next
                grid[nextCell[0]][nextCell[1]] = grid[rowCounter][columnCounter];
            }
            //resets columns for subsequent loops
            if (columnCounter == -1) {columnCounter = COLUMNS - 1;}
        }
        //the stepping variables are unreliable as an index outside of their loops because of
        //how columns must be dealt with, the index of previous cell is stepped up to assign the
        //sort value to the appropriate location
        getNextCell(previousCell);
        grid[previousCell[0]][previousCell[1]] = sortValue;
    }
    
    //simple method for stepping through cells in the grid
    static void getNextCell(int[] cell) {
        if (cell[1] == COLUMNS - 1) {
            cell[0]++;
            cell[1] = 0;
        } else {
            cell[1]++;
        }
    }
    
    //simple method for stepping through cells in the grid
    static void getPreviousCell(int[] cell) {
        if (cell[1] == 0) {
            cell[1] = COLUMNS - 1;
            cell[0]--;
        } else {
            cell[1]--;
        }
    }
    
    //-----Generating & Statistics---------------------------------------------------------------
    //generates the grid for sorting and keeps track of data about the values generated
    static int generateGrid(int[][] grid, int[] min, int[] max) {
        int total = 0;
        for (int rowCounter=0;rowCounter<ROWS;rowCounter++) {
            for (int columnCounter=0;columnCounter<COLUMNS;columnCounter++) {
                //assigns the value
                grid[rowCounter][columnCounter]=IR.getRandomNumber(RND_MIN, RND_MAX);
                //running total of all generated values
                total+=grid[rowCounter][columnCounter];
                //tests for minimum
                if (grid[rowCounter][columnCounter] < min[0]) {
                    min[0] = grid[rowCounter][columnCounter];
                    min[1] = rowCounter;
                    min[2] = columnCounter;
                    min[3] = 1;
                } else if (grid[rowCounter][columnCounter] == min[0]) {
                    min[3]++;//keeps track of multiple occurrences
                }
                //tests for maximum
                if (grid[rowCounter][columnCounter] > max[0]) {
                    max[0] = grid[rowCounter][columnCounter];
                    max[1] = rowCounter;
                    max[2] = columnCounter;
                    max[3] = 1;
                } else if (grid[rowCounter][columnCounter] == max[0]) {
                    max[3]++;//keeps track of multiple occurrences
                }
            }
        }
        return total;
    }
    
    //calculates average
    static double getAverage(int total) {
        return (double)total / (ROWS*COLUMNS);
    }
    
    //-----Display Functions----------------------------------------------------------------------------------
    //displays the grid using a loop
    static void displayGrid(int[][] grid) {
        for (int rowCounter=0;rowCounter<ROWS;rowCounter++) {
            for (int columnCounter=0;columnCounter<COLUMNS;columnCounter++) {
                //formats columns based on string length of the maximum random number
                System.out.print(String.format(
                        "%" + Integer.toString(RND_MAX).length() + "d ",
                        grid[rowCounter][columnCounter]));
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
    
    //displays information about the unsorted grid
    static void displayStatistics(int[] min, int[] max, int total, double average) {
        System.out.println("The lowest value " + min[0] + " first occurs at [" + min[1] + "][" + min[2] + "] and occurs " + min[3] + " time(s).");
        System.out.println("The highest value " + max[0] + " first occurs at [" + max[1] + "][" + max[2] + "] and occurs " + max[3] + " time(s).");
        System.out.println("Total of all numbers in the grid: " + total);
        System.out.println("The average is: " + average);
        System.out.println("");
    }
    
}
