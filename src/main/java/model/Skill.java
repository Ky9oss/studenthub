package model;

import java.io.*;
import java.util.*;

import com.google.gson.Gson;

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
        // -------------done, waiting for changing the JSON path---------------

        String path = "";
        String json = getStr(path);
	    Gson gson = new Gson();
        Skill[] skills = gson.fromJson(json, Skill[].class);
        ArrayList<Skill> skillList = new ArrayList<>(Arrays.asList(skills));

        // Constructor
        Skill newSkill = new Skill(this.title, this.content, this.proficiency, this.project);
        skillList.add(newSkill);

        String savedSkills = gson.toJson(skillList);
        return setStr(path, savedSkills);
    }


    /**
     * @param title 
     * @return
     */
    public static boolean deleteSkill(String title) {
        // -------------done, waiting for changing the JSON path---------------

        String path = "C:/Users/Hanxi/Documents/WeChat Files/wxid_df2qbfla549x22/FileStorage/File/2023-04/studenthub-main/src/main/java/model/1.json";
        String json = getStr(path);
	    Gson gson = new Gson();
        Skill[] skills = gson.fromJson(json, Skill[].class);
        ArrayList<Skill> skillList = new ArrayList<>(Arrays.asList(skills));

        for(int i = 0; i < skillList.size(); i++){
            // skillList.get(i).title == title ?
            if(skillList.get(i).title.equals(title)){
                skillList.remove(i);
                break;
            }
        }

        String deletedSkills = gson.toJson(skillList);
        return setStr(path, deletedSkills);
    }

    /**
     * @param proficiency 
     * @return
     */
    public static String getSkillsByProficiency(String proficiency) {
        // -------------done, waiting for changing the JSON path---------------
        if (proficiency == "") return "";

        String[] proes = proficiency.split(",");
        ArrayList<String> proesList = new ArrayList<>(Arrays.asList(proes));

        String json = getStr("C:/Users/Hanxi/Documents/WeChat Files/wxid_df2qbfla549x22/FileStorage/File/2023-04/studenthub-main/src/main/java/model/1.json");
	    Gson gson = new Gson();
        Skill[] skills = gson.fromJson(json, Skill[].class);
        ArrayList<Skill> skillList = new ArrayList<>(Arrays.asList(skills));

        for (int i = skillList.size() - 1; i >= 0; i--) {
            if( !proesList.contains(skillList.get(i).proficiency) ) {
                skillList.remove(i);
            }
        }

        String allSkills = "";
        for(int i = 0; i < skillList.size(); i++) {
            allSkills = allSkills + "{\n";
            allSkills = allSkills + "\"title\": \"" + skillList.get(i).title + "\",\n";
            allSkills = allSkills + "\"content\": \"" + skillList.get(i).content + "\",\n";
            allSkills = allSkills + "\"proficiency\": \"" + skillList.get(i).proficiency + "\",\n";
            allSkills = allSkills + "\"project\": \"" + skillList.get(i).project + "\",\n";
            
            if (i == skillList.size() - 1) {
                allSkills = allSkills + "}\n";
            }
            else {
                allSkills = allSkills + "},\n";
            }
        }
        return allSkills;
    }


    /**
     * @param skills_titles 
     * @return
     */
    // skills_titles = "Peter,John"
    public static String getSkillsByTitles(String skills_titles) {
        // -------------done, waiting for changing the JSON path---------------
        if (skills_titles == "") return "";

        String[] titles = skills_titles.split(",");
        ArrayList<String> titlesList = new ArrayList<>(Arrays.asList(titles));

        String json = getStr("C:/Users/Hanxi/Documents/WeChat Files/wxid_df2qbfla549x22/FileStorage/File/2023-04/studenthub-main/src/main/java/model/1.json");
	    Gson gson = new Gson();
        Skill[] skills = gson.fromJson(json, Skill[].class);
        //数组 --> 线性表 ： remove（），contains()
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
            }
            else {
                allSkills = allSkills + "},\n";
            }
        }
        return allSkills;
    }


    public static String getAllSkills() {
        // -------------done, waiting for changing the JSON path---------------
        String json = getStr("C:/Users/Hanxi/Documents/WeChat Files/wxid_df2qbfla549x22/FileStorage/File/2023-04/studenthub-main/src/main/java/model/1.json");
	    Gson gson = new Gson();
        Skill[] skillList = gson.fromJson(json, Skill[].class);

        String allSkills = "";
        for(int i = 0; i < skillList.length; i++){
            allSkills = allSkills + "{\n"; //转义字符
            allSkills = allSkills + "\"title\": \"" + skillList[i].title + "\",\n";
            allSkills = allSkills + "\"content\": \"" + skillList[i].content + "\",\n";
            allSkills = allSkills + "\"proficiency\": \"" + skillList[i].proficiency + "\",\n";
            allSkills = allSkills + "\"project\": \"" + skillList[i].project + "\",\n";
            
            if(i == skillList.length - 1){
                allSkills = allSkills + "}\n";
            }
            else{
                allSkills = allSkills + "},\n";
            }
        }
        return allSkills;
    }


    public static String getStr(String jsonFile){
        String jsonStr = "";
        try {
            File file = new File(jsonFile);
            FileReader fileReader = new FileReader(file);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile),"utf-8");
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

    public static boolean setStr(String jsonFile, String text){
        try{
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
        }catch(Exception e ){
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        // Skill newSkill = new Skill("Marry", "ddd", "eee", "ffff");
        // newSkill.saveSkill();
        System.out.println(getAllSkills());

        // deleteSkill("Marry");
    }
}
