import java.io.*;
import java.net.*;
import java.util.*;

import javax.xml.ws.handler.MessageContext.Scope;

class ChatClient {
	final private String CMDList = "/list";
	final private String EedMessage = "!@#!@#!@#";
	final private String ExitMessage = "/exit";
	final private String MyIP = "192.168.0.26";
	final private int MyPort = 9999;

	private String NicName;
	private Scanner aScanner;
	private Socket cSocket;
	private BufferedReader Receiver;
	PrintWriter Sender;

	public ChatClient() throws UnknownHostException, IOException {

		this.cSocket = new Socket(MyIP, MyPort);
		Receiver = new BufferedReader(
				new InputStreamReader(cSocket.getInputStream()));
		Sender = new PrintWriter(cSocket.getOutputStream(), true); //true �ڵ� flush ���
		ThreadCommu aThreadCommu = new ThreadCommu();
		aThreadCommu.start();
	}
	class ThreadCommu extends Thread {
		private String Message;
		public ThreadCommu() {
			System.out.println("Client ����");

			aScanner = new Scanner(System.in);
			while(true) {
				while(true) {
					System.out.println("�г����� �Է�(3���� �̻�) : ");
					NicName = aScanner.nextLine();
					if (NicName.length() < 3) { //�г��� 3���� �̻�
						System.out.println("3���ڰ� �ƴ��ݾ�! �ٽ�!");
						continue;
					}
					break;
				}//////////////////////////
				//////�ߺ� �г��� ó�� �̿�//////
				// �г����� ���� ����
				Sender.println(NicName);
				// ���� ���� ����
				
				// ���ߺ�?
				// �ߺ� -> while������
				// ���ߺ� -> ä�� ����
				/////////////////////////
			}
		}

		@Override
		public void run() {
			while(true) {
				System.out.println("["+NicName+"] >> ");
				Message = aScanner.nextLine();
				if (Sender.checkError()) {
					System.out.println("���� �̻�");
					break;
				}
				Sender.println(Message);
				//				Sender.flush();
				if (ExitMessage.equals(ExitMessage)) {
					break;
				}
			}
			try {
				Receiver.close();
				Sender.close();
				cSocket.close();
				System.out.println("Ŭ�󸮾�Ʈ ���� ����");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
public class Client {

	public static void main(String[] args) {

	}
}
