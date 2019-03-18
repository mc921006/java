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
		//		System.out.format("%08X ", 0); //%X는 16진수로 바꿔줌.

		while(true) { //파일 열기 처리
			System.out.print("읽어들일 파일 명을 입력하세요 : ");
			FileName = aScanner.nextLine();
			if (FileName.length() == 0) {
				System.out.println("파일 명을 입력되지 않았습니다.");
				continue;
			}
			Title();
			try {
				objReadFile = new FileInputStream(FileName);	
			} catch (FileNotFoundException e) {
				System.out.println("<경고> ["+FileName+"] 파일을 찾을 수 없습니다.");
				continue;
			}
			break;
		}aScanner.close();
		//파일 열기 처리 끝

		byte bData[] = new byte[16]; //버퍼
		try {
			int iLine = 0;
			int iGet; //실제로 읽은 수
			while(true) {
				iGet = objReadFile.read(bData);
				if(iGet == -1) {
					break;
				}
				System.out.format("%08X ", iLine); // 주소 출력

				////값 출력/////////
				////값 출력 : 헥사////
				for (int i = 0; i < 16; i++) {
					if (iGet > i) { //16개보다 적을 시 오류 해결
						System.out.format("%02X ", bData[i]);	
					}else {
						System.out.print("   ");
					}
				}
				////값 출력 : 아스키코드////
				for (int i = 0; i < 16; i++) {
					if (iGet <= i) { //16개보다 적을 시 오류 해결
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
			System.out.println("["+FileName+"]을 읽지 못했습니다.");
		}


	}
}
