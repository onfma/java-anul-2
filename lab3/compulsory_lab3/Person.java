public class Person implements Comparable<Person>, INode
{
    private String name;
    private String specializedRole = null; // programmer or designer

    /**
     * Class constructor
     */
    public Person(String name) {this.name=name;}

    public String getName() {return name;}

    /**
     * Adds a specialized role to the person.
     * By default, a person has no specialized role.
     *
     * @param role  the specialized role that can be "programmer" or "designer"
     */
    public void addSpecializedRole(String role)
    {
        if(role == "programmer") this.specializedRole = "programmer";
        else if(role == "designer") this.specializedRole = "designer";
        else throw new Error("EROARE! rol specializat invalid");
    }

    /**
     * Orders the people by alphabetic order.
     */
    public int compareTo(Person p){
         return name.compareTo(p.name);
         // 0 = sunt egale
         // 1 = daca nume > p.nume
         //-1 = daca nume < p.nume
    }
}


