class T1 
{ T1(){System.out.println("T1...");}} 
class T2 
{ T2(){System.out.println("T2...");}} 
class T3 
{ T3(){System.out.println("T3...");}} 
class T4 
{ T4(){System.out.println("T4...");}} 
class T5 
{ T5(){System.out.println("T5...");}} 

public class ObjectTest 
{ 
	public static void main(String[] TT) 
	{ 
		Object[] VObj = new Object[5]; 
		VObj[0] = new T1(); 
		VObj[1] = new T2(); 
		VObj[2] = new T3(); 
		VObj[3] = new T4(); 
		VObj[4] = new T5(); 

		int iCnt = 0; 
		for(Object temp : VObj) 
		{ 
			if(temp instanceof T3) 
			{ 
				System.out.println("array["+iCnt+"] is instanceof T3"); 
				break; 
			} 
			++iCnt; 
		} 

	} 

}