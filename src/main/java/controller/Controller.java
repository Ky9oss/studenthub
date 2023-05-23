package controller;
import java.io.File;
import java.net.URISyntaxException;
import java.text.ParseException;
import model.*;

//import java.util.*;

//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.*;
//import com.fasterxml.jackson.core.*;
//import org.json.JSONArray;
import java.io.IOException;
//import org.apache.commons.io.FileUtils;



/**
 * The Controller class serves as the main controller of the application.
 * It contains methods for retrieving information to be displayed in a resume/CV, 
 * as well as creating and saving basic information for the resume/CV.
 * @author KaixuanHou
 * @version 1.0
 */
public class Controller {

    /**
     * Default constructor
     */
    public Controller() {
    }

    /**
     * Retrieves a string representation of all roles for a resume/CV.
     * @return A string representation of all roles for a resume/CV.
     * @throws URISyntaxException If the specified URI syntax is invalid.
     */
    public static String getRolesForCV()throws URISyntaxException{
        String s = Role.getRolesForCV();
        return s;
    }

    /**
     * Retrieves a string representation of all skills for a resume/CV.
     * @return A string representation of all skills for a resume/CV.
     * @throws URISyntaxException If the specified URI syntax is invalid.
     */
    public static String getSkillsForCV()throws URISyntaxException{
        String s = Skill.getSkillsForCV();
        return s;
    }

    /**
     * Retrieves a string representation of all activities for a resume/CV.
     * @return A string representation of all activities for a resume/CV.
     * @throws URISyntaxException If the specified URI syntax is invalid.
     */
    public static String getActivitiesForCV()throws URISyntaxException{
        String s = Activity.getActivitiesForCV();
        return s;
    }

    /**
     * Retrieves a string representation of all achievements for a resume/CV.
     * @return A string representation of all achievements for a resume/CV.
     * @throws URISyntaxException If the specified URI syntax is invalid.
     */
    public static String getAchievementsForCV() throws URISyntaxException{
        String s = Achievement.getAchievementsForCV();
        return s;
    }

    /**
     * Creates basic information for a resume/CV with the given parameters and saves it to file.
     * @param name The name of the individual for whom the resume/CV is being created.
     * @param age The age of the individual for whom the resume/CV is being created.
     * @param school The school attended by the individual for whom the resume/CV is being created.
     * @param major The major of study for the individual for whom the resume/CV is being created.
     * @param admission_time The date of admission for the individual for whom the resume/CV is being created.
     * @param graduation_time The date of graduation for the individual for whom the resume/CV is being created.
     * @param head A file containing the image of the individual for whom the resume/CV is being created.
     * @return The path to the saved image of the individual for whom the resume/CV is being created.
     */
    public String createBasicInformation(String name, int age, String school, String major, String admission_time, String graduation_time, File head) {
        
        BasicInformation basic_information = new BasicInformation(name, age, school, major, admission_time, graduation_time);
        String image_path = basic_information.saveBasicInformation(head);
        return image_path+"/image.png";
    }
    /**
     * Creates basic information for a resume/CV with the given parameters and saves it to file with a specified selection.
     * @param name The name of the individual for whom the resume/CV is being created.
     * @param age The age of the individual for whom the resume/CV is being created.
     * @param school The school attended by the individual for whom the resume/CV is being created.
     * @param major The major of study for the individual for whom the resume/CV is being created.
     * @param admission_time The date of admission for the individual for whom the resume/CV is being created.
     * @param graduation_time The date of graduation for the individual for whom the resume/CV is being created.
     * @param selection A specified selection for saving the basic information to file.
     * @return The path to the saved image of the individual for whom the resume/CV is being created.
     */
    public static String newCreateBasicInformation(String name, int age, String school, String major, String admission_time, String graduation_time, int selection) {
        
        BasicInformation basic_information = new BasicInformation(name, age, school, major, admission_time, graduation_time);
        String image_path = basic_information.newSaveBasicInformation(selection);
        return image_path;
    }

