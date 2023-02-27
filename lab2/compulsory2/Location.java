
enum LocationType { City, Airport, GasStation;}

public class Location extends Map
{
    protected String name;
    protected LocationType type;
    protected int coordinatesX;
    protected int coordinatesY;

    public Location(String name, LocationType type, int x, int y)
    {
        this.name = name;
        this.type = type;
        this.coordinatesX = x;
        this.coordinatesY = y;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", coordinatesX=" + coordinatesX +
                ", coordinatesY=" + coordinatesY +
                '}' + "\n";
    }

    void getLocationInformation() {System.out.println(toString());}
    String getLocationName() {return name;}
    LocationType getLocationType() {return type;}
    int getLocationCoordinateX() {return coordinatesX;}
    int getLocationCoordinateY() {return coordinatesY;}
}
