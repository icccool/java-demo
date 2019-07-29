package com.code.socket;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) {
		try {
			String host = "127.0.0.1";
			int port = 8891;
			Socket clent = new Socket(host, port);
			Writer writer = new OutputStreamWriter(clent.getOutputStream());
			writer.write("hello server1\n");
			writer.write("hello server2\n");
			writer.flush();
			writer.close();
			clent.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
