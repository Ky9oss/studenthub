package model;
import java.util.*;

/**
 * 
 */
public class Skill {


    public Skill(String title, String content, String proficiency, String project) {
        this.title = title;
        this.content = content;
        this.proficiency = proficiency;
        this.project = project;
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
    private String proficiency;

    /**
     * 
     */
    private String project;

    /**
     * @return
     */
    public boolean saveSkill() {
        // TODO implement here
        return false;
    }

    /**
     * @param title 
     * @return
     */
    public static boolean deleteSkill(String title) {
        // TODO implement here
        return false;
    }

    /**
     * @param proficiency 
     * @return
     */
    public static String getSkillsByProficiency(String proficiency) {
        // TODO implement here
        return "";
    }

    /**
     * @param skills_titles 
     * @return
     */
    public static String getSkillsByTitles(String skills_titles) {
        // TODO implement here
        return "";
    }
    public static String getAllSkills(){
	    return "";
    }

}
