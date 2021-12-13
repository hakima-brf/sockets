package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client_Strings {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		Socket client = new Socket("127.0.0.1",1027);
		System.out.println("nom client");
		Scanner sc = new Scanner(System.in);
		String nomClient = sc.next();
		
		
		DataOutputStream out = new DataOutputStream(client.getOutputStream());
		out.writeUTF(nomClient);
		
		DataInputStream in = new DataInputStream(client.getInputStream());
		String s1= in.readUTF();
		System.out.println(s1);
		

	}
}
