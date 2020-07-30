package telran.chat.server.tasks;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import telran.chat.model.Message;
import telran.messages.model.MessageBox;

public class ChatServerSender implements Runnable {
	MessageBox messageBox;
	Set<ObjectOutputStream> senders = new HashSet<>();
	static Object mutex = new Object();
	

	public ChatServerSender(MessageBox messageBox) {
		this.messageBox = messageBox;
	}
	
	public boolean addSender(Socket socket) throws IOException {
		synchronized (mutex) {
			return senders.add(new ObjectOutputStream(socket.getOutputStream()));
		}
	}


	@Override
	public void run() {
		// FIXME
		while(true) {
			Message message = messageBox.get();
			synchronized (mutex) {
				Iterator<ObjectOutputStream> iter = senders.iterator();
				while (iter.hasNext()) {
					try {
						ObjectOutputStream oos = iter.next();
						oos.writeObject(message);
						oos.flush();
					} catch (IOException e) {
						iter.remove();
					}

				}
			}
		}

	}

}
