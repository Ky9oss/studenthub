package controller;
import java.io.File;
import java.util.*;
import model.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.*;

/**
 * 
 */
public class Controller {

    /**
     * Default constructor
     */
    public Controller() {
    }


    public boolean createBasicInformation(String name, int age, String school, String major, String admission_time, String graduation_time, File head) {
        
        BasicInformation basic_information = new BasicInformation(name, age, school, major, admission_time, graduation_time);
        boolean istrue = basic_information.saveBasicInformation();
        return istrue;
    }


    public boolean changeBasicInformation(String name, int age, String school, String major, String admission_time, String graduation_time, File head) {
        BasicInformation basic_information = new BasicInformation(name, age, school, major, admission_time, graduation_time);
        boolean istrue1 = basic_information.deleteBasicInformation();
        if(istrue1==true){
            boolean istrue2 = basic_information.saveBasicInformation();
            return istrue2;
        }else{
            return false;
        }
    }

    /**
     * @return
     */
    public String getBasicInformation() {
        // TODO implement here
        return "";
    }


    public boolean createSkill(String title, String content, String proficiency, String project) {
        // TODO implement here
        return false;
    }


    public boolean changeSkill(String title, String content, String proficiency, String project) {
        // TODO implement here
        return false;
    }


    public boolean deleteSkill(String title) {
        // TODO implement here
        return false;
    }


    public String getSkillsByProficiency(String proficiency) {
        // TODO implement here
        return "";
    }


    public boolean createAchievement(String title, String content, String time, String team, String responsibility) {
        // TODO implement here
        return false;
    }


    public boolean changeAchievement(String title, String content, String time, String team, String responsibility) {
        // TODO implement here
        return false;
    }

 
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

    public String getSkillsTitles(){
        String jsonStr = Skill.getAllSkills();

        try{
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(jsonStr);

            StringBuilder sb = new StringBuilder();

            for (JsonNode node : rootNode) {
                String name = node.get("name").asText();
                sb.append(name).append(",");
            }

            String result = sb.toString().replaceAll(",$", "");
            return result;
        }catch(JsonMappingException e){
            e.printStackTrace();
            return "";
        }catch(JsonProcessingException e){
            e.printStackTrace();
            return "";
        }
    }

    public String getRolesTitles(){
        return "";
    }

    public String getActivitiesTitles(){
        return "";
    }

    public String getAchievementsTitles(){
        return "";
    }

}