package SwingForm;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import students.Student;

public class SerializeWithSwing extends JFrame {

	private JPanel contentPane;
	private JTextField studentIdField;
	private JTextField fNameField;
	private JTextField lNameField;
	private JTextField courseField;
	private JLabel e1;
	private JLabel e2;

	int stdIdNum = -1;
	private Student student;
	private ArrayList<Student> students;
	private JTextArea courseList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SerializeWithSwing frame = new SerializeWithSwing();
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
	public SerializeWithSwing() {
		student = new Student();
		students = new ArrayList<Student>();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Student ID : ");
		lblNewLabel.setBounds(45, 16, 89, 16);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("FIrst Name : ");
		lblNewLabel_1.setBounds(45, 54, 89, 16);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Last Name : ");
		lblNewLabel_2.setBounds(45, 92, 78, 16);
		contentPane.add(lblNewLabel_2);

		studentIdField = new JTextField();
		studentIdField.setBounds(141, 11, 130, 26);
		contentPane.add(studentIdField);
		studentIdField.setColumns(10);
		e1 = new JLabel("Invalid value!");
		e1.setForeground(Color.RED);
		e1.setBounds(283, 16, 96, 16);
		contentPane.add(e1);
		e1.setVisible(false);

		fNameField = new JTextField();
		fNameField.setBounds(141, 49, 130, 26);
		contentPane.add(fNameField);
		fNameField.setColumns(10);

		lNameField = new JTextField();
		lNameField.setBounds(141, 87, 130, 26);
		contentPane.add(lNameField);
		lNameField.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Classes : ");
		lblNewLabel_4.setBounds(62, 136, 61, 16);
		contentPane.add(lblNewLabel_4);

		e2 = new JLabel("Empty!");
		e2.setForeground(Color.RED);
		e2.setBounds(283, 136, 89, 16);
		contentPane.add(e2);
		e2.setVisible(false);

		courseField = new JTextField();
		courseField.setBounds(141, 131, 130, 26);
		contentPane.add(courseField);
		courseField.setColumns(10);
		CourseHandler handler1 = new CourseHandler();
		courseField.addActionListener(handler1);

		JButton saveButton = new JButton("Save");
		SaveHandler saveHandler = new SaveHandler();
		saveButton.addActionListener(saveHandler);
		saveButton.setBounds(45, 219, 117, 29);
		contentPane.add(saveButton);

		JButton submitButton = new JButton("Submit");
		SubmitHandler submitHandler = new SubmitHandler();
		submitButton.addActionListener(submitHandler);
		submitButton.setBounds(236, 219, 117, 29);
		contentPane.add(submitButton);

		courseList = new JTextArea("");
		courseList.setBackground(SystemColor.window);
		courseList.setBounds(141, 164, 253, 43);
		courseList.setVisible(false);
		contentPane.add(courseList);

	}



	/**
	 * Write Student Information to file.
	 * @param students
	 * @return boolean
	 */
	public boolean writeStudentInfo(){
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

	/**
	 * when the student info saved, all textfield is clear and disappearing error msg.
	 */
	public void clear() {
		studentIdField.setText("");;
		fNameField.setText("");
		lNameField.setText("");
		courseField.setText("");
		courseList.setText("");

		if(e1.isVisible()) {
			e1.setVisible(false);
		}

		if(e2.isVisible()) {
			e2.setVisible(false);
		}

		student = new Student();
	}


	private class CourseHandler implements ActionListener{
	      // handle button event
	      @Override
	      public void actionPerformed(ActionEvent event)
	      {
				try {
					String course = courseField.getText();
					student.setCourses(course);
					if(!student.getCourses().isEmpty()) {
						courseList.setText(student.getCourses().toString());
						courseList.setVisible(true);
					}
					courseField.setText("");
					if(e2.isVisible()) {
						e2.setVisible(false);
					}

				}catch (Throwable error) {
					e2.setVisible(true);
				}
	      }
	   }

	   private class SaveHandler implements ActionListener
	   {
	      // handle button event
	      @Override
	      public void actionPerformed(ActionEvent event)
	      {
	  		String stdId = studentIdField.getText();
			try{
				stdIdNum = Integer.parseInt(stdId);
				if(e1.isVisible()) {
					e1.setVisible(false);
				}

				student.setStdID(stdId);
				student.setFirstName(fNameField.getText());
				student.setLastName(lNameField.getText());
				students.add(student);
				clear();
			}catch(Throwable error) {
				e1.setVisible(true);
			}
	      }
	   }

	   private class SubmitHandler implements ActionListener
	   {
	      // handle button event
	      @Override
	      public void actionPerformed(ActionEvent event)
	      {
			try{
				boolean result = writeStudentInfo();
				if(!result) {
					System.out.println("failed");
				}

				 System.exit(0);
			}catch(Throwable error) {
				e1.setVisible(true);
			}
	      }
	   }


}
