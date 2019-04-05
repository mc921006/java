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
		Sender = new PrintWriter(cSocket.getOutputStream(), true); //true 자동 flush 기능
		///// 송신부 처리 /////
		ThreadCommu aThreadCommu = new ThreadCommu();
		aThreadCommu.start();

		///// 수신부 처리 /////
		String Message;
		while(true) {
			try {
			Message = Receiver.readLine();
			}
			catch (SocketException e) { // 서버 비정상 죽음
				Message = MSGEnd;
			}
			if (Message.equals(MSGEnd)) {
				Receiver.close();
				Sender.close();
				cSocket.close();
				System.out.println("서버 종료한다. 가라");
				break;
			}
			System.out.println(Message);
		}
	}
	class ThreadCommu extends Thread {
		private String Message;
		public ThreadCommu() throws IOException {
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
				Message = Receiver.readLine();
				if (Message.equals(MSGError)) { // 중복 -> while문으로
					System.out.println("중복 닉네임임 바꿔");
					continue;
				}else { // 노중복 -> 채팅 ㄱㄱ
					System.out.println("채팅 시좍~~");
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
					System.out.println("서버 이상");
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
				System.out.println("클라리언트 접속 종료");
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
