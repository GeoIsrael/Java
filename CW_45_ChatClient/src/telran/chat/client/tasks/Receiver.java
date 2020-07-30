package telran.chat.client.tasks;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Receiver implements Runnable {
	Socket socket;
	ObjectInputStream ois;

	public Receiver(Socket socket) throws IOException {
		this.socket = socket;
		InputStream inputStream = socket.getInputStream();
		ois = new ObjectInputStream(inputStream);
	}

	@Override
	public void run() {
		while(true) {
			try {
				String message = ois.readObject().toString();
				System.out.println(message);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
