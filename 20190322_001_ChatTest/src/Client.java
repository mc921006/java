import java.io.*;
import java.net.*;
import java.util.*;

class ChatClient {
	final private String MSGEnd = "!@#!@#!@#";
	final private String MSGExit = "/exit";
	final private String MSGError = "^^^error^^^" ;
	final private String MSGOk = "===ok===" ;
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
		///// �۽ź� ó�� /////
		ThreadCommu aThreadCommu = new ThreadCommu();
		aThreadCommu.start();

		///// ���ź� ó�� /////
		String Message;
		while(true) {
			try {
			Message = Receiver.readLine();
			}
			catch (SocketException e) { // ���� ������ ����
				Message = MSGEnd;
			}
			if (Message.equals(MSGEnd)) {
				Receiver.close();
				Sender.close();
				cSocket.close();
				System.out.println("���� �����Ѵ�. ����");
				break;
			}
			System.out.println(Message);
		}
	}
	class ThreadCommu extends Thread {
		private String Message;
		public ThreadCommu() throws IOException {
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
				Message = Receiver.readLine();
				if (Message.equals(MSGError)) { // �ߺ� -> while������
					System.out.println("�ߺ� �г����� �ٲ�");
					continue;
				}else { // ���ߺ� -> ä�� ����
					System.out.println("ä�� ����~~");
				}
				break;
				/////////////////////////
			}
		}

		@Override
		public void run() {
			while(true) {
				System.out.print("["+NicName+"] >> ");
				Message = aScanner.nextLine();
				if (Sender.checkError()) {
					System.out.println("���� �̻�");
					break;
				}
				Sender.println(Message);
				if (Message.equals(MSGExit)) {
					break;
				}
			}
			try {
				Receiver.close();
				Sender.close();
				cSocket.close();
				System.out.println("Ŭ�󸮾�Ʈ ���� ����");
				System.exit(0);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		ChatClient chatClient = new ChatClient();
	}
}
