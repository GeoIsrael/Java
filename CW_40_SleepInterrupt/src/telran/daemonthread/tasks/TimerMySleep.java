package telran.daemonthread.tasks;

import java.time.Instant;
import java.time.LocalTime;

public class TimerMySleep implements Runnable {    //таймер имплементирует Runnable
	int clockPeriod = 1;                           //период 1 сек

	public int getClockPeriod() {        
		return clockPeriod;
	}

	public void setClockPeriod(int clockPeriod) {
		this.clockPeriod = clockPeriod;
	}

	@Override
	public void run() {
		while (true) {
			System.out.println(LocalTime.now());              //печатает текущее время
			try {
				mySleep(clockPeriod * 1000);                  //Засыпает при помощи метода
			} catch (InterruptedException e) {
				System.out.println("into the catch block, " + e.getMessage());    //отправляет меня разбудили и эксцепшн
				break;                  //засыпает
			}
		}
	}

	private void mySleep(long period) throws InterruptedException{
		Instant currentTime = Instant.now();                    //запоминает текущее время в объект класса 
		Instant finish = currentTime.plusMillis(period);        //определяяем время пробуждения 
		while (currentTime.isBefore(finish)) {                 //пока не текущее время меньше время пробуждения
			currentTime = Instant.now();
			boolean flag = Thread.interrupted();               //читаем флаг interrupted (прерваный)
			if (flag) {                                         //если он поднят, то 
				System.out.println(flag);                       //печатаем его (false потому что сбрасывается во время Exception)
				throw new InterruptedException("Hello from mySleep");        //бросаем сключение "Привет"
			}
		}		
	}
}
