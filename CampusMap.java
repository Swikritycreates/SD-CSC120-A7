import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Ainsworth", "Far end of the Campus", 3 ));
        myMap.addBuilding(new Building("Neilson", "1 Chapin Way, Northampton, MA 01063", 4 ));
        myMap.addBuilding(new Building("Compass Cafe", "Inside Neilson Library", 1 ));
        myMap.addBuilding(new Building("Capen", "12 Prospect Street", 3 ));
        myMap.addBuilding(new Building("Ainsworth", "Far end of the Campus", 3 ));
        myMap.addBuilding(new Building("Cutter", "Elm Street", 3 ));
        myMap.addBuilding(new Building("Wright Hall", "1 Chapin Way, Northampton, MA 01063", 1 ));
        myMap.addBuilding(new Building("Hilliyer", "Green Street", 3 ));
        myMap.addBuilding(new Building("Clark Hall", "Elm Street", 2 ));
        System.out.println(myMap);
    }
    
}
