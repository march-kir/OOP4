package com.gmail.kirillmarch6;

public class Main {

	public static void main(String[] args) {
		
		Stack myStack = new Stack(5);
		
		//���������� ��������� � ����
		myStack.addObject("text");
		myStack.addObject(25);
		myStack.addObject("string");
		
		//��������� �������� �� �����
		System.out.println("� ������� ����� ��������� ����� ������ - " + myStack.getObject());
		
		//�������� �������� �� �����
		System.out.println("����� ������ ��������� ������ - " + myStack.deleteObject());
		
		System.out.println("� ������� ����� ��������� ����� ������ - " + myStack.getObject());
		

	}

}
