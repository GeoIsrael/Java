package telran.messages.model;

import telran.chat.model.Message;

public class MessageBoxB implements MessageBox{
	Message message;

	@Override
	public synchronized void post(Message message) {
		while (this.message != null) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.message = message;
		this.notifyAll();
	}

	@Override
	public synchronized Message get() {
		while (this.message == null) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Message res = this.message;
		this.message = null;
		this.notifyAll();
		return res;
	}
}
