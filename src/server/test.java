package server;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class test {

	public static void main(String[] args) {
		ArrayList<String> info = new ArrayList<>();
		String id = null;
		String pwd = null;
		Scanner in = new Scanner(System.in);

		info.add("aaa/111");
		info.add("bbb/111");
		info.add("ccc/111");

		for (int i = 0; i < info.size(); i++) {
			String pre = info.get(i);
			StringTokenizer st = new StringTokenizer(pre, "/");
			if (st.hasMoreTokens()) {
				id = st.nextToken();
				pwd = st.nextToken();
			}
			System.out.println("1. info�� �ִ� id��� : "+id);
			String aaa = in.nextLine();
			if(aaa.equals(id)) {
				System.out.println("id�� ��ġ�մϴ�.");
			}else{
				System.out.println("id�� ��ġ���� �ʽ��ϴ�.");
			}

		}
		//System.out.println("2. info�� �ִ� id��� : "+id);
		


	}

}
