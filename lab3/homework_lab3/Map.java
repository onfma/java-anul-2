import java.util.ArrayList;

public class Map
{
    protected ArrayList<Network> network;

    /**
     * Class constructor
     */
    public Map() {network = new ArrayList<>();}

    /**
     * Adds in the ArrayList a new network
     */
    public void addNetworkRelation(Network n) {
        for(Network x : network)
        {
            if(x.equals(n))
            {
                throw new Error("ERROR! This network relationship already exists.");
            }
        }
        network.add(n);
    }

    /**
     * Deletes in the ArrayList a new network
     */
    public void deleteNetworkRelation(Network n) {network.remove(n);}

    /**
     * Displays on the screen all the relationships
     * in the network for that Person/Company
     */
    public void viewNetworkMap() {
        for (Network n: network) {
            System.out.println(n.toString());
        }
    }

}
