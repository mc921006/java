import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreaEx {
	public static void main(String[] args) {
		byte b[] = new byte [6];
		try {
			FileInputStream fin = new FileInputStream("f:\\test.txt");
			int n = 0, c;
			while (true) {
				c = fin.read();
				if (c == -1) {
					break;
				}
				b[n] = (byte)c;
				n++;
			}
			System.out.println("f:\\test.txt에서 읽은 배열을 출력합니다.");
			for (int i = 0; i < b.length; i++) {
				System.out.print(b[i]+" ");
			}
			System.out.println();
			fin.close();
		} catch (IOException e) {
			System.out.println("f:\\test.txt에서 읽지 못했습니다.");
		}
		
	}
}
