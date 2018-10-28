package com.gmail.kirillmarch6;

public class Main {

	public static void main(String[] args) {
		
		Stack myStack = new Stack(5);
		
		//добавление элементов в стек
		myStack.addObject("text");
		myStack.addObject(25);
		myStack.addObject("string");
		
		//получение элемента из стека
		System.out.println("В вершине стека находится такой объект - " + myStack.getObject());
		
		//удаление элемента из стека
		System.out.println("Будет удален следующий объект - " + myStack.deleteObject());
		
		System.out.println("В вершине стека находится такой объект - " + myStack.getObject());
		

	}

}
