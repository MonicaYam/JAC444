package students;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * this class reads Student info from text file and displays that info on console.
 * @author Monica Yam
 *
 */
public class StudentDesirialize {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		int numOfStudent = 1;
		ArrayList<Student> students;

		try {
			FileInputStream fi = new FileInputStream("studentInfo.out");
			ObjectInputStream oi = new ObjectInputStream(fi);

			System.out.println("---------- Students Information ----------");

			students = (ArrayList<Student>)oi.readObject();

			if(students != null) {
				for(Student student:students) {
					System.out.printf("Student %s%n",numOfStudent++);
					System.out.printf("%s%n",student.toString());
				}
			}

			oi.close();
			fi.close();
		} catch (Throwable e) {
			System.err.println(e);
		}
	}
}
