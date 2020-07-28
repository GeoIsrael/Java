package telran.utils.executor;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

public class ThreadPool implements Executor{
	private Queue<Runnable> taskQueue = new ConcurrentLinkedQueue<>();
	private volatile boolean isRunning = true;
	private Thread[] threads;
	
	public ThreadPool(int nThread) {
		threads = new Thread[nThread];
		for(int i = 0; i < nThread; i++) {
			threads[i] = new Thread(new TaskHandler());
			threads[i].start();
		}
	}

	@Override
	public void execute(Runnable command) {
		if (isRunning) {
			taskQueue.add(command);
		}
		
	}
	
	public void shutdown() {
		isRunning = false;
	}
	
	public void awaitThreads() {
		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private class TaskHandler implements Runnable{

		@Override
		public void run() {
			while (!taskQueue.isEmpty() || isRunning) {
				Runnable task = taskQueue.poll();
				if (task != null) {
					task.run();
				}
			}
			
		}
		
	}

}
