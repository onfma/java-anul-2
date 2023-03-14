package org.example;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        var students = IntStream.rangeClosed(0,2)
                .mapToObj(i -> new Student("Student" + i))
                .toArray(Student[]:: new);
        System.out.println("Added " + students.length + " students.");

        var projects = IntStream.rangeClosed(0,2)
                .mapToObj(i -> new Project("Project" +i))
                .toArray(Project[]:: new);
        System.out.println("Added " + projects.length + " projects.");

        System.out.println();

        List<Student> studentsLikedList = new LinkedList<>();
        studentsLikedList.addAll(Arrays.stream(students).toList());
        Collections.sort(studentsLikedList);
        for(Student s: studentsLikedList)
        {
            System.out.println(s.getName());
        }

        System.out.println();

        TreeSet<Project> projectsTreeSet = new TreeSet<>();
        projectsTreeSet.addAll(Arrays.stream(projects).toList());
        for(Project p: projectsTreeSet)
        {
            System.out.println(p.getName());
        }



        //System.out.println("Hello world!");
    }
}