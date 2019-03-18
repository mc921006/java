import java.util.StringTokenizer;

public class StringTokenizerEx {
	public static void main(String[] args) {
		StringTokenizer st; //구분자로 '/' 사용
		st = new StringTokenizer("홍길동/장화=홍령,여고%괴담","/,=%");
		
		while (st.hasMoreElements()) {
			System.out.println(st.nextToken());
		}
	}
}
