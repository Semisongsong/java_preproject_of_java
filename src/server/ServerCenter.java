package server;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ServerCenter extends Thread {
	Socket withClient = null;
	ArrayList<String> info = new ArrayList<>();
	InputStream reMsg = null;
	OutputStream sendMsg = null;
	String id = null;
	String pwd = null;
	String oriid = " ";
	String oripwd = " ";

	ServerCenter(Socket s) {
		this.withClient = s;
		info.add("aaa/111");
		info.add("bbb/111");
		info.add("ccc/111");
	}

	@Override
	public void run() {
		streamSet();
	}

	private void streamSet() {
		try {
			reMsg = withClient.getInputStream();
			byte[] reBuffer = new byte[100];
			reMsg.read(reBuffer);
			id = new String(reBuffer);
			id = id.trim();
			System.out.println(id);
			int ch = loginCheck(id);
			String reMsg2 = null;
			if (ch == 1) {
				id = id.trim();
				reMsg2 = "pwd���Է��ϼ���.";
			} else if (ch == 0) {
				reMsg2 = "��ȿ���� ���� id�Դϴ�.";
			}
			sendMsg = withClient.getOutputStream();
			sendMsg.write(reMsg2.getBytes());

			reMsg = withClient.getInputStream();
			reMsg.read(reBuffer);
			pwd = new String(reBuffer);
			System.out.println("���� �н����� Ȯ�� :" + pwd);
			int ch2 = pwdCheck(id);
			String reMsg3 = null;
			if (ch2 == 1) {
				pwd = pwd.trim();
				InetAddress c_ip = withClient.getInetAddress();
				String ip = c_ip.getHostAddress();
				System.out.println(id + "�� �α��� (" + ip + ")");
				menu();
			} else if (ch2 == 0) {
				reMsg3 = "��й�ȣ�� ��ġ���� �ʽ��ϴ�.";
				sendMsg = withClient.getOutputStream();
				sendMsg.write(reMsg3.getBytes());
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void menu() {
		System.out.println("��Ʊ���");

	}

	private int pwdCheck(String id2) {
		return 0;

	}

	private int loginCheck(String id) {
		for (int i = 0; i < info.size(); i++) {
			String pre = info.get(i); // aaa/111
			StringTokenizer st = new StringTokenizer(pre, "/");
			oriid = st.nextToken();
			oripwd = st.nextToken();
		}
		System.out.println("����Ʈ�� �ִ� ���̵� Ȯ��" + oriid);
		if (oriid.equals(id)) {
			System.out.println("����Ʈ�� �ִ� ���̵�" + oriid + " / " + "�Է���" + id);
			System.out.println("id ��ġ");
			return 1;
		} else {
			System.out.println("����Ʈ�� �ִ� ���̵�" + oriid + " / " + "�Է���" + id);
			System.out.println("��ġ�ϴ� ���̵� �����ϴ�.");
			return 0;
		}
	}

}
