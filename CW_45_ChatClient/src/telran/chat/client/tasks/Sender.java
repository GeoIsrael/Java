package telran.chat.client.tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.time.LocalTime;

import telran.chat.model.Message;

public class Sender implements Runnable {
	Socket socket;
	BufferedReader br;
	ObjectOutputStream oos;

	public Sender(Socket socket) throws IOException {
		this.socket = socket;
		br = new BufferedReader(new InputStreamReader(System.in));
		OutputStream outputStream = socket.getOutputStream();
		oos = new ObjectOutputStream(outputStream);
	}

	@Override
	public void run() {
		try {
			System.out.println("Please enter your nickname");
			String name = br.readLine();
			Message message = new Message(name);
			System.out.println("Please enter your message or exit for quit");
			String text = br.readLine();
			while (!"exit".equalsIgnoreCase(text)) {
				oos.reset();
				message.setMessage(text);
				message.setTime(LocalTime.now());
				oos.writeObject(message);
				oos.flush();
				text = br.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
