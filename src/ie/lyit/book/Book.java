package ie.lyit.book;
import java.util.*;
import java.io.*;
import javax.swing.*;

public class Book implements Serializable{
   private String name;  			////////////////////////
   private String isbnNumber;		// Instance Variables //
   private String author;  		////////////////////////
   private String publishingCompany;
   private int libraryNumber;   
	
	private static int nextNumber=1000;	// static for unique number - starts off at 1000
	
	// Default Constructor - set Instance Variables to null
	public Book(){
		name=isbnNumber=author=publishingCompany="";

		// Set number to static nextNumber before incrementing nextNumber
 		libraryNumber=nextNumber++;
	}
	
	// Initialisation Constructor
	public Book(String name, String isbnNumber, String author, String publishingCompany){
		this.name = name;
		this.isbnNumber = isbnNumber;;
		this.author = author;
		this.publishingCompany = publishingCompany;      
		// Set number to static nextNumber before incrementing nextNumber
 		libraryNumber=nextNumber++;
	}

	// toString() method for displaying a Book objects
	// Display Book object as 
	//         "BOOK 100001:Clean Code by Robert Martin [ISBN 978-0132350884 PUBLISHER Prentice Hall]" 
 	@Override
	public String toString(){
 		return("BOOK " + libraryNumber + ":" + name + " by " + author + " [ISBN " + isbnNumber + " PUBLISHER " + publishingCompany + "]");
  	}	

	// equals() method for comparison of two Book objects
 	@Override
 	public boolean equals(Object obj){
      Book bObject;
	   if (obj instanceof Book)
	      bObject = (Book)obj;
	   else
	       return false;
	 
	   return this.libraryNumber == bObject.libraryNumber;
	}	

	// get() and set() methods for each Instance Variable
	public String getName(){
	   return name;
	}
	public void setName(String name){
	   this.name=name;
	}
	
	public String getIsbnNumber(){
	   return isbnNumber;
	}	
	public void setIsbnNumber(String isbnNumber){
	   this.isbnNumber=isbnNumber;
	}
	
	public String getAuthor(){
	   return author;
	}
	public void setAuthor(String author){
	   this.author=author;
	}

	public String getPublishingCompany(){
	   return publishingCompany;
	}
	public void setPublishingCompany(String publishingCompany){
	   this.publishingCompany=publishingCompany;
	}

	public int getLibraryNumber(){
	   return libraryNumber;
	}
   // SHOULD NOT HAVE A setLibraryNumber() METHOD

	// read() - To read a book from the user	
   public void read(){
      JTextField txtLibraryNo = new JTextField();
      txtLibraryNo.setText("" + this.getLibraryNumber());
      JTextField txtName = new JTextField();
      txtName.requestFocus();
      JTextField txtIsnbNumber = new JTextField();
      JTextField txtAuthor = new JTextField();
      JTextField txtPublishingCompany = new JTextField();

      Object[] message = {
          "Library Number:", txtLibraryNo,
          "Book Name:", txtName,
          "ISBN Number:", txtIsnbNumber,
          "Author:", txtAuthor,
          "Publishing Company:", txtPublishingCompany,
      };

      JDialog dialog = new JDialog();
      dialog.setAlwaysOnTop(true);    
      int option = JOptionPane.showConfirmDialog(dialog, message, "Enter book details", JOptionPane.OK_CANCEL_OPTION);

      if (option == JOptionPane.OK_OPTION){
          this.name = txtName.getText();
          this.isbnNumber = txtIsnbNumber.getText();
          this.author = txtAuthor.getText();
          this.publishingCompany = txtPublishingCompany.getText();
      }   
	}
}