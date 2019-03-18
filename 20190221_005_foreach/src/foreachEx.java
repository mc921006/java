
public class foreachEx {
	enum Week {��, ȭ, ��, ��, ��, ��, ��}
	public static void main(String[] args) {
		int [] n = {1, 2, 3, 4, 5};
		int sum = 0;
		for (int i = 0; i < n.length; i++) {
			sum += n[i];
		}
		System.out.println("���� : " + sum);
		
		sum = 0;
		for (int k : n) {
			sum += k;
		}
		System.out.println("(for-each)���� : " + sum);
		
		String names[] = {"���", "��", "�ٳ���", "ü��", "����"};
		for (String s : names) {
			System.out.print(s + " ");
		}
		
		System.out.println();
		for (Week day : Week.values()) {
			System.out.println(day + "���� ");
		}
	}

}

