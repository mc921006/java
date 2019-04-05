import java.util.*;

import org.omg.CORBA.SystemException;

import java.io.*;
import java.net.*;

public class ClientJava {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket CSocket = null;
		BufferedReader Receiver = null;
		String Message;
		String NicName;
		SendThread SThread;
		Scanner aScanner;
		PrintWriter Sender;

		while(true) {
			aScanner = new Scanner(System.in);
			System.out.println("�г��� �Է�(3���� �̻�) : ");
			NicName = aScanner.nextLine();
			if (NicName.length() < 3) {
				System.out.println("Ʋ�Ⱦ� ������");
				continue;
			}
			break;
		}
		CSocket = new Socket("192.168.0.23", 10040);
		Sender = new PrintWriter(CSocket.getOutputStream());
		Sender.println(NicName);
		Sender.flush();
		System.out.println("����");
		
		SThread = new SendThread(Sender, NicName);
		SThread.start();
		Receiver = new BufferedReader(new InputStreamReader
				(CSocket.getInputStream())); 
		while (true) {
			Message = Receiver.readLine();
			System.out.println("[����] :" +Message);
		}///////////////////////////////////////
	}
}
class SendThread extends Thread {
	Scanner aScanner = new Scanner(System.in);
	PrintWriter Sender;
	String NicName;

	public SendThread(PrintWriter Sender, String NicName) {
		this.Sender = Sender;
		this.NicName = NicName;
	}
	@Override
	public void run() {
		String Message;
		while(true) {
			System.out.println("�޼����� �Է����ּ��� : ");
			Message = aScanner.nextLine();
			Sender.println("[ "+NicName + " ]"+ Message);
			Sender.flush();

			if (Message.equals("exit")) {
				System.exit(0);
			}
		}
	}
}
