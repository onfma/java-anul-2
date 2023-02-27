
enum RoadType { Highway, Express, Country;}

public class Road extends Map
{
    protected Location location1;
    protected Location location2;
    protected RoadType type;
    protected int length;
    protected int speedLimit;

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
            // CEVA COD DE STERGERE A INREGISTRARII IN MAPA
        }
    }

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

    void getRoadInformation() {System.out.println(toString());}
    void getRoadPosition() {System.out.println("Drumul are un capat in locatia " + location1.getLocationName() + " si un capat in locatia " + location2.getLocationName());}
    void getRoadType() {System.out.println("Drumul este de tip: " + type);}
    int getRoadLength() {return length;}
    void getRoadSpeedLimit() {System.out.println("Drumul eare limita de viteza: " + speedLimit);}

}
