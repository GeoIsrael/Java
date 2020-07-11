package telran.reflection.model;

import java.lang.reflect.Method;

public class Foo {                                          //класс ни о чем
	public void f1(String str) {                      //public метод f1
		System.out.println("f1 " + str);
	}

	public void f2(String str) {                      //public
		System.out.println("f2 " + str);
	}

	private void f1private(String str) {              //private
		System.out.println("f1private " + str);
	}

	public void caller(String function, String arg) {      //public функция принимает два строковых аргумента - название функии и вызывал функцию с аргументом
//		Class<Foo> clazz = Foo.class;
		Class<?> clazz = this.getClass();         //у объекта получаем объект рефлексии(любого)
		try {
			Method method = clazz.getDeclaredMethod(function, String.class);    //объект класса Method = дай мне getDeclaredMethod у класса рефлексии
			method.invoke(this, arg);  //способ вызова метода класса рефлексии методом invoke (вызываем у объекта this с аргументом)
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
//Есть много классов рефлексии в Java в пакете Java.Util.Reflection		
		
		
//Забыть		
		
//		switch (function) {
//		case "f1":
//			f1(arg);
//			break;
//		case "f2":
//			f2(arg);
//			break;
//		case "f1private":
//			f1private(arg);
//			break;
//		default:
//			System.out.println(function + "doesn't exist");
//		}
	}
}
