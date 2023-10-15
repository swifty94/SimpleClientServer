import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

class Server { 

	public static void main(String args[]) throws Exception { 

		ServerSocket server = new ServerSocket(8080);
		System.out.println("[ SERVER STARTED SUCCESSFULLY ]");

		Socket client = server.accept(); 
		System.out.println("[ New client connection -> " + client.toString() + "\n"); 
 
		PrintStream serverPrintStream = new PrintStream(client.getOutputStream());
		BufferedReader clientBufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream())); 
		BufferedReader keyboardBufferedReader = new BufferedReader(new InputStreamReader(System.in)); 

		while (true) {
			String clientString, serverString; 
			
			while ((clientString = clientBufferedReader.readLine()) != null) { 
				System.out.println(clientString); 
				serverString = keyboardBufferedReader.readLine(); 
				serverPrintStream.println("Server: " + serverString);
			} 
			System.out.println("Client sent 'exit' message. Application stopped.");
			serverPrintStream.close(); 
			clientBufferedReader.close(); 
			keyboardBufferedReader.close(); 
			server.close(); 
			client.close(); 

			System.exit(0); 

		}
	} 
} 
