package telran.reflection.controller;

public class ReflectionAppl {

	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<String> clazzStr1 = String.class;   //по имени класса получаем объект рефлексии//Sting.class известна еще до запуска компиляции
		String str = "";                          
		Class<?> clazzStr2 = str.getClass();      //можно попросить объект рефлексии через метод getClass()//getClass  не возвращает точный дженерик, поэтому <?>
		Class<?> clazzStr3 = Class.forName("java.lang.String"); //третий способ получения ссылки на класс рефлексии
		System.out.println(clazzStr1 == clazzStr2); //можно проверить что они указывают на один и тот же объект
		System.out.println(clazzStr3 == clazzStr2);
		String str1 = (String) clazzStr3.newInstance(); //создаем объект рефлексии методом newInstance() (аналог дефолтного конструктора. если его в классе не будет, то newInstance сделать нельзя)
		//newInstance возвращает объект Object, поэтому нужно делать кастинг. если дефолтного конструктора нет, то newInstance не сработает
		Class<?> clazzInteger = Class.forName("java.lang.Integer");
		Class<?> clazzInt = int.class;   //можно получить рефлексию для примитивного типа  (объект рефлексии типа Int)
		
		//=================================
		
		
	}

}

//1) сущетвуют объекты, соответствующие каждому классу (тип Class)
//2) эти объекты находятся в Class Loader (часть JVM)
//3) Эти объекты имеют тип Class
//4) Эти объекты называются объектами рефлексии (reflection) (отражение)



//--наследоваться от String нельзя, потому что String это final Class (final Class это класс, от которого нельзя наследоваться)
//--String является Imutable потому что в нем находится массив Char
//--final поле делаем String Immytable
//--final Class говорит от том что от стринга нельзя наследоваться (extends)


//В итоге - ссылку на объект рефлексии можно получить
//1) по имени класса
//2) по методу getClass() в процессе рантайма
//3) Class.forName("java.lang.String");  метод forName (forName бросает Exception)
//Эти три ссылки указывают на один и тот же объект, соотвествующий String


//На лету в RunTime можно управлять созданием объектов








