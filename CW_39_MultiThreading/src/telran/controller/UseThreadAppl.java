package telran.controller;
 
import telran.model.MyThreadExtends;
import telran.model.MyThreadImplements;

public class UseThreadAppl {

	private static final int MAX = 10;    //константа для создания циклов в классах потоков
	private static final int SIZE = 5;    //сколько будет потоков в массиве

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main thread start");          
		MyThreadImplements task1 = new MyThreadImplements("Thread implements", MAX);   //создаем задачу для потока1
		Thread thread1 = new Thread(task1);	    //создаем поток1 из задачи
		MyThreadExtends thread2 = new MyThreadExtends("Thread extends", MAX, thread1);  //создаем поток2
		MyThreadImplements[] tasks = new MyThreadImplements[SIZE];  //создаем массив задач
		for (int i = 0; i < tasks.length; i++) {          
			tasks[i] = new MyThreadImplements("Thread#" + i, MAX);    //в цикле наполняем массив задачами в цикле
		}
		Thread[] threads = new Thread[SIZE];               //в цикле делаем из массива задач массив потоков
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(tasks[i]);
		}
		for (int i = 0; i < threads.length; i++) {         //в цикле запускаем потоки из массива
			threads[i].start();
		}
		thread1.start();                                   //и еще два потока 
		thread2.start();
		System.out.println(thread1.isAlive());             //проверка живй ли поток
		for (int i = 0; i < MAX; i++) {                     //цикл для выполнения потока main
			System.out.println("In thread Main, count is " + i);    
			Thread.sleep(1);
		}
		thread1.join();                                      //ожидание пока закончится thread1
		thread2.join();
		for (int i = 0; i < threads.length; i++) {           //расстановка оиданий всех потоков в цикле
			threads[i].join();
		}
		System.out.println("Main thread finish");

	}

}