package model;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import com.google.gson.Gson;
/**

Represents a skill.

<p>
The Skill class represents a skill with its associated properties such as title, content, proficiency level, and project details. A skill object can be instantiated by providing values for these properties through the constructor.

</p>
@author YiruLi

@version 1.0
*/
public class Skill {
/**

Constructs a Skill object with the specified properties.
@param title the title of the skill
@param content the content or description of the skill
@param proficiency the proficiency level of the skill
@param project the project related to the skill
*/
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

    
    private String skillpath;

    public void setAchievementPath(String path) {
        this.skillpath = path;
    }

    public void setSkillPath(String path) {
        this.skillpath = path;
    }
    /**

Saves the Skill object to a JSON file.

<p>
This method saves the Skill object to a JSON file specified by the SkillPath. It serializes the Skill object to JSON format and appends it to the existing JSON data. If the Skill object is successfully saved, it returns 1. If the Skill object is invalid (missing required fields), it returns -1. If the Skill object already exists in the JSON data, it returns -2. If there is an error during the save operation, it returns 0.

</p>
@return 1 if the Skill object is successfully saved, -1 if the Skill object is invalid, -2 if the Skill object already exists, 0 if there is an error

@throws URISyntaxException if there is an error in the URI syntax

@throws IOException if there is an error in reading or writing the JSON file

@author YiruLi

@version 1.0
*/
    public int saveSkill() throws URISyntaxException {
        // -------------done, waiting for changing the JSON path---------------

        java.net.URL classResource = Achievement.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path resourcesPath = classDirectory.getParent().getParent();
        Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
        // 获取resources的文件目录

        String SkillPath = mainResourcesPath.toString() + "/skill.json";

        this.setSkillPath(SkillPath);

        JSONObject jsonObject = new JSONObject(this);
        String json = jsonObject.toString();

        // 创建resources目录
        File resourcesDirectory = new File(mainResourcesPath.toString());
        if (!resourcesDirectory.exists()) {
            resourcesDirectory.mkdir();
        }
        String skilljson = getStr(SkillPath);
        Gson gson = new Gson();
        Skill[] skills = gson.fromJson(skilljson, Skill[].class);
        ArrayList<Skill> skillList = new ArrayList<>(Arrays.asList(skills));
        if(this.proficiency.isEmpty()||this.title.isEmpty()||this.content.isEmpty()||this.project.isEmpty()){
            return -1;
        }

        // Constructor
        Skill newSkill = new Skill(this.title, this.content, this.proficiency, this.project);
        for(int i = 0; i < skillList.size(); i++){
            if(skillList.get(i).title.equals(newSkill.title)){
               return -2;
            }
          }
        skillList.add(newSkill);

        String savedSkills = gson.toJson(skillList);
        if (setStr(SkillPath, savedSkills) == true) {
            return 1;
        } else {
            return 0;
        }
    }

