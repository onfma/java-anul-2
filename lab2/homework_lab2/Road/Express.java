package Road;
import Location.Location;

public class Express extends Road
{
    /**
     * Class constructor specifying the 2 locations that the express road connected and length of the road.
     *
     * The constructor is verifying if the specified length of the road is bigger
     * or at least the same as the actual distance between the 2 locations
     * (the distance is calculated from the coordinates of the locations)
     */
    public Express(Location location1, Location location2, double length) {
        this.location1 = location1;
        this.location2 = location2;
        this.type = "Express";
        this.length = length;
        this.speedLimit = 100;
    }
}
