package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client_oct {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		Socket client = new Socket("127.0.0.1",1027);
		System.out.println("veuillez choisir un nombre");
		Scanner sc = new Scanner(System.in);
		String nb = sc.next();
		
		
		DataOutputStream out = new DataOutputStream(client.getOutputStream());
		out.writeBytes(nb);
		
		DataInputStream in = new DataInputStream(client.getInputStream());
		int s1= in.read();
		System.out.println("le resultat recu de l'appart du serveur est :"+s1);
		

	}
}
