package telran.interfaces;

public interface IMyArray {
	
	boolean add(Object obj);                                 //add object
    boolean add(int index, Object obj);                      //add object by index
	Object get(int index);                                   //return object by index
	int size();                                              //return actual size array 
	int indexOf(Object obj);								 //return index of object
	int lastIndexOf(Object obj);							 //return last index of object
	boolean contains(Object obj);						     //return true if object contains in array
	boolean remove(Object obj);                              //remove object
	Object[] toArray();                                      //return actual array
	Object remove(int index);                                //remove object by index
	
//	boolean removeAll(MyArray<E> other);                     //remove elements by type

	
	
}
