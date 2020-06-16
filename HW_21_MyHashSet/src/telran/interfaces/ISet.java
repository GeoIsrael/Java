package telran.interfaces;

public interface ISet<E> extends Iterable<E> {
	boolean add(E data);
	boolean contains(E data);
	boolean remove(E data);
	int size();

}
