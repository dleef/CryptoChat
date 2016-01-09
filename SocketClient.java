package prime;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * A Simple Socket client that connects to our socket server
 *
 */
public class SocketClient {

    private String hostname;
    private int port;
    Socket socketClient;
    PrintWriter out;

    public SocketClient(String hostname, int port){
        this.hostname = hostname;
        this.port = port;
    }

    public void connect() throws UnknownHostException, IOException{
        System.out.println("Attempting to connect to "+hostname+":"+port);
        socketClient = new Socket(hostname,port);
        System.out.println("Connection Established");
    }

    public void readResponse() throws IOException{
        String userInput;
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
        System.out.println("Response from server:");
        while ((userInput = stdIn.readLine()) != null) {
            System.out.println(userInput);
        }
    }


    public static void main(String arg[]){
        //Creating a SocketClient object
        SocketClient client = new SocketClient ("localhost",9999);
        try {
            //trying to establish connection to the server
            client.connect();
            
            //if successful, read response from server
            client.readResponse();
            

        } catch (UnknownHostException e) {
            System.err.println("Host unknown. Cannot establish connection");
        } catch (IOException e) {
            System.err.println("Cannot establish connection. Server may not be up."+e.getMessage());
        }
    }
}
