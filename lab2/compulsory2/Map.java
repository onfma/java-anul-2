import java.util.ArrayList;
import java.lang.Math;

class Map
{
    protected ArrayList<Location> locations;
    protected ArrayList<Road> roads;

    public Map() {locations = new ArrayList<Location>(); roads = new ArrayList<Road>();}

    public void addLocation(Location location) {locations.add(location);}
    public void removeLocation(Location location) {locations.remove(location);}
    public void addRoad(Road road) {roads.add(road);}
    public void removeRoad(Road road) {roads.remove(road);}

    @Override
    public String toString() {
        return "Map{" +
                "locations=" + locations + "\n" +
                ", roads=" + roads +
                '}';
    }

    public void getMap() {System.out.println(toString());}

    public void getAllLocations()
    {
        for(Location location : locations) {location.getLocationInformation();}
    }

    public void getAllRoads()
    {
        for(Road road : roads) {road.getRoadInformation();}
    }

    public int distanceBetween2Locations(Location location1, Location location2)
    {
        return (int) Math.sqrt(Math.pow((location1.getLocationCoordinateX()-location2.getLocationCoordinateX()),2) + Math.pow((location1.getLocationCoordinateY()-location2.getLocationCoordinateY()),2));
    }
}
