public class Gugu4 {
	public static void main(String[] args) {
		int iDan;
		int iCnt;

		for(iDan = 1; 10>iDan; ++iDan) {
			for (iCnt = 1; iCnt < 10; iCnt++) {
				System.out.print(iDan+"*"+iCnt+"="+iDan*iCnt);
				System.out.print("\t");
			}
			System.out.println();
		}
	}
}
