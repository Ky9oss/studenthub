package model;
import java.util.*;

/**
 * 
 */
public class BasicInformation {



    public BasicInformation(String name, int age, String school, String major, String admission_time,
            String graduation_time) {
        this.name = name;
        this.age = age;
        this.school = school;
        this.major = major;
        this.admission_time = admission_time;
        this.graduation_time = graduation_time;
    }

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private int age;

    /**
     * 
     */
    private String school;

    /**
     * 
     */
    private String major;

    /**
     * 
     */
    private String admission_time;

    /**
     * 
     */
    private String graduation_time;

    /**
     * @return
     */
    public String getBasicInformation() {
        // TODO implement here;
        return "";
    }

    /**
     * @return
     */
    public boolean saveBasicInformation() {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public boolean deleteBasicInformation() {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public String getAllInformationForCV() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public boolean saveImage() {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public String getImagePath() {
        // TODO implement here
        return "";
    }

}