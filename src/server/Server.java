package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public Server() throws IOException{
		ServerSocket server = new ServerSocket(12345);
	}
}
