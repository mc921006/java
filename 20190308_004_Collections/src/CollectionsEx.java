import java.util.*;

public class CollectionsEx {
	static void printList(LinkedList<String> l) {
		Iterator<String> iterator = l.iterator();
		while (iterator.hasNext()) {
			String e = iterator.next();
			String separator;
			if (iterator.hasNext()) {
				separator = "->";
			}
			else {
				separator = "\n";
			}
			System.out.print(e+separator);
		}
	}
	public static void main(String[] args) {
		LinkedList<String> myList = new LinkedList<String>();
		Scanner scanner = new Scanner(System.in);
		myList.add("Ʈ��������");
		myList.add("�����");
		myList.add("ĸƾ����");
		myList.add(0, "�����");
		myList.add(2, "��������");
		printList(myList);
		
		Collections.sort(myList);
		printList(myList);
		
		System.out.print("ã������ ��ȭ�� �����ÿ� : ");
		String movie = scanner.next();
		int index = Collections.binarySearch(myList, movie) +1;
		System.out.println(myList +" ["+movie+"]");
		System.out.println("ã���ô�"+movie+"��"
				+ " "+index+"��°����Դϴ�.");
		
		Collections.reverse(myList);
		printList(myList);
		
		
	}
}
