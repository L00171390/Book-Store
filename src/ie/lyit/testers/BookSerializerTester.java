package ie.lyit.testers;

import ie.lyit.book.Menu;
import ie.lyit.serialize.BookSerializer;

public class BookSerializerTester {

	
	
	public static void main(String[] args) {
		
		
		//Week 6
		//Serializer
		BookSerializer bookSerializer= new BookSerializer();
		
		//Add Books to the File
		
	  	//bookSerializer.Add();
		//bookSerializer.Add();
		//bookSerializer.SerializeBooks();
		
		
		//read in the book file and print them
		bookSerializer.DeserializeBooks();
		bookSerializer.List();
		
		
		
		
		//Week7
		
		Menu menu= new Menu();
		
		while(menu.GetOption() !=6) {
			
			menu.display();
			menu.readOption();
			
			switch(menu.GetOption()) {
			
			case(1):
				bookSerializer.Add();
				break;
			case(2):
				bookSerializer.List();
				break;
			case(3):
				bookSerializer.View();
				break;
			case(4):
				bookSerializer.Edit();
				break;
			case(5):
				bookSerializer.Delete();
				break;
			case (6):
				break;
			default:
				System.out.println("Could not read Input, please try again");
				break;
			}
			
			
		}
		
		bookSerializer.SerializeBooks();
		System.out.println("Serialized again");
		
	}
}

