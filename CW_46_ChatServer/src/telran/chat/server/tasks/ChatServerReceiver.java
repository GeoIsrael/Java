package telran.chat.server.tasks;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import telran.chat.model.Message;
import telran.messages.model.MessageBox;

public class ChatServerReceiver implements Runnable {
	MessageBox messageBox;
	Socket socket;
	ObjectInputStream ois;

	public ChatServerReceiver(MessageBox messageBox, Socket socket) throws IOException {
		this.messageBox = messageBox;
		this.socket = socket;
		ois = new ObjectInputStream(socket.getInputStream());
	}

	@Override
	public void run() {
		try {
			while (true) {
				Message message = (Message) ois.readObject();
				messageBox.post(message);
			} 
		} catch (Exception e) {
			try {
				System.out.println(socket+" leave chat");
				socket.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

}
