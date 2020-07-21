package telran.daemonthread.tasks;

import java.time.Instant;
import java.time.LocalTime;

public class TimerMySleep implements Runnable {
	int clockPeriod = 1;

	public int getClockPeriod() {
		return clockPeriod;
	}

	public void setClockPeriod(int clockPeriod) {
		this.clockPeriod = clockPeriod;
	}

	@Override
	public void run() {
		while (true) {
			System.out.println(LocalTime.now());
			try {
				mySleep(clockPeriod * 1000);
			} catch (InterruptedException e) {
				System.out.println("into the catch block, " + e.getMessage());
				break;
			}
		}
	}

	private void mySleep(long period) throws InterruptedException{
		Instant currentTime = Instant.now();
		Instant finish = currentTime.plusMillis(period);
		while (currentTime.isBefore(finish)) {
			currentTime = Instant.now();
			boolean flag = Thread.interrupted();
			if (flag) {
				System.out.println(flag);
				throw new InterruptedException("Hello from mySleep");
			}
		}		
	}
}
