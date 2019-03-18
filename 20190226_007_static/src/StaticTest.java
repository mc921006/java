
public class StaticTest {
	public static void main(String[] args) {
		Product.iNum = 1000;
		
		Product rProduct1 = new Product();
		rProduct1.Time = "4시 11분 50초";
		rProduct1.print();
		
		Product rProduct2 = new Product();
		rProduct2.Time = "4시 15분 20초";
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
		System.out.println("제품 번호 : "+iNum+"\n시간 : "+Time);
	}
}

