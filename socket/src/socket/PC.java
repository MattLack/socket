package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class PC {
	public static void main(String[] args){
		try {
			Socket kkSocket = new Socket(InetAddress.getByName("localhost").getHostAddress(), 4444);
			PrintWriter out2 = new PrintWriter(kkSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
			String mensagem = "";
			Scanner ler = new Scanner(System.in);
			while(!mensagem.equals("sair")){
				while(in.ready()){
					System.out.println("Servidor disse:\n" + in.readLine());
				}
				System.out.println("PC, digite a mensagem: (digite sair para sair e enter para atulizar o chat)");
				mensagem = ler.nextLine();
				out2.println(mensagem);
				System.out.flush();
			}
			System.out.println("Tchau!");
			in.close();
			out2.close();
			} catch (UnknownHostException e) {
			System.err.println("O host 172.16.205.93 não foi encontrado.");
			System.exit(1);
			} catch (IOException e) {
			System.err.println("Erro de IO com 172.16.205.93.");
			System.exit(1);
			}
	}
	

}
