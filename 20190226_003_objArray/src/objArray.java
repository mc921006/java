
public class objArray {

	public static void main(String[] args) {
		ObjTest myobjtest = new ObjTest();
		ObjTest [] myobjArray = new ObjTest[5];
		System.out.println();
		for (int i = 0; i < myobjArray.length; i++) {
			myobjArray[i] = new ObjTest();
		}
	}

}

class ObjTest{
	
	ObjTest() {
		System.out.println("objtest »ý¼ºÀÚ");
	}
}
