public class ShapeTest {
	public static void main(String[] args) {
		ShapeRect rRect1 = new ShapeRect();
		ShapeRect rRect2 = new ShapeRect(10, 20);

		System.out.println("rRect1�� ���� : "+rRect1.GetArea());
		System.out.println("rRect2�� ���� : "+rRect2.GetArea());
	}
}

class ShapeRect {
	public int width;
	public int height;
	
	// �����ε� : �޼ҵ� �̸��� ���������� �Ű�����/����/�μ��� �����Ǵ� �޼ҵ�
	//������ �޼ҵ� �����ε�
	// ���ڰ� ���� ������(����Ʈ ������)
	public ShapeRect() { //������ : 1.Ŭ������ �̸��� ���� / 2. ��ȯ���� ����.
		width = 0;
		height = 0;
	}
	
	// ���ڰ� �ִ� ������
	//������ : 1.Ŭ������ �̸��� ���� / 2. ��ȯ���� ����.
	public ShapeRect(int iw, int ih) { 
		width = iw;
		height = ih;
	}

	public int GetArea() {
		return width*height;
	}
}
