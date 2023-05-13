package model;

import java.io.*;
import java.util.*;

import com.google.gson.Gson;

/**
 * zu
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

    public static String getSkillsForCV() {
        return "";
    }

    private String skillpath;

    public void setAchievementPath(String path) {
        this.skillpath = path;
    }

    /**
     * @return
     */
    public int saveSkill() throws URISyntaxExceptio {
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

        // Constructor
        Skill newSkill = new Skill(this.title, this.content, this.proficiency, this.project);
        skillList.add(newSkill);

        String savedSkills = gson.toJson(skillList);
        if (setStr(path, savedSkills) == true) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * @param title
     * @return
     */
    public static boolean deleteSkill(String title) {
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
        return setStr(path, deletedSkills);
    }

    /**
     * @param proficiency
     * @return
     */
    public static String getSkillsByProficiency(String proficiency) {
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
        return allSkills;
    }

    /**
     * @param skills_titles
     * @return
     */
    // skills_titles = "Peter,John"
    public static String getSkillsByTitles(String skills_titles) {
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
        return allSkills;
    }

    public static String getAllSkills() {
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
        return allSkills;
    }

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

}

class Main {
    public static void main(String[] args) {
        Skill newSkill = new Skill("Marry", "ddd", "eee", "ffff");
        newSkill.saveSkill();
        System.out.println(Skill.getAllSkills());

        // deleteSkill("Marry");
    }
}

