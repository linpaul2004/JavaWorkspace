package chapter12;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
	public static void main(String[] args) {
		try {
			// connecting to server on port 8000
			Socket connectionSock = new Socket("192.168.34.140", 8000);
			DataOutputStream serverOutput = new DataOutputStream(connectionSock.getOutputStream());
			// Connection made, sending name.
			while (true) {
				Scanner scanner = new Scanner(System.in);
				System.out.println("Type your message:");
				String msg = null;
				while (scanner.hasNextLine()) {
					msg = scanner.nextLine();
				}
				System.out.println(msg + "\n");
				if (!msg.equals("")) {
					serverOutput.writeBytes(msg + "\n");
				}
				if (msg.equals("bye")) {
					scanner.close();
					break;
				}
				scanner.close();
			}
			serverOutput.close();
			connectionSock.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
