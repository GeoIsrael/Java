package telran.throwtest;

//Оператор throw нужен чтобы создавать исключения
//в main лучше не пробрасывать исключения дальше, а обрабатывать их в catch
//
//
//


public class TestShow {

	public static void main(String[] args) {

		int count = 30;
		try {
			 addToBox(count);                //в обоих методах генерируютс исключения
		     procedure();                     //но try ловит только первый
		
		
		} catch (Exception e) {
			e.printStackTrace();                                   //выводит информацию system error
			System.out.println("\n*****************************");
			System.out.println("full");
			System.out.println("*****************************");

		}
		System.err.println("System ERROR information");           //выводит системные ошибки
		
		
		
		
	}

	private static void procedure() throws IllegalAccessException {
		System.out.println("inside procedure");
		throw new IllegalAccessException("Tel Ran");    //Исключение возникает, когда мы не можем обратиться к классу
		                                                //Запрещен доступ к классу
	}

	private static void addToBox(int count) throws Exception {

		if(count>30) throw new Exception("The number count must be less or equaal than 30");
	}

}
