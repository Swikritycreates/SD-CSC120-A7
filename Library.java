/* This is a stub for the Library class */

import java.util.Hashtable;

public class Library extends Building {


  /**
   * private attribute to store book title and its status
   */
  private Hashtable<String, Boolean> collection;

  /**
   * constructor
   * @param name
   * @param address
   * @param nFloors
   */

  public Library(String name, String address, int nFloors) {
    super(name,address,nFloors);
    this.collection = new Hashtable<>();

    System.out.println("You have built a library: 📖");
  }
  /**
   * adds book to the library stock
   * @param title is the book's name
   */
  public void addTitle(String title){
    collection.put(title, true);
    System.out.println("Book Added");
  }

  /**
   * Overloaded Method
   * @param title
   * @param isbn added parameter
   * stores book with isbn numbers
   */
  public void addTitle(String title, int isbn){
    collection.put(title, true);
    System.out.println("Book Added");
  }

  /**
   * removes book from library stock
   * @param title is the name of the book
   * @return the title that we removed
   */
 
  public String removeTitle(String title){
    collection.remove(title, false);
    System.out.println("Book Removed");
    return title;
  }

  /**
   * changes tha status of the book when a student checks it out
   * @param title - book 
   */

  public void checkOut(String title){
    collection.replace(title, true, false);
    System.out.println("Checked Out");
  }

  /**
   * changes tha status of the book when a student returns it
   * @param title - book
   */
  public void returnBook(String title){
    collection.replace(title, false, true);
    System.out.println("Checked In");
  }

  /**
   * checks if the book is in the library
   * @param title - book
   * @return true if the title appears as a key in the Libary's collection, false otherwise
   */

  public boolean containsTitle(String title){
    if (collection.containsKey(title)){
      System.out.println("It is there");
      return true;
    }
    System.out.println("It's not there");
    return false;
    
  }
  /**
   * checks if the book is checked out by a student ot not 
   * @param title
   * @return true if the title is currently available, false otherwise
   */

  public boolean isAvailable(String title){
    Boolean result = collection.get(title);
    System.out.println(result);
    return result;
  }
  /**
   * prints out the entire collection in an easy-to-read way (including checkout status)
   */

  public void printCollection(){
    System.out.println(collection.toString());
  } 
  /**
   * overriding show options from Building class with the options available in this class
   */

  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + printCollection() \n + checkOut(title) \n + returnBook(title) \n + addTitle(title)\n + removeTitle(title)");
}

  /**xs
   * main
   * creates object
   * @param args
   */
  public static void main(String[] args) {
     Library l = new Library("Neilson", "Mid-campus", 3);
     l.addTitle("Pretty Bae by Ms. Ayer", 9866345);
     l.checkOut("Shri's Princess");
     l.returnBook("Shri's Princess");
  }
  
  }