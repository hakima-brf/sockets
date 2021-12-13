package sockets;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class Serveur_Strings {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	ServerSocket ss = new ServerSocket(1027);
	System.out.println("en attente de connexion de client");
	Socket s = ss.accept();
	System.out.println("Connexion etablie");
	
	DataInputStream in = new DataInputStream(s.getInputStream());
	String nomClient = in.readUTF();
	
	String s1 = "Bienvenu"+nomClient+", t'es bien connecté";
	DataOutputStream out = new DataOutputStream(s.getOutputStream());
	out.writeUTF(s1);
	
		

	}

}
