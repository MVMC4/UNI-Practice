import java.util.Scanner;
import java.util.ArrayList;

/*
 *Design a simple student record
 *
*/

public class Class {

	public static void main(String[] args) {

		

	}


}


class StudentRecord {
	private String studentName;
	private int studentScore;

	public ArrarList<String> studentList = new ArrayList<String>;
	public ArrayList<Integer> studentScores = new ArrayList<Integer>;

	public StudentRecord() {
		System.out.println("Instruction set: ");
		System.out.println("newRecords(String name, int score): puts ");
		System.out.print
	}

	public void newRecords(String name, int score) {
		if ((score >= 0) && (score <= 10)) {
			studentName = name;
			studentScore = score;
		}
		else {
			System.out.println("Failed to make record, score out side of range, 0 -10"");
		}
	}

	public void saveRecords () {
		studentList.add(StudentName);
		studentScore.add(studentScore);
	}

	public void showAllRecords() {
		for
	}

	public void sortRecords() {
		
	}

}
