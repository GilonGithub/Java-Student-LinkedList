import java.awt.List;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
				
		int userChoice;
		LinkedList<Student> studentList = new LinkedList<>();
		
		do {
			userChoice = showOptions();
			
			switch(userChoice) {
				case 1: addStudent(studentList);
						break;
				case 2: displayStudentList(studentList); 
						break;
				case 3: Student s = findStudent(studentList);
						removeStudent(s, studentList);
						break;
				case 4: System.out.println("Thank you! Good bye!"); break;
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
		
		if(!studentList.isEmpty()) {
			Iterator<Student> it = studentList.iterator();
			
			System.out.println("\nLIST OF STUDENTS\n");
			while(it.hasNext()) {
				System.out.println(it.next());
			}
		} else {
			System.err.println("\nThere are no students in the list!\n");
		}
		
	}

	private static Student addStudent(LinkedList<Student> studentList) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("\nEnter the student ID: ");
		int id = input.nextInt();
		
		System.out.println("\nEnter the email address: ");
		String email = input.next();
		input.nextLine();

		System.out.println("\nEnter the full name: ");
		String fullName = input.nextLine();

		Student s = new Student(id, email, fullName);
		
		studentList.add(s);
		System.out.println("\nThe following student has been added!\n");
		System.out.println(s);
		
		return s;
		
	}

	private static int showOptions() {
		
		Scanner input = new Scanner(System.in);
		int userChoice;
		boolean invalidInput;
		
		do {
			System.out.println("---------MENU---------"
								+ "\n 1 - Add a student"
								+ "\n 2 - Display the student list"
								+ "\n 3 - Remove a student"
								+ "\n 4 - Quit"
								+ "\n----------------------"
								+ "\n\nSelected Option: ");
			
			userChoice = input.nextInt();
			invalidInput = userChoice < 5 && userChoice > 0 ? false : true;
			
			if(invalidInput)
				System.err.println("\nInvalid! Pick again.\n");
			
		} while(invalidInput);
		
		return userChoice;
		
	}

}
