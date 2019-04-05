import java.util.*;
import java.io.*;
import java.net.*;

public class ClientJava {
	public static void main(String[] args) {
		Scanner aScanner = new Scanner(System.in);
		Socket CSocket = null;
		BufferedWriter MSGSend = null;
		String Message;
		System.out.println("클라이언트 시작");
		try {
			//포트번호 : 1024~65535
			System.out.println("클라이언트 옷 입는 중");
			CSocket = new Socket("192.168.0.26", 9999);
			System.out.println("클라이언트 입장");
			MSGSend = new BufferedWriter(new OutputStreamWriter
					(CSocket.getOutputStream())); //소켓과 연결하는 코드
			while (true) {
				System.out.println("메세지를 입력해주세요 : ");
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
				System.out.println("클라이언트 퇴장");
				CSocket.close();
			} catch (IOException e2) {
				System.out.println("통신 오류");
			}
		}
	}
}
