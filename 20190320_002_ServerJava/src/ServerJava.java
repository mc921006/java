import java.util.*;
import java.io.*;
import java.net.*;

public class ServerJava {
	public static void main(String[] args) {
		ServerSocket RSocket = null; // 입구지키는 개
		Socket CSocket = null;
		Socket CSocket1 = null;
		String Message;
		
		try {
			RSocket = new ServerSocket(9999);
			System.out.println("[서버] 시작");
			/////////////////////////
			CSocket = RSocket.accept();
			System.out.println("[서버] 1번 입장"+CSocket.getPort() +" "+ CSocket.getLocalPort());
			/////////////////////////
			CSocket1 = RSocket.accept();
			System.out.println("[서버] 2번 입장"+CSocket1.getPort() +" "+ CSocket1.getLocalPort());
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
				System.out.println("폐쇄");
				CSocket.close();
				CSocket1.close();
				RSocket.close();	
			} catch (IOException e2) {
				System.out.println("통신 오류");
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
				System.out.println("[클라이언트] :" +Message);
				MSGSend.write(Message + "\n");
				MSGSend.flush();
				if (Message.equals("exit")) {
					System.out.println("큭 죽음.");
					System.exit(0);				}
			} 
			
		}catch (IOException e) {

			e.printStackTrace();
		}
	}
}
