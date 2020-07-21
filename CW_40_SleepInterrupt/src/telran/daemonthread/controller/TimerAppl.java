package telran.daemonthread.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import telran.daemonthread.tasks.Timer;
import telran.daemonthread.tasks.TimerMySleep;

public class TimerAppl {

	public static void main(String[] args) throws IOException {
		Timer timer = new Timer();
		Thread thread = new Thread(timer);
		//thread.setDaemon(true);
		thread.start();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("Enter time interval or q for exit");
			String input = br.readLine();
			if ("q".equalsIgnoreCase(input)) {
				thread.interrupt();
				//System.out.println(thread.isInterrupted());
				break;
			}else {
				timer.setClockPeriod(Integer.parseInt(input));
			}
			
		}
		br.close();
	}

}
