/******************************************************************************
* Lab_6.java                                                                  *
* Created by: Phillip Benoit 10-28-16                                         *
* CIS 131 - Programming and Problem Solving II                                * 
* Pima Community College - Fall 2016                                          *
******************************************************************************* 
* Lab 6                                                                       *
* Class Class                                                                 *
*******************************************************************************
* This program uses a special class do describe a class at                    *
* Pima College.  It then demonstrates class functions.                        *
*******************************************************************************/

public class Lab_6 {

    public static void main(String[] args) {
        IR.displayProgramInformation("Lab_6", "10-28-16", "Lab 6", "Class Class",
                "This program uses a special class do describe a class at",
                "Pima College.  It then demonstrates class functions.");
        ClassSection firstClass, secondClass;
        firstClass = new ClassSection();
        generateClass(firstClass);
        System.out.println(firstClass.toString());
        secondClass = new ClassSection(13156, 131, 20, 9, 9002,
                "CIS", "Hybrid", "East", "W", "12:00 - 14:35");
        System.out.println(secondClass.toString());
        IR.displayEndOfProgram();
    }
    
    static void generateClass(ClassSection course) {
        course.setCampus("N/A");
        course.setCapacity(15);
        course.setCourseNumber(142);
        course.setCRN(13273);
        course.setDays("N/A");
        course.setDepartment("CIS");
        course.setEnrollment(12);
        course.setInstructorID(9001);
        course.setMode("Online");
        course.setTimes("N/A");
    }
    
}
