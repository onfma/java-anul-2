import java.time.LocalDate;
import java.util.*;

public class Company implements Comparable<Company>, INode
{
    protected String name;
    protected LocalDate foundingDate;
    protected Person CEO;
    protected Map companyMap;
    protected int nrOfRelationships;

    /**
     * Class constructor
     */
    public Company(String name, LocalDate date, Person ceo) {
        this.name=name;
        this.foundingDate = date;
        this.CEO = ceo;
        companyMap = new Map();
        nrOfRelationships = 0;
    }

    /**
     * Creates a relationship between a Company and the Company
     */
    public void createRelationship(SocialNetwork sn,Company c, RelationshipType rt) {
        nrOfRelationships++;
        Network n = new Network(sn, this, c, rt);
        companyMap.addNetworkRelation(n);
        c.companyMap.addNetworkRelation(new Network(sn, c, this, rt));
    }

    /**
     * Creates a relationship between the Company and a Person
     */
    public void createRelationship(SocialNetwork sn,Person p, RelationshipType rt) {
        nrOfRelationships++;
        Network n = new Network(sn, this, p, rt);
        companyMap.addNetworkRelation(n);
        p.personalMap.addNetworkRelation(new Network(sn, p, this, rt));
    }

    /**
     * Displays on the screen the network around the company
     */
    public void viewPersonalNetwork() {
        System.out.println("The network of the Company " + this.name + ":");
        companyMap.viewNetworkMap();
    }

    /**
     * Orders the companies by alphabetic order
     */
    public int compareTo(Company c){
        if(nrOfRelationships > c.nrOfRelationships) return -1;
        else if(nrOfRelationships < c.nrOfRelationships) return 1;
        else return 0;
    }
    public int compareTo(Person p){
        if(nrOfRelationships > p.getNrOfRelasionships()) return -1;
        else if(nrOfRelationships < p.getNrOfRelasionships()) return 1;
        else return 0;
    }

    public String getName() {return name;}
    public int getNrOfRelationships() {return nrOfRelationships;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company company)) return false;
        return Objects.equals(getName(), company.getName());
    }
}