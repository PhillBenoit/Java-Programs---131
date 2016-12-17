import java.util.ArrayList;
import java.util.List;

public class ClassSection {
    private int CRN, CourseNumber, Capacity, InstructorID;
    private String Department, Mode, Campus, Days, Times;
    List<Enrollee> StudentList = new ArrayList<Enrollee>();
    
    public ClassSection() {
        CRN = 0;
        CourseNumber = 0;
        Capacity = 0;
        InstructorID = 0;
        Department = "";
        Mode = "";
        Campus = "";
        Days = "";
        Times = "";
    }
    
    public ClassSection(int CRN, int CourseNumber, int Capacity, int InstructorID,
            String Department, String Mode, String Campus, String Days, String Times) {
        this.CRN = CRN;
        this.CourseNumber = CourseNumber;
        this.Capacity = Capacity;
        this.InstructorID = InstructorID;
        this.Department = Department;
        this.Mode = Mode;
        this.Campus = Campus;
        this.Days = Days;
        this.Times = Times;
    }
    
    public int getCRN() {
        return CRN;
    }
    
    public void setCRN(int CRN) {
        this.CRN = CRN;
    }
    
    public int getCourseNumber() {
        return CourseNumber;
    }
    
    public void setCourseNumber(int CourseNumber) {
        this.CourseNumber = CourseNumber;
    }
    
    public int getCapacity() {
        return Capacity;
    }
    
    public void setCapacity(int Capacity) {
        this.Capacity = Capacity;
    }
    
    public int getEnrollment() {
        return StudentList.size();
    }
    
    public int getInstructorID() {
        return InstructorID;
    }
    
    public void setInstructorID(int InstructorID) {
        this.InstructorID = InstructorID;
    }
    
    public String getMode() {
        return Mode;
    }
    
    public void setMode(String Mode) {
        this.Mode = Mode;
    }
    
    public String getDepartment() {
        return Department;
    }
    
    public void setDepartment(String Department) {
        this.Department = Department;
    }
    
    public String getCampus() {
        return Campus;
    }
    
    public void setCampus(String Campus) {
        this.Campus = Campus;
    }
    
    public String getDays() {
        return Days;
    }
    
    public void setDays(String Days) {
        this.Days = Days;
    }
    
    public String getTimes() {
        return Times;
    }
    
    public void setTimes(String Times) {
        this.Times = Times;
    }
    
    public String toString () {
        return String.format("************************************\n"
                + "CRN:                %d\n"
                + "Department:         %s\n"
                + "Course Number:      %d\n"
                + "Instructional Mode: %s\n"
                + "Campus:             %s\n"
                + "Meeting Days:       %s\n"
                + "Meeting Times:      %s\n"
                + "Capacity:           %d\n"
                + "Enrollment:         %d\n"
                + "Instructor's ID     %d\n"
                + "************************************"
                , CRN, Department, CourseNumber, Mode,
                Campus, Days, Times, Capacity, getEnrollment(), InstructorID);
    }
    
    public void addStudent(int ID) {
        Enrollee studentToAdd = new Enrollee(ID, 0);
        StudentList.add(studentToAdd);
    }
    
    public int findStudent(int ID) {
        for (int step = 0; step < StudentList.size(); step++) {
            Enrollee student = StudentList.get(step);
            if (student.getID() == ID) {return step;}
        }
        return -1;        
    }
    
    public void withdrawStudent(int ID) {
        StudentList.remove(findStudent(ID));
    }
    
    public void assignGrade(int ID, int grade) {
        Enrollee student = StudentList.get(findStudent(ID));
        student.setGrade(grade);
    }
    
    public String getStudents() {
        String returnString = "Student List:";
        for (int step = 0; step < StudentList.size(); step++) {
            Enrollee student = StudentList.get(step);
            returnString += "\n    " + student.toString();
        }
        return returnString;
    }
}
