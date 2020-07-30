package telran.chat.client.controller;

import java.net.Socket;

import telran.chat.client.tasks.Receiver;
import telran.chat.client.tasks.Sender;

public class ClientAppl {

	public static void main(String[] args) {
		String serverAddress = "127.0.0.1";
		int port = 9000;
		try (Socket socket = new Socket(serverAddress, port)) {
			Sender sender = new Sender(socket);
			Thread senderThread = new Thread(sender);
			senderThread.start();
			Receiver receiver = new Receiver(socket);
			Thread receiverThread = new Thread(receiver);
			receiverThread.setDaemon(true);
			receiverThread.start();
			senderThread.join();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
