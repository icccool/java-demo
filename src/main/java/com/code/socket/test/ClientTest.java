package com.code.socket.test;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ClientTest {
	public static void main(String[] args) {
		try {
			Socket client = new Socket("127.0.0.1", 1516);
			OutputStream out = client.getOutputStream();
			OutputStreamWriter writer = new OutputStreamWriter(out);
			writer.write("aaa");
			writer.write("bbb");
			writer.close();
			out.close();
			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
