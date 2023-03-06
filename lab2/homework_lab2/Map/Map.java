package Map;
import Location.*;
import Road.*;

import java.util.ArrayList;

public class Map
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
    public void addLocation(Location location)
    {
        for(Location loc : locations)
        {
            if(location.equals(loc))
            {
                throw new Error("EROARE! Deja exista o locatie la aceste coordonate");
            }
        }
        locations.add(location);
    }

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
    public void addRoad(Road road)
    {
        for(Road r : roads)
        {
            if(road.equals(r))
            {
                throw new Error("EROARE! Deja exista un astfel de drum");
            }
        }
        roads.add(road);
    }

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
        return "Map{" +
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
}
