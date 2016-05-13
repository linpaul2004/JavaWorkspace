package chapter12;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// Connecting to server on port 8000
			Socket cSock = new Socket("127.0.0.1", 8000);
			BufferedReader serverInput = new BufferedReader(new InputStreamReader(cSock.getInputStream()));
			DataOutputStream serverOutput = new DataOutputStream(cSock.getOutputStream());
			// connection made, sending name.
			serverOutput.writeBytes("Hello! I am a client...\n");
			// waiting for reply
			String serverData = serverInput.readLine();
			System.out.println("From Server: " + serverData);
			serverOutput.close();
			serverInput.close();
			cSock.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
