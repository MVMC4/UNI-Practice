/*
 * Student.java
 * ID: 202505647
 * Name: Mooketsi Magwaza Vincent
 */

public class Student {

    private String studentId;
    private String name;
    private String major;
    private double gpa;

    public Student(String studentId, String name, String major, double gpa) {
        this.studentId = studentId;
        this.name = name;
        this.major = major;
        this.gpa = gpa;
        validateGpa();
    }

    private void validateGpa() {
        if (gpa < 0.0 || gpa > 4.0) {
            gpa = 0.0;
            System.err.println("GPA must be between 0.0 and 4.0, ");
        }
    }

    public String getID() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }

    public double getGPA() {
        return gpa;
    }

    public void changeMajor(String newMajor) {
        if (newMajor == null || newMajor.isEmpty()) {
            System.err.println("Major cannot be null or empty.");
        } else {
            major = newMajor;
        }
    }

    public void updateGPA(double newGpa) {
        gpa = newGpa;
        validateGpa();
    }

    @Override
    public String toString() {
        return "Student{studentId='" + studentId + "', name='" + name + "', major='" + major + "', gpa=" + gpa + "}";

    }

}