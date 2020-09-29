package SwingForm;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class stores student Info for StudentDesirial and StudentSirial class.
 * @author MonicaYam
 *
 */
public class Student implements Serializable {
	private int stdID;
	private String firstName;
	private String lastName;
	private ArrayList<String> courses;

	public Student(){
		courses = new ArrayList<String>();
	}

	public void setStdID(String strId) throws Exception {
		try{
			int id = Integer.parseInt(strId);
			if(id > -1) {
				stdID = id;
			}else {
				throw new Exception();
			}
		}catch(Exception e) {
			throw new Exception("Invalid student number. Please enter valid number!");
		}
	}

	public int getStdID() {
		return stdID;
	}

	public void setFirstName(String name) throws Exception {
		if(!name.trim().isEmpty() && !name.isEmpty()) {
			firstName = name;
		}else {
			throw new Exception("first name doesn't accept empty! please enter again.");
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String name) throws Exception {
		if(!name.trim().isEmpty() && !name.isEmpty()) {
			lastName = name;
		}else {
			throw new Exception("last name doesn't accept empty! please enter again.");
		}
	}

	public String getLastName() {
		return lastName;
	}

	public String getName() {
		return firstName + " " + lastName;
	}
	public void setCourses(String courseName) throws Exception  {
		if( !courseName.trim().isEmpty() && !courseName.isEmpty()) {
			courses.add(courseName);
		}else {
			throw new Exception("course name doesn't accept empty! please enter again.");
		}
	}

	public ArrayList<String> getCourses(){
		return courses;
	}

	@Override
	public String toString(){
		return String.format(" StudentId : %s%n Name: %s%n Classes: %s%n", this.getStdID(),this.getName(), this.getCourses());
	}
}

