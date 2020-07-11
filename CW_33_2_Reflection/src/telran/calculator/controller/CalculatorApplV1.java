package telran.calculator.controller;

public class CalculatorApplV1 {

	public static void main(String[] args) {
		if (args.length < 3) {                             //если меньше 3 аргументов
			System.out.println("Wrong numbers of arguments");  //то выход
			return;              
		}
		try {
			double operand1 = Double.parseDouble(args[0]);  //парсим операнды
			double operand2 = Double.parseDouble(args[1]);  
			double res = calculate(operand1, operand2, args[2]);     //отправляем все в вычисление в метод calculate()
			System.out.println("Result = " + res);      //печатаем результат
		} catch (NumberFormatException e) {
			System.out.println("Wrong number format");       //обработка исключений
		} catch (Exception e) {
			System.out.println("Wrong operation");
		}

	}

	private static double calculate(double operand1, double operand2, String oper) throws Exception {
		switch (oper) {                      //метод вычисления
		case "Add": 
			return operand1 + operand2;
		case "Sub":
			return operand1 - operand2;
		case "Mul":
			return operand1 * operand2;
		case "Div":
			return operand1 / operand2;
		default:
			throw new Exception();
		}
	}

}
