import Map.*;
import Location.*;
import Road.*;

public class Main {
    public static void main(String[] args)
    {
        Map map = new Map();

        Location l1 = new City("l1",10,10);
        map.addLocation(l1);

        Location l2 = new GasStation("l2",1,10);
        map.addLocation(l2);

        Location l3 = new City("l3",3,1);
        map.addLocation(l3);

        Location l4 = new City("l4",7,20);
        map.addLocation(l4);

        Road r1 = new Highway(l1, l2, 100);
        map.addRoad(r1);

        Road r2 = new Express(l3, l2, 100);
        map.addRoad(r2);

        Road r3 = new Highway(l2, l4, 200);
        map.addRoad(r3);

        //map.getMap();
        BestRouteProblem x = new BestRouteProblem(map, l1, l3);
    }
}
