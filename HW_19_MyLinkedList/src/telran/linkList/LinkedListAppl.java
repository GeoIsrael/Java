package telran.linkList;

import java.util.Arrays;
import java.util.LinkedList;

import telran.list.MyLinkedList;

public class LinkedListAppl {

	public static void main(String[] args) {
		LinkedList<String> strings = new LinkedList<>();
		strings.addFirst("Beer");
		String[] strs = {"Mama","mila","ramu"};
		strings.addAll(Arrays.asList(strs));
		display(strings);
		//=================HWTest=============================s
		MyLinkedList<String> myStrings = new MyLinkedList<>();
		myStrings.add("Java");		
		myStrings.add("HTML");				
		myStrings.add("CSS");				
		myStrings.add("Javascript");				
		myStrings.add("Angular");				
		myStrings.add("Spring");				
				
		display(myStrings);
		myStrings.add(2, "No name");
		display(myStrings);
		System.out.println(myStrings.indexOf("No name"));
		System.out.println(myStrings.lastIndexOf("No name"));
		myStrings.remove("No name");
		display(myStrings);
		myStrings.remove(myStrings.size()-1);
		display(myStrings);
		String old = myStrings.set(0, "Java8");
		display(myStrings);
		System.out.println(old);
		myStrings.clear();
		System.out.println(myStrings.isEmpty());
		display(myStrings);
	}
	public static void display(LinkedList<String> ll)
	{
		for(String s: ll)
		{
			System.out.print(s+" ");
		}
		System.out.println("\n============================\n");
	}
	
	public static void display(MyLinkedList<String> mll)
	{
		for(String s: mll)
		{
			System.out.print(s+" ");
		}
		System.out.println("\n=============================\n");
	}

}

