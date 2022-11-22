package ie.lyit.book;

import java.awt.font.NumericShaper;
import java.io.*;

public class Menu {

	private int option = 0;

	public int GetOption() {

		return option;
	}

	public void display() {

		System.out.println("Book Menu\r\n");
		System.out.println("1. Add");
		System.out.println("2. List");
		System.out.println("3. View");
		System.out.println("4. Edit");
		System.out.println("5. Delete");
		System.out.println("6. Quit");

	}

	public void readOption() {

		System.out.println("Please enter the number of option");
		// Enter data using BufferReader
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// Reading data using readLine
		String input = "";
		try {
			input = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			// Printing the read line
			this.option = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			//e.printStackTrace();
		}
	}
}
