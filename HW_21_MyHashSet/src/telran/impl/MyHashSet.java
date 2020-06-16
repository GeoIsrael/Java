package telran.impl;

import java.util.Iterator;
import java.util.LinkedList;

import telran.interfaces.ISet;

public class MyHashSet<E> implements ISet<E> {
	private LinkedList<E>[] hashset;
	int size;
	int capacity;
	double loadFactor;
	
	@SuppressWarnings("unchecked")
	public MyHashSet(int capacity, double loadFactor) {
		this.capacity = capacity;
		this.loadFactor = loadFactor;
		hashset=new LinkedList[capacity];
	}

	public MyHashSet(int capacity) {
		this(capacity, 0.75);
	}
	
	public MyHashSet() {
		this(16,0.75);
	}

	@Override
	public Iterator<E> iterator() {
		
		return new HashSetIterator<>(hashset,size);
	}

	@Override
	public boolean add(E data) {
		if(size>=capacity*loadFactor)
			rebuildHashSet();
		int index = getIndex(data);
		if(hashset[index]==null)
			hashset[index] = new LinkedList<>();
		else if(hashset[index].contains(data))
			return false;
		hashset[index].add(data);
		size++;
		return true;
	}

	private int getIndex(E data) {
		if(data == null) return 0;                     //проверка data == 0 
		int hashcode = data.hashCode();
		hashcode=hashcode>=0?hashcode:-hashcode;
		return hashcode % capacity;
	}

	private void rebuildHashSet() {
	capacity*=2;
	@SuppressWarnings("unchecked")
	LinkedList<E>[] newHashset = new LinkedList[capacity];
	for(int i=0;i<hashset.length;i++)
	{
		if(hashset[i]!=null)
		{
			for(E data:hashset[i]) {
				int index = getIndex(data);
				if(newHashset[index]==null)
					newHashset[index] = new LinkedList<>();
				newHashset[index].add(data);
			}
		}
		
	}
	hashset=newHashset;
		
	}

	@Override
	public boolean contains(E data) {           //реализация поиска
		int index = getIndex(data);              //получаем индекс
		if(hashset[index] == null){              //есть ли индекс равен нулю
			return false;                       //возвращаем false
		}
				 
		return hashset[index].contains(data);       //делаем в LinkedList поиск  по элементу
	}

	@Override
	public boolean remove(E data) {              //реализаия удаления элемента
		int index = getIndex(data);
		if(hashset[index] == null) {
			return false;
		}
		boolean res =hashset[index].remove(data);       //удаляем элемент с LinkedList
		if(res) {                                
			size--;                                    //уменьшаем size
		}
		return res;
	}

	@Override
	public int size() {
		
		return size;
	}
	
	private static class HashSetIterator<E> implements Iterator<E>
	{
		int size;
		LinkedList<E>[] hashset;
		int counterArray;
		int counterList;
		int totalCounter;
		
		public HashSetIterator(LinkedList<E>[] hashset, int size) {			
			this.size = size;
			this.hashset = hashset;
		}

		@Override
		public boolean hasNext() {
			
			return totalCounter<size;
		}

		@Override
		public E next() {
			while(hashset[counterArray]==null || hashset[counterArray].size()==0)
				counterArray++;
			E data = hashset[counterArray].get(counterList);
			totalCounter++;
			if(counterList<hashset[counterArray].size()-1)
			{
				counterList++;
			}
			else
			{
				counterArray++;
				counterList=0;
			}
			return data;
		}
		
		
	}
	
	
	
}
