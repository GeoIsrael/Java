package telran.socket.server.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;

public class ServerAppl {

	public static void main(String[] args) {
		int port = 9000;
		try (ServerSocket serverSocket = new ServerSocket(port);) {
			System.out.println("Server is waiting...");
			Socket socket = serverSocket.accept();
			System.out.println("Connection established");
			System.out.println("Client host: " + socket.getInetAddress());
			System.out.println("Client port: " + socket.getPort());
			InputStream inputStream = socket.getInputStream();
			OutputStream outputStream = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(outputStream);
			ObjectInputStream ois = new ObjectInputStream(inputStream);
			while (true) {
				String message = ois.readObject().toString();
				String response = message + " " + LocalTime.now();
				oos.writeObject(response);
				oos.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
