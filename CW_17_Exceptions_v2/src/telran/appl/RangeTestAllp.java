package telran.appl;

import telran.exceptions.NumberGreaterMaxException;
import telran.exceptions.NumberLessMinException;
import telran.impl.Range;

public class RangeTestAllp {
	
	private static final int MIN_RANGE = 100;
	private static final int MAX_RANGE = 1000;           
	private static final int N_NUMBERS = 20_000;           
	private static final int MIN_NUMBER = 20;
	private static final int MAX_NUMBER = 1500;
	
	public static void main(String[] args) {
		int countRight = 0, countLess = 0, countGreater = 0;
		Range range = new Range(MIN_RANGE, MAX_RANGE);
		
		int number;                                            //переменная создается за циклом, чтобы каждый раз ее не создавать
		for (int i = 0; i < N_NUMBERS; i++) {
			number = getRandomNumber(MIN_NUMBER,MAX_NUMBER);   //создаем случайное значение в диапазоне

			try {
				range.checkNumber(number);                         //проверяем на попадание числа в range
				countRight ++;
			
			} catch (NumberGreaterMaxException e) {
				countGreater ++;
			    
				
			} catch (NumberLessMinException e) {
				countLess ++;
			}
			
        }
		System.out.printf("countRight = %d,  countless = %d,  countGreater = %d",      //вывод
				countRight, countLess, countGreater);
		
	}

	private static int getRandomNumber(int minNumber, int maxNumber) {
		
		return (int) (minNumber + Math.random()*(maxNumber - minNumber + 1));      //генератор чисел в указанном диапазоне
									                                               //+1 нужен чтобы maxNumber входил в диапазон
	}
	
}
