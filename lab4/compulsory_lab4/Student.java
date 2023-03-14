package org.example;
import java.util.*;

public class Student implements Comparable<Student> {
    private String name;
    private List<Project> admissibleProjects = new ArrayList<>();

    /**
     * Class constructor
     */
    public Student(String name) {
        this.name = name;
    }
    /**
     * Getter for the name of the project
     */
    public String getName() {
        return name;
    }

    public void setAdmissibleProject(Project p){
        admissibleProjects.add(p);
    }

    @Override
    public int compareTo(Student p) {
        return getName().compareTo(p.getName());
    }
}
