package Road;
import Location.Location;
import Map.Map;

import java.lang.Math;

public class Road extends Map
{
    protected Location location1;
    protected Location location2;
    protected String type;
    protected double length;
    protected int speedLimit;

    /**
     * Returns all information about the road
     * (locations, type, length and speed limit of the road)
     */
    @Override
    public String toString() {
        return "Road{" +
                "location1=" + location1.getLocationName() +
                ", location2=" + location2.getLocationName() +
                ", type=" + type +
                ", length=" + length +
                ", speedLimit=" + speedLimit +
                '}' + "\n";
    }

    /**
     * Returns FALSE if there already exists a road with the same type, length and start and end location
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Road road)) return false;
        return Double.compare(road.length, length) == 0 &&
                ((location1.equals(road.location1) && location2.equals(road.location2)) ||
                        (location2.equals(road.location1) && location1.equals(road.location2))) &&
                type.equals(road.type);
    }

    /**
     * Displays on the screen all information about the road
     */
    public void getRoadInformation() {System.out.println(toString());}

    /**
     * Displays on the screen the locations that the road connected
     */
    public void getRoadPosition() {System.out.println("Drumul are un capat in locatia " + location1.getLocationName() + " si un capat in locatia " + location2.getLocationName());}

    /**
     * Displays on the screen the road's type (Highway, Express, Country)
     */
    public void getRoadType() {System.out.println("Drumul este de tip: " + type);}

    /**
     * Returns the length of the road
     */
    public double getRoadLength() {return length;}

    /**
     * Displays on the screen the road's speed limit
     */
    public void getRoadSpeedLimit() {System.out.println("Drumul eare limita de viteza: " + speedLimit);}

    /**
     * Calculates and returns the euclidean distance from one location to another by their coordinates
     *
     * @param location1  the start location
     * @param location2  the end location
     */
    public double distanceBetween2Locations(Location location1, Location location2)
    {
        return Math.sqrt(Math.pow((location1.getLocationCoordinateX()-location2.getLocationCoordinateX()),2) + Math.pow((location1.getLocationCoordinateY()-location2.getLocationCoordinateY()),2));
    }

}
