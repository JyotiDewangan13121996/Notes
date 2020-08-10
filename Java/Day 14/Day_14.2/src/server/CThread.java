package server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class CThread implements Runnable
{
	private Socket socket;
	private Thread thread;
	public CThread(Socket socket) 
	{
		this.socket = socket;
		this.thread = new Thread(this);
		this.thread.start();
	}
	@Override
	public void run() 
	{
		try( DataInputStream inputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			 DataOutputStream outputStream = new DataOutputStream(new BufferedOutputStream( socket.getOutputStream()));
			 Scanner sc = new Scanner(System.in); )
		{
			String text = "";
			do
			{
				System.out.print("S:Server	:	");
				text = sc.nextLine();
				outputStream.writeUTF(text);
				outputStream.flush();
				
				text = inputStream.readUTF();
				System.out.println("S:Client	:	"+text);
			}while( !text.equalsIgnoreCase("end"));
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}
	}
}
