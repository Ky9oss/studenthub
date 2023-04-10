package controller;
import java.io.File;
//import java.util.*;
import model.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.core.*;



public class Controller {

    /**
     * Default constructor
     */
    public Controller() {
    }

    //create basic information
    public boolean createBasicInformation(String name, int age, String school, String major, String admission_time, String graduation_time, File head) {
        
        BasicInformation basic_information = new BasicInformation(name, age, school, major, admission_time, graduation_time);
        boolean istrue1 = basic_information.saveImage(head);
        if(istrue1==false){
            return false;
        }
        String image_path = BasicInformation.getImagePath();
        boolean istrue = basic_information.saveBasicInformation(image_path);
        return istrue;
    }


    //change basic information
    public boolean changeBasicInformation(String name, int age, String school, String major, String admission_time, String graduation_time, File head) {
        BasicInformation basic_information = new BasicInformation(name, age, school, major, admission_time, graduation_time);        
        
        boolean istrue = basic_information.saveImage(head);
        if(istrue==false){
            return false;
        }
        String image_path = BasicInformation.getImagePath();
        
        boolean istrue1 = basic_information.deleteBasicInformation();
        if(istrue1==false){
            return false;
        }
        
        boolean istrue2 = basic_information.saveBasicInformation(image_path);
        return istrue2;

    }


    //get basic information
    public String getBasicInformation() {
        String basic_information = getBasicInformation();
        return basic_information;
    }


    //create skill
    public boolean createSkill(String title, String content, String proficiency, String project) {
        Skill skill = new Skill(title, content, proficiency, project);
        boolean istrue = skill.saveSkill();
        return istrue;
    }


    //change skill
    public boolean changeSkill(String title, String content, String proficiency, String project) {
        Skill skill = new Skill(title, content, proficiency, project);
        boolean istrue = Skill.deleteSkill(title);
        if(istrue==false){
            return false;
        }

        boolean istrue1 = skill.saveSkill();
        return istrue1;
    }


    //delete skill
    public boolean deleteSkill(String title) {
        boolean istrue = Skill.deleteSkill(title);
        return istrue;
    }


    //get skills by proficiency
    public String getSkillsByProficiency(String proficiency) {
        String skills = Skill.getSkillsByProficiency(proficiency);
        return skills;
    }


    //create achievement
    public boolean createAchievement(String title, String content, String time, String team, String responsibility) {
        Achievement achievement = new Achievement(title, content, time, team, responsibility);
        boolean istrue = achievement.saveAchievement();
        return istrue;
    }


    //change achievement
    public boolean changeAchievement(String title, String content, String time, String team, String responsibility) {
        Achievement achievement = new Achievement(title, content, time, team, responsibility);
        boolean istrue = Achievement.deleteAchievement(title);
        if(istrue==false){
            return false;
        }

        boolean istrue1 = achievement.saveAchievement();
        return istrue1;
    }

 
    //delete achivement
    public boolean deleteAchievement(String title) {
        boolean istrue = Achievement.deleteAchievement(title);
        return istrue;
    }


    //With foraward sorting, get achivement by year
    public String getAchievementsByYearForwardSort(int year) {
        String json_str = Achievement.getAchievementsByYearForwardSort(year);
        return json_str;
    }

    //With reverse sorting, get achivement by year
    public String getAchievementsByYearReverseSort(int year) {
        String json_str = Achievement.getAchievementsByYearReverseSort(year);
        return json_str;
    }



    //create role
    public boolean createRole(String title, String content, String time) {
        Role role = new Role(title, content, time);
        boolean istrue = role.saveRole();
        return istrue;
    }



    //change role
    public boolean changeRole(String title, String content, String time) {
        Role role = new Role(title, content, time);
        boolean istrue1 = Role.deleteRole(title);
        if(istrue1==false){
            return false;
        }
        boolean istrue = role.saveRole();
        return istrue;
    }


