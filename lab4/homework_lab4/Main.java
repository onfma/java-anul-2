package org.example;
import java.util.*;
import com.github.javafaker.Faker;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        Faker faker = new Faker();

        var students = IntStream.rangeClosed(0,2)
                .mapToObj(i -> new Student(faker.name().firstName()))
                .toArray(Student[]:: new);
        List<Student> allStudents = new ArrayList<>();
        allStudents.addAll(Arrays.stream(students).toList());

        var projects = IntStream.rangeClosed(0,2)
                .mapToObj(i -> new Project("Project " + faker.idNumber().valid()))
                .toArray(Project[]:: new);
        List<Project> allProjects = new ArrayList<>();
        allProjects.addAll(Arrays.stream(projects).toList());


        allStudents.get(0).setAdmissibleProjects(allProjects);

        allStudents.get(1).setAdmissibleProject(allProjects.get(0));
        allStudents.get(1).setAdmissibleProject(allProjects.get(1));

        allStudents.get(2).setAdmissibleProject(allProjects.get(0));


        StudentProjectProblem spp = new StudentProjectProblem(allStudents, allProjects);
        System.out.println("------------------");
        spp.getStudentsWithBelowAverageNumberOfPreferences();

    }
}