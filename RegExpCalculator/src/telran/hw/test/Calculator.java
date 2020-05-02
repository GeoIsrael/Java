package telran.hw.test;

public class Calculator {
	/**
	 * computes an arithmetic expression
	 * @param expression
	 * @return result or null if expression is wrong
	 */
	public static Object computeExpressions(String string) {
		
		String s = (string.trim()).replaceAll("\\s*", "") ;  
		String[] operands = s.split("[+]|-|[*]|/");   //array of operands 		
		String[] operators = s.split("\\d+");         //array of operators


        String testofsym = s.replaceAll("[a-zA-Z&!@#$%&=]", "");  
        if ((!s.equals(testofsym))||(operands.length != (operators.length))) return null;
	
		int result = Integer.parseInt(operands[0]);
		int next = 0;
		String oper = "";
		
		for (int i = 1; i < operands.length; i++)
		{
	         next = Integer.parseInt(operands[i]);
	         oper = operators[i];
	         
	         switch (oper) {
		    	case "+": 
			    	result += next;
			    	break;
			    case "-": 
				    result -= next;
				    break;
				
		    	case "*": 
			    	result *= next;
				    break;
				
			    case "/": 
				    result /= next;
				    break;
				
			    default:
				    break;
			    }
		}
		System.out.println(result);
		
		return  result;
	}
}