    //delete role
    public boolean deleteRole(String title) {
        boolean istrue = Role.deleteRole(title);
        return istrue;
    }


    //get roles by year with forward sorting
    public String getRolesByYearForwardSort(int year) {
        String json_str = Role.getRolesByYearForwardSort(year);
        return json_str;
    }



    //get roles by year with reverse sorting
    public String getRolesByYearReverseSort(int year) {
        String json_str = Role.getRolesByYearReverseSort(year);
        return json_str;
    }



    //create activity
    public boolean createActivity(String title, String content, String time, String type, String location) {
        Activity activity = new Activity(title, content, time, type, location);
        boolean istrue = activity.saveActivity();
        return istrue;
    }


    //change activity
    public boolean changeActivity(String title, String content, String time, String type, String location) {
        Activity activity = new Activity(title, content, time, type, location);
        boolean istrue = Activity.deleteActivity(title);
        if(istrue==false){
            return false;
        }
        boolean istrue1 = activity.saveActivity();
        return istrue1;
    }



    //delete activity
    public boolean deleteActivity(String title) {
        boolean istrue = Activity.deleteActivity(title);
        return istrue;
    }



    //get activities by year and type with forward sorting
    public String getActivitiesByYearAndByTypeForwardSort(int year, String type) {
        String json_str = Activity.getActivitiesByYearAndByTypeForwardSort(year, type);
        return json_str;
    }



    //get activities by year and type with reverse sorting
    public String getActivitiesByYearAndByTypeReverseSort(int year, String type) {
        String json_str = Activity.getActivitiesByYearAndByTypeReverseSort(year, type);
        return json_str;
    }


    //create course
    public boolean createCourse(String title, String content, String time, String type, String teacher, int grade, int credit) {
        Course course = new Course(title, content, time, type, teacher, grade, credit);
        boolean istrue = course.saveCourse();
        return istrue;
    }


    //change course
    public boolean changeCourse(String title, String content, String time, String type, String teacher, int grade, int credit) {
        Course course = new Course(title, content, time, type, teacher, grade, credit);
        boolean istrue = Course.deleteCourse(title);
        if(istrue==false){
            return false;
        }
        boolean istrue1 = course.saveCourse();
        return istrue1;
    }



    //delete course
    public boolean deleteCourse(String title) {
        boolean istrue = Course.deleteCourse(title);
        return istrue;
    }



    //get courses by year and type with forward sorting
    public String getCoursesByYearAndByTypeForwardSort(int year, String type) {
        String json_str = Course.getCoursesByYearAndByTypeForwardSort(year, type);
        return json_str;
    }


    //get courses by year and type with reverse sorting
    public String getCoursesByYearAndByTypeReverseSort(int year, String type) {
        String json_str = Course.getCoursesByYearAndByTypeReverseSort(year, type);
        return json_str;
    }



    //calculate GPA
    public double calculateGradePointAverage(int method) {
        Calculator calculator = new Calculator();
        String grades_credits_types = Course.getAllGradesAndCreditsAndType();
        switch (method) {
            case 1:
                double result1 = calculator.calculateByPostgraduateRecommendation(grades_credits_types);
                return result1;
            case 2:
                double result2 = calculator.calculateByStudyingAbroad(grades_credits_types);
                return result2;
            case 3:
                double result3 = calculator.calculateByWorldEducationScore(grades_credits_types);
                return result3; 
            default:
                return 0;
        }
 
    }



    //createCV
    public String createCV(String skills_titles, String achievements_titles, String roles_titles, String activities_titles) {
        CV cv = new CV();
        String basic_information = BasicInformation.getBasicInformation();
        String skills = Skill.getSkillsByTitles(skills_titles);
        String achievements = Achievement.getAchievementsByTitles(achievements_titles);
        String roles = Role.getRolesByTitles(roles_titles);
        String activities = Activity.getActivitiesByTitles(activities_titles);
        String pdf_path = cv.createCV(basic_information, skills, achievements, roles, activities);
        return pdf_path;
    }


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