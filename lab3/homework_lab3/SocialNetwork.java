import java.util.ArrayList;
import java.util.Collections;

public class SocialNetwork
{
    protected String name;
    public Map fullMapOfTheNetwork;

    /**
     * Class constructor
     */
    public SocialNetwork(String name) {
        this.name = name;
        fullMapOfTheNetwork = new Map();
    }

    /**
     * Displays on the screen the FULL network sorted by importance
     */
    public void viewFullSocialNetwork() {
        sort();
        System.out.println(this.name + ":");
        fullMapOfTheNetwork.viewNetworkMap();
    }

    /**
     * Sorting all relationships by the importance
     */
    public void sort() {
        Collections.sort(fullMapOfTheNetwork.network);
    }
}
