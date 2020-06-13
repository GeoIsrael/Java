package telran.list;

import java.util.Iterator;

import telran.list.interfaces.IList;

public class MyLinkedList<E> implements IList<E> {
	private Node<E> head;
	private Node<E> tail;
	private int size;

	private static class Node<E> {
		E data;
		Node<E> prev;
		Node<E> next;

		public Node(E data, Node<E> prev, Node<E> next) {
			super();
			this.data = data;
			this.prev = prev;
			this.next = next;
		}

	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			Node<E> position = head;

			@Override
			public boolean hasNext() {

				return position != null;
			}

			@Override
			public E next() {
				E element = position.data;
				position = position.next;
				return element;
			}
		};
	}

	@Override
	public int size() {
		return size;
	}

	
	@Override
	public int indexOf(E e) {
		int index = 0;
		if(e==null){
			for(Node<E> x = head;x!=null;x=x.next)
			{
				if(x.data==null) return index;
				index++;
			}
		}
		else{
			for(Node<E> x = head;x!=null;x=x.next)
			{
				if(e.equals(x.data)) return index;
				index++;
			}
		}
		return -1;
	}
	
	private Node<E> getNodeByIndex(int index)
	{
		checkIndex(index);                        //проверяем индекс
		Node<E> node;
		if(index<=size/2)                        //если индекс в первой половине
		{
			node=head;
			for(int i = 0;i<index;i++)            //идем с начала
			{
				node = node.next;
			}
		}
		else
		{
			node = tail;
			for(int i = size-1;i>index;i--)            //если индекс во второй половине - идем с хвоста
			{
				node = node.prev;
			}
		
		}
		return node;
	}

	private void checkIndex(int index) {                     //проверяем индекс на корректность
		if(index<0||index>=size)
			throw new IndexOutOfBoundsException("Index " + index 
					+ " out of bounds");
		
	}

	@Override
	public int lastIndexOf(E e) {
		// TODO Auto-generated method stub
		int index = size-1;
		if (e == null) {
			for (Node<E> x = tail; x != null; x = x.prev) {
				
				if (x.data == null) {
					return index;
				}
				index--;
			}
		} else {
			for (Node<E> x = tail; x != null; x = x.prev) {
				if (e.equals(x.data)) {
					return index;
				}
				index--;
			}
		}
		return -1;
		
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		Node<E> node = getNodeByIndex(index);
		return node.data;
		
	}

	@Override
	public E set(int index, E e) {
		// TODO Auto-generated method stub
		Node<E> node = getNodeByIndex(index);
		E old = node.data;
		node.data = e;
		return old;
		
	}

	@Override
	public boolean add(E e) {
		Node<E> newNode = new Node<E>(e, tail, null);
		if (head == null)
			head = newNode;
		else
			tail.next = newNode;
		tail = newNode;
		size++;
		return true;
	}

	@Override
	public boolean add(int index, E e) 
	{
	
		if(index==size)                          //если индекс = size, просто добавляем в конец
		{
			return add(e);                       //существующим методом
		}
		if(index==0)                              //если индекс == 0
		{
			size++;                                   //увеличиваем size
			Node<E> newNode = new Node<E>(e, null, head);      //создаем новую ноду
			Node<E> node = head;                         //записываем в нее head
			head = newNode;                              //в head записываем новую ноду
			node.prev = head;                           //перелинковываем ссылку 
			return true;
		}
		Node<E> node = getNodeByIndex(index);             //сохраняю ноду, на место которой нужн сделать вставку.
		Node<E> newNode = new Node<E>(e, node.prev, node);  //создаю новую ноду
		node.prev = newNode;                              //перелинковка
		newNode.prev.next = newNode;
		size++;
		return true;
	}

	@Override
	public E remove(int index) {
		return unlink(getNodeByIndex(index));          //метод перелинковки
		
	}
	private E unlink(Node<E> x) {                     
		E element = x.data;        
		Node<E> prev = x.prev;
		Node<E> next = x.next;
		if(prev == null) {       //если начальная нода 
			head = next;         
			//head.prev = null;
		}else {
			prev.next = next;
			x.prev = null;
		}
		if(next == null) {       //если нода в конце
			tail = prev;
			//tail.next = null;
		}else {
			next.prev = prev;    
			x.next = null;
		}
		
		x.data = null;
		size--;
		
		return element;
		
	}

	@Override
	public boolean remove(E e) {
		// TODO Auto-generated method stub
		if(e == null) {
			for(Node<E> x = head; x != null; x = x.next) {
				if(x.data == null) {
					unlink(x);
					return true;
				}
			}
		}else {
			for(Node<E> x = head; x != null; x = x.next) {
				if(e.equals(x.data)) {
					unlink(x);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		Node<E> next;
		for (Node<E> x = head; x != null;x = next) {
			next = x.next;
			x.data = null;
			x.prev = null;
			x.next = null;
			
		}
		head = tail = null;
		size = 0;

	}

}
