/******************************************************************************
* Lab_7.java                                                                  *
* Created by: Phillip Benoit 11-12-16                                         *
* CIS 131 - Programming and Problem Solving II                                * 
* Pima Community College - Fall 2016                                          *
******************************************************************************* 
* Lab 7                                                                       *
* Class Class Part 2                                                          *
*******************************************************************************
* This program uses a special class do describe a class at                    *
* Pima College.  It then demonstrates class functions.                        *
*******************************************************************************/

public class Lab_7 {

    public static void main(String[] args) {
        IR.displayProgramInformation("Lab_7", "11-12-16", "Lab 7", "Class Class Part 2",
                "This program uses a special class do describe a class at",
                "Pima College.  It then demonstrates class functions.");
        ClassSection myClass = new ClassSection(13156, 131, 20, 9002,
                "CIS", "Hybrid", "East", "W", "12:00 - 14:35");
        System.out.println("-----Pre Enrollment-----");
        System.out.println(myClass.toString());
        generateStudents(myClass);
        System.out.println("-----Post Enrollment-----");
        System.out.println(myClass.getStudents());
        generateGrades(myClass);
        System.out.println("-----With Grades-----");
        System.out.println(myClass.toString());
        System.out.println(myClass.getStudents());
        removeStudents(myClass);
        System.out.println("-----With Students Removed-----");
        System.out.println(myClass.toString());
        System.out.println(myClass.getStudents());
        IR.displayEndOfProgram();
    }
    
    static void generateStudents(ClassSection myClass) {
        for (int step = 10001; step < 10010; step++) {
            myClass.addStudent(step);
        }
    }
    
    static void generateGrades(ClassSection myClass) {
        myClass.assignGrade(10001, 4);
        myClass.assignGrade(10002, 3);
        myClass.assignGrade(10003, 2);
        myClass.assignGrade(10004, 1);
        for (int step = 10005; step < 10010; step++) {
            myClass.assignGrade(step, IR.getRandomNumber(1, 4));
        }
    }
    
    static void removeStudents(ClassSection myClass) {
        myClass.withdrawStudent(10005);
        myClass.withdrawStudent(10006);
        myClass.withdrawStudent(10007);
    }
}
