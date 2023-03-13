
enum RelationshipType {Friendship, WorkingFor, Family, IntresestedIn};

public class Network implements Comparable<Network>
{
    protected SocialNetwork fullSocialNetwork;
    protected Person mainPerson;
    protected Company mainCompany;
    protected Person associatedPerson;
    protected Company associatedCompany;
    protected RelationshipType relationshipType;


    /**
     * Class constructor: Person + Company
     */
    public Network(SocialNetwork sn, Person me, Company c, RelationshipType rt){
        this.fullSocialNetwork = sn;
        this.mainPerson = me;
        this.associatedCompany = c;
        this.relationshipType = rt;

        sn.fullMapOfTheNetwork.network.add(this);
    }

    /**
     * Class constructor: Person + Person
     */
    public Network(SocialNetwork sn,Person me, Person p, RelationshipType rt){
        this.fullSocialNetwork = sn;
        this.mainPerson = me;
        this.associatedPerson = p;
        this.relationshipType = rt;

        sn.fullMapOfTheNetwork.network.add(this);
    }

    /**
     * Class constructor: Company + Person
     */
    public Network(SocialNetwork sn, Company me, Person p, RelationshipType rt){
        this.fullSocialNetwork = sn;
        this.mainCompany = me;
        this.associatedPerson = p;
        this.relationshipType = rt;

        sn.fullMapOfTheNetwork.network.add(this);
    }

    /**
     * Class constructor: Company + Person
     */
    public Network(SocialNetwork sn, Company me, Company c, RelationshipType rt){
        this.fullSocialNetwork = sn;
        this.mainCompany = me;
        this.associatedCompany = c;
        this.relationshipType = rt;

        sn.fullMapOfTheNetwork.network.add(this);
    }


    /**
     * Orders the NETWORKS by the frequency of the main name
     */
    public int compareTo(Network n){
        // COMPANY + COMPANY
        if(mainCompany != null && n.mainCompany != null)
            return mainCompany.compareTo(n.mainCompany);
            // PERSON + PERSON
        else if(mainPerson != null && n.mainPerson != null)
            return mainPerson.compareTo(n.mainPerson);
            // COMPANY + PERSON
        else if(mainCompany != null && n.mainPerson != null)
            return mainCompany.compareTo(n.mainPerson);
            // PERSON + COMPANY
        else
            return mainPerson.compareTo(n.mainCompany);

    }


    @Override
    public String toString() {
        // PERSON + PERSON
        if(mainPerson != null && associatedPerson != null) {
            return "Network: " +
                    " mainPerson = " + mainPerson.getName() +
                    ", associatedPerson = " + associatedPerson.getName() +
                    ", relationshipType = " + relationshipType +
                    ';';
        }
        // PERSON + COMPANY
        else if(mainPerson != null && associatedCompany != null) {
            return "Network: " +
                    " mainPerson = " + mainPerson.getName() +
                    ", associatedCompany = " + associatedCompany.getName() +
                    ", relationshipType = " + relationshipType +
                    ';';
        }
        //COMPANY + PERSON
        else if(mainCompany != null && associatedPerson != null) {
            return "Network: " +
                    " mainCompany = " + mainCompany.getName() +
                    ", associatedPerson = " + associatedPerson.getName() +
                    ", relationshipType = " + relationshipType +
                    ';';
        }
        // COMPANY + COMPANY
        else {
            return "Network: " +
                    " mainCompany = " + mainCompany.getName() +
                    ", associatedCompany = " + associatedCompany.getName() +
                    ", relationshipType = " + relationshipType +
                    ';';
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Network network)) return false;
        return mainPerson == network.mainPerson &&
                mainCompany == network.mainCompany &&
                associatedPerson == network.associatedPerson &&
                associatedCompany == network.associatedCompany &&
                relationshipType == network.relationshipType;
    }
}
