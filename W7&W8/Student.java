package Student;

public class Student{
	private String firstName, lastName, department;
	private double grade;

	Student(String fName, String lName, double grade, String dName) {
		if(fName.isEmpty() || lName.isEmpty() ||dName.isEmpty()) {
			setFirstName("");
			setLastName("");
			setGrade(0.0);
			setDepartment("");
		}else {
			setFirstName(fName);
			setLastName(lName);
			setGrade(grade);
			setDepartment(dName);
		}
	}


	/**
	 * set first name in Student class
	 * @param
	 */
	public void setFirstName(String fName) {
		firstName = fName;
	}

	/**
	 * return first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * set last name in Student class
	 * @param
	 */
	public void setLastName(String lName) {
		lastName = lName;
	}

	/**
	 * return last name
	 * @return String lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * return full name
	 * @return String getFirstName() + " " + getLastName()
	 */
	public String getName() {
		return getFirstName() + " " + getLastName();
	}

	/**
	 * set department in Student class
	 * @param dName
	 */
	public void setDepartment(String dName) {
		department = dName;
	}

	/**
	 * return department
	 * @return String
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * set Grade in Student class
	 * @param grade
	 */
	public void setGrade(double grade) {
		this.grade = grade;
	}

	/**
	 * return grade
	 * @return double
	 */
	public double getGrade() {
		return grade;
	}

	@Override
	public String toString() {
		return String.format( "%-9s%-12s%.2f   %-7s", getFirstName(), getLastName(), getGrade(), getDepartment());
	}

}
