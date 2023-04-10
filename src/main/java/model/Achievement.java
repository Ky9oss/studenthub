package model;
import java.util.*;

/**
 * 
 */
public class Achievement {





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
    private String team;

    /**
     * 
     */
    private String responsibility;

    
    public Achievement(String title, String content, String time, String team, String responsibility) {
        this.title = title;
        this.content = content;
        this.time = time;
        this.team = team;
        this.responsibility = responsibility;
    }   

    /**
     * @return
     */
    public boolean saveAchievement() {
        // TODO implement here
        return false;
    }

    /**
     * @param title 
     * @return
     */
    public static boolean deleteAchievement(String title) {
        // TODO implement here
        return false;
    }

    /**
     * @param year 
     * @return
     */
    public static String getAchievementsByYearForwardSort(int year) {
        // TODO implement here
        return "";
    }

    /**
     * @param year 
     * @return
     */
    public static String getAchievementsByYearReverseSort(int year) {
        // TODO implement here
        return "";
    }

    /**
     * @param achievements_titles 
     * @return
     */
    public static String getAchievementsByTitles(String achievements_titles) {
        // TODO implement here
        return "";
    }

}