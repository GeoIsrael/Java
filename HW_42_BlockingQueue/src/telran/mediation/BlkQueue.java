package telran.mediation;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlkQueue<T> implements IBlkQueue<T> {

	private LinkedList<T> queue = new LinkedList<>();
	private int maxSize;
	Lock mutex = new ReentrantLock();
	Condition senderWaitCondition = mutex.newCondition();
	Condition receiverWaitCondition = mutex.newCondition();

	public BlkQueue(int maxSize) {
		this.maxSize = maxSize;
	}

	@Override
	public void push(T message) {
		try {
			mutex.lock();
			while (queue.size() >= maxSize) {
				try {
					senderWaitCondition.await();
				} catch (InterruptedException e) {
					System.out.println("thread was interrupted");
				}
			}
			queue.add(message);
			receiverWaitCondition.signal();
		} finally {
			mutex.unlock();
		}

	}

	@Override
	public T pop() {
		try {
			mutex.lock();
			while (queue.isEmpty()) {
				try {
					receiverWaitCondition.await();
				} catch (InterruptedException e) {
					System.out.println("thread was interrupted");
				}
			}
			T msg = queue.poll();
			senderWaitCondition.signal();
			return msg;
		} finally {
			mutex.unlock();
		}

	}
}