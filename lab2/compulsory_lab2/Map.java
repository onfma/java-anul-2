import java.util.ArrayList;
import java.lang.Math;

class Map
{
    protected ArrayList<Location> locations;
    protected ArrayList<Road> roads;

    /**
     * Class constructor
     */
    public Map() {locations = new ArrayList<Location>(); roads = new ArrayList<Road>();}

    /**
     * Adds a new location in the map
     *
     * @param location  the location that is newly added to the map
     */
    public void addLocation(Location location) {locations.add(location);}
    
    /**
     * Deletes a location of the map
     *
     * @param location  the location that is deleted from the map
     */
    public void removeLocation(Location location) {locations.remove(location);}

    /**
     * Adds a new road in the map
     *
     * @param road  the road that is newly added to the map
     */
    public void addRoad(Road road) {roads.add(road);}

    /**
     * Deletes a road of the map
     *
     * @param road  the road that is deleted from the map
     */
    public void removeRoad(Road road) {roads.remove(road);}

    /**
     * Returns all locations and roads from the map 
     * with all the information about each of them
     */
    @Override
    public String toString() {
        return "Map{" + "\n" +
                "locations=" + locations + "\n" +
                ", roads=" + roads +
                '}';
    }

    /**
     * Displays on the screen all information about the roads and locations of the map
     */
    public void getMap() {System.out.println(toString());}

    /**
     * Displays on the screen all information about the locations of the map
     */
    public void getAllLocations()
    {
        for(Location location : locations) {location.getLocationInformation();}
    }

    /**
     * Displays on the screen all information about the roads of the map
     */
    public void getAllRoads()
    {
        for(Road road : roads) {road.getRoadInformation();}
    }

    /**
     * Calculates and returns the distance from one location to another by their coordinates
     *
     * @param location1  the start location
     * @param location2  the end location
     */
    public int distanceBetween2Locations(Location location1, Location location2)
    {
        return (int) Math.sqrt(Math.pow((location1.getLocationCoordinateX()-location2.getLocationCoordinateX()),2) + Math.pow((location1.getLocationCoordinateY()-location2.getLocationCoordinateY()),2));
    }
}
