package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur_oct {
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	ServerSocket ss = new ServerSocket(1027);
	System.out.println("en attente de connexion de client");
	Socket s = ss.accept();
	System.out.println("Connexion etablie");
	System.out.println("j'attend un nombre");

	
	DataInputStream in = new DataInputStream(s.getInputStream());
	int nb = in.read();
	System.out.println("je vien de recevoir le nombre "+nb);
    
	int rep = nb *3;
	
	DataOutputStream out = new DataOutputStream(s.getOutputStream());
	out.writeByte(rep);
	
		

	}


}
