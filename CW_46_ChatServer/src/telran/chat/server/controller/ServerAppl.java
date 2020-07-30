package telran.chat.server.controller;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import telran.chat.server.tasks.ChatServerReceiver;
import telran.chat.server.tasks.ChatServerSender;
import telran.messages.model.MessageBox;
import telran.messages.model.MessageBoxB;

public class ServerAppl {

	public static void main(String[] args) {
		int port = 9000;
		MessageBox messageBox = new MessageBoxB();
		ExecutorService executorService = Executors.newFixedThreadPool(20);
		ChatServerSender sender = new ChatServerSender(messageBox);
		Thread threadSender = new Thread(sender);
		threadSender.setDaemon(true);
		threadSender.start();
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			try {
				while (true) {
					System.out.println("Server is waiting...");
					Socket socket = serverSocket.accept();
					System.out.println("Connection established");
					System.out.println("Client host: " + socket.getInetAddress().getHostAddress());
					System.out.println("Client port: " + socket.getPort());
					ChatServerReceiver receiver = new ChatServerReceiver(messageBox, socket);
					executorService.execute(receiver);
					sender.addSender(socket);
				}
			} finally {
				executorService.shutdown();
				executorService.awaitTermination(1, TimeUnit.HOURS);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Server down");
		}
	}

}
