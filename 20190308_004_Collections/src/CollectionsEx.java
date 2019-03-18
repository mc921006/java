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
		myList.add("트랜스포머");
		myList.add("사바하");
		myList.add("캡틴마블");
		myList.add(0, "어벤져스");
		myList.add(2, "극한직업");
		printList(myList);
		
		Collections.sort(myList);
		printList(myList);
		
		System.out.print("찾을려는 영화를 적으시요 : ");
		String movie = scanner.next();
		int index = Collections.binarySearch(myList, movie) +1;
		System.out.println(myList +" ["+movie+"]");
		System.out.println("찾으시는"+movie+"는"
				+ " "+index+"번째요소입니다.");
		
		Collections.reverse(myList);
		printList(myList);
		
		
	}
}