   /**

Deletes a Skill from the skill.json file based on the given title.

<p>
This method deletes a Skill object from the skill.json file by matching the title. It retrieves the JSON data from the skill.json file, deserializes it into Skill objects, searches for a Skill with a matching title, and removes it from the list. The modified Skill list is then serialized back into JSON format and saved to the skill.json file. If the deletion is successful, it returns true. Otherwise, it returns false.

</p>
@param title the title of the Skill to be deleted

@return true if the Skill is successfully deleted, false otherwise

@throws URISyntaxException if there is an error in the URI syntax

@throws IOException if there is an error in reading or writing the JSON file

@author YiruLi

@version 1.0
*/
    public static boolean deleteSkill(String title) throws URISyntaxException {
        // -------------done, waiting for changing the JSON path---------------

        java.net.URL classResource = Achievement.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path resourcesPath = classDirectory.getParent().getParent();
        Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
        // 获取resources的文件目录

        String jsonPath = mainResourcesPath.toString() + "/skill.json";
        Path filePath = Paths.get(jsonPath);
        String pathStr = filePath.toString();
        String json = getStr(pathStr);
        Gson gson = new Gson();
        Skill[] skills = gson.fromJson(json, Skill[].class);
        ArrayList<Skill> skillList = new ArrayList<>(Arrays.asList(skills));

        for (int i = 0; i < skillList.size(); i++) {
            // skillList.get(i).title == title ?
            if (skillList.get(i).title.equals(title)) {
                skillList.remove(i);
                break;
            }
        }

        String deletedSkills = gson.toJson(skillList);
        return setStr(pathStr, deletedSkills);
    }

/**

Retrieves a list of Skills filtered by proficiency from the skill.json file.

<p>
This method retrieves a list of Skills from the skill.json file that match the given proficiency. It reads the JSON data from the skill.json file, deserializes it into Skill objects, filters the list based on the provided proficiency, and returns the filtered Skills as a JSON string. The proficiency can be a single value or multiple values separated by commas. If no Skills match the given proficiency, an empty string is returned.

</p>
@param proficiency the proficiency level(s) to filter the Skills by

@return a JSON string representing the list of Skills matching the given proficiency

@throws URISyntaxException if there is an error in the URI syntax

@throws IOException if there is an error in reading the JSON file

@author YiruLi

@version 1.0
*/
    public static String getSkillsByProficiency(String proficiency) throws URISyntaxException {
        // -------------done, waiting for changing the JSON path---------------
        if (proficiency == "")
            return "";

        String[] proes = proficiency.split(",");
        ArrayList<String> proesList = new ArrayList<>(Arrays.asList(proes));

        java.net.URL classResource = Achievement.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path resourcesPath = classDirectory.getParent().getParent();
        Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
        // 获取resources的文件目录

        String jsonPath = mainResourcesPath.toString() + "/skill.json";
        Path filePath = Paths.get(jsonPath);
        String pathStr = filePath.toString();
        String json = getStr(pathStr);
        Gson gson = new Gson();
        Skill[] skills = gson.fromJson(json, Skill[].class);
        ArrayList<Skill> skillList = new ArrayList<>(Arrays.asList(skills));

        for (int i = skillList.size() - 1; i >= 0; i--) {
            if (!proesList.contains(skillList.get(i).proficiency)) {
                skillList.remove(i);
            }
        }

        String allSkills = "";
        for (int i = 0; i < skillList.size(); i++) {
            allSkills = allSkills + "{\n";
            allSkills = allSkills + "\"title\": \"" + skillList.get(i).title + "\",\n";
            allSkills = allSkills + "\"content\": \"" + skillList.get(i).content + "\",\n";
            allSkills = allSkills + "\"proficiency\": \"" + skillList.get(i).proficiency + "\",\n";
            allSkills = allSkills + "\"project\": \"" + skillList.get(i).project + "\",\n";

            if (i == skillList.size() - 1) {
                allSkills = allSkills + "}\n";
            } else {
                allSkills = allSkills + "},\n";
            }
        }
        allSkills = "["+allSkills+"]";
        return allSkills;
    }
/**

Retrieves a list of Skills based on the provided titles from the skill.json file.
<p>
This method retrieves a list of Skills from the skill.json file that match the given titles. It reads the JSON data from the skill.json file, deserializes it into Skill objects, filters the list based on the provided titles, and returns the filtered Skills as a JSON string. The titles can be a single title or multiple titles separated by commas. If no Skills match the given titles, an empty string is returned.
</p>
@param skills_titles the titles of Skills to retrieve
@return a JSON string representing the list of Skills matching the given titles
@throws URISyntaxException if there is an error in the URI syntax
@throws IOException if there is an error in reading the JSON file
@author YiruLi
@version 1.0
*/
    // skills_titles = "Peter,John"
    public static String getSkillsByTitles(String skills_titles) throws URISyntaxException {
        // -------------done, waiting for changing the JSON path---------------
        if (skills_titles == "")
            return "";

        String[] titles = skills_titles.split(",");
        ArrayList<String> titlesList = new ArrayList<>(Arrays.asList(titles));

        java.net.URL classResource = Achievement.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path resourcesPath = classDirectory.getParent().getParent();
        Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
        // 获取resources的文件目录

        String jsonPath = mainResourcesPath.toString() + "/skill.json";
        Path filePath = Paths.get(jsonPath);
        String pathStr = filePath.toString();
        String json = getStr(pathStr);
        Gson gson = new Gson();
        Skill[] skills = gson.fromJson(json, Skill[].class);
        // 数组 --> 线性表 ： remove（），contains()
        ArrayList<Skill> skillList = new ArrayList<>(Arrays.asList(skills));

        for (int i = skillList.size() - 1; i >= 0; i--) {
            if (!titlesList.contains(skillList.get(i).title)) {
                skillList.remove(i);
            }
        }

        String allSkills = "";
        for (int i = 0; i < skillList.size(); i++) {
            allSkills = allSkills + "{\n";
            allSkills = allSkills + "\"title\": \"" + skillList.get(i).title + "\",\n";
            allSkills = allSkills + "\"content\": \"" + skillList.get(i).content + "\",\n";
            allSkills = allSkills + "\"proficiency\": \"" + skillList.get(i).proficiency + "\",\n";
            allSkills = allSkills + "\"project\": \"" + skillList.get(i).project + "\",\n";

            if (i == skillList.size() - 1) {
                allSkills = allSkills + "}\n";
            } else {
                allSkills = allSkills + "},\n";
            }
        }
        allSkills = "["+allSkills+"]";
        return allSkills;
    }

/**

Retrieves all Skills from the skill.json file.

<p>
This method retrieves all Skills from the skill.json file. It reads the JSON data from the skill.json file, deserializes it into an array of Skill objects, and returns the Skills as a JSON string. Each Skill object in the JSON string includes the title, content, proficiency, and project. If there are no Skills available, an empty string is returned.

</p>
@return a JSON string representing all the Skills

@throws URISyntaxException if there is an error in the URI syntax

@throws IOException if there is an error in reading the JSON file

@author YiruLi

@version 1.0
*/
    public static String getAllSkills() throws URISyntaxException {
        // -------------done, waiting for changing the JSON path---------------
        java.net.URL classResource = Achievement.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path resourcesPath = classDirectory.getParent().getParent();
        Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
        // 获取resources的文件目录

        String jsonPath = mainResourcesPath.toString() + "/skill.json";
        Path filePath = Paths.get(jsonPath);
        String pathStr = filePath.toString();
        String json = getStr(pathStr);
        Gson gson = new Gson();
        Skill[] skillList = gson.fromJson(json, Skill[].class);

        String allSkills = "";
        for (int i = 0; i < skillList.length; i++) {
            allSkills = allSkills + "{\n"; // 转义字符
            allSkills = allSkills + "\"title\": \"" + skillList[i].title + "\",\n";
            allSkills = allSkills + "\"content\": \"" + skillList[i].content + "\",\n";
            allSkills = allSkills + "\"proficiency\": \"" + skillList[i].proficiency + "\",\n";
            allSkills = allSkills + "\"project\": \"" + skillList[i].project + "\",\n";

            if (i == skillList.length - 1) {
                allSkills = allSkills + "}\n";
            } else {
                allSkills = allSkills + "},\n";
            }
        }
        allSkills = "["+allSkills+"]";
        return allSkills;
    }

