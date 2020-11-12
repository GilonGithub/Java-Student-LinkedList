import java.awt.List;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
//		Student s1 = new Student(1001, "first@first.com", "Jericho David");
//		Student s2 = new Student(1002, "first@first.com", "Jeremiah Jase");
//		Student s3 = new Student(1003, "first@first.com", "George Castro");
//		Student s4 = new Student(-1, "first@first.com", "Janelle Pierzina");
//		Student s5 = new Student(1005, "first@first.com", "Howie Gordon");
//		
		int userChoice;
		LinkedList<Student> studentList = new LinkedList<>();
		
		do {
			userChoice = showOptions();
			
			switch(userChoice) {
				case 1: Student s = addStudent(); 
						studentList.add(s);
						break;
				case 2: displayStudentList(studentList); 
						break;
				case 3: Student s1 = findStudent(studentList);
						removeStudent(s1, studentList);
						break;
				
			}
		} while(userChoice != 4);

	}



	private static void removeStudent(Student s1, LinkedList<Student> studentList) {
		
		studentList.remove(s1);
		System.out.println("\nThe following student has been removed from the list: \n" + s1);
		
		
	}



	private static Student findStudent(LinkedList<Student> studentList) {
		
		Scanner input = new Scanner(System.in);
		boolean isFound = false;
		int userChoice;
		
		do {
			System.out.println("\nEnter the student ID to be removed: ");
			userChoice = input.nextInt();
			for(Student s : studentList) {
				if(s.getID() == userChoice) {
					isFound = true;
					return s;
				}				
			}
			
			if(!isFound)
				System.err.println("\nStudent not found! Try again...");
			
		}while(!isFound);
		
		
		return null;
	}


	private static void displayStudentList(LinkedList<Student> studentList) {
		Iterator<Student> it = studentList.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
	}

	private static Student addStudent() {
		Scanner input = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		
		System.out.println("\nEnter the student ID: ");
		int id = input.nextInt();
		
		System.out.println("\nEnter the email address: ");
		String email = input.next();
		input.nextLine();

		System.out.println("\nEnter the full name: ");
		String fullName = input.nextLine();

		Student s = new Student(id, email, fullName);
		
		System.out.println("New student has been added!\n");
		
		return s;
		
	}

	private static int showOptions() {
		
		Scanner input = new Scanner(System.in);
		int userChoice;
		boolean invalidInput;
		
		do {
			System.out.println("Select an option from the menu:"
								+ "\n1. Add a student"
								+ "\n2. Display a student"
								+ "\n3. Remove a student"
								+ "\n4. Quit");
			
			userChoice = input.nextInt();
			invalidInput = userChoice < 5 && userChoice > 0 ? false : true;
			
		} while(invalidInput);
		
		return userChoice;
		
	}

}
