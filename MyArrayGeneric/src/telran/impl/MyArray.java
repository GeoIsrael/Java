package telran.impl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.Predicate;

import telran.interfaces.IMyArray;
import telran.iterators.MyArrayIterator;


	public class MyArray<E> implements IMyArray<E>{
		private static final int INITIAL_SIZE = 16;
		private Object[] array;
		private int size = 0;

		public MyArray() {
			// array = new Object[INITIAL_SIZE];
			this(INITIAL_SIZE);
		}

		public MyArray(int initialSize) {
			array = new Object[initialSize];
		}
		
		@Override
		public boolean add(E obj) {
			if (size == array.length)
				allocateArray();
			array[size++] = obj;
			return true;

		}

		private void allocateArray() {
			array = Arrays.copyOf(array, array.length * 2);

		}
		
		@Override
		public int size() {
			return size;
		}
		
		@Override
		@SuppressWarnings("unchecked")
		public E get(int index) {
			Object res = null;
			if (index >= 0 && index < size)
				res = array[index];
			return (E) res;
		}
		@Override
		public int indexOf(Object obj) {
			for (int i = 0; i < size; i++) {
				if (array[i].equals(obj))
					return i;
			}
			return -1;
		}
		@Override
		public int lastIndexOf(Object obj) {
			for (int i = size - 1; i >= 0; i--) {
				if (array[i].equals(obj))
					return i;
			}
			return -1;
		}
		@Override
		public boolean remove(Object obj) {
			int index = indexOf(obj);

			if (index >= 0) {
				System.arraycopy(array, index + 1, array, index, size - index - 1);
				size--;
				return true;
			}
			return false;
		}
		@Override
		public boolean contains(Object obj) {
			for (int i = 0; i < size; i++) {
				if (array[i].equals(obj))
					return true;
			}
			return false;
		}
		@Override
		public Object[] toArray() {
			Object[] temp = new Object[size];
			for (int i = 0; i < size; i++) {
				temp[i] = array[i];
			}
			return temp;
		}

		@Override
		public boolean add(int index, E obj) {
			if (index < 0 || index > size)
				return false;

			if (index == size)
				return add(obj);
			if (size == array.length) {
				allocateArray();
			}
			System.arraycopy(array, index, array, index + 1, size - index);

			array[index] = obj;
			size++;
			return true;
		}
		
		//=================================================================================
//		@Override
//		@SuppressWarnings("unchecked")
//		public E remove(int index) {
//			if (index < 0 || index >= size)
//				return null;
//			Object res = array[index];
//			if (index < size - 1) {
//				System.arraycopy(array, index + 1, array, index, size - index - 1);
//			}
//			size--;
//			return (E) res;
//		}
	
		
   //MyVersion==============================================================================
		@SuppressWarnings("unchecked")
		@Override
		public E remove(int index) {
			Object obj = null;
			if (index < 0 || index >= size) return null;
			obj = array[index];
			if (!remove(obj)) return null;
			return (E) obj;
		}
	//========================================================================================	
		
		
		
		
		
		//1 1 1 2 3 4 5 6 1 7
		//23 47 100 500 1234
		//1 1 1 2 3 4 5 6 1 7
		@Override
		public boolean removeAll(MyArray<E> other){
			if(other==null) return false;
			Object[] tmp=new Object[array.length];
			int index=0;
			int oldSize=size;
			for(int i=0;i<size;i++) {
				if(!other.contains(array[i]))
					tmp[index++]=array[i];
			}
			array=tmp;
			size=index;
			return size!=oldSize;
		}
		
	
		
	
		
		
		@Override
		public boolean retainAll(MyArray<E> other) {
			if(other==null) return false;
			Object[] tmp=new Object[array.length];
			int index=0;
			int oldSize=size;
			for(int i=0;i<size;i++) {
				if(other.contains(array[i]))
					tmp[index++]=array[i];
			}
			array=tmp;
			size=index;
			return size!=oldSize;
		} 

		@SuppressWarnings("unchecked")
		@Override
		public E set(int index, E obj) {
			if (index < 0 || index >= size)
				return null;
			Object rem = array[index];
			array[index]=obj;
			return (E)rem;
		}

		@Override
		public void clear() {
			for(int i=0;i<size;i++) array[i]=null;
			size=0;
			
		}

		@Override
		public Iterator<E> iterator() {
			return new MyArrayIterator<E>(this);
		}
		
		//=======================================
		
		@SuppressWarnings("unchecked")
		@Override
		public void sort(Comparator<E> comp) {
			boolean flSort;
			int n = size;
			do {
				n--;
				flSort = false;
				for (int i = 0; i < n; i++) {
					if(comp.compare((E)array[i], (E)array[i+1]) > 0) {
						swap(i, i+1);
						flSort = true;
					}
				}
				
				
			}while (flSort);
			
		}

		private void swap(int i, int j) {
			
			Object temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}

		
		//====================================
		
		@SuppressWarnings("unchecked")
		@Override
		public boolean removeIf(Predicate<E> predicate) {

			int count = 0;
			for (int i = 0; i < size; i++) {
				if (predicate.test((E) array[i])) {
					remove(array[i]);
					count++;
				}	
			}
			if (count > 0) return true;
			return false;
		}
		
//		private static int count(int[] ar, Predicate<Integer> predicate)   {   		
//
//			int count = 0;
//			for (int num:ar) {
//				if (predicate.test(num)) count++;
//			}
//			return count;
//		}
//		
		
//		private static int[] getNumbers(int[] ar, Predicate<Integer> predicate) {
//			int count = count(ar, predicate);
//			int[] res = new int[count];
//			if (count > 0) {
//				int iRes = 0;
//				for (int num : ar) {
//					if (predicate.test(num)) res[iRes++] = num;		
//				}
//			}
//			return res;
//		}
		
		
		
		
		
}
