package telran.calculator.utils;

import telran.calculator.model.IOperation;

public class Calculator {
	private static final String PACKAGE = "telran.calculator.model.";  //поле ссылки на package
	
	public static double calculate(double a, double b, String oper) {   
		try {
			Class<?> clazz = Class.forName(PACKAGE + oper);     //получаю объект рефлексии, связанный с операцией (PACKAGE+oper)
			//если есть объект рефлексии, можно вместо конструктора создавать Instance
			IOperation operation = (IOperation) clazz.newInstance();  //здесь устанавливаетя интерфейс, а у интерфейса есть action
			return operation.action(a, b);     //метод action выполняется у реального объекта в Heap
		} catch (Exception e) {       //прием - ловлю checked Exception
			throw new RuntimeException();   //а пробрасываю unchecked Exception 
		}
		
	}

}

//лучше добавить новый класс, чем лезть в работающий код и менять IF или Swich CASE
//одно из решений - рефлексия



