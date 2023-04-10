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
    public static boolean deleteRole(String title) {
        // TODO implement here
        return false;
    }

    /**
     * @param year 
     * @return
     */
    public static String getRolesByYearForwardSort(int year) {
        // TODO implement here
        return "";
    }

    /**
     * @param year 
     * @return
     */
    public static String getRolesByYearReverseSort(int year) {
        // TODO implement here
        return "";
    }

    /**
     * @param roles_titles 
     * @return
     */
    public static String getRolesByTitles(String roles_titles) {
        // TODO implement here
        return "";
    }



    public static String getAllRoles(){
	    return "";
    }

}
