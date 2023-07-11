package com.masai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientApp {

	public static void main(String[] args) {

		try {
			Socket socket = new Socket("localhost", 8888);

			InputStream is = socket.getInputStream();

			// Scanner sc=new Scanner(is);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			while (true) {
				String line = br.readLine();
				System.out.println("message from server: " + line);

				if (line.equals("exit")) {
					System.out.println("server stoped the connection");
					break;
				}
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}