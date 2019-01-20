
//COSC 350 Group Assignment #1
//Java TCP Socket Program
//*****************************
//Group # 9
//Memebrs:
//Michael Santoro
//Yefim Fayngersh
//******************************
import java.util.*;
import java.io.*;
import java.net.*; //transmission over a network 

public class Server_Socket {

    public static void main(String[] args) throws Exception {

        String upperCase;  //used for converting from lowercase
        //port number chosen is currently local host, must use machines IP when testing 2 computers 
        ServerSocket serverSocket = new ServerSocket(444);   //opens the socket for the server      
        System.out.println("Waiting for client on port: " + serverSocket.getLocalPort());
        System.out.println("IP Address of server machine: " + Inet4Address.getLocalHost().getHostAddress());  //This is the local IP

        while (true) {  //we want the server to stay running even when clients disconnect 

            //****************************************************  Listen and Connect to Client...print info to Client
            Socket socket = serverSocket.accept();              //pointer to socket object once connection is made to a client
            PrintStream printS = new PrintStream(socket.getOutputStream());  //once connnection is made to server / send info
            printS.println("Hello Client! ");
            printS.println("Port Number of the Server: " + socket.getPort());
            printS.println("IP Address of the Server: " + Inet4Address.getLocalHost().getHostAddress());
            //to be sent to GUI      
            //*********************************************************************************************
            InputStreamReader inputR = new InputStreamReader(socket.getInputStream());
            BufferedReader bufferR = new BufferedReader(inputR);
            String s1;
            s1 = bufferR.readLine();   //read the initial message from the server "Hello Server"
            System.out.print(s1);      //"print this to the server console for confirmation 

            //connected to a client and waiting for the next move....
            s1 = bufferR.readLine(); //start loop....see what the client does next   

            while (!s1.equals("stop")) {   //continue to read input and respond or reset until client wants to disconnect 

                upperCase = s1;
                upperCase = lowerToUpper(upperCase);   //convert lowercase message to uppercase 
                printS.println(upperCase);   //print upperCase to the Server 

                s1 = bufferR.readLine(); //read the next input and restart the loop

            }

            if (s1 == "stop") {
                inputR.close();
                bufferR.close();
                printS.close();
                socket.close();
            } //if client disconnects...close that specific socket

        } // End while loop

        //socket() - endpoint for comm
        //bind() - assign a unique address - IP and port #
        //listen() - wait for client to request access
        //connect() - ask to server
        //accept() - server receives a call
        //send() recv() 
        //close() - hang up 
        
    } //Ends main

    //*******************************************   Method used to convert a message from uppercase to lowercase
    public static String lowerToUpper(String lower) {
        String upper;
        upper = lower.toUpperCase();
        return upper;
    }
    //********************************************* 

} // Ends Class
