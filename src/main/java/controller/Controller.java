package controller;
import java.io.File;
import java.net.URISyntaxException;
import java.text.ParseException;

//import java.util.*;
import model.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.*;
import org.json.JSONArray;
import java.io.IOException;
import org.apache.commons.io.FileUtils;



public class Controller {

    /**
     * Default constructor
     */
    public Controller() {
    }


    public static String getRolesForCV()throws URISyntaxException{
        String s = Role.getRolesForCV();
        return s;
    }
    public static String getSkillsForCV()throws URISyntaxException{
        String s = Skill.getSkillsForCV();
        return s;
    }
    public static String getActivitiesForCV()throws URISyntaxException{
        String s = Activity.getActivitiesForCV();
        return s;
    }
    public static String getAchievementsForCV() throws URISyntaxException{
        String s = Achievement.getAchievementsForCV();
        return s;
    }


    public String createBasicInformation(String name, int age, String school, String major, String admission_time, String graduation_time, File head) {
        
        BasicInformation basic_information = new BasicInformation(name, age, school, major, admission_time, graduation_time);
        String image_path = basic_information.saveBasicInformation(head);
        return image_path+"/image.png";
    }

    public String newCreateBasicInformation(String name, int age, String school, String major, String admission_time, String graduation_time, int selection) {
        
        BasicInformation basic_information = new BasicInformation(name, age, school, major, admission_time, graduation_time);
        String image_path = basic_information.newSaveBasicInformation(selection);
        return image_path;
    }

    //change basic information
    public static String changeBasicInformation(String name, int age, String school, String major, String admission_time, String graduation_time, File head) {
        BasicInformation basic_information = new BasicInformation(name, age, school, major, admission_time, graduation_time);            
        boolean istrue1 = basic_information.deleteBasicInformation();
        if(istrue1==false){
            return null;
        }     
        String image_path = basic_information.saveBasicInformation(head);
        return image_path+"/image.png";

    }

    //change basic information
    public String newChangeBasicInformation(String name, int age, String school, String major, String admission_time, String graduation_time, int selection) {
        BasicInformation basic_information = new BasicInformation(name, age, school, major, admission_time, graduation_time);            
        boolean istrue1 = basic_information.deleteBasicInformation();
        if(istrue1==false){
            return null;
        }     
        String image_path = basic_information.newSaveBasicInformation(selection);
        return image_path;

    }


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


    //create skill
    public static int createSkill(String title, String content, String proficiency, String project) throws URISyntaxException {
        Skill skill = new Skill(title, content, proficiency, project);
        int istrue = skill.saveSkill();
        return istrue;
    }


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


    //delete skill
    public static boolean deleteSkill(String title) throws URISyntaxException {
        boolean istrue = Skill.deleteSkill(title);
        return istrue;
    }


    //get skills by proficiency
    public static String getSkillsByProficiency(String proficiency) throws URISyntaxException {
        String skills = Skill.getSkillsByProficiency(proficiency);
        return skills;
    }

    public String getSkillsTitlesByProficiency(String proficiency) throws URISyntaxException {
        String skills = Skill.getSkillsByProficiency(proficiency);
        String skills_titles = Skill.getSkillsTitles(skills);
        return skills_titles;
    }



    public static String getSkillByTitle(String title) throws URISyntaxException{
        String s = Skill.getSkillByTitle(title);
        return s;
    }

    public static String getAchivementByTitle(String title) throws URISyntaxException{
        String s = Achievement.getAchievementByTitle(title);
        return s;
    }

    public static String getActivityByTitle(String title) throws URISyntaxException{
        String s = Activity.getActivityByTitle(title);
        return s;
    }

    public static String getRoleByTitle(String title) throws URISyntaxException{
        String s = Role.getRoleByTitle(title);
        return s;
    }

    public static String getCourseByTitle(String title) throws URISyntaxException{
        String s = Course.getCourseByTitle(title);
        return s;
    }




    //create achievement
    public static int createAchievement(String title, String content, String time, String team, String responsibility) throws URISyntaxException, IOException {
        Achievement achievement = new Achievement(title, content, time, team, responsibility);
        int istrue = achievement.saveAchievement();
        return istrue;
    }


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

 
    //delete achivement
    public static boolean deleteAchievement(String title) throws URISyntaxException, ParseException{
        boolean istrue = Achievement.deleteAchievement(title);
        return istrue;
    }


    //With foraward sorting, get achivement by year
    public static String getAchievementsByYearForwardSort(int year) throws URISyntaxException, ParseException{
        String json_str = Achievement.getAchievementsByYearForwardSort(year);
        return json_str;
    }

    //With foraward sorting, get achivement by year
    public String getAchievementsTitlesByYearForwardSort(int year) throws URISyntaxException, ParseException{
        String json_str = Achievement.getAchievementsByYearForwardSort(year);
        String titles = Achievement.getAchievementsTitles(json_str);
        return titles;
    }

