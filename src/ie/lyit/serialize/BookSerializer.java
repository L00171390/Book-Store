package ie.lyit.serialize;

import java.io.*;
import java.util.ArrayList;

import ie.lyit.book.Book;

public class BookSerializer {

	// List of all books
	private ArrayList<Book> books = new ArrayList<>();

	// Path of the books file
	public String bookPath = "books.bin";

	// get user input and add book to list
	public void Add() {

		Book book = new Book();
		book.read();
		books.add(book);
	}

	// Write books in File
	public void SerializeBooks() {

		try {

			// Create new File
			File booksFile = new File(bookPath);

			// Open OutputStreams
			FileOutputStream fileOutPutStream = new FileOutputStream("books.bin");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutPutStream);

			// Write Arraylist books into File
			objectOutputStream.writeObject(books);
			objectOutputStream.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// read books from File
	public void DeserializeBooks() {
		File booksFile = new File(bookPath);

		try {
			// Open InputStreams
			FileInputStream fileInputStream = new FileInputStream(booksFile);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

			// Parse read Data in books Arraylist
			books = (ArrayList<Book>) objectInputStream.readObject();

			// Close InputStreams
			objectInputStream.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// print out the whole books List
	public void List() {

		for (Book book : books) {

			System.out.println(book.toString());
		}
	}

	public Book View() {
		Book searchedBook = null;

		System.out.println("Type in the libraryNumber of the book");
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

		for (Book book : books) {
			if (book.getLibraryNumber() == Integer.parseInt(input)) {

				searchedBook = book;
				
			}
		}
		
		
		if (searchedBook == null) {
			System.out.println("No book with the Number "+ input+ " was found");
		}else {
			System.out.println(searchedBook.toString());
		}
		return searchedBook;
	}

	public void Delete() {
		
		Book deleteBook= View();
		
		if(deleteBook !=null) {
			
			books.remove(deleteBook);
		}
	}
	public void Edit() {
		
		Book editBook= View();
		
		if(editBook !=null) {
			
			int oldBookIndex=books.indexOf(editBook);
		
			editBook.read();
			books.set(oldBookIndex, editBook);
		}
		
	}

}
