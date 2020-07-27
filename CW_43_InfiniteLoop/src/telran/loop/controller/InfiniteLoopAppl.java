package telran.loop.controller;

import telran.loop.model.InfiniteLoop;

public class InfiniteLoopAppl {

	public static void main(String[] args) throws InterruptedException {
		InfiniteLoop loop = new InfiniteLoop();    //создаем объект задачу
		Thread thread = new Thread(loop);    //создаем новый поток 
		thread.start();                    
		Thread.sleep(3000);
		loop.setFlag(false);
		System.out.println(loop.isFlag());

	}

}