    //With reverse sorting, get achivement by year
    public static String getAchievementsByYearReverseSort(int year) throws URISyntaxException, ParseException{
        String json_str = Achievement.getAchievementsByYearReverseSort(year);
        return json_str;
    }
    public String getAchievementsTitlesByYearReverseSort(int year) throws URISyntaxException, ParseException{
        String json_str = Achievement.getAchievementsByYearReverseSort(year);
        String titles = Achievement.getAchievementsTitles(json_str);
        return titles;
    }



    //create role
    public static int createRole(String title, String content, String time) throws URISyntaxException {
        Role role = new Role(title, content, time);
        int istrue = role.saveRoles();
        return istrue;
    }



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


    //delete role
    public static boolean deleteRole(String title) throws URISyntaxException {
        boolean istrue = Role.deleteRoles(title);
        return istrue;
    }


    //get roles by year with forward sorting
    public static String getRolesByYearForwardSort(int year) throws ParseException, URISyntaxException {
        String json_str = Role.getRolesByYearForwardSort(year);
        return json_str;
    }

    public String getRolesTitlesByYearForwardSort(int year) throws ParseException, URISyntaxException {
        String json_str = Role.getRolesByYearForwardSort(year);
        String titles = Role.getRolesTitles(json_str);
        return titles;
    }



    //get roles by year with reverse sorting
    public static String getRolesByYearReverseSort(int year) throws ParseException, URISyntaxException {
        String json_str = Role.getRolesByYearReverseSort(year);
        return json_str;
    }

    public String getRolesTitlesByYearReverseSort(int year) throws ParseException, URISyntaxException {
        String json_str = Role.getRolesByYearReverseSort(year);
        String titles = Role.getRolesTitles(json_str);
        return titles;
    }



    //create activity
    public static int createActivity(String title, String content, String time, String type, String location) throws URISyntaxException {
        Activity activity = new Activity(title, content, time, type, location);
        int istrue = activity.saveActivity();
        return istrue;
    }


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



    //delete activity
    public static boolean deleteActivity(String title) throws URISyntaxException {
        boolean istrue = Activity.deleteActivity(title);
        return istrue;
    }



    //get activities by year and type with forward sorting
    public static String getActivitiesByYearAndByTypeForwardSort(int year, String type) throws URISyntaxException, ParseException{
        String json_str = Activity.getActivitiesByYearAndByTypeForwardSort(year, type);
        return json_str;
    }

    public String getActivitiesTitlesByYearAndByTypeForwardSort(int year, String type) throws URISyntaxException, ParseException{
        String json_str = Activity.getActivitiesByYearAndByTypeForwardSort(year, type);
        String titles = Activity.getActivitiesTitles(json_str);
        return titles;
    }



    //get activities by year and type with reverse sorting
    public static String getActivitiesByYearAndByTypeReverseSort(int year, String type) throws URISyntaxException, ParseException{
        String json_str = Activity.getActivitiesByYearAndByTypeReverseSort(year, type);
        return json_str;
    }

    public String getActivitiesTitlesByYearAndByTypeReverseSort(int year, String type) throws URISyntaxException, ParseException{
        String json_str = Activity.getActivitiesByYearAndByTypeReverseSort(year, type);
        String titles = Activity.getActivitiesTitles(json_str);
        return titles;
    }
    




    //create course
    public static int createCourse(String title, String content, String time, String type, String teacher, int grade, int credit) throws URISyntaxException {
        Course course = new Course(title, content, time, type, teacher, grade, credit);
        int istrue = course.saveCourse();
        return istrue;
    }


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



    //delete course
    public static boolean deleteCourse(String title) throws URISyntaxException {
        boolean istrue = Course.deleteCourse(title);
        return istrue;
    }



    //get courses by year and type with forward sorting
    public static String getCoursesByYearAndByTypeForwardSort(int year, String type) throws URISyntaxException, ParseException {
        String json_str = Course.getCoursesByYearAndByTypeForwardSort(year, type);
        return json_str;
    }

    public String getCoursesTitlesByYearAndByTypeForwardSort(int year, String type) throws URISyntaxException, ParseException {
        String json_str = Course.getCoursesByYearAndByTypeForwardSort(year, type);
        String titles = Course.getCoursesTitles(json_str);
        return titles;
    }

    //get courses by year and type with reverse sorting
    public static String getCoursesByYearAndByTypeReverseSort(int year, String type) throws URISyntaxException, ParseException {
        String json_str = Course.getCoursesByYearAndByTypeReverseSort(year, type);
        return json_str;
    }

    public String getCoursesTitlesByYearAndByTypeReverseSort(int year, String type) throws URISyntaxException, ParseException {
        String json_str = Course.getCoursesByYearAndByTypeReverseSort(year, type);
        String titles = Course.getCoursesTitles(json_str);
        return titles;
    }



    //calculate GPA

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


    public static String getSkillsByYearReverseSort(String prof) {
        return null;
    }


    public static String getSkillsByYearForwardSort(String prof) {
        return null;
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