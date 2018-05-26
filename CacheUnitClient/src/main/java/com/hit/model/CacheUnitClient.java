package com.hit.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class CacheUnitClient extends Object	 {

	int port;
	
	String serverHostname;
	
	Socket echoSocket;
    ObjectOutputStream outC;
    ObjectInputStream inC;
	
	public CacheUnitClient() {
		port = 12345;
		
		serverHostname = new String("127.0.0.1");
		
		echoSocket = null;
        outC = null;
        inC = null;
		
	}
	
	public String send(String request) {
            
       // System.out.println("Connecting to host " + serverHostname + " on port " + port + "."); 
 
		try {
            echoSocket = new Socket(serverHostname, port);
            outC = new ObjectOutputStream(echoSocket.getOutputStream());
            inC = new ObjectInputStream(echoSocket.getInputStream());
                
            outC.writeObject(request);
            outC.flush();
               
            outC.close();
            inC.close();
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + serverHostname);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Unable to get streams from server");
            System.exit(1);
        } catch (Exception e) {
         	e.printStackTrace();
        }     
		
		return "";
	}
}
