package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur_obj {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
	ServerSocket ss = new ServerSocket(1027);
	System.out.println("en attente de connexion de client");
	Socket s = ss.accept();
	System.out.println("Connexion etablie");
	System.out.println("j'attend un objet");

	
	ObjectInputStream in = new ObjectInputStream(s.getInputStream());
	Object obj1 = (Object) in.readObject();
	Object obj2 =new Object(obj1.nom,obj1.description);
	obj2.description = obj1.description+". Cet objet est renvoyer par le serveur.";

	System.out.println("l'objet recu de l'appart du client a \n *le nom : "+obj1.nom+" \n * la description :"+obj1.description);
    
	
	
	ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
	out.writeObject(obj2);
	
		

	}

}
