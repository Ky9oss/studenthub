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
import org.json.JSONTokener;
/**
 * 
 */
public class Course {

    public Course(String title, String content, String time, String type, String teacher, int grade, int credit) {
        this.title = title;
        this.content = content;
        this.time = time;
        this.type = type;
        this.teacher = teacher;
        this.grade = grade;
        this.credit = credit;
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
    private String teacher;

    /**
     * 
     */
    private double grade;

    /**
     * 
     */
    private double credit;

    /**
     * @return
     */
    public boolean saveCourse() {
        // TODO implement here
        try {
            // 创建一个FileWriter对象，指定要保存的文件路径
            FileWriter writer = new FileWriter("output.json");

            // 将JSON字符串写入文件中
            writer.write();

            // 关闭文件流
            writer.close();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param title
     * @return
     */
    public static boolean deleteCourse(String title) {
        // TODO implement here
        try {
            // 创建一个FileWriter对象，指定要保存的文件路径
            FileWriter writer = new FileWriter("output.json");

            // 将JSON字符串写入文件中
            writer.write(title);

            // 关闭文件流
            writer.close();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * @param year
     * @param type
     * @return
     */
    public static String getCoursesByYearAndByTypeForwardSort(int year, String type) {
        // TODO implement here
        //以下是新内容

        try {
          // 读取JSON文件并解析为JSONArray对象
          JSONTokener tokener = new JSONTokener(new FileReader("course.json"));
          JSONArray jsonArray = new JSONArray(tokener);

          // 将JSONArray对象转换为Java List对象
          List<JSONObject> list = new ArrayList<JSONObject>();
          for (int i = 0; i < jsonArray.length(); i++) {
              list.add(jsonArray.getJSONObject(i));
          }

          // 使用Collections.sort()方法对Java List对象进行排序
          Collections.sort(list, new Comparator<JSONObject>() {
              @Override
              public int compare(JSONObject o1, JSONObject o2) {
                  // 根据对象的某个值进行排序，这里假设JSON对象中有一个名为"value"的属性
                  String val1 = o1.getInt("year");
                  String val2 = o2.getInt("year");
                  return val1.compareTo(val2);
              }
          });

          // 将Java List对象转换回JSONArray对象
          jsonArray = new JSONArray();
          for (JSONObject obj : list) {
              jsonArray.put(obj);
          }

          // 将JSONArray对象转换为JSON字符串并输出
          System.out.println(jsonArray.toString(4));
      } catch (Exception e) {
          e.printStackTrace();
      }
        
    }

    /**
     * @param year
     * @param type
     * @return
     */
    public static String getCoursesByYearAndByTypeReverseSort(int year, String type) {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public static String getAllGradesAndCreditsAndType() {
        // TODO implement here
        String results = new StringBuffer();
        File folder = new File(".");
            for (File file : folder.listFiles()) {
              // 如果文件是一个Activity文件，读取文件内容并检查关键字是否匹配
              if (file.getName().endsWith(".json")) {
                try {
                  String json = new String(Files.readAllBytes(file.toPath()));
                  JSONObject jsonObject = new JSONObject(json);
                  Activity activity = new Activity(
                    jsonObject.getString("grade"),
                    jsonObject.getString("credit"),
                    
                    jsonObject.getString("type")
                    
                  );
                  results.StringBuffer(activity);
                } catch (IOException e) {
                  e.printStackTrace();
              }
              }
            }
        
            return results;
        return "";
    }

    public static String getAllCourses() {
        String results = new String();
        File folder = new File(".");
            for (File file : folder.listFiles()) {
              // 如果文件是一个Activity文件，读取文件内容并检查关键字是否匹配
              if (file.getName().endsWith(".json")) {
                try {
                  String json = new String(Files.readAllBytes(file.toPath()));
                  JSONObject jsonObject = new JSONObject(json);
                  Activity activity = new Activity(
                    results = jsonObject.getString("course")
                    
                  );
                }  catch (IOException e) {
                  e.printStackTrace();
              }
              }
            }
        
            return results;
        return "";
    }

}