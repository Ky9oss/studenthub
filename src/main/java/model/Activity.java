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
public class Activity {

    public Activity(String title, String content, String time, String type, String location) {
        this.title = title;
        this.content = content;
        this.time = time;
        this.type = type;
        this.location = location;
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
    private String type;

    /**
     * 
     */
    private String location;


    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }

    public String getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    private String activity_path;

    public void setActivityPath(String path) {
        this.activity_path = path;
    }

    /**
     * @return
     * @throws URISyntaxException
     */
    public int saveActivity() throws URISyntaxException {
        try{
            // 获取程序文件所在的目录
            java.net.URL classResource = Activity.class.getProtectionDomain().getCodeSource().getLocation();
            Path classDirectory = Paths.get(classResource.toURI());
            Path resourcesPath = classDirectory.getParent().getParent();
            Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");

            // 获取resources的文件目录
            String activityPath = mainResourcesPath.toString() + "/activity.json";

            // 设置activity_path变量

            this.setActivityPath(activityPath);

            // 将Activity对象转换成JSON格式
            JSONObject jsonObject = new JSONObject(this);
            String json = jsonObject.toString();

            // 创建resources目录
            File resourcesDirectory = new File(mainResourcesPath.toString());
            if (!resourcesDirectory.exists()) {
                resourcesDirectory.mkdir();
            }
            String actjson = getStr(activityPath);
            Gson gson = new Gson();
            Activity[] Activitys = gson.fromJson(actjson, Activity[].class);
            ArrayList<Activity> activityList = new ArrayList<>(Arrays.asList(Activitys));
            if(this.type.isEmpty()||this.title.isEmpty()||this.content.isEmpty()||this.time.isEmpty()||this.location.isEmpty()){
                return -1;
            }
    
            // Constructor
            Activity newActivity = new Activity(this.title, this.content, this.time,this.type,this.location);
            for(int i = 0; i < activityList.size(); i++){
                if(activityList.get(i).title.equals(newActivity.title)){
                   return -2;
                }
              }
            activityList.add(newActivity);
    
            String savedActivitys = gson.toJson(activityList);
            if(setStr(activityPath, savedActivitys)==true){
                return 1;
            }else{
                return 0;
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * @param title
     * @return
     * @throws URISyntaxException
     */
    public static boolean deleteActivity(String title) throws URISyntaxException {
        //try{
        // 获取程序文件所在的目录
            java.net.URL classResource = Activity.class.getProtectionDomain().getCodeSource().getLocation();
            Path classDirectory = Paths.get(classResource.toURI());
            Path resourcesPath = classDirectory.getParent().getParent();
            Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
            //获取resources的文件目录

             String jsonPath = mainResourcesPath.toString() + "/activity.json";
             Path filePath = Paths.get(jsonPath);
             String pathStr = filePath.toString();
             String json = getStr(pathStr);
             Gson gson = new Gson();
             Activity[] Activitys = gson.fromJson(json, Activity[].class);
             ArrayList<Activity> results = new ArrayList<>(Arrays.asList(Activitys));

            for(int i = 0; i < results.size(); i++){
              if(results.get(i).title.equals(title)){
                results.remove(i);
                break;
            }
            }
        String deletedActivitys = gson.toJson(results);
        return setStr(pathStr, deletedActivitys);}
          /* } catch (URISyntaxException e) {
            e.printStackTrace();
          }     */  
    

    /**
       @param year
     * @param type
     * @throws ParseException
     */
    public static String getActivitiesByYearAndByTypeForwardSort(int year, String typetype)  throws URISyntaxException,ParseException{
        String yearyear = String.valueOf(year);
        //JSONArray results = new JSONArray();

        java.net.URL classResource = Activity.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path resourcesPath = classDirectory.getParent().getParent();
        Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
        //获取resources的文件目录

             String jsonPath = mainResourcesPath.toString() + "/activity.json";
             Path filePath = Paths.get(jsonPath);
             String pathStr = filePath.toString();
             String json = getStr(pathStr);
        Gson gson = new Gson();
        Activity[] Activitys = gson.fromJson(json, Activity[].class);
        ArrayList<Activity> activityList = new ArrayList<>(Arrays.asList(Activitys));

        for(int i = activityList.size() - 1; i >= 0 ; i--){
            if(!(activityList.get(i).getType().equals(typetype) &&activityList.get(i).getTime().contains(yearyear))){
                activityList.remove(i);
            }
        }
        for(int i = 0; i < activityList.size(); i++){
            for(int j = 0; j < activityList.size() - 1 - i; j++){
                SimpleDateFormat ft = new SimpleDateFormat("yy-MM-dd");
                if (ft.parse(activityList.get(j).time).compareTo (ft.parse(activityList.get(j + 1).time)) > 0){
                    Collections.swap(activityList, j, j+1);
                }
            }
        }
        /*Collections.sort(activityList, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                JSONObject obj1 = (JSONObject) o1;
                JSONObject obj2 = (JSONObject) o2;
                return obj1.getString("time").compareTo(obj2.getString("time"));
            }
        });
       /* for(int i = 0; i < activityList.size(); i++){
            for(int j = 0; j < activityList.size() - 1 - i; j++){
                SimpleDateFormat ft = new SimpleDateFormat("yy-MM-dd");
                if (ft.parse(activityList.get(j).getTime().contains(yearyear)).compareTo(ft.parse(activityList.get(j + 1).getTime().contains(yearyear))) > 0){
                    Collections.swap(activityList, j, j+1);
                }
            }
        }*/ 

        String allActivitys = "";
        for(int i = 0; i < activityList.size(); i++) {
            allActivitys = allActivitys + "{\n";
            allActivitys = allActivitys + "\"title\": \"" + activityList.get(i).title + "\",\n";
            allActivitys = allActivitys + "\"content\": \"" + activityList.get(i).content+ "\",\n";
            allActivitys = allActivitys + "\"time\": \"" + activityList.get(i).time + "\",\n";
            allActivitys = allActivitys + "\"type\": \"" + activityList.get(i).type + "\",\n";
            allActivitys = allActivitys + "\"location\": \"" + activityList.get(i).location+ "\",\n";

            if (i == activityList.size() - 1) {
                allActivitys = allActivitys + "}\n";
            }
            else {
                allActivitys = allActivitys + "},\n";
            }
        }
        allActivitys="["+allActivitys+"]";
        return allActivitys;
             /*String json = getStr(pathStr);
             Gson gson = new Gson();
             Activity[] Activitys = gson.fromJson(json, Activity[].class);
             ArrayList<Activity> results = new ArrayList<>(Arrays.asList(Activitys));
             JSONArray jsonArrayResults = new JSONArray(results);
             //if(results.get(i).title.equals(title))
            for(int i = 0; i < results.size(); i++){
                try {
                    String jsonAct = new String(Files.readAllBytes(filePath));
                    JSONObject jsonObject = new JSONObject(jsonAct);
                    Activity activity = new Activity(
                            jsonObject.getString("title"),
                            jsonObject.getString("content"),
                            jsonObject.getString("time"),
                            jsonObject.getString("type"),
                            jsonObject.getString("location"));

                    if (activity.getTime().contains(typetype) &&activity.getTime().contains(yearyear)) {
                        JSONObject object = new JSONObject();
                        object.put("title", activity.getTitle());
                        object.put("content", activity.getContent());
                        object.put("time", activity.getTime());
                        object.put("type", activity.getType());
                        object.put("location", activity.getLocation());
                        jsonArrayResults.put(object);
                    }*/
                } 



    /**
     * @param year
     * @param type
     * @throws ParseException
     */
    public static String getActivitiesByYearAndByTypeReverseSort(int year, String type)  throws URISyntaxException,ParseException{
        String yearyear = String.valueOf(year);
        //JSONArray results = new JSONArray();

        java.net.URL classResource = Activity.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path resourcesPath = classDirectory.getParent().getParent();
        Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
        //获取resources的文件目录

             String jsonPath = mainResourcesPath.toString() + "/activity.json";
             Path filePath = Paths.get(jsonPath);
             String pathStr = filePath.toString();
             String json = getStr(pathStr);
        Gson gson = new Gson();
        Activity[] Activitys = gson.fromJson(json, Activity[].class);
        ArrayList<Activity> activityList = new ArrayList<>(Arrays.asList(Activitys));

       
        for(int i = 0; i < activityList.size(); i++){
            for(int j = 0; j < activityList.size() - 1 - i; j++){
                SimpleDateFormat ft = new SimpleDateFormat("yy-MM-dd");
                if (ft.parse(activityList.get(j).time).compareTo (ft.parse(activityList.get(j + 1).time)) < 0){
                    Collections.swap(activityList, j, j+1);
                }
            }
        }
        for(int i = activityList.size() - 1; i >= 0 ; i--){
            if(!(activityList.get(i).getType().equals(type) &&activityList.get(i).getTime().contains(yearyear))){
                activityList.remove(i);
            }
        }
        /*Collections.sort(activityList, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                JSONObject obj1 = (JSONObject) o1;
                JSONObject obj2 = (JSONObject) o2;
                return obj1.getString("time").compareTo(obj2.getString("time"));
            }
        });
       /* for(int i = 0; i < activityList.size(); i++){
            for(int j = 0; j < activityList.size() - 1 - i; j++){
                SimpleDateFormat ft = new SimpleDateFormat("yy-MM-dd");
                if (ft.parse(activityList.get(j).getTime().contains(yearyear)).compareTo(ft.parse(activityList.get(j + 1).getTime().contains(yearyear))) > 0){
                    Collections.swap(activityList, j, j+1);
                }
            }
        }*/ 

        String allActivitys = "";
        for(int i = 0; i < activityList.size(); i++) {
            allActivitys = allActivitys + "{\n";
            allActivitys = allActivitys + "\"title\": \"" + activityList.get(i).title + "\",\n";
            allActivitys = allActivitys + "\"content\": \"" + activityList.get(i).content+ "\",\n";
            allActivitys = allActivitys + "\"time\": \"" + activityList.get(i).time + "\",\n";
            allActivitys = allActivitys + "\"type\": \"" + activityList.get(i).type + "\",\n";
            allActivitys = allActivitys + "\"location\": \"" + activityList.get(i).location+ "\",\n";

            if (i == activityList.size() - 1) {
                allActivitys = allActivitys + "}\n";
            }
            else {
                allActivitys = allActivitys + "},\n";
            }
        }
        allActivitys="["+allActivitys+"]";
        return allActivitys;
             /*String json = getStr(pathStr);
             Gson gson = new Gson();
             Activity[] Activitys = gson.fromJson(json, Activity[].class);
             ArrayList<Activity> results = new ArrayList<>(Arrays.asList(Activitys));
             JSONArray jsonArrayResults = new JSONArray(results);
             //if(results.get(i).title.equals(title))
            for(int i = 0; i < results.size(); i++){
                try {
                    String jsonAct = new String(Files.readAllBytes(filePath));
                    JSONObject jsonObject = new JSONObject(jsonAct);
                    Activity activity = new Activity(
                            jsonObject.getString("title"),
                            jsonObject.getString("content"),
                            jsonObject.getString("time"),
                            jsonObject.getString("type"),
                            jsonObject.getString("location"));

                    if (activity.getTime().contains(typetype) &&activity.getTime().contains(yearyear)) {
                        JSONObject object = new JSONObject();
                        object.put("title", activity.getTitle());
                        object.put("content", activity.getContent());
                        object.put("time", activity.getTime());
                        object.put("type", activity.getType());
                        object.put("location", activity.getLocation());
                        jsonArrayResults.put(object);
                    }*/
                } 

    /**
     * @param activities_titles
     * @return
     */
    public static String getActivitiesByTitles(String activities_titles)throws URISyntaxException {
        if (activities_titles == "") return "";

        String[] titles = activities_titles.split(",");
        ArrayList<String> titlesList = new ArrayList<>(Arrays.asList(titles));

        java.net.URL classResource = Activity.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path resourcesPath = classDirectory.getParent().getParent();
        Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
        //获取resources的文件目录

        String jsonPath = mainResourcesPath.toString() + "/activity.json";
        Path filePath = Paths.get(jsonPath);
        String pathStr = filePath.toString();
        String json = getStr(pathStr);
        Gson gson = new Gson();
        Activity[] activities = gson.fromJson(json, Activity[].class);
        ArrayList<Activity> activityList = new ArrayList<>(Arrays.asList(activities));

        for (int i = titlesList.size() - 1; i >= 0; i--) {
            if(!titlesList.contains(activityList.get(i).title) ) {
                activityList.remove(i);
            }
        }

        String allActivitys = "";
        for(int i = 0; i < activityList.size(); i++) {
            allActivitys = allActivitys + "{\n";
            allActivitys = allActivitys + "\"title\": \"" + activityList.get(i).title + "\",\n";
            allActivitys = allActivitys + "\"content\": \"" + activityList.get(i).content+ "\",\n";
            allActivitys = allActivitys + "\"time\": \"" + activityList.get(i).time + "\",\n";
            allActivitys = allActivitys + "\"type\": \"" + activityList.get(i).type + "\",\n";
            allActivitys = allActivitys + "\"location\": \"" + activityList.get(i).location+ "\",\n";

            if (i == activityList.size() - 1) {
                allActivitys = allActivitys + "}\n";
            }
            else {
                allActivitys = allActivitys + "},\n";
            }
        }
        allActivitys="["+allActivitys+"]";
        return allActivitys;
    }
        /*try {
            // 根据标题获取文件路径
            String filePath = activities_titles + ".json";

            // 读取文件内容并转换成Activity对象
            String json = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject jsonObject = new JSONObject(json);
            Activity activity = new Activity(
                    jsonObject.getString("title"),
                    jsonObject.getString("content"),
                    jsonObject.getString("time"),
                    jsonObject.getString("type"),
                    jsonObject.getString("location"));

            return activity.toString(); // 返回读取到的Activity对象
        } catch (IOException e) {
            e.printStackTrace();
            return null; // 表示读取失败
        }*/
    

    /**
     * @return
     */
    public static String getallActivitys()throws URISyntaxException{
        java.net.URL classResource = Activity.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path resourcesPath = classDirectory.getParent().getParent();
        Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
        //获取resources的文件目录

             String jsonPath = mainResourcesPath.toString() + "/activity.json";
             Path filePath = Paths.get(jsonPath);
             String pathStr = filePath.toString();
             String json = getStr(pathStr);
        Gson gson = new Gson();
        Activity[] activities = gson.fromJson(json, Activity[].class);
        ArrayList<Activity> activityList = new ArrayList<>(Arrays.asList(activities));

        String allActivitys = "";
        for(int i = 0; i < activityList.size(); i++) {
            allActivitys = allActivitys + "{\n";
            allActivitys = allActivitys + "\"title\": \"" + activityList.get(i).title + "\",\n";
            allActivitys = allActivitys + "\"content\": \"" + activityList.get(i).content+ "\",\n";
            allActivitys = allActivitys + "\"time\": \"" + activityList.get(i).time + "\",\n";
            allActivitys = allActivitys + "\"type\": \"" + activityList.get(i).type + "\",\n";
            allActivitys = allActivitys + "\"location\": \"" + activityList.get(i).location+ "\",\n";


            if (i == activityList.size() - 1) {
                allActivitys = allActivitys + "}\n";
            }
            else {
                allActivitys = allActivitys + "},\n";
            }
        }
        allActivitys="["+allActivitys+"]";
        return allActivitys;
	    /*JSONArray results = new JSONArray();
        
            // 遍历当前目录下的所有文件
            File folder = new File(".");
            for (File file : folder.listFiles()) {
              // 如果文件是一个Activity文件，读取文件内容并检查关键字是否匹配
              if (file.getName().endsWith(".json")) {
                  //String json = new String(Files.readAllBytes(file.toPath()));
                  JSONObject jsonObject = new JSONObject();
                  Activity activity = new Activity(
                    jsonObject.getString("title"),
                    jsonObject.getString("content"),
                    jsonObject.getString("time"),
                    jsonObject.getString("type"),
                    jsonObject.getString("location")
                  );
                
                    results.put(activity);
              }
            }

          return results.toString();*/
}
public static String getActivitiesForCV()throws URISyntaxException{
    java.net.URL classResource = Activity.class.getProtectionDomain().getCodeSource().getLocation();
    Path classDirectory = Paths.get(classResource.toURI());
    Path resourcesPath = classDirectory.getParent().getParent();
    Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
    //获取resources的文件目录

         String jsonPath = mainResourcesPath.toString() + "/activity.json";
         Path filePath = Paths.get(jsonPath);
         String pathStr = filePath.toString();
         String json = getStr(pathStr);
    Gson gson = new Gson();
    Activity[] activities = gson.fromJson(json, Activity[].class);
    ArrayList<Activity> activityList = new ArrayList<>(Arrays.asList(activities));

    String allActivitys = "";
    if(activityList.size()<3)
        {
            return null;
        }
    for(int i = 0; i < 3; i++) {
        allActivitys = allActivitys + "{\n";
        allActivitys = allActivitys + "\"title\": \"" + activityList.get(i).title + "\",\n";
        allActivitys = allActivitys + "\"content\": \"" + activityList.get(i).content+ "\",\n";
        allActivitys = allActivitys + "\"time\": \"" + activityList.get(i).time + "\",\n";
        allActivitys = allActivitys + "\"type\": \"" + activityList.get(i).type + "\",\n";
        allActivitys = allActivitys + "\"location\": \"" + activityList.get(i).location+ "\",\n";


        if (i == activityList.size() - 1) {
            allActivitys = allActivitys + "}\n";
        }
        else {
            allActivitys = allActivitys + "},\n";
        }
    }
    allActivitys="["+allActivitys+"]";
    return allActivitys;
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

public static String getActivityByTitle(String title) throws URISyntaxException {
    if (title == "")
        return "";

    
    java.net.URL classResource = Course.class.getProtectionDomain().getCodeSource().getLocation();
    
    Path classDirectory = Paths.get(classResource.toURI());
    
    Path resourcesPath = classDirectory.getParent().getParent();
    Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
    
    // 获取resources的文件目录

    String jsonPath = mainResourcesPath.toString() + "/activity.json";
    Path filePath = Paths.get(jsonPath);
    String pathStr = filePath.toString();
    String json = getStr(pathStr);
    Gson gson = new Gson();
    Activity[] activities = gson.fromJson(json, Activity[].class);
    ArrayList<Activity> courseList = new ArrayList<>(Arrays.asList(activities));
    

    String theActivity = "";
    for (int i = 0; i < courseList.size(); i++) {
        if (courseList.get(i).title.equals(title)) {
            theActivity = theActivity + "{\n";
            theActivity = theActivity + "\"title\": \"" + courseList.get(i).title + "\",\n";
            theActivity = theActivity + "\"content\": \"" + courseList.get(i).content + "\",\n";
            theActivity = theActivity + "\"time\": \"" + courseList.get(i).time + "\",\n";
            theActivity = theActivity + "\"type\": \"" + courseList.get(i).type + "\",\n";
            theActivity = theActivity + "\"teacher\": \"" + courseList.get(i).location + "\",\n";
            theActivity = theActivity + "}\n";
        }
    }

    return theActivity;
}

public static String getActivitiesTitles(String json_str) {
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


