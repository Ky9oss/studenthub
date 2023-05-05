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
     */
    public boolean saveActivity() {
        try {
            // 获取程序文件所在的目录
            java.net.URL classResource = BasicInformation.class.getProtectionDomain().getCodeSource().getLocation();
            Path classDirectory = Paths.get(classResource.toURI());
            Path resourcesPath = classDirectory.getParent().getParent();
            Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");

            // 获取resources的文件目录
            String activityPath = mainResourcesPath.toString() + "activity.json";

            // 设置image_path变量

            this.setActivityPath(activityPath);

            // 将Activity对象转换成JSON格式
            JSONObject jsonObject = new JSONObject(this);
            String json = jsonObject.toString();

            // 创建resources目录
            File resourcesDirectory = new File(mainResourcesPath.toString());
            if (!resourcesDirectory.exists()) {
                resourcesDirectory.mkdir();
            }

            if (jsonFile.exists()) {
                // 如果文件已存在，删除它
                jsonFile.delete();
            }
            if (jsonFile.createNewFile()) {
                FileWriter writer = new FileWriter(jsonFile);
                writer.write(json);
                writer.close();
            }
            // 将JSON字符串写入
            FileWriter writer = new FileWriter("activity.json");
            writer.write(json);
            writer.close();

            // 返回相对路径
            return resourcesDirectory.getPath();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return null; // 表示保存失败
        }
    }

    /**
     * @param title
     * @return
     */
    public static boolean deleteActivity(String title) {
        // 根据标题获取文件路径
        String filePath = title + ".json";

        // 创建对应的文件对象
        File file = new File(filePath);

        // 如果文件存在且删除成功，返回true
        if (file.exists() && file.delete()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param year
     * @param type
     * @return
     */
    public static string getActivitiesByYearAndByTypeForwardSort(int year, String typetype) {
        yearyear = String.valueOf(year);
        List<Activity> results = new ArrayList<>();

        // 遍历当前目录下的所有文件
        File folder = new File(".");
        for (File file : folder.listFiles()) {
            // 如果文件是一个Activity文件，读取文件内容并检查关键字是否匹配
            if (file.getName().endsWith(".json")) {
                try {
                    String json = new String(Files.readAllBytes(file.toPath()));
                    JSONObject jsonObject = new JSONObject(json);
                    Activity activity = new Activity(
                            jsonObject.getString("title"),
                            jsonObject.getString("content"),
                            jsonObject.getString("time"),
                            jsonObject.getString("type"),
                            jsonObject.getString("location"));

                    if (activity.getTime().contains(yearyear) &&
                            activity.getType().contains(typetype)) {
                        results.add(activity);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        for (int i = results.size() - 1; i >= 0; i--) {
            if (!results.get(i).year.substring(0, 4).equals(String.valueOf(year))) {
                results.remove(i);
            }
        }

        for (int i = 0; i < results.size(); i++) {
            for (int j = 0; j < results.size() - 1 - i; j++) {
                SimpleDateFormat ft = new SimpleDateFormat("yy-MM-dd");
                if (ft.parse(results.get(j).year).compareTo(ft.parse(results.get(j + 1).year)) > 0) {
                    Collections.swap(results, j, j + 1);
                }
            }
        }

        for (int i = 0; i < results.size(); i++) {
            str = str + "{\n";
            String str = String.join(",", results.get(i));// StringUtils.join(list, ",");
            return str;

            if (i == results.size() - 1) {
                str = str + "}\n";
            } else {
                str = str + "},\n";
            }
        }
        return str;

    }

    /**
     * @param year
     * @param type
     * @return
     */
    public static String getActivitiesByYearAndByTypeReverseSort(int year, String type) {
        yearyear = String.valueOf(year);
        List<Activity> results = new ArrayList<>();

        // 遍历当前目录下的所有文件
        File folder = new File(".");
        for (File file : folder.listFiles()) {
            // 如果文件是一个Activity文件，读取文件内容并检查关键字是否匹配
            if (file.getName().endsWith(".json")) {
                try {
                    String json = new String(Files.readAllBytes(file.toPath()));
                    JSONObject jsonObject = new JSONObject(json);
                    Activity activity = new Activity(
                            jsonObject.getString("title"),
                            jsonObject.getString("content"),
                            jsonObject.getString("time"),
                            jsonObject.getString("type"),
                            jsonObject.getString("location"));

                    if (activity.getTime().contains(yearyear) &&
                            activity.getType().contains(typetype)) {
                        results.add(activity);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        for (int i = results.size() - 1; i >= 0; i--) {
            if (!results.get(i).year.substring(0, 4).equals(String.valueOf(year))) {
                results.remove(i);
            }
        }

        for (int i = 0; i < results.size(); i++) {
            for (int j = 0; j < results.size() - 1 - i; j++) {
                SimpleDateFormat ft = new SimpleDateFormat("yy-MM-dd");
                if (ft.parse(results.get(j).year).compareTo(ft.parse(results.get(j + 1).year)) > 0) {
                    Collections.swap(results, j, j + 1);
                }
            }
        }

        for (int i = 0; i < results.size(); i++) {
            str = str + "{\n";
            String str = String.join(",", results.get(i));// StringUtils.join(list, ",");
            return str;

            if (i == results.size() - 1) {
                str = str + "}\n";
            } else {
                str = str + "},\n";
            }
        }
        return str;

    }

    }

    /**
     * @param activities_titles
     * @return
     */
    public static String getActivitiesByTitles(String activities_titles) {
        try {
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

            return activity; // 返回读取到的Activity对象
        } catch (IOException e) {
            e.printStackTrace();
            return null; // 表示读取失败
        }
    }

    /**
     * @return
     */
    public static string getAllActivities(){
	    List<Activity> results = new ArrayList<>();
        
            // 遍历当前目录下的所有文件
            File folder = new File(".");
            for (File file : folder.listFiles()) {
              // 如果文件是一个Activity文件，读取文件内容并检查关键字是否匹配
              if (file.getName().endsWith(".json")) {
                try {
                  String json = new String(Files.readAllBytes(file.toPath()));
                  JSONObject jsonObject = new JSONObject(json);
                  Activity activity = new Activity(
                    jsonObject.getString("title"),
                    jsonObject.getString("content"),
                    jsonObject.getString("time"),
                    jsonObject.getString("type"),
                    jsonObject.getString("location")
                  );
                    results.add(activity);
              }
            }
            String str = String.join(",", results);// StringUtils.join(list, ",");
            return str;
          }
}
