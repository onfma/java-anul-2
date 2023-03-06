package Map;
import Location.*;
import Road.*;

import java.util.ArrayList;

public class BestRouteProblem
{
    protected ArrayList<Road> bestRouteComponents = new ArrayList<Road>();
    protected double totalLenght;

    /**
     * Returns FALSE if the 2 locations aren't in the map or
     * if there is no combination of roads between the 2
     */
    protected Boolean verifyProblemInstance(Map map, Location startLocation, Location endLocation)
    {
        // se verifica daca ambele locatii exista in mapa
        boolean ok1 = false;
        boolean ok2 = false;
        for(Location l : map.locations)
        {
            if(startLocation.equals(l)) ok1 = true;
            if(endLocation.equals(l)) ok2 = true;
        }

        // se verifica daca exista macar un drum intre locatii
        boolean ok3 = false;

        return ok1 && ok2 && ok3;
    }

    /**
     * Class constructor that displays on the screen the
     * best route between Start and Finish locations
     *
     * @param startLocation the start location of the route
     * @param endLocation the end location of the route
     */
    public BestRouteProblem(Map map, Location startLocation, Location endLocation)
    {
        if(verifyProblemInstance(map, startLocation, endLocation))
        {
            // COD CARE IMI GENEREAZA CEL MAI SCURT DRUM
            System.out.println("Ruta cea mai scurta " + bestRouteComponents);
        }
        else throw new Error("EROARE! Instantele problemei nu sunt corecte.");
    }
}
