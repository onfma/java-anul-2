
public class compulsory_lab2
{
    public static void main(String[] args)
    {
        Map maria = new Map();
        Location a = new Location("a", LocationType.City,1,1);
        maria.addLocation(a);

        Location b = new Location("b", LocationType.City,1,1);
        Location v;
        maria.addLocation(v = new Location("v", LocationType.City,1,1));
        maria.addLocation(b);

        Road ab = new Road(a, b, RoadType.Highway, 30, 100);
        maria.addRoad(ab);

        Road av = new Road(a, v, RoadType.Highway, 30, 100);
        maria.addRoad(av);

        maria.getMap();

    }
}


