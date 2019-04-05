import java.util.*;
import java.io.*;
import java.net.*;

public class ServerJave {
	public static void main(String[] args) {
		Scanner aScanner = new Scanner(System.in);
		ServerSocket RSocket = null; // 입구지키는 개
		Socket CSocket = null;
		BufferedReader MSGRead = null;
		String Message;
		System.out.println("서버 시작");
		try {
			//포트번호 : 1024~65535
			System.out.println("가드 옷 입는 중");
			RSocket = new ServerSocket(9999);
			System.out.println("가드 서 있는 중");
			System.out.println("손님 아직 노입장");
			CSocket = RSocket.accept();
			System.out.println("손님 입장");
			MSGRead = new BufferedReader(new InputStreamReader(CSocket.getInputStream())); 
			while (true) {
				Message = MSGRead.readLine();
				System.out.println("[클라이언트] :" +Message);
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
