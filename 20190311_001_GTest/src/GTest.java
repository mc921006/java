
public class GTest {
	public static void main(String[] args) {
		SumTestInt aSumTestInt = new SumTestInt(3, 4);
		SumTestDouble aSumTestDouble = new SumTestDouble(3.1, 4.1);
		
		SumTest<Integer> aSumTest = new SumTest<Integer>(3, 4);
		SumTest<Double> aSumTest2 = new SumTest<Double>(3.1, 4.1);
		SumTest<Float> aSumTest3 = new SumTest<Float>(3.1f, 4.1f);
		SumTest<String> aSumTest4 = new SumTest<String>("aa", "bb");

		
		System.out.println(aSumTestInt.Run());
		System.out.println(aSumTestDouble.Run());
		System.out.println(aSumTest.Run());
		System.out.println(aSumTest2.Run());
		System.out.println(aSumTest3.Run());
		System.out.println(aSumTest4.Run());
	}
}

class SumTestInt {
	int iX, iY;
	
	SumTestInt(int iX, int iY){
		this.iX = iX;
		this.iY = iY;
	}
	int Run() {
		return iX + iY;
	}
}

class SumTestDouble {
	double iX, iY;
	
	SumTestDouble(double iX, double iY){
		this.iX = iX;
		this.iY = iY;
	}
	double Run() {
		return iX + iY;
	}
}

class SumTest<T> {
	T iX, iY;
	
	SumTest(T iX, T iY){
		this.iX = iX;
		this.iY = iY;
	}
	T Run() {
		return iX;
	}
}