package telran.reflection.controller;

import telran.reflection.model.Foo;

public class FooAppl {

	public static void main(String[] args) {
//		if (args.length != 2) {                                  //проверка аргументов
//			System.out.println("Wrong number of arguments");
//			return;
//		}
		
		Foo foo = new Foo();                                     //создаем объект foo
		foo.caller("f1private", "Chao");                         //вызов функции
//		foo.caller("f1", "Chao");                                //вызов функции

	}

}
