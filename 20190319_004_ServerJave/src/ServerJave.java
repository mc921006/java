import java.util.*;
import java.io.*;
import java.net.*;

public class ServerJave {
	public static void main(String[] args) {
		Scanner aScanner = new Scanner(System.in);
		ServerSocket RSocket = null; // �Ա���Ű�� ��
		Socket CSocket = null;
		BufferedReader MSGRead = null;
		String Message;
		System.out.println("���� ����");
		try {
			//��Ʈ��ȣ : 1024~65535
			System.out.println("���� �� �Դ� ��");
			RSocket = new ServerSocket(9999);
			System.out.println("���� �� �ִ� ��");
			System.out.println("�մ� ���� ������");
			CSocket = RSocket.accept();
			System.out.println("�մ� ����");
			MSGRead = new BufferedReader(new InputStreamReader(CSocket.getInputStream())); 
			while (true) {
				Message = MSGRead.readLine();
				System.out.println("[Ŭ���̾�Ʈ] :" +Message);
				if (Message.equals("exit")) {
					break;
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				System.out.println("���");
				CSocket.close();
				RSocket.close();	
			} catch (IOException e2) {
				System.out.println("��� ����");
			}
		}
	}
}
