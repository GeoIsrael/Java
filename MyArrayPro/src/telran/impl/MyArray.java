package telran.impl;

import java.util.Arrays;

import telran.interfaces.IMyArray;

public class MyArray implements IMyArray {

	private static final int INITIAL_SIZE = 16;             //capacity constant
	private Object[] array;                                 //internal implementation array
	private int size = 0;                                   
	
	
	public MyArray(int initialSize) {
		array = new Object[initialSize];
	}
	
	public MyArray() {
//		array = new Object[INITIAL_SIZE];     // same result
		this(INITIAL_SIZE);                   //same result
	}
	
	
	@Override
	public boolean add(Object obj) {
		if (size == array.length) 
			allocateArray();
		array[size++] = obj;
		return true;
	}

	private void allocateArray() {
		array = Arrays.copyOf(array, array.length * 2);
		
	}

	@Override
	public boolean add(int index, Object obj) {
		if (index < 0 || index > size) 
			return false; 
//		if (obj == null)
//			return false;
        if (index == size) 
        	return add(obj);
        if (size == array.length) 
        	allocateArray();
		
        System.arraycopy(array, index, array, index+1, size - index);
		
		array[index] = obj;
		size++;
		
		return true;
	}
	
	

	@Override
	public Object get(int index) {
		Object res = null;
		if (index >= 0 && index < size) {
			res = array[index];
		}
		return res;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public int indexOf(Object obj) {

		for (int i = 0; i < size; i++) {
			if (array[i].equals(obj)) return i;
		}
		return -1;
	}

	
	@Override
	public int lastIndexOf(Object obj) {
		for (int i = size - 1; i >= 0; i--) {
			if (array[i].equals(obj)) return i;
		}
		return -1;
	}

	@Override
	public boolean contains(Object obj) {
        for (int i = 0; i < size; i++) {
        	if (array[i].equals(obj)) return true;
        }
		return false;
	}

	@Override
	public boolean remove(Object obj) {
		int index = indexOf(obj);
		if (index < 0 || index >= size) return false;
		if (index < size -1) {
			System.arraycopy(array, index+1, array, index, size - index -1);
		}
		size --;
		return true;
	}

	@Override
	public Object[] toArray() {
		Object[] temp = new Object[size];	
		System.arraycopy(array, 0, temp, 0, size);
		return temp;
		
//		return Arrays.copyOf(array, size);
		
	}
	
	 
	@Override
	public Object remove(int index) {
		Object obj = null;
		if (index < 0 || index > size) return obj;
		obj = array[index];
		if (!remove(obj)) return null;
		return obj;
	}
	
	

	

}
