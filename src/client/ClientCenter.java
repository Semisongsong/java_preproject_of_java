package client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

import server.ServerCenter;

public class ClientCenter {
	Socket withServer = null;
	Scanner in = new Scanner(System.in);
	OutputStream sendMsg =null;
	InputStream reMsg = null;
	String id = null;
	String pwd = null;
	
	
	ClientCenter(Socket s) {
		this.withServer=s;
		streamSet();
		//login();
	}


	
	private void streamSet() {
		try {
			System.out.println("ID�� �Է��ϼ���.");
			id = in.nextLine();
			OutputStream sendMsg = withServer.getOutputStream();
			sendMsg.write(id.getBytes());
			
			
			reMsg = withServer.getInputStream();
			byte[] reBuffer = new byte[100];
			reMsg.read(reBuffer);
			String msg = new String(reBuffer);
			msg = msg.trim();
			if(msg.equals("pwd���Է��ϼ���.")) {
				System.out.println(msg);
				pwd = in.nextLine();
				sendMsg = withServer.getOutputStream();
				sendMsg.write(pwd.getBytes());
			}else if(msg.equals("��ȿ���� ���� id�Դϴ�.")) {
				System.out.println(msg);
				streamSet();
			}
			
			
		} catch (Exception e) {
		
		}
	}

}
