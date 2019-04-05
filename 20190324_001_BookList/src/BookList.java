import java.io.IOException;
import java.io.Serializable;

public class BookList implements Serializable{
	public static void main(String[] args) throws Exception {
		
		BookLink Head = null;
		BookLink Temp;
		
		BookManager bookManager = new BookManager();
		bookManager.Run();	
	}
}
