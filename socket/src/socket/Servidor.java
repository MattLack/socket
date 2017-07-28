package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
	
	public static void main(String[] args){
	
	ServerSocket serverSocket = null;
	
	try {
	serverSocket = new ServerSocket(4444);
	} catch (IOException e) {
	System.err.println("Não foi possível escutar na porta 4444.");
	System.exit(1);
	}
	Socket clientSocket = null;
	try {
	clientSocket = serverSocket.accept();
	} catch (IOException e) {
	System.err.println("Falha no accept.");
	System.exit(1);
	}
	try {
		PrintWriter out2 = new PrintWriter(clientSocket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		String mensagem = "";
		Scanner ler = new Scanner(System.in);
		while(!mensagem.equals("sair")){
			while(in.ready()){
				System.out.println("PC disse:\n" + in.readLine());
			}
			System.out.println("Servidor, digite a mensagem:(digite sair para sair e enter para atulizar o chat) ");
			mensagem = ler.nextLine();
			out2.println(mensagem);	
			System.out.flush();
		}
		System.out.println("Tchau!");
		in.close();
		out2.close();
		clientSocket.close();
		serverSocket.close();
	} catch (IOException e) {
		e.printStackTrace();
	}


	}

}
