import java.time.LocalDate;
import java.util.*;

public class Person implements Comparable<Person>, INode
{
    protected String name;
    protected LocalDate birthDate;
    protected Map personalMap;
    protected int nrOfRelasionships;


    /**
     * Class constructor
     */
    public Person(String name, LocalDate birthDate) {
        this.name=name;
        this.birthDate = birthDate;
        personalMap = new Map();
        nrOfRelasionships = 0;
    }

    /**
     * Creates a relationship between a Company and the Person
     */
    public void createRelationship(SocialNetwork sn, Company c, RelationshipType rt) {
        nrOfRelasionships++;
        Network n = new Network(sn, this, c, rt);
        personalMap.addNetworkRelation(n);
        c.companyMap.addNetworkRelation(new Network(sn, c, this, rt));
        c.nrOfRelationships++;
    }

    /**
     * Creates a relationship between the Person and another Person
     */
    public void createRelationship(SocialNetwork sn, Person p, RelationshipType rt) {
        nrOfRelasionships++;
        Network n = new Network(sn,this, p, rt);
        personalMap.addNetworkRelation(n);
        p.personalMap.addNetworkRelation(new Network(sn, p, this, rt));
        p.nrOfRelasionships++;
    }

    /**
     * Displays on the screen the network around the person
     */
    public void viewPersonalNetwork() {
        System.out.println("The network of " + this.name + ":");
        personalMap.viewNetworkMap();
    }

    /**
     * Orders the people by how many relationships they have.
     */
    public int compareTo(Person p){
        if(nrOfRelasionships > p.nrOfRelasionships) return -1;
        else if(nrOfRelasionships < p.nrOfRelasionships) return 1;
        else return 0;
    }
    public int compareTo(Company x) {
        if(nrOfRelasionships > x.getNrOfRelationships()) return -1;
        else if(nrOfRelasionships < x.getNrOfRelationships()) return 1;
        else return 0;
    }

    public String getName() {return name;}
    public int getNrOfRelasionships() {return nrOfRelasionships;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return Objects.equals(getName(), person.getName());
    }
}