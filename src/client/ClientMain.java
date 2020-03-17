package client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientMain {

	public static void main(String[] args) throws Exception {

		Socket withServer = null;
		withServer = new Socket("10.0.0.141",9999);
		new ClientCenter(withServer); 
		
		
		
	}

}
