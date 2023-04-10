package model;
import java.util.*;

/**
 * 
 */
public class Activity {


    public Activity(String title, String content, String time, String type, String location) {
        this.title = title;
        this.content = content;
        this.time = time;
        this.type = type;
        this.location = location;
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
    private String location;

    /**
     * @return
     */
    public boolean saveActivity() {
        // TODO implement here
        return false;
    }

    /**
     * @param title 
     * @return
     */
    public static boolean deleteActivity(String title) {
        // TODO implement here
        return false;
    }

    /**
     * @param year 
     * @param type 
     * @return
     */
    public static String getActivitiesByYearAndByTypeForwardSort(int year, String type) {
        // TODO implement here
        return "";
    }

    /**
     * @param year 
     * @param type 
     * @return
     */
    public static String getActivitiesByYearAndByTypeReverseSort(int year, String type) {
        // TODO implement here
        return "";
    }

    /**
     * @param activities_titles 
     * @return
     */
    public static String getActivitiesByTitles(String activities_titles) {
        // TODO implement here
        return "";
    }
    public static String getAllActivities(){
	    return "";
    }

}
