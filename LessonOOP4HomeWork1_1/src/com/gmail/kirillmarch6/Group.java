package com.gmail.kirillmarch6;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Group implements Voenkom, Serializable {

	private Student[] group = new Student[10];

	public Group(Student[] group) {
		super();
		this.group = group;
	}

	public Group() {
		super();
	}

	public Student[] getGroup() {
		return group;
	}

	public void setGroup(Student[] group) {
		this.group = group;
	}

	public void addStudent(Student student) {// ���������� ��������
		for (int i = 0; i < group.length; i++) {
			try {
				if (group[i] == null) {
					group[i] = student;
					System.out.println("�������� ������� " + student.getInformation());
					break;
				}
				if (i == group.length - 1) {
					throw new QuantityOverflowException();
				}
			} catch (QuantityOverflowException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void interactiveAddingStudent() {// ������������� ���� �������� � ���������� � ���������� ��� � ������
		Student s = new Student();
		try {
			s.setSurname(interactiveAddingStudentSurname());
			s.setName(interactiveAddingStudentName());
			s.setPatronymic(interactiveAddingStudentPatronimic());
			s.setAge(Integer.valueOf(JOptionPane.showInputDialog("������� �������")));
			s.setSex(Sex.valueOf(interactiveAddingStudentSex()));
			s.setStudentID(Integer.valueOf(JOptionPane.showInputDialog("������� ����� ������������� ������")));
			s.setNumberRecordBook(Integer.valueOf(JOptionPane.showInputDialog("������� ����� �������� ������")));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "������ ���� �����!");
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "������ �� ���� ������� ��� ������ ������!");
		}
		if (s.getSurname() != null) {
			addStudent(s);
		}
	}

	public String interactiveAddingStudentSurname() {
		String surname = "";
		surname = JOptionPane.showInputDialog("������� �������");
		if (surname.equals("")) {
			throw new NullPointerException();
		} else {
			return surname;
		}
	}

	public String interactiveAddingStudentName() {
		String name = "";
		name = JOptionPane.showInputDialog("������� ���");
		if (name.equals("")) {
			throw new NullPointerException();
		} else {
			return name;
		}
	}

	public String interactiveAddingStudentPatronimic() {
		String patronymic = "";
		patronymic = JOptionPane.showInputDialog("������� ��������");
		if (patronymic.equals("")) {
			throw new NullPointerException();
		} else {
			return patronymic;
		}
	}

	public String interactiveAddingStudentSex() {
		String sex = "";
		sex = String.valueOf(JOptionPane.showInputDialog("������� ��� (man/woman)"));
		try {
			if (sex.equals("man") || sex.equals("woman")) {
				return sex;
			} else {
				throw new NoSexExcaption();
			}
		} catch (NoSexExcaption e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}
	}

	public void deleteStudent(Student student) {// �������� �������� �� ������
		for (int i = 0; i < group.length; i++) {
			if (group[i] != null) {
				if (group[i].equals(student)) {
					group[i] = null;
					System.out.println("������ ������� " + student.getInformation());
					sortStudentAfterDelStudent();
					break;
				}
				if (i == group.length - 1) {
					System.out.println("������� ������� �������� ��������. � ������ ��� ������ ��������!");
				}
			}
		}
	}

	public void sortStudentAfterDelStudent() { // ������������ null � ������� ����� �������� � ����� �����
		for (int i = 0; i < group.length - 1; i++) {
			if (group[i] == null && group[i + 1] != null) {
				group[i] = group[i + 1];
				group[i + 1] = null;
			}
		}
	}

	public Student[] arrWithoutNull(Student[] arr) { // ��������������� ����� ������� ������ ������ ��� null � �����,
														// ���� ��� ����
		int number = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == null) {
				break;
			}
			number++;
		}
		Student[] sortList = new Student[number];
		System.arraycopy(arr, 0, sortList, 0, number);
		return sortList;
	}

	public Student searchStudent(String findStudnent) {// ����� �������� �� �������
		Student searchStudent = null;
		for (int i = 0; i < group.length; i++) {
			if (findStudnent.equals(group[i].getSurname())) {
				searchStudent = group[i];
				break;
			}
		}
		return searchStudent;
	}

	public void getInformation() { // ����� ���������� � ��������
		for (int i = 0; i < group.length; i++) {
			if (group[i] != null) {
				System.out.println(group[i].getInformation());
			}
		}
	}

	public Student[] getStudnetsForVoenkom() {// �������� ������ 18-������ ������ �� ��������� �������
		int n = 0;
		for (int i = 0; i < group.length; i++) {
			if (group[i] != null) {
				if (group[i].getAge() == 18 && group[i].getSex() == Sex.man) {
					n++;
				}
			}
		}
		Student[] year18men = new Student[n];
		n = 0;
		for (int i = 0; i < group.length; i++) {
			if (group[i] != null) {
				if (group[i].getAge() == 18 && group[i].getSex() == Sex.man) {
					year18men[n] = group[i];
					n++;
				}
			}
		}
		return year18men;
	}

	public Student[] getInteractiveSortArray() { // ������������� ���������� � ����������
		Student[] sortArray = new Student[] {};
		sortArray = arrWithoutNull(group); // �������� ������ ��� null � �����
		boolean goodParametr = true;
		String parametr = "";
		try {
			parametr = JOptionPane.showInputDialog(
					"������� �������� ��������� ���������� (surname/name/patronymic/age/studentID/numberRecordBook)");
			if (parametr.equals("")) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "������ �� ���� ������� ��� ������ ������!");
			return null;
		}
		if (parametr.equals("surname") || parametr.equals("name") || parametr.equals("patronymic")) {
			getInteractiveSortArrayString(sortArray, parametr);
			goodParametr = false;
		}
		if (parametr.equals("age") || parametr.equals("studentID") || parametr.equals("numberRecordBook")) {
			getInteractiveSortArrayInt(sortArray, parametr);
			goodParametr = false;
		}
		if (goodParametr == false) {
			return sortArray;
		} else {
			System.out.println("�������� ��������!");
			return null;
		}
	}

	public Student[] getInteractiveSortArrayString(Student[] sortArray, String parametr) {
		Arrays.sort(sortArray, new Comparator<Student>() {
			public int compare(Student a, Student b) {
				if (parametr.equals("surname")) {
					return a.getSurname().compareToIgnoreCase(b.getSurname());
				} else if (parametr.equals("name")) {
					return a.getName().compareToIgnoreCase(b.getName());
				} else if (parametr.equals("patronymic")) {
					return a.getPatronymic().compareToIgnoreCase(b.getPatronymic());
				} else {
					return 0;
				}

			}
		});
		return sortArray;
	}

	public Student[] getInteractiveSortArrayInt(Student[] sortArray, String parametr) {
		Arrays.sort(sortArray, new Comparator<Student>() {
			public int compare(Student a, Student b) {
				if (parametr.equals("numberRecordBook") && a.getNumberRecordBook() < b.getNumberRecordBook()) {
					return 1;
				}
				if (parametr.equals("numberRecordBook") && a.getNumberRecordBook() > b.getNumberRecordBook()) {
					return -1;
				}
				if (parametr.equals("studentID") && a.getStudentID() < b.getStudentID()) {
					return 1;
				}
				if (parametr.equals("studentID") && a.getStudentID() > b.getStudentID()) {
					return -1;
				}
				if (parametr.equals("age") && a.getAge() < b.getAge()) {
					return 1;
				}
				if (parametr.equals("age") && a.getAge() > b.getAge()) {
					return -1;
				}
				return 0;
			}
		});
		return sortArray;
	}

	public String reportToCSV() { // ������������ ������ � �������
		String report = "";

		for (int i = 0; i < group.length; i++) {
			if (group[i] != null) {
				report += group[i].getSurname() + ";" + group[i].getName() + ";" + group[i].getPatronymic() + ";"
						+ group[i].getAge() + ";" + group[i].getSex() + ";" + group[i].getStudentID() + ";"
						+ group[i].getNumberRecordBook();
				report += System.lineSeparator();
			}
		}
		return report;
	}

	public void saveStringToFile(String text, File file) { // ������ � ����
		try (PrintWriter pw = new PrintWriter(file)) {
			pw.println(text);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void saveStringToFile(Group group) { // ������ � ����
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("group_students"))) {
			oos.writeObject(group);
		} catch (IOException e) {
			System.out.println("���������� ��������� ������ � ����!");
		}
	}

	public String loadStringFromFile(File file) { // �������� ������ � ������� �� �����
		String text = "";
		try (Scanner sc = new Scanner(file)) {
			for (; sc.hasNextLine();) {
				text += sc.nextLine();
				text += ";";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return text;
	}

	public Group getGroupFromFile(String[] arrayFromFile) { // �� ������ ������ �� ����� ������� ����� ������ ��
															// ����������
		Group groupFromFile = new Group();
		for (int i = 0; i < arrayFromFile.length; i = i + 7) {
			Student studentFromFile = new Student();
			studentFromFile.setSurname(arrayFromFile[i]);
			studentFromFile.setName(arrayFromFile[i + 1]);
			studentFromFile.setPatronymic(arrayFromFile[i + 2]);
			studentFromFile.setAge(Integer.valueOf(arrayFromFile[i + 3]));
			studentFromFile.setSex(Sex.valueOf(arrayFromFile[i + 4]));
			studentFromFile.setStudentID(Integer.valueOf(arrayFromFile[i + 5]));
			studentFromFile.setNumberRecordBook(Integer.valueOf(arrayFromFile[i + 6]));
			groupFromFile.addStudent(studentFromFile);
		}
		return groupFromFile;
	}

	public Group getGroupFromFile(Group groupFromFile) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("group_students"))) {
			groupFromFile = (Group) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("���������� ������� ������ �� �����!");
		}
		return groupFromFile;
	}

}
