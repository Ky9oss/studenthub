package model;

import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

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
        
        try {
            JSONObject jsonObject = new JSONObject(json);

            if (jsonObject.has(Integer.toString(year)&&jsonObject.has(type) {
                String value = jsonObject.get(Integer.toString(year)).getAsString();
                System.out.println("Found matching value for year " + year + ": " + value);
                return "Found matching value for year " + year;
              }
          } catch (IOException e) {
            e.printStackTrace();
          }
        //
        
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
                    
                    jsonObject.getString("type"),
                    
                  );
                    results.StringBuffer(activity);
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
                    
              }
            }
        
            return results;
        return "";
    }

}