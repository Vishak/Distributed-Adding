package com.client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class DClient {

	/**
	 * @param args
	 */
	Socket socket;
	ObjectOutputStream out;
	ObjectInputStream in;
	String message;
	Object msg;
	
	public void createSocket() {
		try{
			socket=new Socket("192.168.1.132",12345);
			DataOutputStream write=new DataOutputStream(socket.getOutputStream());
			write.writeBytes("hello");
			message="Hello";
			//out.writeObject(message);
			//System.out.println("Writing data.");				
			//out.flush();				
//				msg=in.readObject();
//			System.out.println(msg.toString());
			
		
		}
		catch (UnknownHostException e) {			
			// TODO: handle exception
			System.out.println("Unknown Host");
		}
		catch(IOException io){
			System.out.println("IOexception");
		}
		try {
			//in.close();
			out.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException,NullPointerException{
		// TODO Auto-generated method stub
		DClient client=new DClient();
		client.createSocket();
	}

}