    public static String getSkillsForCV() throws URISyntaxException {
        // -------------done, waiting for changing the JSON path---------------
        java.net.URL classResource = Achievement.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path resourcesPath = classDirectory.getParent().getParent();
        Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
        // 获取resources的文件目录

        String jsonPath = mainResourcesPath.toString() + "/skill.json";
        Path filePath = Paths.get(jsonPath);
        String pathStr = filePath.toString();
        String json = getStr(pathStr);
        Gson gson = new Gson();
        Skill[] skillList = gson.fromJson(json, Skill[].class);

        String allSkills = "";
        if(skillList.length<3)
        {
            return null;
        }
        for (int i = 0; i < 3; i++) {
            allSkills = allSkills + "{\n"; // 转义字符
            allSkills = allSkills + "\"title\": \"" + skillList[i].title + "\",\n";
            allSkills = allSkills + "\"content\": \"" + skillList[i].content + "\",\n";
            allSkills = allSkills + "\"proficiency\": \"" + skillList[i].proficiency + "\",\n";
            allSkills = allSkills + "\"project\": \"" + skillList[i].project + "\",\n";

            if (i == skillList.length - 1) {
                allSkills = allSkills + "}\n";
            } else {
                allSkills = allSkills + "},\n";
            }
        }
        allSkills = "["+allSkills+"]";
        return allSkills;
    }
    /**

Reads the content of a file and returns it as a string.
@param jsonFile the path of the JSON file to be read
@return the content of the JSON file as a string
@throws IOException if there is an error in reading the JSON file
*/
    public static String getStr(String jsonFile) {
        String jsonStr = "";
        try {
            File file = new File(jsonFile);
            FileReader fileReader = new FileReader(file);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

/**

Sets the content of a file with the provided text.
<p>
This method sets the content of the specified file with the provided text. It first clears the file content, then writes the new text to the file.
</p>
@param jsonFile the path of the file to be updated
@param text the text to be written to the file
@return {@code true} if the file content is successfully updated, {@code false} otherwise
@throws IOException if there is an error in writing to the file
@author YiruLi
@version 1.0
*/
    public static boolean setStr(String jsonFile, String text) {
        try {
            File file = new File(jsonFile);
            FileWriter fileWriter = new FileWriter(file);
            // clean the file
            fileWriter.write("");
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(text);
            fileWriter.flush();
            bw.flush();
            fileWriter.close();
            bw.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


/**

Retrieves the skill information based on the specified title.
<p>
This method searches for the skill with the provided title in the skill.json file and returns its information.
</p>
@param title the title of the skill to retrieve
@return a string representation of the skill information in JSON format, or an empty string if the title is empty or no skill is found
@throws URISyntaxException if there is an error in obtaining the JSON file path
@author YiruLi
@version 1.0
*/
    public static String getSkillByTitle(String title) throws URISyntaxException {
        if (title == "")
            return "";
    
        
        java.net.URL classResource = Course.class.getProtectionDomain().getCodeSource().getLocation();
        
        Path classDirectory = Paths.get(classResource.toURI());
        
        Path resourcesPath = classDirectory.getParent().getParent();
        Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
        
        // 获取resources的文件目录
    
        String jsonPath = mainResourcesPath.toString() + "/skill.json";
        Path filePath = Paths.get(jsonPath);
        String pathStr = filePath.toString();
        String json = getStr(pathStr);
        Gson gson = new Gson();
        Skill[] activities = gson.fromJson(json, Skill[].class);
        ArrayList<Skill> courseList = new ArrayList<>(Arrays.asList(activities));
        
    
        String theActivity = "";
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).title.equals(title)) {
                theActivity = theActivity + "{\n";
                theActivity = theActivity + "\"title\": \"" + courseList.get(i).title + "\",\n";
                theActivity = theActivity + "\"content\": \"" + courseList.get(i).content + "\",\n";
                theActivity = theActivity + "\"proficiency\": \"" + courseList.get(i).proficiency + "\",\n";
                theActivity = theActivity + "\"project\": \"" + courseList.get(i).project + "\",\n";
                theActivity = theActivity + "}\n";
            }
        }
    
        return theActivity;
    }
    
    public static String getSkillsTitles(String json_str) {
        JSONArray jsonString = new JSONArray(json_str);
    
        String titleList = "{";
        //List<String> tempList = new ArrayList<>(Arrays.asList(jsonString));
        for (int i = 0; i < jsonString.length(); i++) {
    
    
            JSONObject jsonObject = jsonString.getJSONObject(i);
            String titles = jsonObject.getString("title");
            titleList = titleList +"\"" +titles +"\"";
            if (i == jsonString.length() - 1) {
                titleList = titleList + "";
            }
            else {
                titleList = titleList + ",";
            }
        }
        titleList = titleList + "}";
        return titleList;
    
        
    
    }
}
/*
class Main {
    public static void main(String[] args) {
        Skill newSkill = new Skill("Marry", "ddd", "eee", "ffff");
        newSkill.saveSkill();
        System.out.println(Skill.getAllSkills());

        // deleteSkill("Marry");
    }
}
*/