    /**
 * Changes the basic information of the user.
 *
 * @param name The name of the user.
 * @param age The age of the user.
 * @param school The school of the user.
 * @param major The major of the user.
 * @param admission_time The admission time of the user.
 * @param graduation_time The graduation time of the user.
 * @param head The head image file of the user.
 * @return The saved image file path with "/image.png" appended to it on successful save; null on failure to save.
 */
    public static String changeBasicInformation(String name, int age, String school, String major, String admission_time, String graduation_time, File head) {
        BasicInformation basic_information = new BasicInformation(name, age, school, major, admission_time, graduation_time);            
        boolean istrue1 = basic_information.deleteBasicInformation();
        if(istrue1==false){
            return null;
        }     
        String image_path = basic_information.saveBasicInformation(head);
        return image_path+"/image.png";

    }

    /**
 * Changes the basic information of the user.
 *
 * @param name The name of the user.
 * @param age The age of the user.
 * @param school The school of the user.
 * @param major The major of the user.
 * @param admission_time The admission time of the user.
 * @param graduation_time The graduation time of the user.
 * @param selection The selection option (0: default avatar, 1: select from album, 2: take a photo).
 * @return The saved image file path on successful save; null on failure to save.
 */
    //change basic information
    public static String newChangeBasicInformation(String name, int age, String school, String major, String admission_time, String graduation_time, int selection) {
        BasicInformation basic_information = new BasicInformation(name, age, school, major, admission_time, graduation_time);            
        boolean istrue1 = basic_information.deleteBasicInformation();
        if(istrue1==false){
            return null;
        }     
        String image_path = basic_information.newSaveBasicInformation(selection);
        return image_path;

    }

/**
 * Gets the basic information of the user.
 *
 * @return The basic information as a string.
 * @throws URISyntaxException If there's an issue with the URI syntax.
 */
    //get basic information
    public static String getBasicInformation() throws URISyntaxException {
        try {
            String basic_information = BasicInformation.getBasicInformation();
            return basic_information;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "";
    }

/**
 * Creates a new skill item.
 *
 * @param title The title of the skill.
 * @param content The content of the skill.
 * @param proficiency The proficiency level of the skill.
 * @param project The project associated with the skill.
 * @return A status flag indicating whether the item was saved successfully (1: success, 0: failure).
 * @throws URISyntaxException If there's an issue with the URI syntax.
 */
    //create skill
    public static int createSkill(String title, String content, String proficiency, String project) throws URISyntaxException {
        Skill skill = new Skill(title, content, proficiency, project);
        int istrue = skill.saveSkill();
        return istrue;
    }

/**
 * Changes an existing skill item.
 *
 * @param title The title of the skill.
 * @param content The content of the skill.
 * @param proficiency The proficiency level of the skill.
 * @param project The project associated with the skill.
 * @return A status flag indicating whether the item was saved successfully (1: success, 0: failure).
 * @throws URISyntaxException If there's an issue with the URI syntax.
 */
    //change skill
    public static int changeSkill(String title, String content, String proficiency, String project) throws URISyntaxException {
        Skill skill = new Skill(title, content, proficiency, project);
        boolean istrue = Skill.deleteSkill(title);
        if(istrue==false){
            return 0;
        }

        int istrue1 = skill.saveSkill();
        return istrue1;
    }

/**
 * Deletes a skill by title.
 *
 * @param title The title of the skill to delete.
 * @return true if the skill was deleted successfully; false otherwise.
 * @throws URISyntaxException If there's an issue with the URI syntax.
 */
    //delete skill
    public static boolean deleteSkill(String title) throws URISyntaxException {
        boolean istrue = Skill.deleteSkill(title);
        return istrue;
    }

/**
 * Gets skills by proficiency level.
 *
 * @param proficiency The proficiency level of the skills to get.
 * @return The skills as a string.
 * @throws URISyntaxException If there's an issue with the URI syntax.
 */
    //get skills by proficiency
    public static String getSkillsByProficiency(String proficiency) throws URISyntaxException {
        String skills = Skill.getSkillsByProficiency(proficiency);
        return skills;
    }
/**
 * Gets the titles of skills by proficiency level.
 *
 * @param proficiency The proficiency level of the skills to get.
 * @return The skill titles as a string.
 * @throws URISyntaxException If there's an issue with the URI syntax.
 */
    public String getSkillsTitlesByProficiency(String proficiency) throws URISyntaxException {
        String skills = Skill.getSkillsByProficiency(proficiency);
        String skills_titles = Skill.getSkillsTitles(skills);
        return skills_titles;
    }


/**
 * Gets a skill by its title.
 *
 * @param title The title of the skill to get.
 * @return The skill as a string.
 * @throws URISyntaxException If there's an issue with the URI syntax.
 */
    public static String getSkillByTitle(String title) throws URISyntaxException{
        String s = Skill.getSkillByTitle(title);
        return s;
    }
/**
 * Gets an achievement by its title.
 *
 * @param title The title of the achievement to get.
 * @return The achievement as a string.
 * @throws URISyntaxException If there's an issue with the URI syntax.
 */
    public static String getAchivementByTitle(String title) throws URISyntaxException{
        String s = Achievement.getAchievementByTitle(title);
        return s;
    }

/**
 * Gets an activity by its title.
 *
 * @param title The title of the activity to get.
 * @return The activity as a string.
 * @throws URISyntaxException If there's an issue with the URI syntax.
 */
    public static String getActivityByTitle(String title) throws URISyntaxException{
        String s = Activity.getActivityByTitle(title);
        return s;
    }
/**
 * Gets a role by its title.
 *
 * @param title The title of the role to get.
 * @return The role as a string.
 * @throws URISyntaxException If there's an issue with the URI syntax.
 */
    public static String getRoleByTitle(String title) throws URISyntaxException{
        String s = Role.getRoleByTitle(title);
        return s;
    }
/**
 * Gets a course by its title.
 *
 * @param title The title of the course to get.
 * @return The course as a string.
 * @throws URISyntaxException If there's an issue with the URI syntax.
 */
    public static String getCourseByTitle(String title) throws URISyntaxException{
        String s = Course.getCourseByTitle(title);
        return s;
    }



/**
 * Creates a new achievement item.
 *
 * @param title The title of the achievement.
 * @param content The content of the achievement.
 * @param time The time of the achievement.
 * @param team The team associated with the achievement.
 * @param responsibility The responsibility associated with the achievement.
 * @return A status flag indicating whether the item was saved successfully (1: success, 0: failure).
 * @throws URISyntaxException If there's an issue with the URI syntax.
 * @throws IOException If there's an issue with saving the achievement.
 */
    //create achievement
    public static int createAchievement(String title, String content, String time, String team, String responsibility) throws URISyntaxException, IOException {
        Achievement achievement = new Achievement(title, content, time, team, responsibility);
        int istrue = achievement.saveAchievement();
        return istrue;
    }

/**
 * Changes an existing achievement item.
 *
 * @param title The title of the achievement.
 * @param content The content of the achievement.
 * @param time The time of the achievement.
 * @param team The team associated with the achievement.
 * @param responsibility The responsibility associated with the achievement.
 * @return A status flag indicating whether the item was saved successfully (1: success, 0: failure).
 * @throws URISyntaxException If there's an issue with the URI syntax.
 * @throws IOException If there's an issue with saving the achievement.
 */
    //change achievement
    public static int changeAchievement(String title, String content, String time, String team, String responsibility) throws URISyntaxException, IOException {
        Achievement achievement = new Achievement(title, content, time, team, responsibility);
        boolean istrue = Achievement.deleteAchievement(title);
        if(istrue==false){
            return 0;
        }

        int istrue1 = achievement.saveAchievement();
        return istrue1;
    }

 /**
 * Deletes an achievement by its title.
 *
 * @param title The title of the achievement to delete.
 * @return true if the achievement was deleted successfully; false otherwise.
 * @throws URISyntaxException If there's an issue with the URI syntax.
 * @throws ParseException If there's an issue with parsing the data.
 */
    //delete achivement
    public static boolean deleteAchievement(String title) throws URISyntaxException, ParseException{
        boolean istrue = Achievement.deleteAchievement(title);
        return istrue;
    }


    /**

Retrieves a JSON string containing the achievements for a particular year in ascending order.
@param year The year to retrieve achievements for.
@return A JSON string containing the achievements for the specified year in ascending order.
@throws URISyntaxException If there is an issue with the URI syntax.
@throws ParseException If there is an issue parsing the response.
@author KaixuanHou */
    //With foraward sorting, get achivement by year
    public static String getAchievementsByYearForwardSort(int year) throws URISyntaxException, ParseException{
        String json_str = Achievement.getAchievementsByYearForwardSort(year);
        return json_str;
    }

    /**

Retrieves a string containing the titles of the achievements for a particular year in ascending order.
@param year The year to retrieve achievements for.
@return A string containing the titles of the achievements for the specified year in ascending order.
@throws URISyntaxException If there is an issue with the URI syntax.
@throws ParseException If there is an issue parsing the response.
@author KaixuanHou */
    //With foraward sorting, get achivement by year
    public String getAchievementsTitlesByYearForwardSort(int year) throws URISyntaxException, ParseException{
        String json_str = Achievement.getAchievementsByYearForwardSort(year);
        String titles = Achievement.getAchievementsTitles(json_str);
        return titles;
    }

    /**

Retrieves a JSON string containing the achievements for a particular year in descending order.
@param year The year to retrieve achievements for.
@return A JSON string containing the achievements for the specified year in descending order.
@throws URISyntaxException If there is an issue with the URI syntax.
@throws ParseException If there is an issue parsing the response.
@author KaixuanHou */
    //With reverse sorting, get achivement by year
    public static String getAchievementsByYearReverseSort(int year) throws URISyntaxException, ParseException{
        String json_str = Achievement.getAchievementsByYearReverseSort(year);
        return json_str;
    }

    /**

Retrieves a string containing the titles of the achievements for a particular year in descending order.
@param year The year to retrieve achievements for.
@return A string containing the titles of the achievements for the specified year in descending order.
@throws URISyntaxException If there is an issue with the URI syntax.
@throws ParseException If there is an issue parsing the response.
@author KaixuanHou */
    public String getAchievementsTitlesByYearReverseSort(int year) throws URISyntaxException, ParseException{
        String json_str = Achievement.getAchievementsByYearReverseSort(year);
        String titles = Achievement.getAchievementsTitles(json_str);
        return titles;
    }



    /**

Creates a new role with the specified title, content, and time.
@param title The title of the role to create.
@param content The content of the role to create.
@param time The time of the role to create.
@return An integer indicating whether the role creation was successful (1) or not (0).
@throws URISyntaxException If there is an issue with the URI syntax.
@author KaixuanHou */
    //create role
    public static int createRole(String title, String content, String time) throws URISyntaxException {
        Role role = new Role(title, content, time);
        int istrue = role.saveRoles();
        return istrue;
    }


/**

Changes a role with the specified title, content, and time.
@param title The title of the role to change.
@param content The new content for the role.
@param time The new time for the role.
@return An integer indicating whether the role change was successful (1) or not (0).
@throws URISyntaxException If there is an issue with the URI syntax.
@author KaixuanHou */
    //change role
    public static int changeRole(String title, String content, String time) throws URISyntaxException {
        Role role = new Role(title, content, time);
        boolean istrue1 = Role.deleteRoles(title);
        if(istrue1==false){
            return 0;
        }
        int istrue = role.saveRoles();
        return istrue;
    }

/**

Deletes a role with the specified title.
@param title The title of the role to delete.
@return A boolean indicating whether the role deletion was successful (true) or not (false).
@throws URISyntaxException If there is an issue with the URI syntax.
@author KaixuanHou */
    //delete role
    public static boolean deleteRole(String title) throws URISyntaxException {
        boolean istrue = Role.deleteRoles(title);
        return istrue;
    }

/**

Retrieves a JSON string containing the roles for a particular year in ascending order.
@param year The year to retrieve roles for.
@return A JSON string containing the roles for the specified year in ascending order.
@throws ParseException If there is an issue parsing the response.
@throws URISyntaxException If there is an issue with the URI syntax.
@author KaixuanHou */
    //get roles by year with forward sorting
    public static String getRolesByYearForwardSort(int year) throws ParseException, URISyntaxException {
        String json_str = Role.getRolesByYearForwardSort(year);
        return json_str;
    }

    /**

This method gets the titles of roles in a given year with forward sorting.
@param year The year to get the roles for.
@return A string containing the titles of the roles.
@throws ParseException If there is an error parsing the JSON.
@throws URISyntaxException If there is an error parsing the URI.
@author KaixuanHou */
    public String getRolesTitlesByYearForwardSort(int year) throws ParseException, URISyntaxException {
        String json_str = Role.getRolesByYearForwardSort(year);
        String titles = Role.getRolesTitles(json_str);
        return titles;
    }


/**

This method gets the roles in a given year with reverse sorting.
@param year The year to get the roles for.
@return A string containing the roles in JSON format.
@throws ParseException If there is an error parsing the JSON.
@throws URISyntaxException If there is an error parsing the URI.
@author KaixuanHou */
    //get roles by year with reverse sorting
    public static String getRolesByYearReverseSort(int year) throws ParseException, URISyntaxException {
        String json_str = Role.getRolesByYearReverseSort(year);
        return json_str;
    }
/**

This method gets the titles of roles in a given year with reverse sorting.
@param year The year to get the roles for.
@return A string containing the titles of the roles.
@throws ParseException If there is an error parsing the JSON.
@throws URISyntaxException If there is an error parsing the URI.
@author KaixuanHou */
    public String getRolesTitlesByYearReverseSort(int year) throws ParseException, URISyntaxException {
        String json_str = Role.getRolesByYearReverseSort(year);
        String titles = Role.getRolesTitles(json_str);
        return titles;
    }


/**

This method creates a new activity with the given parameters.
@param title The title of the activity.
@param content The content of the activity.
@param time The time of the activity.
@param type The type of the activity.
@param location The location of the activity.
@return An integer representing the success of creating the activity (1 for success, 0 for failure).
@throws URISyntaxException If there is an error parsing the URI.
@author KaixuanHou */
    //create activity
    public static int createActivity(String title, String content, String time, String type, String location) throws URISyntaxException {
        Activity activity = new Activity(title, content, time, type, location);
        int istrue = activity.saveActivity();
        return istrue;
    }

/**

This method changes an existing activity with the given parameters.
@param title The title of the activity.
@param content The content of the activity.
@param time The time of the activity.
@param type The type of the activity.
@param location The location of the activity.
@return An integer representing the success of changing the activity (1 for success, 0 for failure).
@throws URISyntaxException If there is an error parsing the URI.
@author KaixuanHou */
    //change activity
    public static int changeActivity(String title, String content, String time, String type, String location) throws URISyntaxException {
        Activity activity = new Activity(title, content, time, type, location);
        boolean istrue = Activity.deleteActivity(title);
        if(istrue==false){
            return 0;
        }
        int istrue1 = activity.saveActivity();
        return istrue1;
    }


/**

This method deletes an existing activity with the given title.
@param title The title of the activity to be deleted.
@return A boolean representing the success of deleting the activity (true for success, false for failure).
@throws URISyntaxException If there is an error parsing the URI.
@author KaixuanHou */
    //delete activity
    public static boolean deleteActivity(String title) throws URISyntaxException {
        boolean istrue = Activity.deleteActivity(title);
        return istrue;
    }


/**

This method gets the activities in a given year and type with forward sorting.
@param year The year to get the activities for.
@param type The type of the activities to get.
@return A string containing the activities in JSON format.
@throws ParseException If there is an error parsing the JSON.
@throws URISyntaxException If there is an error parsing the URI.
@author KaixuanHou */
    //get activities by year and type with forward sorting
    public static String getActivitiesByYearAndByTypeForwardSort(int year, String type) throws URISyntaxException, ParseException{
        String json_str = Activity.getActivitiesByYearAndByTypeForwardSort(year, type);
        return json_str;
    }
/**

This method gets the titles of activities in a given year and type with forward sorting.
@param year The year to get the activities for.
@param type The type of the activities to get.
@return A string containing the titles of the activities.
@throws ParseException If there is an error parsing the JSON.
@throws URISyntaxException If there is an error parsing the URI.
@author KaixuanHou */
    public String getActivitiesTitlesByYearAndByTypeForwardSort(int year, String type) throws URISyntaxException, ParseException{
        String json_str = Activity.getActivitiesByYearAndByTypeForwardSort(year, type);
        String titles = Activity.getActivitiesTitles(json_str);
        return titles;
    }


/**

This method gets the activities in a given year and type with reverse sorting.
@param year The year to get the activities for.
@param type The type of the activities to get.
@return A string containing the activities in JSON format.
@throws ParseException If there is an error parsing the JSON.
@throws URISyntaxException If there is an error parsing the URI.
@author KaixuanHou */
    //get activities by year and type with reverse sorting
    public static String getActivitiesByYearAndByTypeReverseSort(int year, String type) throws URISyntaxException, ParseException{
        String json_str = Activity.getActivitiesByYearAndByTypeReverseSort(year, type);
        return json_str;
    }
/**

This method gets the titles of activities in a given year and type with reverse sorting.
@param year The year to get the activities for.
@param type The type of the activities to get.
@return A string containing the titles of the activities.
@throws URISyntaxException If there is an error parsing the URI.
@throws ParseException If there is an error parsing the JSON.
@author KaixuanHou */
    public String getActivitiesTitlesByYearAndByTypeReverseSort(int year, String type) throws URISyntaxException, ParseException{
        String json_str = Activity.getActivitiesByYearAndByTypeReverseSort(year, type);
        String titles = Activity.getActivitiesTitles(json_str);
        return titles;
    }
    



/**

This method creates a new course with the given parameters.
@param title The title of the course.
@param content The content of the course.
@param time The time of the course.
@param type The type of the course.
@param teacher The teacher of the course.
@param grade The grade of the course.
@param credit The credit of the course.
@return An integer representing the success of creating the course (1 for success, 0 for failure).
@throws URISyntaxException If there is an error parsing the URI.
@author KaixuanHou */
    //create course
    public static int createCourse(String title, String content, String time, String type, String teacher, int grade, int credit) throws URISyntaxException {
        Course course = new Course(title, content, time, type, teacher, grade, credit);
        int istrue = course.saveCourse();
        return istrue;
    }

/**

This method changes an existing course with the given parameters.
@param title The title of the course.
@param content The content of the course.
@param time The time of the course.
@param type The type of the course.
@param teacher The teacher of the course.
@param grade The grade of the course.
@param credit The credit of the course.
@return An integer representing the success of changing the course (1 for success, 0 for failure).
@throws URISyntaxException If there is an error parsing the URI.
@author KaixuanHou */
    //change course
    public static int changeCourse(String title, String content, String time, String type, String teacher, int grade, int credit) throws URISyntaxException {
        Course course = new Course(title, content, time, type, teacher, grade, credit);
        boolean istrue = Course.deleteCourse(title);
        if(istrue==false){
            return 0;
        }
        int istrue1 = course.saveCourse();
        return istrue1;
    }


/**

This method deletes an existing course with the given title.
@param title The title of the course to be deleted.
@return A boolean representing the success of deleting the course (true for success, false for failure).
@throws URISyntaxException If there is an error parsing the URI.
@author KaixuanHou */
    //delete course
    public static boolean deleteCourse(String title) throws URISyntaxException {
        boolean istrue = Course.deleteCourse(title);
        return istrue;
    }


/**

This method gets the courses in a given year and type with forward sorting.
@param year The year to get the courses for.
@param type The type of the courses to get.
@return A string containing the courses in JSON format.
@throws URISyntaxException If there is an error parsing the URI.
@throws ParseException If there is an error parsing the JSON.
@author KaixuanHou */
    //get courses by year and type with forward sorting
    public static String getCoursesByYearAndByTypeForwardSort(int year, String type) throws URISyntaxException, ParseException {
        String json_str = Course.getCoursesByYearAndByTypeForwardSort(year, type);
        return json_str;
    }
/**

This method gets the titles of courses in a given year and type with forward sorting.
@param year The year to get the courses for.
@param type The type of the courses to get.
@return A string containing the titles of the courses.
@throws URISyntaxException If there is an error parsing the URI.
@throws ParseException If there is an error parsing the JSON.
@author KaixuanHou */
    public String getCoursesTitlesByYearAndByTypeForwardSort(int year, String type) throws URISyntaxException, ParseException {
        String json_str = Course.getCoursesByYearAndByTypeForwardSort(year, type);
        String titles = Course.getCoursesTitles(json_str);
        return titles;
    }
/**

This method gets the courses in a given year and type with reverse sorting.
@param year The year to get the courses for.
@param type The type of the courses to get.
@return A string containing the courses in JSON format.
@throws URISyntaxException If there is an error parsing the URI.
@throws ParseException If there is an error parsing the JSON.
@author KaixuanHou */
    //get courses by year and type with reverse sorting
    public static String getCoursesByYearAndByTypeReverseSort(int year, String type) throws URISyntaxException, ParseException {
        String json_str = Course.getCoursesByYearAndByTypeReverseSort(year, type);
        return json_str;
    }
/**

This method gets the titles of courses in a given year and type with reverse sorting.
@param year The year to get the courses for.
@param type The type of the courses to get.
@return A string containing the titles of the courses.
@throws URISyntaxException If there is an error parsing the URI.
@throws ParseException If there is an error parsing the JSON.
@author KaixuanHou */
    public String getCoursesTitlesByYearAndByTypeReverseSort(int year, String type) throws URISyntaxException, ParseException {
        String json_str = Course.getCoursesByYearAndByTypeReverseSort(year, type);
        String titles = Course.getCoursesTitles(json_str);
        return titles;
    }



    //calculate GPA
/**

Calculates the grade point average based on the given method.
@param method an integer representing the calculation method to be used
@return a double representing the calculated grade point average
@throws URISyntaxException if a URI syntax exception occurs while retrieving course information */
    public static double calculateGradePointAverage(int method) throws URISyntaxException {
        Calculator calculator = new Calculator();
        String grades_credits_types = Course.getAllGradesAndCreditsAndType();
        switch (method) {
            case 1:
                double result1 = calculator.calculateByStandard(grades_credits_types);
                return result1;
            case 2:
                double result2 = calculator.calculateByBeida4_0(grades_credits_types);
                return result2;
            case 3:
                double result3 = calculator.calculateByWorldEducationScore(grades_credits_types);
                return result3; 
            default:
                return 0;
        }
 
    }



/**

Creates a CV based on information retrieved from various sources.
@return a string representing the file path of the created CV in PDF format
@throws URISyntaxException if a URI syntax exception occurs while retrieving information for the CV */ 
    //createCV
    public String createCV() throws URISyntaxException {
        CV cv = new CV();
        String basic_information = BasicInformation.getBasicInformation();
        String skills = Skill.getSkillsForCV();
        String achievements = Achievement.getAchievementsForCV();
        String roles = Role.getRolesForCV();
        String activities = Activity.getActivitiesForCV();
        String pdf_path = cv.createCV(basic_information, skills, achievements, roles, activities);
        return pdf_path;
    }

/**

Retrieves a sorted list of skills for a given profession in reverse chronological order.
@param prof a string representing the desired profession to retrieve skills for
@return a string representing the sorted list of skills */
    public static String getSkillsByYearReverseSort(String prof) {
        return null;
    }

/**

Retrieves a sorted list of skills for a given profession in chronological order.
@param prof a string representing the desired profession to retrieve skills for
@return a string representing the sorted list of skills */
    public static String getSkillsByYearForwardSort(String prof) {
        return null;
    }
/**

Adds leading zeros to a date string in the format "yyyy-mm-dd".
@param date a string representing the date to be formatted
@return a string representing the formatted date with leading zeros in the year and month fields */
    public static String addZeroToDate(String date) {
        String[] dateParts = date.split("-");
        int year = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int day = Integer.parseInt(dateParts[2]);
    
        return String.format("%04d-%02d-%02d", year, month, day);
    }
    /**

Removes leading zeros from a date string in the format "yyyy-mm-dd".
@param date a string representing the date to be formatted
@return a string representing the formatted date without leading zeros in the year and month fields */ 
    public static String deleteZeroToDate(String date) {
        String[] dateParts = date.split("-");
        int year = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int day = Integer.parseInt(dateParts[2]);
    
        return String.format("%d-%d-%d", year, month, day);
    }
}



/* 
    //get skills all titles
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

    //get roles all titles
    public String getRolesTitles(){
        String jsonStr = Role.getAllRoles();

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


    //get activities all titles
    public String getActivitiesTitles(){
        String jsonStr = Activity.getAllActivities();

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


    //get achivements all titles
    public String getAchievementsTitles(){
        String jsonStr = Achievement.getAllAchivements();

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

}
*/