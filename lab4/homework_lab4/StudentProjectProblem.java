package org.example;
import java.util.*;

public class StudentProjectProblem {
    protected List<Student> allStudents =  new ArrayList<>();
    protected List<Project> allProjects =  new ArrayList<>();

    /**
     * Verifica daca un anumit proiect este in lsita admisibila a unui anumit student
     *
     * @param s studentul
     * @param p proiectul cautat in lista studentului s
     */
    private Boolean isProjectAdmissible(Student s, Project p){
        for(Project x : s.getAdmissibleProjects()){
            if(Objects.equals(x.getName(), p.getName())) return true;
        }
        return false;
    }

    /**
     * Rezolvarea problemei printr-un algoritm care ordoneaza toti studentii crescator
     * dupa nr de proiecte admisibile pe care le au, si mai apoi asigneaza proiecte
     * in functie de disponibilitatea lor
     */
    public StudentProjectProblem(List<Student> allStudents, List<Project> allProjects) {
        this.allStudents = allStudents;
        this.allProjects = allProjects;

        Collections.sort(this.allStudents);
        Collections.sort(this.allProjects);

        System.out.println("Rezolvarea problemei: ");

        for(Student s: this.allStudents){
            boolean ok = false;
            for(Project p : this.allProjects) {
                if(isProjectAdmissible(s,p)) {
                    System.out.println( s.getName() + " -> " + p.getName());
                    this.allProjects.remove(p);
                    ok = true;
                    break;
                }
            }
            if(!ok) throw new Error("ERROR! Problema nu are rezolvare ptc studentul " +
                    s.getName() + " nu are asignat un proiect.");
        }
    }

    /**
     * Afiseaza pe ecran toti sudentii care au mai putin decat media nr de
     * proiecte preferentiate per student
     */
    public void getStudentsWithBelowAverageNumberOfPreferences() {
        var sum = 0;

        for(Student s : allStudents){
            sum += s.getNumberOfAdmissibleProjects();
        }
        sum = sum / allStudents.size();

        System.out.print("Studentii cu mai putin de " + sum + " proiecte admisibile sunt: ");
        for(Student s : allStudents){
            if(s.getNumberOfAdmissibleProjects() >= sum) break;
            else System.out.print(s.getName() + ", ");
        }
    }

}
