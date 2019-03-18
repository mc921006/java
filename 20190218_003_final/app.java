public class app{
	public static void main(String[] args){
		final double PI = 3.141592;
		//PI = 3.14;
		boolean a = true;
		boolean b = false;
		String toolName = "JDK";
		char c1= 'a',c2 = 'b',c3 = 'c';
		int n = 15, m = 015, k = 0x15, o = 0b0101;
		double e = 1234E-4;
		char a1 = '한', a2 = '글';
		//char a3 = \u0041;
		boolean b1 = 10 > 0;
		int n1 = 812;
		byte bn = (byte)n1;
		double d = 1.9;
		int nn = (int)d;
		System.out.println(PI);
		System.out.println(a);
		System.out.println(b);
		System.out.println(toolName+1.8+"이 출시됨.");
		System.out.println("("+3+","+5+")");
		System.out.println(c1 +" "+ c2 +" "+ c3);
		System.out.println(n+" "+m+" "+k+" "+o);
		System.out.println(e);
		System.out.println(a1+""+a2);
		System.out.println(b1);
		//System.out.println(a3);
		System.out.println(bn);
		System.out.println(nn);
	}
}