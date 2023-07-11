package com.masai;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerApp {

	public static void main(String[] args) {

		System.out.println("Server started waiting from the client..");

		try {
			ServerSocket serverSocket = new ServerSocket(8888);

			Socket socket = serverSocket.accept();
			System.out.println("Connected with the client");
			OutputStream os = socket.getOutputStream();

			PrintWriter pw = new PrintWriter(os);

			Scanner sc = new Scanner(System.in);

			while (true) {

				System.out.println("Enter a text to send to client");

				String line = sc.nextLine();

				pw.println(line);
				pw.flush();

				System.out.println("message is sent");

				if (line.equals("exit")) {
					System.out.println("server has terminated the connection");
					break;
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
