import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

class Client { 

	public static void main(String args[]) throws Exception { 

		Socket servertSocket = new Socket("localhost", 8080);
		System.out.println("[ SUCCESSFULLY CONNECTED TO THE SERVER ]");
		System.out.println("[ Type any message to exchange with the server...]");
		System.out.println("[ Type 'exit' to close the connection ]" + "\n");

		DataOutputStream serverDataOutputStream = new DataOutputStream(servertSocket.getOutputStream()); 
		BufferedReader serveBufferedReader = new BufferedReader(new InputStreamReader(servertSocket.getInputStream())); 
		BufferedReader keyboardBufferedReader = new BufferedReader(new InputStreamReader(System.in)); 
		
		String clientString, serverString; 

		while (!(clientString = keyboardBufferedReader.readLine()).equals("exit")) { 
			serverDataOutputStream.writeBytes("Client: " + clientString + "\n"); 
			serverString = serveBufferedReader.readLine();
			System.out.println(serverString); 
		}
		
		serverDataOutputStream.close(); 
		serveBufferedReader.close(); 
		keyboardBufferedReader.close(); 
		servertSocket.close(); 
	} 
} 
