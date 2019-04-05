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
		System.out.println(">> ���� ����");
		KeyInput aKeyInput = new KeyInput(ClientList);
		aKeyInput.start();
		
		while (true) {
			System.out.println(">> ������ : "+ClientList.size());
			System.out.println(">> ä�� ���� ���� ��� ��...");
			cSocket = LSocket.accept(); //Ŭ���̾�Ʈ�� ���� ���� ���
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
					MessageSender("["+NicName+"] ����");
					this.ClientList.get(NicName).close(); //Close Sender
					this.Receiver.close(); // Close Receiver
					this.cSocket.close();  // Close Socket
					this.ClientList.remove(NicName); // Remove Client
					System.out.println("������");
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
			
			System.out.println(">> ["+NicName+"] ����"+cSocket.getInetAddress());
			MessageSender("["+NicName+"] ����");
			
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
	//inner class, Ű �Է� thread
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
					System.out.println(">> ���� �����մϴ�.");
					
					synchronized(this.ClientList) {
						for (PrintWriter Sender : ClientList.values()) {
							Sender.println("���� ����");
							Sender.flush();
							Sender.println(EedMessage);
							Sender.flush();
							System.out.println(">> ���� ������...");
							for (int i = 0; i < 100000000; i++) {
								
							}
						}
					}
					System.out.println(">> ���� ����");
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
