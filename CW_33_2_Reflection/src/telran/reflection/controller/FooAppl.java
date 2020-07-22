package telran.reflection.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import telran.reflection.model.Foo;

public class FooAppl {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
		System.out.println("start");
		if (args.length != 2) {                                  //проверка аргументов
			System.out.println("Wrong number of arguments");
			return;
		}
		
		Foo foo = new Foo();                                     //создаем объект foo
		foo.f1("HHH");
		foo.caller("f1private", "Chao");                         //вызов функции статическим методом
//		foo.caller("f1", "Chao");                                //вызов функции
		Method method = foo.getClass().getDeclaredMethod(args[0], String.class);
//		Method method2 = foo.getClass.getDeclaredMethod(args[0], String.class);       //второй способ создания 
		method.setAccessible(true);     //делаем private метод видимым из вне
		method.invoke(foo, args[1]);    //выполняем метд у объекта рефлексии
		displayInfo(foo);                         //просмотр методов и контрактов. есть то же самое по полям   h
//		System.out.println();
//
//		System.out.println(Foo.class.getName());
//		System.out.println(Foo.class.getSimpleName());
//		System.out.println(Foo.class.getCanonicalName());
//		System.out.println();
//
//		System.out.println(int.class.getName());
//		System.out.println(int.class.getSimpleName());
//		System.out.println(int.class.getCanonicalName());
//		System.out.println();
//
	}

	private static void displayInfo(Object obj) throws ClassNotFoundException {
		Class<?> clazz = obj.getClass();
		System.out.println("Protocol");
		Method[] protocol = clazz.getMethods();         //protocol это все public методы класса включая унаследованные
		Arrays.stream(protocol)
			.forEach(m -> System.out.println(m.getName()));
		System.out.println("Contract");                 //contract  дает только методы данного класса, но включая приватные
		Method[] contract = clazz.getDeclaredMethods();
		Arrays.stream(contract)
			.forEach(m -> System.out.println(m.getName()));
		

//		Class<?> clazz1 = Class.forName("telran.reflection.model.Foo");
//		Method method = clazz1.getClass().getDeclaredMethod(args[0], String.class);
//		method.setAccessible(true);    
//		method.invoke(foo, args[1]);
//		
//		
		
	}
	
	
}
