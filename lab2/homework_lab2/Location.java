package Location;
import Map.*;

public class Location extends Map
{
    protected String name;
    protected String type;
    protected int coordinatesX;
    protected int coordinatesY;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location location)) return false;
        return coordinatesX == location.coordinatesX && coordinatesY == location.coordinatesY;
    }

    /**
     * Returns all information about the location (name, type, coordinates)
     */
    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", coordinatesX=" + coordinatesX +
                ", coordinatesY=" + coordinatesY +
                '}' + "\n";
    }

    /**
     * Displays on the screen all information about the location
     */
    public void getLocationInformation() {System.out.println(toString());}

    /**
     * Returns the location's name
     */
    public String getLocationName() {return name;}

    /**
     * Returns the location's type (City, Airport, GasStation)
     */
    public String getLocationType() {return type;}

    /**
     * Returns the X coordinate of the location
     */
    public int getLocationCoordinateX() {return coordinatesX;}

    /**
     * Returns the Y coordinate of the location
     */
    public int getLocationCoordinateY() {return coordinatesY;}
}
