package telran.linkedList.impl;

import java.util.Iterator;

import telran.linkedList.interfaces.IList;

public class MyLinkedList<T> implements IList<T> {

	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	private static class Node<T>         //нода, описывемая в иннер-классе
	{
		T data;                           //нода содержит внутри себя обьект 
		Node<T> prev;                     //ссылку на предыдущую ноду
		Node<T> next;                     //ссылку на следующую ноду
		
		public Node(T data, Node<T> prev, Node<T> next) {           //конструктор ноды
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
		
		
	}

	@Override
	public Iterator<T> iterator() {              //итератор
		
		return new Iterator<T>() {
			Node<T> position = head;             //

			@Override
			public boolean hasNext() {
				
				return position!=null;
			}

			@Override
			public T next() {
				T element=position.data;
				position = position.next;
				return element;
			}
		};
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int indexOf(T t) {
		int index=0;                      //явно задаем индекс
		if(t==null)                       //в линкед листах могут быть null , то:
		{
			for(Node<T> x = head; x!=null;x=x.next)        
			{
				if(x.data==null) return index;
				index++;
			}
		}
		else
		{
			for(Node<T> x = head; x!=null;x=x.next)
			{
				if(x.data.equals(t)) return index;
				index++;
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(T t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T set(int index, T t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(T t) {
		Node<T> newNode = new Node<T>(t, tail, null);
		if(head==null) head=newNode;             //если первый элемент в листе
		else tail.next=newNode;                  //иначе делаем последнюю ноду предпоследней
		tail=newNode;                            //говорим линкед листу что последний tail
		size++;                                  //увеличиваю size
		return true;
	}

	@Override
	public boolean add(int index, T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(T t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
}
