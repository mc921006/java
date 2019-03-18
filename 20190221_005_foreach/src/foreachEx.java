
public class foreachEx {
	enum Week {월, 화, 수, 목, 금, 토, 일}
	public static void main(String[] args) {
		int [] n = {1, 2, 3, 4, 5};
		int sum = 0;
		for (int i = 0; i < n.length; i++) {
			sum += n[i];
		}
		System.out.println("합은 : " + sum);
		
		sum = 0;
		for (int k : n) {
			sum += k;
		}
		System.out.println("(for-each)합은 : " + sum);
		
		String names[] = {"사과", "배", "바나나", "체리", "딸기"};
		for (String s : names) {
			System.out.print(s + " ");
		}
		
		System.out.println();
		for (Week day : Week.values()) {
			System.out.println(day + "요일 ");
		}
	}

}

