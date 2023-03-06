package Location;

public class Airport extends Location
{
    protected int nrTerminals;
    protected int nrAircrafts;

    /**
     * Class constructor specifying the name and the coordinates of the Airport
     */
    public Airport(String name, int x, int y)
    {
        this.name = name;
        this.type = "Airport";
        this.coordinatesX = x;
        this.coordinatesY = y;
    }

    /**
     * Sets the number of terminals in the Airport
     *
     * @param count  the nuymber of terminals
     */
    public void setNrTerminals(int count) {nrTerminals = count;}

    /**
     * Sets the number of aircrafts of the Airport
     *
     * @param count  the number of aircrafts
     */
    public void setNrAircrafts(int count) {nrAircrafts = count;}


    /**
     * Displays on the screen the number of terminals in the Airport
     */
    public void getNrTerminals() {System.out.println("Aeroportul " + name + " are  " + nrTerminals + " terminale");}

    /**
     * Displays on the screen the number of aircrafts of the Airport
     */
    public void getNtAircrafts() {System.out.println("Aeroportul " + name + " are " + nrAircrafts + "avioane");}
}