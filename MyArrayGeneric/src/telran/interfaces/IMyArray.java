package telran.interfaces;

import telran.impl.MyArray;

public interface IMyArray<E>  extends Iterable<E>{
	boolean add(E obj);
	boolean add(int index, E obj);
	Object get(int index);
	int size();
	int indexOf(Object obj);
	int lastIndexOf(Object obj);
	boolean contains(Object obj);
	boolean remove(E obj);
	Object[] toArray();
	public Object remove(int index);
	boolean removeAll(MyArray<E> other);
	boolean retainAll(MyArray<E> other);
	E set(int index, E obj);
	public void clear();
	
	
}
