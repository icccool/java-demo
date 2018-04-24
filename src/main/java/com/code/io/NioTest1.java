package com.code.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class NioTest1 {
	public static void main(String[] args) {
		FileChannel outChannel = null;
		FileChannel inChannel = null;
		try {
			outChannel = new FileOutputStream("nio_data1.txt").getChannel();
			outChannel.write(ByteBuffer.wrap("你好,21213中文,fsdfs".getBytes()));
			outChannel.close();

			inChannel = new FileInputStream("nio_data1.txt").getChannel();
			ByteBuffer bf = ByteBuffer.allocate(6);
			inChannel.read(bf);
			bf.flip();
			while (bf.hasRemaining()) {
				System.out.println(Charset.forName("UTF-8").decode(bf));
			}
			// inChannel = new FileInputStream("").getChannel();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (outChannel != null) {
					outChannel.close();
				}
				if (inChannel != null) {
					inChannel.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
