import java.util.*;
import java.io.*;
import java.net.*;

public class ServerJava {
	public static void main(String[] args) {
		ServerSocket RSocket = null; // 입구지키는 개
		Socket CSocket = null;
		BufferedReader MSGRead = null;
		String Message;
		SendThread SThread;
		System.out.println("서버 시작");
		try {
			//포트번호 : 1024~65535
			System.out.println("가드 옷 입는 중");
			RSocket = new ServerSocket(9999);
			System.out.println("가드 서 있는 중");
			System.out.println("손님 아직 노입장");
			CSocket = RSocket.accept();
			System.out.println("손님 입장"+CSocket.getPort() +" "+ CSocket.getLocalPort());
			SThread = new SendThread(CSocket);
			SThread.start();
			MSGRead = new BufferedReader(new InputStreamReader
					(CSocket.getInputStream())); 
			while (true) {
				/////// Read ///////
				Message = MSGRead.readLine();
				System.out.println("[클라이언트] :" +Message);
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
				System.out.println("폐쇄");
				CSocket.close();
				RSocket.close();	
			} catch (IOException e2) {
				System.out.println("통신 오류");
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
						(CSocket.getOutputStream())); //소켓과 연결하는 코드
				//////// Write /////////
				System.out.println("메세지를 입력해주세요 : ");
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
