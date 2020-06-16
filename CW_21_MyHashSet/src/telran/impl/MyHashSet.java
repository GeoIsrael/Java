package telran.impl;

import java.util.Iterator;
import java.util.LinkedList;

import telran.interfaces.ISet;

public class MyHashSet<E> implements ISet<E> {
	private LinkedList<E>[] hashset;
	int size;
	int capacity;
	double loadFactor;
	
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
		
		return new HashSetIterator<>(hashset,size);   // конструктор итератора hashset
	}

	@Override
	public boolean add(E data) {
		if(size>=capacity*loadFactor)     //в случае заполненности хешсета
			rebuildHashSet();              //увеличиваем структуру
		int index = getIndex(data);            //вычисляем индекс элемента data в массиве
		if(hashset[index]==null)              //если в ячейке массива нет LinkedList
			hashset[index] = new LinkedList<>();      //создаем в ячейке новый LinkedList
		else if(hashset[index].contains(data))        //могу ли я добавить элемент в hashset?
			return false;                             //если он там присутствует, то добавить мы его не можем
		hashset[index].add(data);                    //если элемента нет, добавляем его в индекс
		size++;                                    //увеличиваем size
		return true;                     
	}

	private int getIndex(E data) {                   //метод возврата индекса 
		int hashcode = data.hashCode();              //вычисляем hashcode элемента
		hashcode=hashcode>=0?hashcode:-hashcode;     //возврат hashcode по модулю (исключение отрицательных значений)
		return hashcode % capacity;                //index = hashcode % capacity (индекс это остаток от деления)
	}

	private void rebuildHashSet() {
	capacity*=2;                                            //увеличиваем capacity
	LinkedList<E>[] newHashset = new LinkedList[capacity];   //создаем новый hashset 
	for(int i=0;i<hashset.length;i++)          //перенос элементов из старого hashset в новый 
	{
		if(hashset[i]!=null)                  //если в индексе есть LinkedList
		{
			for(E data:hashset[i]) {          //начинаем его итерировать
				int index = getIndex(data);    //и добавлять в новый массив
				if(newHashset[index]==null)
					newHashset[index] = new LinkedList<>();
				newHashset[index].add(data);
			}
		}
		
	}
	hashset=newHashset;       //в конце процедуры меняем ссылку основного hashset на новый
		
	}

	@Override
	public boolean contains(E data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(E data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		
		return size;
	}
	
	private static class HashSetIterator<E> implements Iterator<E>         //статический иннер-класс итератор
	{
		int size;                                           //приходит size
		LinkedList<E>[] hashset;                            //приходит hashset (массив LinkedLists
		int counterArray;                                   //счетчики продвижения по массиву
		int counterList;                                    //счетчик продвижения по LinkedList
		int totalCounter;                                   //общий счетчик элементов
		
		public HashSetIterator(LinkedList<E>[] hashset, int size) {			//конструктор класса
			this.size = size;
			this.hashset = hashset;
		}

		@Override
		public boolean hasNext() {               		
			return totalCounter<size;             //условие для итерирования
		}

		
//
		@Override
		public E next() {
			while(hashset[counterArray]==null || hashset[counterArray].size()==0)    //если внутри ячейки нет LinkedList мы оттуда ничего брать не будем 
				                                           //или когда размер ячейки = 0
				counterArray++;                            //переходим к следующей ячейке
			E data = hashset[counterArray].get(counterList);   //берем элемент
			totalCounter++;                                    //увеличиваем общий счетчик
			if(counterList<hashset[counterArray].size()-1)    //проверяем есть ли элементы еще в LinkedList
			{
				counterList++;                           //инкрементируем счетчик перехода внутри листа
			}
			else              //иначе:
			{
				counterArray++;                        //переходим в новую ячейку массива
				counterList=0;                         //обнуляем счетчик внутри листа
			}
			return data;                       //возвращаем текущий элемент hashSet
		}
		
		
	}
	
	
	
}
