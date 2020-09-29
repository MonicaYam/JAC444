package students;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * this class sirialize Student Info.
 * this class get that info from User Input and output it to file(***.out).
 * @author Monica Yam
 *
 */
public class StudentSirialize {
	private static Scanner scanner;
	private static Student student;

	public static void main(String[] args) {
		scanner  = new Scanner(System.in);

		boolean result = addStudentsInfo();
		if(!result) {
			System.out.println("Sirialize Failed.");
		}
	}

	/**
	 * add Students info to ArrayList<Student> and it output to the file.(studentInfo.out)
	 * @return
	 */
	public static boolean addStudentsInfo()
	{
		boolean result = true;
		char answer;
		ArrayList<Student> students = new ArrayList<Student>();

		try {
			do {
				student =  new Student();
				setStudentId();
				setName();
				setCourses();

				do {
					System.out.printf("Do you want to add another student? (Y or N) : ");
					answer = scanner.nextLine().trim().charAt(0);
					if(answer != 'Y' && answer != 'N') {
						System.out.println("Invalid answer! please enter again.");
					}
				}while(answer != 'Y' && answer != 'N');
				students.add(student);
			}while(answer == 'Y');

		} catch (Throwable e) {
			System.err.println(e);
			result = false;
		}

		if(result) {
			result = writeStudentInfo(students);
		}

		return result;
	}

	/**
	 * set Student Id to student class.
	 * @param student
	 * @param scanner
	 * @return
	 */
	public static void setStudentId() {
		int id = -1;
		String strId;

		System.out.println("Please enter student information.");

		do {
			System.out.print("Enter student number: ");
			try {
				strId = scanner.nextLine().trim();
				student.setStdID(strId);
				id = Integer.parseInt(strId);
			}catch(Exception e) {
				// if I put System.err.println(e.getMessage());
				//display message out is different.
				//expect: Enter... -> error msg ->Enter.. ,  but it display Enter.. -> Enter.. -> errorMsg
				System.out.println(e.getMessage());
			}
		}while(id == -1);

	}

	/**
	 * set first name and last name and store them in student.
	 * @param student
	 * @param scanner
	 * @return Student
	 */
	public static void setName() {
		String firstName = "", lastName = "";

		do {
			System.out.print("Please Enter the student's first name: ");
			firstName = scanner.nextLine();
			try {
				student.setFirstName(firstName);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}while(firstName.trim().isEmpty() || firstName.isEmpty());

		do {
			System.out.printf("Please Enter the student's last name: ");
			lastName = scanner.nextLine();
			try {
				student.setLastName(lastName);
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}while(lastName.trim().isEmpty() || lastName.isEmpty());
	}

	/**
	 * Set courses and store them on Student.
	 * @param student
	 * @param scanner
	 * @return
	 */
	public static void setCourses() {
		String courseName;
		do {
			System.out.printf("Please enter course information ( q: Quit ): ");
			courseName = scanner.nextLine();
			if(!courseName.equals("q")) {
				try{
					student.setCourses(courseName);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		} while(!courseName.equals("q"));

	}

	/**
	 * Write Student Information to file.
	 * @param students
	 * @return boolean
	 */
	public static boolean writeStudentInfo(ArrayList<Student> students){
		boolean result = true;
		//Write the information to text file.

		try (FileOutputStream fo = new FileOutputStream("studentInfo.out"); ObjectOutputStream out = new ObjectOutputStream(fo);){
			out.writeObject(students);

			out.close();
			fo.close();
		} catch (FileNotFoundException e) {
			System.err.println(e);
			result = false;
		}catch (IOException e) {
			System.err.println(e);
			result = false;
		} catch (Throwable e) {
			System.err.println(e);
			result = false;
		}
		return result;
	}
}
