import java.util.*;
import java.io.*;
import java.net.*;

public class ServerJava {
	public static void main(String[] args) {
		ServerSocket RSocket = null; // �Ա���Ű�� ��
		Socket CSocket = null;
		BufferedReader MSGRead = null;
		String Message;
		SendThread SThread;
		System.out.println("���� ����");
		try {
			//��Ʈ��ȣ : 1024~65535
			System.out.println("���� �� �Դ� ��");
			RSocket = new ServerSocket(9999);
			System.out.println("���� �� �ִ� ��");
			System.out.println("�մ� ���� ������");
			CSocket = RSocket.accept();
			System.out.println("�մ� ����"+CSocket.getPort() +" "+ CSocket.getLocalPort());
			SThread = new SendThread(CSocket);
			SThread.start();
			MSGRead = new BufferedReader(new InputStreamReader
					(CSocket.getInputStream())); 
			while (true) {
				/////// Read ///////
				Message = MSGRead.readLine();
				System.out.println("[Ŭ���̾�Ʈ] :" +Message);
				/////// Exit ///////
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

class SendThread extends Thread {
	Scanner aScanner = new Scanner(System.in);
	String Message;
	BufferedWriter MSGSend = null;
	Socket CSocket;

	public SendThread(Socket CSocket) {
		this.CSocket = CSocket;
	}
	@Override
	public void run() {
		try {
			while(true) {
				MSGSend = new BufferedWriter(new OutputStreamWriter
						(CSocket.getOutputStream())); //���ϰ� �����ϴ� �ڵ�
				//////// Write /////////
				System.out.println("�޼����� �Է����ּ��� : ");
				Message = aScanner.nextLine();
				MSGSend.write(Message+"\n");
				MSGSend.flush();
				//////// Exit /////////
				if (Message.equals("exit")) {
					System.exit(0);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
