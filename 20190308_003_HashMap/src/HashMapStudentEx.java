import java.util.*;

public class HashMapStudentEx {
	public static void main(String[] args) {
		HashMap<String, Student> map = new HashMap<String, Student>();
		map.put("Ȳ����", new Student(1, "010-1111-1111"));
		map.put("������", new Student(2, "010-2222-2222"));
		map.put("�ڱ���", new Student(3, "010-3333-3333"));
		
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("�˻��� �̸� ? ");
			String name = scanner.nextLine();
			if (name.equals("exit")) {
				break;
			}
			Student student = map.get(name);
			if (student == null) {
				System.out.println(name + "�� �����ϴ�.");
			}else {
				System.out.println("id : " +student.getId()
				 + ", tel : " + student.getTel());
			}
		}
		scanner.close();
	}
}

class Student{
	private int id;
	private String tel;
	public Student(int id, String tel) {
		this.id = id;
		this.tel = tel;
	}
	public int getId() {
		return id;
	}
	public String getTel() {
		return tel;
	}
}
