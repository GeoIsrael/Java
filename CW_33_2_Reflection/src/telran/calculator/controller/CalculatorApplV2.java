package telran.calculator.controller;

import telran.calculator.utils.Calculator;

public class CalculatorApplV2 {

	public static void main(String[] args) {
		if (args.length < 3) {
			System.out.println("Wrong numbers of arguments");
			return;
		}
		try {
			double operand1 = Double.parseDouble(args[0]);
			double operand2 = Double.parseDouble(args[1]);
			double res = Calculator.calculate(operand1, operand2, args[2]);   //вызов метода calculate класса Calculator
			System.out.println("Result = " + res);
		} catch (NumberFormatException e) {
			System.out.println("Wrong number format");
		} catch (Exception e) {
			System.out.println("Wrong operation");
		}
	}

}
