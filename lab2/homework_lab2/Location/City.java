package Location;
import java.util.ArrayList;

public class City extends Location
{
    protected int population;
    protected int density;

    /**
     * Class constructor specifying the name and the coordinates of the City
     */
    public City(String name, int x, int y)
    {
        this.name = name;
        this.type = "City";
        this.coordinatesX = x;
        this.coordinatesY = y;
    }

    /**
     * Sets the population of the City
     *
     * @param count  the number of people in the City
     */
    public void setPopulation(int count) {population = count;}

    /**
     * Sets the density of the City
     *
     * @param count  the density of the City
     */
    public void setDensity(int count) {density = count;}


    /**
     * Displays on the screen the population of the City
     */
    public void getPopulation() {System.out.println("Populatia orasului " + name + " este: " + population);}

    /**
     * Displays on the screen the density of the City
     */
    public void getDensity() {System.out.println("Densitatea orasului " + name + " este: " + density);}
}
