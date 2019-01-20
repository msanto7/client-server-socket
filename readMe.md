## Course
COSC 350 Towson Univeristy 

## Description 
Our TCP socket program consists of 2 java files, Server_Socket.java, and client_display.java. To build this program we have been using NetBeans. The program can been tested on 2 different machines or simply on one machines localhost. To test on your machines localhost, first you have to change line number 20 on the Server_Socket.java file to read…

ServerSocket serverSocket = new ServerSocket(444);

…this starts the server socket on port number 444, which is our localhost. If you would like to run on 2 different machines, you should run the command “netstat –a” and choose a port number that is above 10,000 and not listed as listening when the command runs on windows. This is because you need to start the server on an open unused port, otherwise it will fail. Once the server is running it should print to the console what port number it is now listening on and the local ip of the server machine. To get the ip address of the server machine run the “ipconfig/all” command on this machine and find the IPv4 address (this will only be necessary if you are running between 2 machines, instead of the localhost.

So once the server program is running on port 444, or whatever open port you have chosen, we need to start up the client side. To do this simply run the program either on the localhost or whatever other machine you have chosen. The GUI should pop up and allow you to enter the ip address and port number, then press connect. This is not hardcoded so you can choose whatever ip and port you would like to connect to. For the localhost simply type “localhost” for the ip address, and “444” for the port number. If you are using 2 machines, type in the ip address you got from the ipconfig command earlier on ther server machine, and again type in whatever port number you chose (this should be printed to the servers console). 

Once you have entered these items and pressed connect, if the connection was successful, the ciient will print “Hello Server: “ to the server, and the server will print “Hello Client “ to the server section of the GUI. The client is now connected to the Server through a TCP socket. 
	
From here you can now use the client GUI to do a few different things. If you would like to send a message to the client, type in your message in the box to the right of the “send_message” button, then press that button. This will send your message to the server and the server will respond by printing to the server section of the GUI, your message but now in all capital letters. However, as specified in the client GUI, if you type “stop” this is a way to end the connection with the server. If you send “stop” the socket will be closed and the server GUI will print “You have been disconnected…”. You are free to exit the program or reconnect to the server if you choose. 

If you would like to clear the server section press the reset button. This will make the server section blank, you are still connected to the server and can send messages or disconnect as you wish.


The last functionality would be pressing the “exit/disconnect “ button. This will do exactly the same thing that typing stop in the message box will do. The socket will be closed and the server GUI will print that you have now been disconnected. Once disconnected you will not be able to send messages. However, you can reset the screen or reconnect to the server if you choose. 

## Contributors
  Michael Santoro
  Yefim Fayngersh

