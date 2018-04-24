package com.code.ganymed;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.concurrent.TimeUnit;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.ConnectionInfo;
import ch.ethz.ssh2.SCPClient;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

public class Ganymed {

	public static void main(String[] args) {
		try {
			File localFile = new File("C:\\Users\\W\\Desktop\\scpFileTest.txt");
			String remoteFile = "/root/backup";
			uploadFile(localFile, remoteFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		// 1.获得连接
		try {
			final Connection conn = new Connection(ConParameters.HOST, ConParameters.PORT);
			ConnectionInfo info = conn.connect(null, (int) TimeUnit.SECONDS.toMillis(5L), (int) TimeUnit.SECONDS.toMillis(11L));
			boolean isAuthenticated = conn.authenticateWithPassword(ConParameters.USERNAME, ConParameters.PASSWORD);
			if (isAuthenticated == false) {
				throw new IOException("Authentication failed.");
			}
			System.out.println("Connected: host=" + ConParameters.HOST + ", kex=" + info.keyExchangeAlgorithm + ", key-type=" + info.serverHostKeyAlgorithm + ", c2senc=" + info.clientToServerCryptoAlgorithm
					+ ", s2cenc=" + info.serverToClientCryptoAlgorithm + ", c2mac=" + info.clientToServerMACAlgorithm + ", s2cmac=" + info.serverToClientMACAlgorithm);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 执行脚本
	public static void execCommand(String command) {
		try {
			// 1.获得连接
			final Connection conn = getConnection();
			Session session = conn.openSession();

			// 2.execute command
			session.execCommand(command);
			System.out.println("Here is some information about the remote host:");

			// 3.stdout
			InputStream stdout = new StreamGobbler(session.getStdout());
			BufferedReader br = new BufferedReader(new InputStreamReader(stdout));
			while (true) {
				String line = br.readLine();
				if (line == null)
					break;
				System.out.println(line);
			}
			System.out.println("ExitCode: " + session.getExitStatus());
			br.close();
			session.close();
			conn.close();
		} catch (IOException e) {
			e.printStackTrace(System.err);
			System.exit(2);
		}
	}

	/**
	 * 
	 * @param localFile
	 * @param remotePath
	 */
	public static void uploadFile(File localFile, String remotePath) {
		System.out.println("upload local file '" + localFile.getAbsolutePath() + File.separator + localFile.getName() + "' to remote file '" + remotePath + "'");
		InputStream in = null;
		Connection conn = null;
		OutputStream out = null;
		try {
			conn = getConnection();
			SCPClient scp_client = new SCPClient(conn);
			out = scp_client.put(localFile.getName(), localFile.length(), remotePath, "0600");
			in = new FileInputStream(localFile);
			byte[] buff = new byte[1024];
			int len = 0;
			while ((len = in.read(buff)) > -1) {
				out.write(buff, 0, len);
			}
			out.flush();
			out.close();
			in.close();
			conn.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
			}
			try {
				in.close();
			} catch (IOException e) {
			}

			try {
				conn.close();
			} catch (Exception e) {
			}
		}
		System.out.println("upload file complete.");
	}
}
