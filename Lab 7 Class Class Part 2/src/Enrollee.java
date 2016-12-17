
public class Enrollee {
    private int studentID, grade;
    
    public Enrollee() {
        studentID = 0;
        grade = 0;
    }
    
    public Enrollee(int studentID, int grade) {
        this.studentID = studentID;
        this.grade = grade;
    }
    
    public int getID() {
        return studentID;
    }
    
    public int getGrade() {
        return grade;
    }
    
    public void setID(int studentID) {
        this.studentID = studentID;
    }
    
    public void setGrade(int grade) {
        this.grade = grade;
    }
    
    public String toString() {
        return String.format("ID: %-5s  Grade: %s", Integer.toString(studentID), Integer.toString(grade));
    }

}
