import java.util.*;
import java.io.*;
import java.net.*;

public class ServerJava {
	public static void main(String[] args) throws IOException, InterruptedException {
		ServerSocket RSocket = null; // �Ա���Ű�� ��
		Socket CSocket = null;
		PrintWriter Sender;
		BufferedReader Receiver;
		String Message;
		String NicName;
		HashMap<String , PrintWriter> ClientList;
		ClientThread ThreadTemp;

		RSocket = new ServerSocket(9999);
		ClientList = new HashMap<String, PrintWriter>();
		System.out.println("> ����");

		while(true) {
			System.out.println("> ������");
			CSocket = RSocket.accept();
			Sender = new PrintWriter(CSocket.getOutputStream());
			Receiver = new BufferedReader(new InputStreamReader
					(CSocket.getInputStream()));
			NicName = Receiver.readLine();
			System.out.println("> ���� ��...");
			//�г��� �ߺ� ����
			if (ClientList.containsKey(NicName) == true) {
				Sender.println("�г��� �ߺ�");
				Sender.flush();
				CSocket.close();
				continue;
			}
			//�г��� ���� Ȯ��
			if (NicName.length() < 3) {
				Sender.println("��� ����");
				Sender.flush();
				CSocket.close();
				continue;
			}
			ClientList.put(NicName, Sender);
			System.out.println("> ["+NicName+"] ����");
			ThreadTemp = new ClientThread(NicName, Receiver, ClientList);
			ThreadTemp.start();
		}
	}
}

class ClientThread extends Thread {
	HashMap<String , PrintWriter> ClientList;
	BufferedReader Receiver;
	String NicName;

	ClientThread (String NicName, BufferedReader Receiver, HashMap<String , PrintWriter> ClientList) throws IOException{

		this.ClientList = ClientList;
		this.Receiver =  Receiver;
		this.NicName = NicName;
	}

	@Override
	public void run() {
		String Message;

		try {
			while(true) {
				Message = Receiver.readLine();
				if (Message.equals("["+NicName+"]"+"exit")) {
					Receiver.close();
					
					synchronized(ClientList) {
						ClientList.remove(NicName);
					}
					break;
				}
				for (PrintWriter Temp : ClientList.values()){
					Temp.println(Message);
					Temp.flush();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("> "+NicName+"����");
	}
}
