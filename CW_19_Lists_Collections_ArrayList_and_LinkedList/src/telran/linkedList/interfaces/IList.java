package telran.linkedList.interfaces;

public interface IList<T> extends Iterable<T> {
	int size();
	int indexOf(T t);
	int lastIndexOf(T t);
	T get(int index);
	T set(int index, T t);
	boolean add(T t);
	boolean add(int index, T t);
	boolean remove(T t);
	void clear();
	
	default boolean isEmpty()        //дефолтный метод ( состоит из методов интерфейса
	{
		return size()==0;
	}
	
	default boolean contains(T t)      
	{
		return indexOf(t)>=0;        
	}
}
