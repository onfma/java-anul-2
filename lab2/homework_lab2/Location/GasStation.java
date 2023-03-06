package Location;

public class GasStation extends Location
{
    protected int nrPumpsDiesel;
    protected int nrPumpsGas;
    protected float dieselPrice;
    protected float gasPrice;

    /**
     * Class constructor specifying the name and the coordinates of the Gas Station
     */
    public GasStation(String name, int x, int y) {

        this.name = name;
        this.type = "Gas Station";
        this.coordinatesX = x;
        this.coordinatesY = y;
    }

    /**
     * Sets the number of diesel pumps in the Gas Station
     *
     * @param count  the number of diesel pumps
     */
    public void setNrPumpsDiesel(int count) {nrPumpsDiesel = count;}

    /**
     * Sets the number of gas pumps in the Gas Station
     *
     * @param count  the number of gas pumps
     */
    public void setNrPumpsGas(int count) {nrPumpsGas = count;}

    /**
     * Sets the price of diesel for the Gas Station
     *
     * @param price  the price of diesel per liter
     */
    public void setDieselPrice(float price) {dieselPrice = price;}

    /**
     * Sets the price of gas for the Gas Station
     *
     * @param price  the price of gas per liter
     */
    public void setGasPrice(float price) {gasPrice = price;}


    /**
     * Displays on the screen the number of diesel pumps in the Gas Station
     */
    public void getNrPumpsDiesel() {System.out.println("nr de pompe de motorina: " + nrPumpsDiesel);}

    /**
     * Displays on the screen the number of gas pumps in the Gas Station
     */
    public void getNrPumpsGas() {System.out.println("nr de pompe de benzina: " + nrPumpsGas);}

    /**
     * Displays on the screen the price of diesel for the Gas Station
     */
    public void getDieselPrice() {System.out.println("pret motorina: " + dieselPrice);}

    /**
     * Displays on the screen the price of gas for the Gas Station
     */
    public void getGasPrice() {System.out.println("pret benzina: " + gasPrice);}
}
