package model;
import java.util.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import java.io.*;
import com.google.gson.Gson;

 import java.io.File;
 import java.io.FileWriter;
 import java.io.IOException;
 import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;


/**
 * 
 */
public class Achievement {

    public Achievement(String title, String content, String time, String team, String responsibility) {
        this.title = title;
        this.content = content;
        this.time = time;
        this.team = team;
        this.responsibility = responsibility;
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
     * 
     */
    private String team;

    /**
     * 
     */
    private String responsibility;

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }

    public String getTeam() {
        return team;
    }

    public String getResponsibility() {
        return responsibility;
    }

    private String achievementpath;

    public void setAchievementPath(String path) {
        this.achievementpath = path;
    }


    /**
     * @return
     */
    public boolean saveAchievement() throws URISyntaxException {
        try{
            // 获取程序文件所在的目录
            java.net.URL classResource = Achievement.class.getProtectionDomain().getCodeSource().getLocation();
            Path classDirectory = Paths.get(classResource.toURI());
            Path resourcesPath = classDirectory.getParent().getParent();
            Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");

            // 获取resources的文件目录
            String AchievementPath = mainResourcesPath.toString() + "/achievement.json";

            // 设置Achievement_path变量

            this.setAchievementPath(AchievementPath);

            // 将Achievement对象转换成JSON格式
            JSONObject jsonObject = new JSONObject(this);
            String json = jsonObject.toString();

            // 创建resources目录
            File resourcesDirectory = new File(mainResourcesPath.toString());
            if (!resourcesDirectory.exists()) {
                resourcesDirectory.mkdir();
            }
            String achjson = getStr(AchievementPath);
            Gson gson = new Gson();
            Achievement[] Achievements = gson.fromJson(achjson, Achievement[].class);
            ArrayList<Achievement> achievementList = new ArrayList<>(Arrays.asList(Achievements));
    
            // Constructor
            Achievement newAchievement = new Achievement(this.title, this.content, this.time,this.team,this.responsibility);
            achievementList.add(newAchievement);
    
            String savedAchievements = gson.toJson(achievementList);
            return setStr(AchievementPath, savedAchievements);
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * @param title
     * @return
     */
    public static boolean deleteAchievement(String title) throws URISyntaxException{
       //try{
        // 获取程序文件所在的目录
        java.net.URL classResource = Achievement.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path resourcesPath = classDirectory.getParent().getParent();
        Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
        //获取resources的文件目录

         String jsonPath = mainResourcesPath.toString() + "/achievement.json";
         Path filePath = Paths.get(jsonPath);
         String pathStr = filePath.toString();
         String json = getStr(pathStr);
         Gson gson = new Gson();
         Achievement[] Achievements = gson.fromJson(json, Achievement[].class);
         ArrayList<Achievement> results = new ArrayList<>(Arrays.asList(Achievements));

        for(int i = 0; i < results.size(); i++){
          if(results.get(i).title.equals(title)){
            results.remove(i);
            break;
        }
        }
    String deletedAchievements = gson.toJson(results);
    return setStr(pathStr, deletedAchievements);}

    /**
     * @param year
     * @return
     */
    public static String getAchievementsByYearForwardSort(int year) throws URISyntaxException,ParseException{
        String yearyear = String.valueOf(year);
        //JSONArray results = new JSONArray();

        java.net.URL classResource = Achievement.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path resourcesPath = classDirectory.getParent().getParent();
        Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
        //获取resources的文件目录

             String jsonPath = mainResourcesPath.toString() + "/achievement.json";
             Path filePath = Paths.get(jsonPath);
             String pathStr = filePath.toString();
             String json = getStr(pathStr);
        Gson gson = new Gson();
        Achievement[] Achievements = gson.fromJson(json, Achievement[].class);
        ArrayList<Achievement> achievementList = new ArrayList<>(Arrays.asList(Achievements));

        for(int i = achievementList.size() - 1; i >= 0 ; i--){
            if(!achievementList.get(i).getTime().contains(yearyear)){
                achievementList.remove(i);
            }
        }
        for(int i = 0; i < achievementList.size(); i++){
            for(int j = 0; j < achievementList.size() - 1 - i; j++){
                SimpleDateFormat ft = new SimpleDateFormat("yy-MM-dd");
                if (ft.parse(achievementList.get(j).time).compareTo (ft.parse(achievementList.get(j + 1).time)) > 0){
                    Collections.swap(achievementList, j, j+1);
                }
            }
        }
        /*Collections.sort(achievementList, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                JSONObject obj1 = (JSONObject) o1;
                JSONObject obj2 = (JSONObject) o2;
                return obj1.getString("time").compareTo(obj2.getString("time"));
            }
        });
       /* for(int i = 0; i < achievementList.size(); i++){
            for(int j = 0; j < achievementList.size() - 1 - i; j++){
                SimpleDateFormat ft = new SimpleDateFormat("yy-MM-dd");
                if (ft.parse(achievementList.get(j).getTime().contains(yearyear)).compareTo(ft.parse(achievementList.get(j + 1).getTime().contains(yearyear))) > 0){
                    Collections.swap(achievementList, j, j+1);
                }
            }
        }*/ 

        String allAchievements = "";
        for(int i = 0; i < achievementList.size(); i++) {
            allAchievements = allAchievements + "{\n";
            allAchievements = allAchievements + "\"title\": \"" + achievementList.get(i).title + "\",\n";
            allAchievements = allAchievements + "\"content\": \"" + achievementList.get(i).content+ "\",\n";
            allAchievements = allAchievements + "\"time\": \"" + achievementList.get(i).time + "\",\n";
            allAchievements = allAchievements + "\"team\": \"" + achievementList.get(i).team + "\",\n";
            allAchievements = allAchievements + "\"responsibility\": \"" + achievementList.get(i).responsibility+ "\",\n";

            if (i == achievementList.size() - 1) {
                allAchievements = allAchievements + "}\n";
            }
            else {
                allAchievements = allAchievements + "},\n";
            }
        }
        allAchievements="["+allAchievements+"]";
        return allAchievements;

    }

    /**
     * @param year
     * @return
     */
    public static String getAchievementsByYearReverseSort(int year)throws URISyntaxException,ParseException {
        String yearyear = String.valueOf(year);
        //JSONArray results = new JSONArray();

        java.net.URL classResource = Achievement.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path resourcesPath = classDirectory.getParent().getParent();
        Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
        //获取resources的文件目录

             String jsonPath = mainResourcesPath.toString() + "/achievement.json";
             Path filePath = Paths.get(jsonPath);
             String pathStr = filePath.toString();
             String json = getStr(pathStr);
        Gson gson = new Gson();
        Achievement[] Achievements = gson.fromJson(json, Achievement[].class);
        ArrayList<Achievement> achievementList = new ArrayList<>(Arrays.asList(Achievements));

        for(int i = achievementList.size() - 1; i >= 0 ; i--){
            if(!achievementList.get(i).getTime().contains(yearyear)){
                achievementList.remove(i);
            }
        }
        for(int i = 0; i < achievementList.size(); i++){
            for(int j = 0; j < achievementList.size() - 1 - i; j++){
                SimpleDateFormat ft = new SimpleDateFormat("yy-MM-dd");
                if (ft.parse(achievementList.get(j).time).compareTo (ft.parse(achievementList.get(j + 1).time)) < 0){
                    Collections.swap(achievementList, j, j+1);
                }
            }
        }
        /*Collections.sort(achievementList, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                JSONObject obj1 = (JSONObject) o1;
                JSONObject obj2 = (JSONObject) o2;
                return obj1.getString("time").compareTo(obj2.getString("time"));
            }
        });
       /* for(int i = 0; i < achievementList.size(); i++){
            for(int j = 0; j < achievementList.size() - 1 - i; j++){
                SimpleDateFormat ft = new SimpleDateFormat("yy-MM-dd");
                if (ft.parse(achievementList.get(j).getTime().contains(yearyear)).compareTo(ft.parse(achievementList.get(j + 1).getTime().contains(yearyear))) > 0){
                    Collections.swap(achievementList, j, j+1);
                }
            }
        }*/ 

        String allAchievements = "";
        for(int i = 0; i < achievementList.size(); i++) {
            allAchievements = allAchievements + "{\n";
            allAchievements = allAchievements + "\"title\": \"" + achievementList.get(i).title + "\",\n";
            allAchievements = allAchievements + "\"content\": \"" + achievementList.get(i).content+ "\",\n";
            allAchievements = allAchievements + "\"time\": \"" + achievementList.get(i).time + "\",\n";
            allAchievements = allAchievements + "\"team\": \"" + achievementList.get(i).team + "\",\n";
            allAchievements = allAchievements + "\"responsibility\": \"" + achievementList.get(i).responsibility+ "\",\n";

            if (i == achievementList.size() - 1) {
                allAchievements = allAchievements + "}\n";
            }
            else {
                allAchievements = allAchievements + "},\n";
            }
        }
        allAchievements="["+allAchievements+"]";
        return allAchievements;
    }

    /**
     * @param achievements_titles
     * @return
     */
    public static String getAchievementsByTitles(String achievements_titles)throws URISyntaxException {
        if (achievements_titles == "") return "";

        String[] titles = achievements_titles.split(",");
        ArrayList<String> titlesList = new ArrayList<>(Arrays.asList(titles));

        java.net.URL classResource = Achievement.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path resourcesPath = classDirectory.getParent().getParent();
        Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
        //获取resources的文件目录

        String jsonPath = mainResourcesPath.toString() + "/achievement.json";
        Path filePath = Paths.get(jsonPath);
        String pathStr = filePath.toString();
        String json = getStr(pathStr);
        Gson gson = new Gson();
        Achievement[] achievements = gson.fromJson(json, Achievement[].class);
        ArrayList<Achievement> achievementList = new ArrayList<>(Arrays.asList(achievements));

        for (int i = titlesList.size() - 1; i >= 0; i--) {
            if(!titlesList.contains(achievementList.get(i).title) ) {
                achievementList.remove(i);
            }
        }

        String allachievements = "";
        for(int i = 0; i < achievementList.size(); i++) {
            allachievements = allachievements + "{\n";
            allachievements = allachievements + "\"title\": \"" + achievementList.get(i).title + "\",\n";
            allachievements = allachievements + "\"content\": \"" + achievementList.get(i).content+ "\",\n";
            allachievements = allachievements + "\"time\": \"" + achievementList.get(i).time + "\",\n";
            allachievements = allachievements + "\"team\": \"" + achievementList.get(i).team + "\",\n";
            allachievements = allachievements + "\"responsibility\": \"" + achievementList.get(i).responsibility+ "\",\n";

            if (i == achievementList.size() - 1) {
                allachievements = allachievements + "}\n";
            }
            else {
                allachievements = allachievements + "},\n";
            }
        }
        return allachievements;
    }

    public static String getAllAchivements()throws URISyntaxException{
	    java.net.URL classResource = Achievement.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path resourcesPath = classDirectory.getParent().getParent();
        Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
        //获取resources的文件目录

             String jsonPath = mainResourcesPath.toString() + "/Achievement.json";
             Path filePath = Paths.get(jsonPath);
             String pathStr = filePath.toString();
             String json = getStr(pathStr);
        Gson gson = new Gson();
        Achievement[] activities = gson.fromJson(json, Achievement[].class);
        ArrayList<Achievement> AchievementList = new ArrayList<>(Arrays.asList(activities));

        String allAchievements = "";
        for(int i = 0; i < AchievementList.size(); i++) {
            allAchievements = allAchievements + "{\n";
            allAchievements = allAchievements + "\"title\": \"" + AchievementList.get(i).title + "\",\n";
            allAchievements = allAchievements + "\"content\": \"" + AchievementList.get(i).content+ "\",\n";
            allAchievements = allAchievements + "\"time\": \"" + AchievementList.get(i).time + "\",\n";
            allAchievements = allAchievements + "\"team\": \"" + AchievementList.get(i).team + "\",\n";
            allAchievements = allAchievements + "\"responsibility\": \"" + AchievementList.get(i).responsibility+ "\",\n";


            if (i == AchievementList.size() - 1) {
                allAchievements = allAchievements + "}\n";
            }
            else {
                allAchievements = allAchievements + "},\n";
            }
        }
        return allAchievements;
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
            if(ch != 13){ //\r need to be eliminated
                sb.append((char) ch);
            }
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
}
