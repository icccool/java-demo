package com.code.ganymed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;

public class Basic {
	public static void main(String[] args) {

		try {
			Connection conn = new Connection(ConParameters.HOST);
			conn.connect();
			boolean isAuthenticated = conn.authenticateWithPassword(ConParameters.USERNAME, ConParameters.PASSWORD);
			if (isAuthenticated == false){
				throw new IOException("Authentication failed.");
			}
			Session session = conn.openSession();
			session.execCommand("uname -a && date && uptime && who");
			System.out.println("Here is some information about the remote host:");
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
}