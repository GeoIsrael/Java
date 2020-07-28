package telran.inheritance.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import telran.inheritance.model.Child;

public class DeserializationTestAppl {

	public static void main(String[] args) {
		try(ObjectOutputStream out = 
				new ObjectOutputStream(new FileOutputStream("test"))) {
			System.out.println("Creating...");
			Child child = new Child(10);
			child.setParentField(100);
			System.out.println("Serializing...");
			out.writeObject(child);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try(ObjectInputStream in = 
				new ObjectInputStream(new FileInputStream("test"))) {
			System.out.println("Deserializing...");
			Child child = (Child) in.readObject();
			System.out.println("child.childField = " + child.getChildField());
			System.out.println("child.parentField = " + child.getParentField());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
