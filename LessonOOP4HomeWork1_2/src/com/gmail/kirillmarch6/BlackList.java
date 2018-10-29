package com.gmail.kirillmarch6;

import java.util.ArrayList;
import java.util.Collection;

public class BlackList {

	Collection blackList = new ArrayList();

	public BlackList(Collection blackList) {
		super();
		this.blackList = blackList;
	}

	public BlackList() {
		super();
	}

	public Collection getBlackList() {
		return blackList;
	}

	public void setBlackList(Collection blackList) {
		this.blackList = blackList;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((blackList == null) ? 0 : blackList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BlackList other = (BlackList) obj;
		if (blackList == null) {
			if (other.blackList != null)
				return false;
		} else if (!blackList.equals(other.blackList))
			return false;
		return true;
	}

	public Collection addToBlackList(Class clazz) {
		blackList.add(clazz);
		System.out.println("� ������ ������ �������� ����� - " + clazz);
		return blackList;
	}

	public void deleteToBlackList(Class clazz) {
		blackList.remove(clazz);
		System.out.println("�� ������� ������ ������ ����� - " + clazz);
	}

	public boolean findInBlackList(Class clazz) {
		for (Object o : blackList) {
			if (o.equals(clazz)) {
				System.out.println("����� " + o + " ��������� � ������ ������");
				return true;
			}
		}
		return false;
	}

	public Collection infoBlackList() {
		System.out.println("============= � ������ ������ ����� ������: ");	
		for (Object o : blackList) {
			System.out.println("�������: " + o);
		}
		return blackList;
	}

}
