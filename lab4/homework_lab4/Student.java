package org.example;
import java.util.*;

public class Student implements Comparable<Student> {
    private final String name;
    private List<Project> admissibleProjects = new ArrayList<>();


    /**
     * Class constructor
     */
    public Student(String name) {this.name = name;}

    /**
     * Getter for the name of the project
     */
    public String getName() {return name;}

    public List<Project> getAdmissibleProjects() {return admissibleProjects;}

    /**
     * Getter for the number of admissible projects
     */
    public int getNumberOfAdmissibleProjects(){ return admissibleProjects.size();}


    /**
     * Setter to add one Project in admissibleProjects for the Student.
     */
    public void setAdmissibleProject(Project p){
        boolean ok = true;
        for(Project x : admissibleProjects)
        {
            if (p.equals(x)) {
                ok = false;
                break;
            }
        }
        if(ok) admissibleProjects.add(p);
        else System.out.println("Proiectul " +
                p.getName() +
                " exista deja in lista de proiecte admisibile ale studentului " +
                this.name);
    }

    /**
     * Setter to add more than one Project
     * in admissibleProjects for the Student.
     */
    public void setAdmissibleProjects(List<Project> p){
        for(Project x : p)
        {
            setAdmissibleProject(x);
        }
    }

    /**
     * Orders the size of the admissibleProjects
     */
    @Override
    public int compareTo(Student p) {
        if(admissibleProjects.size() > p.admissibleProjects.size()) return 1;
        else if(admissibleProjects.size() < p.admissibleProjects.size()) return -1;
        else return 0;
    }
}
