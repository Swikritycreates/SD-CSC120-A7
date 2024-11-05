/* This is a stub for the Cafe class */
public class Cafe extends Building {

    /**
     * attributes req to run a cafe, private so only the cafe itself can access 
     */

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory
    public boolean hasElevator;

    /**
     * constructor 
     * @param name of the cafe
     * @param address its address
     * @param nFloors number of floors
     */
    public Cafe(String name, String address, int nFloors, boolean hasElevator) {
        super(name, address, nFloors);
        this.nCoffeeOunces = 50;
        this.nSugarPackets = 30;
        this.nCreams = 20;
        this.nCups = 50;
        this.hasElevator = hasElevator;
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Overloaded Constructor
     * @param name 
     * @param address
     * for buildings with only single floor and no elevators
     */
    public Cafe(String name, String address) {
        this(name, address, 1, false);
        this.nCoffeeOunces = 50;
        this.nSugarPackets = 30;
        this.nCreams = 20;
        this.nCups = 50;
        System.out.println("You have built one floor  cafe: ☕");
    }

    /**
     * method to sell coffee 
     * @param size of the coffee (req coffee ounces)
     * @param sugar amount of sugar packets
     * @param cream amount of cream (whole no.)
     */
    public void sellCoffee(int size, int sugar, int cream) {

        if (this.nCoffeeOunces < size) {
            this.restock();
            throw new RuntimeException("Restocking....");
        } 
        //Sugar
        if (this.nSugarPackets < sugar) {
            this.restock();
            throw new RuntimeException("Restocking....");
        } 
        //Cream
        if (this.nCreams < cream) {
            this.restock();
            throw new RuntimeException("Restocking.....");
        
        } 
        
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= sugar;
        this.nCreams -= cream;
        this.nCups -= 1;
                
        System.out.println("Your coffee is ready");
    }

    /**
     * Overloaded method
     * @param size
     * for customers who like coffee without sugar and without cream
     */

    public void sellCoffee(int size) {
        sellCoffee(size, 0, 0); 
    }

    /**
     * restocks the inventory to its starting amount
     */

    private void restock(){
        this.nCoffeeOunces = 50;
        this.nSugarPackets = 30;
        this.nCreams = 20;
        this.nCups = 50;
        System.out.println("Inventory restocked.");
    }
    /**
     * overriding showOptions with the options available in cafe class
     */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + sellCoffee(size, sugar, cream) ");
    }

    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
          throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum != 1) {
          throw new RuntimeException("Inaccesible floors to non-employees.");
        }
        System.out.println("You are at the ground floor");
        this.activeFloor = 1;
      }

    /**
     * main
     * creates object for cafe
     * @param args
     */

    public static void main(String[] args) {
        Cafe d = new Cafe("CC", "Julia Childs CC");
        d.sellCoffee(10);
        d.enter();
        d.goToFloor(3);
    }
    
}

