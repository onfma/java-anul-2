import java.time.LocalDate;
import java.util.*;

public class Designer extends Person
{
    protected String university;
    protected int yearsOfExperience;
    protected String designPlatform;

    /**
     * Class constructor
     */
    public Designer(String name, LocalDate birthDate, int yearsOfExperience, String designPlatform) {
        super(name, birthDate);
        this.yearsOfExperience = yearsOfExperience;
        this.designPlatform = designPlatform;
        this.personalMap = new Map();
    }


    /**
     * Class getter for the university that the designer attended
     */
    public String getUniversity() {return university;}

    /**
     * Class setter for the university that the designer attended
     */
    public void setUniversity(String university) {this.university = university;}

    /**
     * Class getter for years of experience that the designer has
     */
    public int getYearsOfExperience() {return yearsOfExperience;}

    /**
     * Class setter for years of experience that the designer has
     */
    public void setYearsOfExperience(int yearsOfExperience) {this.yearsOfExperience = yearsOfExperience;}

    /**
     * Class getter for the platform the designer is using
     */
    public String getDesignPlatform() {return designPlatform;}

    /**
     * Class setter for the platform the designer is using
     */
    public void setDesignPlatform(String designPlatform) {this.designPlatform = designPlatform;}
}
