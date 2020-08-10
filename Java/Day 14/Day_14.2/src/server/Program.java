package server;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Program 
{
	public static final int PORT = 5271; 
	public static void main(String[] args) 
	{
		try( ServerSocket serverSocket = new ServerSocket( PORT ); )
		{
			while( true )
			{
				Socket socket = serverSocket.accept();
				Runnable target = new CThread( socket );
			}
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}
	}
}
