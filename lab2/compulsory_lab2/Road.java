
enum RoadType { Highway, Express, Country;}

public class Road extends Map
{
    protected Location location1;
    protected Location location2;
    protected RoadType type;
    protected int length;
    protected int speedLimit;

    /**
     * Class constructor specifying the 2 locations that the road connected,
     * the type, length and speed limit of the road.
     *
     * The constructor is verifying if the specified length of the road is bigger
     * or at least the same as the actual distance between the 2 locations
     * (the distance is calculated from the coordinates of the locations)
     */
    public Road(Location location1, Location location2, RoadType type, int length, int speedLimit)
    {
        if(length >= distanceBetween2Locations(location1,location2))
        {
            this.location1 = location1;
            this.location2 = location2;
            this.type = type;
            this.length = length;
            this.speedLimit = speedLimit;
        }
        else
        {
            System.out.println("EROARE! Distanta drumului treb sa fie mai mare sau egala de " + distanceBetween2Locations(location1,location2));
        }
    }

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
     * Displays on the screen all information about the road
     */
    void getRoadInformation() {System.out.println(toString());}

    /**
     * Displays on the screen the locations that the road connected
     */
    void getRoadPosition() {System.out.println("Drumul are un capat in locatia " + location1.getLocationName() + " si un capat in locatia " + location2.getLocationName());}

    /**
     * Displays on the screen the road's type (Highway, Express, Country)
     */
    void getRoadType() {System.out.println("Drumul este de tip: " + type);}

    /**
     * Returns the length of the road
     */
    int getRoadLength() {return length;}

    /**
     * Displays on the screen the road's speed limit
     */
    void getRoadSpeedLimit() {System.out.println("Drumul eare limita de viteza: " + speedLimit);}

}
