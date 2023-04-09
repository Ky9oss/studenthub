package model;
import java.util.*;

/**
 * 
 */
public class Role {



    public Role(String title, String content, String time) {
        this.title = title;
        this.content = content;
        this.time = time;
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
     * @return
     */
    public boolean saveRole() {
        // TODO implement here
        return false;
    }

    /**
     * @param title 
     * @return
     */
    public boolean deleteRole(String title) {
        // TODO implement here
        return false;
    }

    /**
     * @param year 
     * @return
     */
    public String getRolesByYearForwardSort(int year) {
        // TODO implement here
        return "";
    }

    /**
     * @param year 
     * @return
     */
    public String getRolesByYearReverseSort(int year) {
        // TODO implement here
        return "";
    }

    /**
     * @param roles_titles 
     * @return
     */
    public String getRolesByTitles(String roles_titles) {
        // TODO implement here
        return "";
    }

    /**
     * @param skills_titles 
     * @return
     */
    public String getSkillsByTitles(String skills_titles) {
        // TODO implement here
        return "";
    }

}