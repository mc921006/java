
public class OverRidingTest {
	public static void main(String[] args) {
		Person person = new Person("�ּ�ȫ");
		Professor professor = new Professor("�ּ�ȫ1", "����");
		person.print();
		professor.print();
	}
}

class Person {
	protected String name;
	
	public Person(String aName) {
		this.name = aName;
	}
	protected void print() {
		System.out.println("Person");
		System.out.println("Name : " +name);
		System.out.println();
	}
}

class Professor extends Person {
	private String major;

	public Professor(String aName, String aMajor) {
		super(aName);
		major = aMajor;
	}
	protected void print() {
		System.out.println("professor");
		System.out.println("Name : " +name);
		System.out.println("Major : " +major);
		System.out.println();
	}
}
