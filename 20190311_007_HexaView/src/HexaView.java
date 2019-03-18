import java.io.*;
import java.util.*;

public class HexaView {
	public static void Title() {
		System.out.print("========================");
		System.out.print("========================");
		System.out.print("=========================\n");
		System.out.print(" ADDRESS ");
		for (int i = 0; i < 16; i++) {
			System.out.format("%02X ", i);
		}
		System.out.println("0123456789ABCDEF");
		System.out.print("------------------------");
		System.out.print("------------------------");
		System.out.print("-------------------------");
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner aScanner = new Scanner(System.in);
		String FileName;
		FileInputStream objReadFile;
		//		System.out.format("%08X ", 0); //%X�� 16������ �ٲ���.

		while(true) { //���� ���� ó��
			System.out.print("�о���� ���� ���� �Է��ϼ��� : ");
			FileName = aScanner.nextLine();
			if (FileName.length() == 0) {
				System.out.println("���� ���� �Էµ��� �ʾҽ��ϴ�.");
				continue;
			}
			Title();
			try {
				objReadFile = new FileInputStream(FileName);	
			} catch (FileNotFoundException e) {
				System.out.println("<���> ["+FileName+"] ������ ã�� �� �����ϴ�.");
				continue;
			}
			break;
		}aScanner.close();
		//���� ���� ó�� ��

		byte bData[] = new byte[16]; //����
		try {
			int iLine = 0;
			int iGet; //������ ���� ��
			while(true) {
				iGet = objReadFile.read(bData);
				if(iGet == -1) {
					break;
				}
				System.out.format("%08X ", iLine); // �ּ� ���

				////�� ���/////////
				////�� ��� : ���////
				for (int i = 0; i < 16; i++) {
					if (iGet > i) { //16������ ���� �� ���� �ذ�
						System.out.format("%02X ", bData[i]);	
					}else {
						System.out.print("   ");
					}
				}
				////�� ��� : �ƽ�Ű�ڵ�////
				for (int i = 0; i < 16; i++) {
					if (iGet <= i) { //16������ ���� �� ���� �ذ�
						System.out.println("  ");
						continue;
					}
					if (' ' > (char)bData[i]) {
						System.out.print('.');
					}else {
						System.out.print((char)bData[i]);
					}
				}
				System.out.println();
				iLine += 16;
			}objReadFile.close();

		} catch (IOException e) {
			System.out.println("["+FileName+"]�� ���� ���߽��ϴ�.");
		}


	}
}
