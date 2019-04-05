import java.util.*;
import java.io.*;
import java.net.*;

public class ServerJava {
	public static void main(String[] args) throws IOException, InterruptedException {
		ServerSocket RSocket = null; // 입구지키는 개
		Socket CSocket = null;
		PrintWriter Sender;
		BufferedReader Receiver;
		String Message;
		String NicName;
		HashMap<String , PrintWriter> ClientList;
		ClientThread ThreadTemp;

		RSocket = new ServerSocket(9999);
		ClientList = new HashMap<String, PrintWriter>();
		System.out.println("> 시작");

		while(true) {
			System.out.println("> 대기상태");
			CSocket = RSocket.accept();
			Sender = new PrintWriter(CSocket.getOutputStream());
			Receiver = new BufferedReader(new InputStreamReader
					(CSocket.getInputStream()));
			NicName = Receiver.readLine();
			System.out.println("> 접송 중...");
			//닉네임 중복 제거
			if (ClientList.containsKey(NicName) == true) {
				Sender.println("닉네임 중복");
				Sender.flush();
				CSocket.close();
				continue;
			}
			//닉네임 길이 확인
			if (NicName.length() < 3) {
				Sender.println("어딜 들어와");
				Sender.flush();
				CSocket.close();
				continue;
			}
			ClientList.put(NicName, Sender);
			System.out.println("> ["+NicName+"] 접속");
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
		System.out.println("> "+NicName+"종료");
	}
}
