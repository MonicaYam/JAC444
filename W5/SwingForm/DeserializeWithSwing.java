package SwingForm;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import students.Student;

public class DeserializeWithSwing extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeserializeWithSwing frame = new DeserializeWithSwing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DeserializeWithSwing() {
		int i = 1;
		ArrayList<Student> students;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		JLabel title = new JLabel("---------- Students Information ----------");
		contentPane.add(title);

		try {
			FileInputStream fi = new FileInputStream("studentInfo.out");
			ObjectInputStream oi = new ObjectInputStream(fi);

			students = (ArrayList<Student>)oi.readObject();

			if(students != null) {
				for(Student student:students) {
			        JTextArea studentInfo = new JTextArea(student.toString());
			        studentInfo.setEditable(false);
			        JLabel stdTitle = new JLabel("Student " + i);

			        contentPane.add(stdTitle);
			        contentPane.add(studentInfo);
			        i++;
				}
			}

			oi.close();
			fi.close();
		} catch (Throwable e) {
			System.err.println(e);
		}

		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 System.exit(0);
			}
		});
		contentPane.add(btnNewButton);
	}
}
