import java.util.*;
import java.io.*;
import java.net.*;

public class ClientJava {
	public static void main(String[] args) {
		Scanner aScanner = new Scanner(System.in);
		Socket CSocket = null;
		BufferedWriter MSGSend = null;
		String Message;
		System.out.println("Ŭ���̾�Ʈ ����");
		try {
			//��Ʈ��ȣ : 1024~65535
			System.out.println("Ŭ���̾�Ʈ �� �Դ� ��");
			CSocket = new Socket("192.168.0.26", 9999);
			System.out.println("Ŭ���̾�Ʈ ����");
			MSGSend = new BufferedWriter(new OutputStreamWriter
					(CSocket.getOutputStream())); //���ϰ� �����ϴ� �ڵ�
			while (true) {
				System.out.println("�޼����� �Է����ּ��� : ");
				Message = aScanner.nextLine();
				MSGSend.write(Message+"\n");	
				MSGSend.flush();
				if (Message.equals("exit")) {
					break;
				}
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		finally {
			try {
				System.out.println("Ŭ���̾�Ʈ ����");
				CSocket.close();
			} catch (IOException e2) {
				System.out.println("��� ����");
			}
		}
	}
}
