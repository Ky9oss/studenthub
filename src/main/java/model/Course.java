package model;
import java.util.*;

/**
 * 
 */
public class Course {



    public Course(String title, String content, String time, String type, String teacher, int grade, int credit) {
        this.title = title;
        this.content = content;
        this.time = time;
        this.type = type;
        this.teacher = teacher;
        this.grade = grade;
        this.credit = credit;
    }

    /**
     * 
     */
    private String title;

    /**
     * 
     */
    private String content;

    /**
     * 
     */
    private String time;

    /**
     * 
     */
    private String type;

    /**
     * 
     */
    private String teacher;

    /**
     * 
     */
    private double grade;

    /**
     * 
     */
    private double credit;

    /**
     * @return
     */
    public boolean saveCourse() {
        // TODO implement here
        return false;
    }

    /**
     * @param title 
     * @return
     */
    public static boolean deleteCourse(String title) {
        // TODO implement here
        return false;
    }

    /**
     * @param year 
     * @param type 
     * @return
     */
    public static String getCoursesByYearAndByTypeForwardSort(int year, String type) {
        // TODO implement here
        return "";
    }

    /**
     * @param year 
     * @param type 
     * @return
     */
    public static String getCoursesByYearAndByTypeReverseSort(int year, String type) {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public static String getAllGradesAndCreditsAndType() {
        // TODO implement here
        return "";
    }
    public static String getAllCourses(){
	    return "";
    }

}
