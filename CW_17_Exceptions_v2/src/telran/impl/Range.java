package telran.impl;

import telran.exceptions.NumberGreaterMaxException;
import telran.exceptions.NumberLessMinException;

public class Range {

	private int min, max;

	public Range(int min, int max) {
		
		if (min > max) throw new RuntimeException("min>max");     //существующий в Java exception - проверка
		
		this.min = min;
		this.max = max;
		
	}
	
	
	//метод класса, в котором проверяется попадает ли число в диапазон
	public void checkNumber(int number) throws NumberLessMinException, NumberGreaterMaxException {
		if(number<min) 
			throw new NumberLessMinException(number + " number < min");
		if(number>max) 
			throw new NumberGreaterMaxException(number + " number > max");

	}
	
	
	
	
}
