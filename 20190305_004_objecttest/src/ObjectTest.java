
public class ObjectTest {
	public static void main(String[] args) {
		NotOver aNotOver = new NotOver();
		System.out.println(aNotOver);
		Over aOver = new Over();
		System.out.println(aOver);
		
		String aString = aOver.getClass().getName();
		System.out.println(aString);
		
		Object objectTest;
		objectTest = aNotOver;
		System.out.println(objectTest);
		objectTest = aOver;
		System.out.println(objectTest);
	}
}

class NotOver{
	
}

class Over{
	public String toString() {
		return "���� toString�� �������̵��� �޼ҵ��Դϴ�.";
	}
}