import java.io.*;

public class FileReadHangulSuccess {
	public static void main(String[] args) {
		InputStreamReader in = null;
		FileInputStream fin = null;
		try {
			fin = new FileInputStream("f:\\test.txt");
			in = new InputStreamReader(fin, "MS949");
			int c;
			
			System.out.println("����� ���� ������ " + in.getEncoding());
			while (true) {
				c = in.read();
				if (c == -1) {
					break;
				}
				System.out.print((char)c);
			}
			in.close();
			fin.close();
		} catch (IOException e) {
			System.out.println("����� ����");
		}
	}
}
