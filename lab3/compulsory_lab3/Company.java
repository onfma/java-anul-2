public class Company implements Comparable<Company>, INode
{
    private String name;

    /**
     * Class constructor
     */
    public Company(String name) {this.name=name;}

    public String getName() {return name;}

    /**
     * Orders the companies by alphabetic order
     */
    public int compareTo(Company c){
        return name.compareTo(c.name);
        // 0 = sunt egale
        // 1 = daca nume > c.nume
        //-1 = daca nume < c.nume
    }
}
