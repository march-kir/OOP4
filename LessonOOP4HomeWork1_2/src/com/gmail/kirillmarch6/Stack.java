package com.gmail.kirillmarch6;

public class Stack {

	private int size;
	private Object[] stackArray;
	private int top;

	public Stack(int n) {
		super();
		this.size = n;
		this.stackArray = new Object[size];
		this.top = -1;
	}

	public Stack() {
		super();
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Object[] getStackArray() {
		return stackArray;
	}

	public void setStackArray(Object[] stackArray) {
		this.stackArray = stackArray;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public void addObject(Object obj) {
		if (isFull() == false) {
			top++;
			stackArray[top] = obj;
			System.out.println("В стек добавлен обьект - " + obj);
		} else {
			System.out.println("Стек полон! Добавление невозможно!");
		}

	}

	public Object deleteObject() {
		if (isEmpty() == true) {
			System.out.println("Стек пустой! Удаление невозможно!");
			return null;
		} else {
			return stackArray[top--];
		}

	}

	public Object getObject() {
		if (isEmpty() == true) {
			System.out.println("Стек пустой!");
			return null;
		} else {
			return stackArray[top];
		}
	}

	public boolean isEmpty() {
		if (top == -1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isFull() {
		if (top == size - 1) {
			return true;
		} else {
			return false;
		}
	}
}
