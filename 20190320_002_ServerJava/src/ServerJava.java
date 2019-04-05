import java.util.*;
import java.io.*;
import java.net.*;

public class ServerJava {
	public static void main(String[] args) {
		ServerSocket RSocket = null; // �Ա���Ű�� ��
		Socket CSocket = null;
		Socket CSocket1 = null;
		String Message;
		
		try {
			RSocket = new ServerSocket(9999);
			System.out.println("[����] ����");
			/////////////////////////
			CSocket = RSocket.accept();
			System.out.println("[����] 1�� ����"+CSocket.getPort() +" "+ CSocket.getLocalPort());
			/////////////////////////
			CSocket1 = RSocket.accept();
			System.out.println("[����] 2�� ����"+CSocket1.getPort() +" "+ CSocket1.getLocalPort());
			/////////////////////////
			RelayThread aRelayThread = new RelayThread(CSocket1, CSocket);
			aRelayThread.start();
			RelayThread aRelayThread1 = new RelayThread(CSocket, CSocket1);
			aRelayThread1.start();
			
			while (true) {
				Thread.sleep(60000);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			try {
				System.out.println("���");
				CSocket.close();
				CSocket1.close();
				RSocket.close();	
			} catch (IOException e2) {
				System.out.println("��� ����");
			}
		}
	}
}

class RelayThread extends Thread {
	Socket FromSocket;
	Socket ToSocket;
	BufferedReader MSGRead = null;
	BufferedWriter MSGSend = null;
	RelayThread(Socket FromSocket, Socket ToSocket) {
		this.FromSocket = FromSocket;
		this.ToSocket =ToSocket; 
	}

	@Override
	public void run() {
		
		try {
			MSGRead = new BufferedReader(new InputStreamReader
					(FromSocket.getInputStream()));
			MSGSend = new BufferedWriter(new OutputStreamWriter
					(ToSocket.getOutputStream()));
			String Message;
			while (true) {
				Message = MSGRead.readLine();
				System.out.println("[Ŭ���̾�Ʈ] :" +Message);
				MSGSend.write(Message + "\n");
				MSGSend.flush();
				if (Message.equals("exit")) {
					System.out.println("Ū ����.");
					System.exit(0);				}
			} 
			
		}catch (IOException e) {

			e.printStackTrace();
		}
	}
}
