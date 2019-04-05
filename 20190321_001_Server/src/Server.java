import java.io.*;
import java.net.*;
import java.util.*;

import javax.sound.midi.Receiver;
import javax.xml.ws.handler.MessageContext.Scope;

class ChatServer {
	HashMap<String, PrintWriter> ClientList;
	private String ServerIP;
	private int ServerPort;
	ServerSocket LSocket;
	
	final private String CMDList = "/list";
	final private String EedMessage = "!@#!@#!@#";
	final private String ExitMessage = "/exit";
	final private String MyIP = "192.168.0.26";
	final private int MyPort = 9999;

	ChatServer(){
		Init(MyIP, MyPort);

	}
	ChatServer(String ServerIP){
		Init(ServerIP, MyPort);
	}
	ChatServer(int ServerPort){
		Init(MyIP, ServerPort);
	}
	ChatServer(String ServerIP, int ServerPort){
		Init(ServerIP, ServerPort);
	}
	private void Init(String ServerIP, int ServerPort) 
	{ 
		SetIP(ServerIP);
		SetPort(ServerPort);
		ClientList = new HashMap<String, PrintWriter>();
	} 
	void SetIP(String ServerIP) {
		this.ServerIP = ServerIP;
	}
	void SetPort(int ServerPort) {
		this.ServerPort = ServerPort;
	}

	void Run() throws IOException {
		Socket cSocket = new Socket();
		ThreadClient aThreadClient;
		LSocket = new ServerSocket(MyPort);
		System.out.println(">> 서버 시작");
		KeyInput aKeyInput = new KeyInput(ClientList);
		aKeyInput.start();
		
		while (true) {
			System.out.println(">> 접속자 : "+ClientList.size());
			System.out.println(">> 채팅 서버 접속 대기 중...");
			cSocket = LSocket.accept(); //클라이언트로 부터 접속 대기
			aThreadClient = new ThreadClient(cSocket, ClientList);
			aThreadClient.start();
			}
	}
	class ThreadClient extends Thread{
		HashMap<String, PrintWriter> ClientList;
		BufferedReader Receiver;
		String NicName;
		Socket cSocket;
		final private String ExitMessage = "/exit";
		
		@Override
		public void run() {
			String Message;

			try {
				while (true) {
					Message = this.Receiver.readLine();
					if (Message == null) {
						break;
					}
					if (Message.equals(ExitMessage)) {
						break;
					}
					MessageSender("["+NicName +"] "+Message);
					System.out.println(">> ["+NicName+"] " + Message);
				}
				synchronized (this.ClientList) {
					MessageSender("["+NicName+"] 나감");
					this.ClientList.get(NicName).close(); //Close Sender
					this.Receiver.close(); // Close Receiver
					this.cSocket.close();  // Close Socket
					this.ClientList.remove(NicName); // Remove Client
					System.out.println("나감요");
				}
			}catch (IOException e) {
				e.printStackTrace();

			}
		}

		public ThreadClient(Socket cSocket, HashMap<String, PrintWriter> ClientList) throws IOException {
			this.cSocket= cSocket; 
			this.ClientList = ClientList;
			this.Receiver = new BufferedReader(
					new InputStreamReader(cSocket.getInputStream()));
			PrintWriter Sender = new PrintWriter(cSocket.getOutputStream());
			NicName = this.Receiver.readLine();
			
			System.out.println(">> ["+NicName+"] 입장"+cSocket.getInetAddress());
			MessageSender("["+NicName+"] 입장");
			
			synchronized(this.ClientList) {
				this.ClientList.put(NicName, Sender);
			}
			
			this.ClientList.put(NicName, Sender);
		
		}

		void MessageSender(String Message) {
			
			synchronized(this.ClientList) {
				for (PrintWriter Sender : ClientList.values()) {
					Sender.println(Message);
					Sender.flush();
				}
			}
		}
	}
	//inner class, 키 입력 thread
	class KeyInput extends Thread{ 
		HashMap<String, PrintWriter> ClientList;
		Scanner aScanner = new Scanner(System.in);
		public KeyInput(HashMap<String, PrintWriter> ClientList) {
			this.ClientList = ClientList;
		}
		@Override
		public void run() {
			String Message;
			while(true) {
//				System.out.print(">> ");
				Message = aScanner.nextLine();
				if (ExitMessage.equals(Message)) {
					System.out.println(">> 서버 종료합니다.");
					
					synchronized(this.ClientList) {
						for (PrintWriter Sender : ClientList.values()) {
							Sender.println("서버 종료");
							Sender.flush();
							Sender.println(EedMessage);
							Sender.flush();
							System.out.println(">> 서버 종료중...");
							for (int i = 0; i < 100000000; i++) {
								
							}
						}
					}
					System.out.println(">> 서버 종료");
					System.exit(0);
				}
			}
		}
	}
}

public class Server {
	public static void main(String[] args) throws IOException {
		ChatServer aChatServer = new ChatServer();
		aChatServer.Run();
	}
}
