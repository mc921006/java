import java.util.Vector;

public class VectorEx {
	public static void main(String[] args) {
		//���� ���� �ٷ�� ���� ����
		Vector<Integer> v = new Vector<Integer>();
		System.out.println(v.size()+" "+v.capacity());
		v.add(5);
		v.add(4);
		v.add(-1);
		
		v.add(2, 100);//���� �߰��� ����. 4�� -1 ���̿� 100 ����
		
		System.out.println("���� ���� ��� ��ü�� : "+v.size());
		System.out.println("������ ���� �뷮 : "+v.capacity());

		//��� ��� ���� ���
		for (int i = 0; i < v.size(); i++) {
			int n = v.get(i); //������ i ��° ����
			System.out.println(n);
		}
		//���� ���� ��� ���� ���ϱ�
		int sum = 0;
		for (int i = 0; i < v.size(); i++) {
			int n = v.elementAt(i);
			sum += n;
		}
		v.add(99);
		v.add(12);
		v.add(5);
		v.add(5);
		v.add(5);
		v.add(5);
		v.add(5);
		
		System.out.println("���� ���� ��� ��ü�� : "+v.size());
		System.out.println("������ ���� �뷮 : "+v.capacity());
		System.out.println("���Ϳ� �ִ� ���� �� : "+ sum);
	}
}
