package Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;
/**
 * @author MonicaYam
 *
 */
public class StudentProcess {

	private static int counter = 1;
	private static Predicate<Student> fiftyToHundred = s -> (s.getGrade() >= 50.0) && (s.getGrade() <= 100.00);
	public static void main(String[] args){
		Student[] students= {
				new Student("Jack", "Smith", 50.0, "IT"),
				new Student("Aaron", "Johnson", 76.0, "IT"),
				new Student("Maaria", "White", 35.8, "Business"),
				new Student("John", "White", 47.0, "Media"),
				new Student("Laney", "White", 62.0, "IT"),
				new Student("Jack", "Jones", 32.9, "Business"),
				new Student("Wesley", "Jones", 42.89, "Media")
		};

		List<Student> studentList = new ArrayList<>(Arrays.asList(students));

		runTask1(studentList);
		runTask2(studentList);
		runTask3(studentList);
		runTask4(studentList);
		runTask5(studentList);
		runTask6(studentList);
		runTask7(studentList);
		runTask8(studentList);
		runTask9(studentList);
		runTask10(studentList);
	}

	private static void runTask1(List<Student> studentList) {
		displayTask();
		System.out.println("Complete Student list:");
		studentList.forEach(System.out::println);
	}


	private static void runTask2(List<Student> studentList) {
		List<Student> sList = new ArrayList<>(studentList);
		displayTask();
		System.out.println("Students who got 50.0-100.0 sorted by grade:");
		Comparator<Student> stdGradeComparator = Comparator.comparing(Student::getGrade);
		sList.stream().filter(fiftyToHundred).sorted(stdGradeComparator).forEach(System.out::println);
	}

	private static void runTask3(List<Student> studentList) {
		List<Student> sList = new ArrayList<>(studentList);
		displayTask();
		System.out.println("First Student who got 50.0-100.0:");
		System.out.println(sList.stream().filter(fiftyToHundred).findFirst().get());
	}


	private static void runTask4(List<Student> studentList) {
		displayTask();
		System.out.println("Students in ascending order by last name then first:");
		Comparator<Student> stdLastNameASCComparator = Comparator.comparing(Student::getLastName).thenComparing(Student::getFirstName);
		studentList.stream().sorted(stdLastNameASCComparator).forEach(System.out::println);

		System.out.println("\nStudents in descending order by last name then first:");
		studentList.stream().sorted(stdLastNameASCComparator.reversed()).forEach(System.out::println);
	}

	private static void runTask5(List<Student> studentList) {
		List<Student> sList = new ArrayList<>(studentList);
		displayTask();
		System.out.println("Unique Student last names:");
		sList.stream().map(Student::getLastName).distinct().sorted().forEach(System.out::println);
	}


	private static void runTask6(List<Student> studentList) {
		List<Student> sList = new ArrayList<>(studentList);
		displayTask();
		System.out.println("Student names in order by last name then first name:");
		Comparator<Student> stdNameASCComparator = Comparator.comparing(Student::getLastName).thenComparing(Student::getFirstName);
		sList.stream().sorted(stdNameASCComparator).map(Student::getName).forEach(System.out::println);
	}

	private static void runTask7(List<Student> studentList) {
		List<Student> sList = new ArrayList<>(studentList);
		displayTask();
		System.out.println("Students by department:");
		Map<String, List<Student>> stdList = sList.stream().collect(Collectors.groupingBy(Student::getDepartment));
		stdList.forEach((k,v)->{
			System.out.println(k);
			v.forEach(s->System.out.printf("	 %s %n", s));
		});
	}

	private static void runTask8(List<Student> studentList) {
		List<Student> sList = new ArrayList<>(studentList);
		displayTask();
		System.out.println("Count of Students by department:");
		Map<String, Long> countList = sList.stream().collect(Collectors.groupingBy(Student::getDepartment,  Collectors.counting()));
		countList = new TreeMap<String, Long>(countList);
		countList.forEach((k,v)->{
			System.out.println(k + " has " + v + " students.");
		});
	}

	private static void runTask9(List<Student> studentList) {
		List<Student> sList = new ArrayList<>(studentList);
		displayTask();
		System.out.println("Sum of Students' grades: " + sList.stream().mapToDouble(Student::getGrade).sum());
	}

	private static void runTask10(List<Student> studentList) {
		List<Student> sList = new ArrayList<>(studentList);
		displayTask();
		System.out.println("Average of Students' grades: " + String.format("%.2f", sList.stream().mapToDouble(Student::getGrade).average().getAsDouble()));
	}

	/**
	 * display Task i (i = 1 to 10)
	 * @param i
	 */
	private static void displayTask() {
		System.out.printf("%nTask %s :%n%n", counter++);
	}
}
