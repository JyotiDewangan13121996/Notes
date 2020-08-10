package client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Program 
{
	public static final int PORT = 5271; 
	public static void main(String[] args) 
	{
		try( Socket socket = new Socket("localhost", PORT);
			 DataInputStream inputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			 DataOutputStream outputStream = new DataOutputStream(new BufferedOutputStream( socket.getOutputStream()));
			 Scanner sc = new Scanner(System.in); )
		{
			String text = "";
			do
			{
				text = inputStream.readUTF();
				System.out.println("C:Server	:	"+text);
				
				System.out.print("C:Client	:	");
				text = sc.nextLine();
				outputStream.writeUTF(text);
				outputStream.flush();
			}while( !text.equalsIgnoreCase("end"));
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}
	}
}
