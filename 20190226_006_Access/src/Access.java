
public class Access {
	public int publicA;
	protected int protectedA;
	private int privateA;
	int defalutA; //µðÆúÆ®
	
	void SetprivateA(int iNum) {
		if (iNum > 100) {
			privateA = 100;
		}else
			privateA = iNum;
	}
	
	int GetprivateA() {
		return privateA;
	}

}
