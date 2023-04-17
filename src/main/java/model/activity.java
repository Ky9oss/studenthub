package model;

import java.util.*;

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

    /**
     * @return
     */
    public boolean saveActivity() {
        try {
            // 将Activity对象转换成JSON格式
            JSONObject jsonObject = new JSONObject(this);
            String json = jsonObject.toString();

            // 将JSON字符串写入
            FileWriter writer = new FileWriter("file01.txt");// 自定义的文件夹
            writer.write(json);
            writer.close();

            return true; // 表示保存成功
        } catch (IOException e) {
            e.printStackTrace();
            return false; // 表示保存失败
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

        String str = String.join(",", results);// StringUtils.join(list, ",");
        return str;
    }

    /**
     * @param year
     * @param type
     * @return
     */
    public static String getActivitiesByYearAndByTypeReverseSort(int year, String type) {
        // TODO implement here
        return "";
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

    }

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