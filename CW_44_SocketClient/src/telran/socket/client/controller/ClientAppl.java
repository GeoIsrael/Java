package telran.socket.client.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientAppl {

	public static void main(String[] args) {
		String serverAddress = "127.0.0.1";
		int serverPort = 9000;
		try (Socket socket = new Socket(serverAddress, serverPort);
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			InputStream inputStream = socket.getInputStream();
			OutputStream outputStream = socket.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(outputStream);
			ObjectInputStream ois = new ObjectInputStream(inputStream);
			System.out.println("Please enter your message or exit for quit");
			String message = br.readLine();
			while (!"exit".equalsIgnoreCase(message)) {
				oos.writeObject(message);
				oos.flush();
				String response = ois.readObject().toString();
				System.out.println(response);
				System.out.println("Please enter your message or exit for quit");
				message = br.readLine();
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
