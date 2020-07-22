package telran.daemonthread.tasks;

import java.time.LocalTime;

public class Timer implements Runnable {       //имплементирует Runnable (поток)
	int clockPeriod = 1;

	public int getClockPeriod() {
		return clockPeriod;                      //получает период
	}

	public void setClockPeriod(int clockPeriod) {            //конструктор
		this.clockPeriod = clockPeriod;
	}

	@Override
	public void run() {                    
		while (true) {
			System.out.println(LocalTime.now());                 //печатает текущее время
			try {
				Thread.sleep(clockPeriod * 1000);               //засыпает на свой период
			} catch (InterruptedException e) {
				System.out.println(Thread.interrupted());           //печатает разбужен ли поток
				System.out.println("into the catch block");         //пишет меня разбудили
				break;                          	//уходит в спячку
			}
		}

	}

}
