package telran.iterators;

import java.util.Iterator;

import telran.impl.MyArray;

public class MyArrayIterator<E> implements Iterator<E> {

	private int i = 0;
	private MyArray<E> array;
	private int size;
	
	public MyArrayIterator(MyArray<E> array) {
		this.array = array;
		size = array.size();
	}
	
	
	@Override
	public boolean hasNext() {
		return i < size;
	}

	@Override
	public E next() {
		return (E)array.get(i++);
	}



}
