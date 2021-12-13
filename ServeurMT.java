package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeurMT extends Thread {

	private int nbClients;
	public static void main(String[] args) {
		new ServeurMT().start();

	}
	@Override
	public void run() {
		try {
			ServerSocket ss = new ServerSocket(1028);
			System.out.println("le serveur Multithreading est démaré, en attente de la conexion des clients");
			while(true) {
				Socket s = ss.accept();
				++nbClients;
				new Conversation(s,nbClients).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	class Conversation extends Thread{
		private Socket socket;
		private int numero;
		public Conversation(Socket s, int numero) {
			this.socket = s;
			this.numero = numero;
		}

		@Override
		public void run() {
			try {
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				
				OutputStream os = socket.getOutputStream();
				PrintWriter pw = new PrintWriter(os,true);
				String IP = socket.getRemoteSocketAddress().toString();
				System.out.println("connection du client numero :"+numero+" et d'addresse IP ="+IP);
				pw.println("Bienvenue, vous etes le client numero: "+numero);
				
				while(true) {
					String req = br.readLine();
					System.out.println("Le client du numero : "+numero+"a envoyé la requete suivante \n"+req);
					pw.println(req.length());
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
