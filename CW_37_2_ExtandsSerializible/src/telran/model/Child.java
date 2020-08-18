package telran.model;

import java.io.Serializable;

public class Child extends Parent implements Serializable{

	private int childField;

	public Child(int childField) {
		this.childField = childField;
		System.out.println("Child constructor");
	}

	public int getChildField() {
		return childField;
	}

	public void setChildField(int childField) {
		this.childField = childField;
	}
	
	
	
	
	
}
