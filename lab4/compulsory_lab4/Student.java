package org.example;

public class Student implements Comparable<Student> {
    private String name;

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

    @Override
    public int compareTo(Student p) {
        return getName().compareTo(p.getName());
    }
}