import Map.*;
import Location.*;
import Road.*;

public class Main {
    public static void main(String[] args)
    {
        Map map = new Map();

        Location v = new City("v",10,10);
        map.addLocation(v);

        Location b = new GasStation("b",1,10);
        map.addLocation(b);

        Location a = new City("a",3,1);
        map.addLocation(a);

        Road ab = new Highway(a, b, 100);
        map.addRoad(ab);

        Road av = new Express(b, v, 100);
        map.addRoad(av);

        map.getMap();
    }
}