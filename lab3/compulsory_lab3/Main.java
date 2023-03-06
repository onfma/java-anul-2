import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Main {
    public static void main(String[] args)
    {
        List<INode> nodes = new ArrayList<INode>();
        int indexNodes = 0;

        ArrayList<Person> people = new ArrayList<Person>();
        ArrayList<Company> companies = new ArrayList<Company>();

        Person p1 = new Person("maria");
        people.add(p1);
        Person p2 = new Person("ana");
        people.add(p2);
        Person p3 = new Person("mihai");
        p3.addSpecializedRole("designer");
        people.add(p3);

        Company c1 = new Company("a");
        companies.add(c1);
        Company c2 = new Company("t");
        companies.add(c2);
        Company c3 = new Company("h");
        companies.add(c3);

        Collections.sort(people);
        Collections.sort(companies);

        for(Person p : people) {nodes.add(indexNodes++,p);}
        for(Company c : companies) {nodes.add(indexNodes++,c);}
        for(INode n : nodes) {System.out.println(n.getName());}

    }
}
