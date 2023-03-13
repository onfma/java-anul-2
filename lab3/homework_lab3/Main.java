import java.time.LocalDate;

public class Main {
    public static void main(String[] args)
    {
        SocialNetwork socialNetwork = new SocialNetwork("facebook");

        Person p1 = new Person("maria", LocalDate.of(2001,2,7));
        Person p2 = new Programmer("ana", LocalDate.of(2001,2,7), 5, "C/C++");
        Person p3 = new Designer("mihai", LocalDate.of(2001,2,7), 2, "AI");

        Company c1 = new Company("Company 1", LocalDate.of(2001,2,7), p1);
        Company c2 = new Company("Company 2", LocalDate.of(2001,2,7), p2);
        Company c3 = new Company("Company 3", LocalDate.of(2001,2,7), p3);

        p1.createRelationship(socialNetwork, p2, RelationshipType.Family);
        p1.createRelationship(socialNetwork, c2, RelationshipType.IntresestedIn);

        socialNetwork.viewFullSocialNetwork();
    }
}
