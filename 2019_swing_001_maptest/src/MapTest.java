
public class MapTest {
	public static void main(String[] args) {
		/*String Line1 = "1234567890";
		char [] Line1Array = Line1.toCharArray();
		for (int iCnt = 0; iCnt < Line1Array.length; iCnt++) {
			System.out.printf("[%c]", Line1Array[iCnt]);
		}*/
		String [] Smap1 = {
							"##############",
							"##############",
							"##############",
							"##############",
							"##############",
							"##############",
							"##############",
							"##############",
							"##############",
							"##############"
						};
		
		char [][] Map1 = new char[14][10];
		for (int i = 0; i < Smap1.length; i++) {
			Map1[i] = Smap1[i].toCharArray();	
		}
		
		for (int iCnt = 0; iCnt < Map1[0].length; iCnt++) {
			System.out.printf("[%c]", Map1[0][iCnt]);
		}
		return;
	}
}
