package telran.inheritance.model;

import java.io.Serializable;

public class Parent{
	private int parentField;

	public Parent(String fignya) {
		parentField = 1;
		System.out.println("Parent consructor");
	}

	public int getParentField() {
		return parentField;
	}

	public void setParentField(int parentField) {
		this.parentField = parentField;
	}
	

}
