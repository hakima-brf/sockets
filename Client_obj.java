package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client_obj {
	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		Socket client = new Socket("127.0.0.1",1027);
		System.out.println("veuiller entrer les attribut de votre object");
		System.out.println("veuiller entrer premierement le nom");

		Scanner sc = new Scanner(System.in);
		String nom = sc.nextLine();
		System.out.println("veuiller entrer  la description de l'object");

		String desc = sc.nextLine();
		Object obj = new Object(nom, desc);

		
		
		ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
		out.writeObject(obj);
		
		ObjectInputStream in = new ObjectInputStream(client.getInputStream());
		try {
			Object obj1 = (Object) in.readObject();
			System.out.println("le resultat recu de l'appart du serveur est  l'objet\n du nom: "+obj1.nom+"\n et de description : "+obj1.description);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
