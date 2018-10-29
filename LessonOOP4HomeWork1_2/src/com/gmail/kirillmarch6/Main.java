package com.gmail.kirillmarch6;

import java.util.Collection;

public class Main {

	public static void main(String[] args) {
		
		Stack myStack = new Stack(5);
		BlackList bl = new BlackList();
		
		//���������� � ������ ������ �������	
		bl.addToBlackList(Double.class);
		bl.addToBlackList("some text".getClass());
		
		//��������� ��������� ������� ������
		Collection col;
		System.out.println();	
		col = bl.infoBlackList();
		
		//�������� �������������� ������� ������
		System.out.println();
		bl.findInBlackList("text".getClass());
		
		//�������� �� ������� ������
		System.out.println();
		bl.deleteToBlackList("text".getClass());
		System.out.println();
		col = bl.infoBlackList();
		
		//���������� ��������� � ����
		System.out.println();
		myStack.addObject("text", bl);
		myStack.addObject(25, bl);
		myStack.addObject("string", bl);
		myStack.addObject(22.3, bl);
		
		//��������� �������� �� �����
		System.out.println();
		System.out.println("� ������� ����� ��������� ����� ������ - " + myStack.getObject());
		
		//�������� �������� �� �����
		System.out.println();
		System.out.println("����� ������ ��������� ������ - " + myStack.deleteObject());
		
		System.out.println();
		System.out.println("� ������� ����� ��������� ����� ������ - " + myStack.getObject());
		

	}

}
