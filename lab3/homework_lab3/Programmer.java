import java.time.LocalDate;
import java.util.*;

public class Programmer extends Person
{
    protected String university;
    protected int yearsOfExperience;
    protected String programmingLanguage;

    /**
     * Class constructor
     */
    public Programmer(String name, LocalDate birthDate, int yearsOfExperience, String programmingLanguage) {
        super(name, birthDate);
        this.yearsOfExperience = yearsOfExperience;
        this.programmingLanguage = programmingLanguage;
        this.personalMap = new Map();
    }


    /**
     * Class setter for the university that the programmer finished
     */
    public void setUniversity(String university) {this.university = university;}

    /**
     * Class setter for years of experience that the programmer has
     */
    public void setYearsOfExperience(int yearsOfExperience) {this.yearsOfExperience = yearsOfExperience;}

    /**
     * Class setter for the preferred programming language
     */
    public void setProgrammingLanguage(String programmingLanguage) {this.programmingLanguage = programmingLanguage;}

    /**
     * Class getter for the university that the programmer finished
     */
    public String getUniversity() {return university;}

    /**
     * Class getter for years of experience that the programmer has
     */
    public int getYearsOfExperience() {return yearsOfExperience;}

    /**
     * Class getter for the preferred programming language
     */
    public String getProgrammingLanguage() {return programmingLanguage;}


}
