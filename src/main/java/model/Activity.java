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
    public boolean deleteActivity(String title) {
        // TODO implement here
        return false;
    }

    /**
     * @param year 
     * @param type 
     * @return
     */
    public String getActivitiesByYearAndByTypeForwardSort(int year, String type) {
        // TODO implement here
        return "";
    }

    /**
     * @param year 
     * @param type 
     * @return
     */
    public String getActivitiesByYearAndByTypeReverseSort(int year, String type) {
        // TODO implement here
        return "";
    }

    /**
     * @param activities_titles 
     * @return
     */
    public String getActivitiesByTitles(String activities_titles) {
        // TODO implement here
        return "";
    }
    public String getAllActivities(){
	    return "";
    }

}
