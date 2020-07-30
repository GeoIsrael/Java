package telran.messages.model;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import telran.chat.model.Message;

public class MessageBoxC implements MessageBox {
	Message message;
	Lock mutex = new ReentrantLock();
	Condition senderWaitCondition = mutex.newCondition();
	Condition receiverWaitCondition = mutex.newCondition();

	@Override
	public void post(Message message) {
		try {
			mutex.lock();
			while (this.message != null) {
				try {
					senderWaitCondition.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			this.message = message;
			receiverWaitCondition.signal();
		} finally {
			mutex.unlock();
		}
	}

	@Override
	public Message get() {
		try {
			mutex.lock();
			while (this.message == null) {
				try {
					receiverWaitCondition.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Message res = this.message;
			this.message = null;
			senderWaitCondition.signal();
			return res;
		} finally {
			mutex.unlock();
		}
	}

}
