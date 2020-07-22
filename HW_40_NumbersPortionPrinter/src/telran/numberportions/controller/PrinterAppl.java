package telran.numberportions.controller;

import telran.numberportions.model.Printer;

public class PrinterAppl {

	private static final int TOTAL_NUMBERS = 25;        
	private static final int PORTION = 10;               
	private static final long SLEEP_TIME = 1000 * 60 * 60 * 24;
	private static final int N_TREADS = 4;

	public static void main(String[] args) {
		Printer.setTotalNumbers(TOTAL_NUMBERS);
		Printer.setPortion(PORTION);
		Printer.setSleepTime(SLEEP_TIME);
		Printer[] printers = new Printer[N_TREADS];
		for (int i = 0; i < printers.length; i++) {
			printers[i] = new Printer(i + 1);
		}
		Thread[] threads = new Thread[N_TREADS];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(printers[i]);
			threads[i].start();
		}
		for (int i = 0; i < threads.length - 1; i++) {
			printers[i].setNext(threads[i + 1]);
		}
		printers[printers.length - 1].setNext(threads[0]);
		threads[0].interrupt();

	}

}
