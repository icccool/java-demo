package com.code.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		try {
			int port = 8891;
			ServerSocket serverSocket = new ServerSocket(port);
			Socket socket = serverSocket.accept();
			Reader reader = new InputStreamReader(socket.getInputStream());
			BufferedReader br = new BufferedReader(reader);
			String line = null;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
			System.out.println("from client: " + sb);  
			br.close();
			reader.close();
			socket.close();
			serverSocket.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
