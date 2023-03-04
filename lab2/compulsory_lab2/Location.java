
enum LocationType { City, Airport, GasStation;}

public class Location extends Map
{
    protected String name;
    protected LocationType type;
    protected int coordinatesX;
    protected int coordinatesY;

    /**
     * Class constructor specifying the name, type and the coordinates of the location
     */
    public Location(String name, LocationType type, int x, int y)
    {
        this.name = name;
        this.type = type;
        this.coordinatesX = x;
        this.coordinatesY = y;
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
    void getLocationInformation() {System.out.println(toString());}

    /**
     * Returns the location's name
     */
    String getLocationName() {return name;}

    /**
     * Returns the location's type (City, Airport, GasStation)
     */
    LocationType getLocationType() {return type;}

    /**
     * Returns the X coordinate of the location
     */
    int getLocationCoordinateX() {return coordinatesX;}

    /**
     * Returns the Y coordinate of the location
     */
    int getLocationCoordinateY() {return coordinatesY;}
}
