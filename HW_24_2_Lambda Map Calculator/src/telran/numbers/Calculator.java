package telran.numbers;
import java.util.*;
import java.util.function.BinaryOperator;

//
public class Calculator {
	private static Map<String,BinaryOperator<Integer>> map=new HashMap<>();    //мэпа с байнари оператором
	static {                     //статик блоки нужны чтобы инициализировать статические переменные   
	map.put("+", (a,b)->a+b);    //инициализаия статического поля при помощи статического блока
	map.put("-", (a,b)->a-b);
	map.put("*", (a,b)->a*b);
	map.put("/", (a,b)->a/b);
	}
	public static int multiply(int op1, int op2) {          //
		return op1*op2;
	}

	public static Integer divide(int op1, int op2) {
		if(op2==0)
			return null;
		return op1/op2;
	}

	public static int add(int op1, int op2) {
		
		return op1+op2;
	}

	public static int subtract(int op1, int op2) {
		return op1-op2;
	}

	public static Integer computeExpression(String expression) {
		if(!isArithmeticExpression(expression))
			return null;
		String[] operands=getOperands(expression);
		String[] operations=getOperations(expression);
		for(String str:operands)System.out.println(str);
		for(String str:operations)System.out.println(str);
		int res=Integer.parseInt(operands[0]);
		for(int i=1;i<operands.length;i++){
			res=computeOne(res,Integer.parseInt(operands[i]),operations[i]);
		}
		return res;
	}

		private static boolean isArithmeticExpression(String expression) {
		String regex = "\\s*\\d+(\\s*[*/\\-+]\\s*\\d+)*\\s*";
		return expression.matches(regex);
	}

	public static String[] getOperations(String expression) {
		
		return expression.split("[ \\d]+");
	}

	public static String[] getOperands(String expression) {
		
		return expression.trim().split("\\D+");
	}

private static Integer computeOne(int op1, int op2,
		String operation) {
//	switch(operation) {
//	case "+": return op1+op2;
//	case "*": return op1*op2;
//	case "-": return op1-op2;
//	case "/": return op2==0?null:op1/op2;
//	default: return null;
//	}
	return map.get(operation).apply(op1, op2);    //добавляется метод с Apply для Binary operator
	
	//остальной код не меняется
}

}
