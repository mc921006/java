
public class MyStack {
	public static void main(String[] args) {
		GStack<String> stringStack = new GStack<String>();
		
		stringStack.puch("서울");
		stringStack.puch("부산");
		stringStack.puch("에이");
		
		for (int i = 0; i < 3; i++) {
			System.out.println(stringStack.pop());
		}
		GStack<Integer> intStack = new GStack<Integer>();
		
		intStack.puch(1);
		intStack.puch(3);
		intStack.puch(5);
		
		for (int i = 0; i < 3; i++) {
			System.out.println(intStack.pop());
		}
	}
}

class GStack<T> {
	int tos;
	Object[] stck;
	public GStack() {
		tos = 0;
		stck = new Object[10];
	}
	
	public void puch(T item) {
		if (tos == 10) {
			return;
		}
		stck[tos] = item;
		tos++;
	}
	public T pop() {
		if (tos == 0) {
			return null;
		}
		tos--;
		return (T)stck[tos];
	}
}
