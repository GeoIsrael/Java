package telran.loop.model;

import java.util.concurrent.atomic.AtomicBoolean;

public class InfiniteLoop implements Runnable {
	private AtomicBoolean flag = new AtomicBoolean(true);        // либо volatile (проблема когерентности потоков потоков

	public boolean isFlag() {
		return flag.get();
	}

	public void setFlag(boolean flag) {
		this.flag.set(flag);
	}

	@Override
	public void run() {
		while (isFlag());                            //зацикливается, пока флаг true
		System.out.println("Finished");
	}

}
