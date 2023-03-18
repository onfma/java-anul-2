package org.example;

public class Project implements Comparable<Project> {
    private final String name;

    /**
     * Class constructor
     */
    public Project(String name) {this.name = name;}

    /**
     * Getter for the name of the project
     */
    public String getName() {return name;}

    @Override
    public int compareTo(Project p) {
        return getName().compareTo(p.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project project)) return false;
        return getName().equals(project.getName());
    }
}
