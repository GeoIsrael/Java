package telran.numberportions.model;

public class Printer implements Runnable {
	static int totalNumbers;
	static int portion;
	static long sleepTime;
	int number;
	Thread next;

	public Printer(int number) {
		this.number = number;
	}

	public static int getTotalNumbers() {
		return totalNumbers;
	}

	public static void setTotalNumbers(int totalNumbers) {
		Printer.totalNumbers = totalNumbers;
	}

	public static int getPortion() {
		return portion;
	}

	public static void setPortion(int portion) {
		Printer.portion = portion;
	}

	public static long getSleepTime() {
		return sleepTime;
	}

	public static void setSleepTime(long sleepTime) {
		Printer.sleepTime = sleepTime;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Thread getNext() {
		return next;
	}

	public void setNext(Thread next) {
		this.next = next;
	}

	@Override
	public void run() {
		int nPortions = totalNumbers / portion;
		for (int i = 0; i < nPortions;) {
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				printPortion(portion);
				next.interrupt();
				i++;
			}
		}
		int tail = totalNumbers % portion;
		if (tail != 0) {
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				printPortion(tail);
				next.interrupt();
			}
		}
	}

	private void printPortion(int quantity) {
		for (int i = 0; i < quantity; i++) {
			System.out.print(number);
		}
		System.out.println();
	}

}
