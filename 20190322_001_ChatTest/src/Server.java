import java.io.*;
import java.net.*;
import java.util.*;
import java.util.function.IntUnaryOperator;

import javax.sound.midi.Receiver;
import javax.xml.ws.handler.MessageContext.Scope;

class ChatServer {
	HashMap<String, PrintWriter> ClientList;
	private String ServerIP;
	private int ServerPort;
	ServerSocket LSocket;

	final private String CMDList = "/list";
	final private String MSGEnd = "!@#!@#!@#";
	final private String MSGExit = "/exit";
	final private String MSGError = "^^^error^^^" ;
	final private String MSGOk = "===ok===" ;
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
		final private String MSGExit = "/exit";

		@Override
		public void run() {
			String Message;
			
				while (true) {
					try {
						Message = this.Receiver.readLine();
					}
					catch (SocketException e) {
						Message = MSGExit;
					}
					catch (IOException e) {
						Message = MSGExit;
					}
					if (Message == null) {
						break;
					}
					if (Message.equals(MSGExit)) {
						break;
					}
					MessageSender(Message);
					System.out.println(">> ["+NicName+"] " + Message);
				}
				synchronized (this.ClientList) {
					MessageSender("["+NicName+"] ����");
					this.ClientList.get(NicName).close(); //Close Sender
					try {
					this.Receiver.close(); // Close Receiver
					this.cSocket.close();  // Close Socket
					} catch (IOException e) {
						e.printStackTrace();
					}
					this.ClientList.remove(NicName); // Remove Client
					System.out.println(">> ["+NicName+" ������");
				}
		}

		public ThreadClient(Socket cSocket, HashMap<String, PrintWriter> ClientList) throws IOException {
			this.cSocket= cSocket; 
			this.ClientList = ClientList;
			this.Receiver = new BufferedReader(
					new InputStreamReader(cSocket.getInputStream()));
			PrintWriter Sender = new PrintWriter(cSocket.getOutputStream(), true);

			while(true) {
				try {
				// Ŭ���̾�Ʈ �г��� ����
				NicName = this.Receiver.readLine();
				} catch (SocketException e) {
					interrupt();
				}
				// �ߺ� ���� �Ǵ�
				PrintWriter Temp;
				synchronized(this.ClientList) {
					Temp = this.ClientList.get(NicName);
				}
				if (Temp != null) { //�ߺ���.
					// �ߺ� �۽�
					Sender.println(MSGError);
					continue;
				}
				else { // ���ߺ�
					Sender.println(MSGOk);
				}
				/////////////////////////
				break;
			}
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
				if (MSGExit.equals(Message)) {
					System.out.println(">> ���� �����մϴ�.");

					synchronized(this.ClientList) {
						for (PrintWriter Sender : ClientList.values()) {
							Sender.println("���� ����");
							Sender.println(MSGEnd);
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
