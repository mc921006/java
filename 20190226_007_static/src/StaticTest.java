
public class StaticTest {
	public static void main(String[] args) {
		Product.iNum = 1000;
		
		Product rProduct1 = new Product();
		rProduct1.Time = "4�� 11�� 50��";
		rProduct1.print();
		
		Product rProduct2 = new Product();
		rProduct2.Time = "4�� 15�� 20��";
		rProduct2.print();
	}
}

class Product {
	static int iNum;
	String Time;
	
	Product() {
		++iNum;
	}
	
	void print() {
		System.out.println("��ǰ ��ȣ : "+iNum+"\n�ð� : "+Time);
	}
}

