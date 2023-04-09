package controller;
import java.io.File;
import java.util.*;

/**
 * 
 */
public class Controller {

    /**
     * Default constructor
     */
    public Controller() {
    }

    /**
     * @param name 
     * @param age 
     * @param school 
     * @param major 
     * @param admission_time 
     * @param graduation_time 
     * @param head 
     * @return
     */
    public boolean createBasicInformation(String name, int age, String school, String major, String admission_time, String graduation_time, File head) {
        // TODO implement here
        return false;
    }

    /**
     * @param name 
     * @param age 
     * @param school 
     * @param major 
     * @param admission_time 
     * @param graduation_time 
     * @param head 
     * @return
     */
    public boolean changeBasicInformation(String name, int age, String school, String major, String admission_time, String graduation_time, File head) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public String getBasicInformation() {
        // TODO implement here
        return "";
    }

    /**
     * @param title 
     * @param content 
     * @param proficiency 
     * @param project 
     * @return
     */
    public boolean createSkill(String title, String content, String proficiency, String project) {
        // TODO implement here
        return false;
    }

    /**
     * @param title 
     * @param content 
     * @param proficiency 
     * @param project 
     * @return
     */
    public boolean changeSkill(String title, String content, String proficiency, String project) {
        // TODO implement here
        return false;
    }

    /**
     * @param title 
     * @return
     */
    public boolean deleteSkill(String title) {
        // TODO implement here
        return false;
    }

    /**
     * @param proficiency 
     * @return
     */
    public String getSkillsByProficiency(String proficiency) {
        // TODO implement here
        return "";
    }

    /**
     * @param title 
     * @param content 
     * @param time 
     * @param team 
     * @param responsibility 
     * @return
     */
    public boolean createAchievement(String title, String content, String time, String team, String responsibility) {
        // TODO implement here
        return false;
    }

    /**
     * @param title 
     * @param content 
     * @param time 
     * @param team 
     * @param responsibility 
     * @return
     */
    public boolean changeAchievement(String title, String content, String time, String team, String responsibility) {
        // TODO implement here
        return false;
    }

    /**
     * @param title 
     * @return
     */
    public boolean deleteAchievement(String title) {
        // TODO implement here
        return false;
    }

    /**
     * @param year 
     * @return
     */
    public String getAchievementsByYearForwardSort(int year) {
        // TODO implement here
        return "";
    }

    /**
     * @param year 
     * @return
     */
    public String getAchievementsByYearReverseSort(int year) {
        // TODO implement here
        return "";
    }

    /**
     * @param title 
     * @param content 
     * @param time 
     * @return
     */
    public boolean createRole(String title, String content, String time) {
        // TODO implement here
        return false;
    }

    /**
     * @param title 
     * @param content 
     * @param time 
     * @return
     */
    public boolean changeRole(String title, String content, String time) {
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
     * @param title 
     * @param content 
     * @param time 
     * @param type 
     * @param location 
     * @return
     */
    public boolean createActivity(String title, String content, String time, String type, String location) {
        // TODO implement here
        return false;
    }

    /**
     * @param title 
     * @param content 
     * @param time 
     * @param type 
     * @param location 
     * @return
     */
    public boolean changeActivity(String title, String content, String time, String type, String location) {
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
     * @param title 
     * @param content 
     * @param time 
     * @param type 
     * @param teacher 
     * @param grade 
     * @param credit 
     * @return
     */
    public boolean createCourse(String title, String content, String time, String type, String teacher, int grade, int credit) {
        // TODO implement here
        return false;
    }

    /**
     * @param title 
     * @param content 
     * @param time 
     * @param type 
     * @param teacher 
     * @param grade 
     * @param credit 
     * @return
     */
    public boolean changeCourse(String title, String content, String time, String type, String teacher, int grade, int credit) {
        // TODO implement here
        return false;
    }

    /**
     * @param title 
     * @return
     */
    public boolean deleteCourse(String title) {
        // TODO implement here
        return false;
    }

    /**
     * @param year 
     * @param type 
     * @return
     */
    public String getCoursesByYearAndByTypeForwardSort(int year, String type) {
        // TODO implement here
        return "";
    }

    /**
     * @param year 
     * @param type 
     * @return
     */
    public String getCoursesByYearAndByTypeReverseSort(int year, String type) {
        // TODO implement here
        return "";
    }

    /**
     * @param method 
     * @return
     */
    public int calculateGradePointAverage(int method) {
        // TODO implement here
        return 0;
    }

    /**
     * @param skills_titles 
     * @param achievements_titles 
     * @param roles_titles 
     * @param activities_titles 
     * @return
     */
    public String createCV(String skills_titles, String achievements_titles, String roles_titles, String activities_titles) {
        // TODO implement here
        return "";
    }

}