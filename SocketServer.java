package prime;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
* A simple socket server
*
*/
public class SocketServer {
    
    private ServerSocket serverSocket;
    private Socket socket;
    private int port;
    ArrayList<String> names = new ArrayList<>();
    ArrayList<BufferedWriter> writers = new ArrayList<>();
    
    
    public SocketServer(int port) {
        this.port = port;
    }
    
    public void start() throws IOException {
        System.out.println("Starting the socket server at port:" + port);
        serverSocket = new ServerSocket(port);
        
        //Listen for clients. Block till one connects
        
        System.out.println("Waiting for clients...");
        Socket client = serverSocket.accept();
        
        //A client has connected to this server. Send welcome message
        //enterName(client);
    }
    
   /* 
    private void enterName(Socket client) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        while(true){
        writer.write("Please enter user name");
        String UserInput = in.readLine();
        if(names.contains(UserInput)) {
        	
        	writer.write("Invalid username please enter another");
        	in.readLine();
        	return;
        	
        }
        else{
        names.add(UserInput);
        writers.add(writer);
        break;
        
        }
        }
    }
    */
    /**
    * Creates a SocketServer object and starts the server.
    *
    * @param args
    */
    public static void main(String[] args) {
        // Setting a default port number.
        int portNumber = 9999;
        
        try {
            // initializing the Socket Server
            SocketServer socketServer = new SocketServer(portNumber);
            socketServer.start();
            
            } catch (IOException e) {
            e.printStackTrace();
        }
    }
}