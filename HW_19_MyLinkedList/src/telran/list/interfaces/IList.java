package telran.list.interfaces;

public interface IList<E> extends Iterable<E> {

	int size();
	
	default boolean isEmpty()
	{
		return size()==0;
	}
	
	default boolean contains(E e)
	{
		return indexOf(e)>=0;
	}
	int indexOf(E e);
	int lastIndexOf(E e);
	E get(int index);
	E set(int index, E e);
	boolean add(E e);
	boolean add(int index, E e);
	E remove(int index);
	boolean remove(E e);
	void clear();
	
}
