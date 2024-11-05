import java.util.ArrayList;

/* This is a stub for the House class */
public class House extends Building{

  /**
   * requested attributes for house class which are made private to itself
   */
  private ArrayList<String> residents; // The <String> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;
  public boolean hasElevator;

  /**
   * constructor
   * @param name of the building - similar to building class
   * @param address its address
   * @param nFloors number of floors
   * @param hasDiningRoom to check if the house has a dining Room or Not
   * @param hasElevator to check if the house has an elevator
   */

  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;

    System.out.println("You have built a house: 🏠");
  }

  /**
   * Overloaded Constructor
   * @param name
   * @param address
   * for house with no dining and no elevator and only 1 floor
   */
  public House(String name, String address) {
    this(name, address, 1, false, false); //one floor, no dining room, no elevator
  }
  /**
   * accessor
   * @return the arraylist of Residents
   */
  public ArrayList getResidents(){
    return this.residents;
  }

  /**
   * accessor
   * @return a boolean value for presence/absence of Dining Room
   */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  /**
   * 
   * @return the number of residents living in the house
   */
  public int nResidents(){
    int nResidents = residents.size();
    return nResidents;
  }

  /**
   * 
   * @param name passes the name of the student to check if they are living there or not
   * @return a boolean value  of true if they are living there, and false if not
   */

  public Boolean isResident(String name){
    if (residents.contains(name)){
      return true;
    }
    else{
      return false;
    }
  }

  /**
   * 
   * @param name of the Student
   * checks if the student of that name is already living there 
   * throws exception if they are
   * adds them to the residents list if not
   */

  public void moveIn(String name){
    if (isResident(name)){
      throw new RuntimeException(name+" already in the house!");
    } else{
      residents.add(name);
      System.out.println(name+" has moved in ");
    }

  }

  /**
   * Overloaded method
   * @param name
   * @param roomNo addition to previous method
   */

  public void moveIn(String name, int roomNo){
    if (isResident(name)){
      throw new RuntimeException(name+" already in the house!");
    } else{
      residents.add(name);
      System.out.println(name+" has moved in " +roomNo);
    }
  }

  /**
   * 
   * @param name of the student
   * checks if they are living there
   * removes if living
   * throws exception if not living
   * @return name of the student who moved out
   */
  
   public String moveOut(String name) {
    if (isResident(name)){
      residents.remove(name);
      System.out.println("Removed.");
      return name;
    }
    else{
      throw new RuntimeException(name+ " doesn't live here.");
    }

  }

  /**
   * overriding showOptions with the options available in house class
   */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + moveIn(name) \n + moveOut(name) \n + nResidents()");
  }

  /**
   * 
   */

  public void goToFloor(int floorNum) {
    if (this.activeFloor == -1) {
      throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
      throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
    }
    if (!hasElevator){
      throw new RuntimeException("This building doesn't have an elevator; Please try goUp()");
    }

    System.out.println("You are now on floor #" + floorNum + " of " + this.name);
    this.activeFloor = floorNum;
  }
  /**
   * main
   * creates object for house
   * @param args
   */

  public static void main(String[] args) {
    House h = new House("Talbot", "12 Prospect Street", 4, false, false);
    House i = new House("Cutter", "Elm Street", 4, true, true);
    h.moveIn("Swiki", 212);
    i.enter();
    i.goToFloor(4);
    h.enter();
    h.goToFloor(3);
  }

}