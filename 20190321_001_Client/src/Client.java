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
		Sender = new PrintWriter(cSocket.getOutputStream(), true); //true 자동 flush 기능
		ThreadCommu aThreadCommu = new ThreadCommu();
		aThreadCommu.start();
	}
	class ThreadCommu extends Thread {
		private String Message;
		public ThreadCommu() {
			System.out.println("Client 시좍");

			aScanner = new Scanner(System.in);
			while(true) {
				while(true) {
					System.out.println("닉네임을 입력(3글자 이상) : ");
					NicName = aScanner.nextLine();
					if (NicName.length() < 3) { //닉네임 3글자 이상
						System.out.println("3글자가 아니잖어! 다시!");
						continue;
					}
					break;
				}//////////////////////////
				//////중복 닉네임 처리 미완//////
				// 닉네임을 서버 전송
				Sender.println(NicName);
				// 서버 응답 수신
				
				// 노중복?
				// 중복 -> while문으로
				// 노중복 -> 채팅 ㄱㄱ
				/////////////////////////
			}
		}

		@Override
		public void run() {
			while(true) {
				System.out.println("["+NicName+"] >> ");
				Message = aScanner.nextLine();
				if (Sender.checkError()) {
					System.out.println("서버 이상");
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
				System.out.println("클라리언트 접속 종료");
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
