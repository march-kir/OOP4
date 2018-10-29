package com.gmail.kirillmarch6;

import java.util.Collection;

public class Main {

	public static void main(String[] args) {
		
		Stack myStack = new Stack(5);
		BlackList bl = new BlackList();
		
		//Добавление в черный список классов	
		bl.addToBlackList(Double.class);
		bl.addToBlackList("some text".getClass());
		
		//получение элементов черного списка
		Collection col;
		System.out.println();	
		col = bl.infoBlackList();
		
		//проверка принадлежности Черному Списку
		System.out.println();
		bl.findInBlackList("text".getClass());
		
		//удаление из Черного Списка
		System.out.println();
		bl.deleteToBlackList("text".getClass());
		System.out.println();
		col = bl.infoBlackList();
		
		//добавление элементов в стек
		System.out.println();
		myStack.addObject("text", bl);
		myStack.addObject(25, bl);
		myStack.addObject("string", bl);
		myStack.addObject(22.3, bl);
		
		//получение элемента из стека
		System.out.println();
		System.out.println("В вершине стека находится такой объект - " + myStack.getObject());
		
		//удаление элемента из стека
		System.out.println();
		System.out.println("Будет удален следующий объект - " + myStack.deleteObject());
		
		System.out.println();
		System.out.println("В вершине стека находится такой объект - " + myStack.getObject());
		

	}

}
