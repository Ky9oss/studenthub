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
    private int grade;

    /**
     * 
     */
    private int credit;


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

    public String getTeacher() {
        return teacher;
    }

    public int getGrade() {
        return grade;
    }

    public int getCredit() {
        return credit;
    }

    private String course_path;

    public void setCoursePath(String path) {
        this.course_path = path;
    }

    /**
     * @return
     */
    public int saveCourse() throws URISyntaxException {
        try {
            // 获取程序文件所在的目录
            java.net.URL classResource = Course.class.getProtectionDomain().getCodeSource().getLocation();
            Path classDirectory = Paths.get(classResource.toURI());
            Path resourcesPath = classDirectory.getParent().getParent();
            Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");

            // 获取resources的文件目录
            String coursePath = mainResourcesPath.toString() + "/course.json";

            // 设置course_path变量

            this.setCoursePath(coursePath);

            // 将Course对象转换成JSON格式
            JSONObject jsonObject = new JSONObject(this);
            String json = jsonObject.toString();

            // 创建resources目录
            File resourcesDirectory = new File(mainResourcesPath.toString());
            if (!resourcesDirectory.exists()) {
                resourcesDirectory.mkdir();
            }
            String coursejson = getStr(coursePath);
            Gson gson = new Gson();
            Course[] Courses = gson.fromJson(coursejson, Course[].class);
            ArrayList<Course> courseList = new ArrayList<>(Arrays.asList(Courses));
            if(this.type.isEmpty()||this.title.isEmpty()||this.content.isEmpty()||this.time.isEmpty()||this.teacher.isEmpty()){
                return -1;
            }

            // Constructor
            Course newCourse = new Course(this.title, this.content, this.time, this.type, this.teacher, this.grade, this.credit);
            for(int i = 0; i < courseList.size(); i++){
                if(courseList.get(i).title.equals(newCourse.title)){
                   return -2;
                }
              }
            courseList.add(newCourse);

            String savedCourses = gson.toJson(courseList);
            if (setStr(coursePath, savedCourses) == true) {
                return 1;
            } else {
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
     */
    public static boolean deleteCourse(String title) throws URISyntaxException {
        // try{
        // 获取程序文件所在的目录
        java.net.URL classResource = Course.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path resourcesPath = classDirectory.getParent().getParent();
        Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
        // 获取resources的文件目录

        String jsonPath = mainResourcesPath.toString() + "/course.json";
        Path filePath = Paths.get(jsonPath);
        String pathStr = filePath.toString();
        String json = getStr(pathStr);
        Gson gson = new Gson();
        Course[] Courses = gson.fromJson(json, Course[].class);
        ArrayList<Course> results = new ArrayList<>(Arrays.asList(Courses));

        for (int i = 0; i < results.size(); i++) {
            if (results.get(i).title.equals(title)) {
                results.remove(i);
                break;
            }
        }
        String deletedCourses = gson.toJson(results);
        return setStr(pathStr, deletedCourses);
    }

    /**
     * @param year
     * @param type
     * @return
     */
    public static String getCoursesByYearAndByTypeForwardSort(int year, String typetype)
            throws URISyntaxException, ParseException {

        String yearyear = String.valueOf(year);
        // JSONArray results = new JSONArray();

        java.net.URL classResource = Course.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path resourcesPath = classDirectory.getParent().getParent();
        Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
        // 获取resources的文件目录

        String jsonPath = mainResourcesPath.toString() + "/course.json";
        Path filePath = Paths.get(jsonPath);
        String pathStr = filePath.toString();
        String json = getStr(pathStr);
        Gson gson = new Gson();
        Course[] Courses = gson.fromJson(json, Course[].class);
        ArrayList<Course> courseList = new ArrayList<>(Arrays.asList(Courses));

        for (int i = courseList.size() - 1; i >= 0; i--) {
            if (!(courseList.get(i).getType().equals(typetype) && courseList.get(i).getTime().contains(yearyear))) {
                courseList.remove(i);
            }
        }
        for (int i = 0; i < courseList.size(); i++) {
            for (int j = 0; j < courseList.size() - 1 - i; j++) {
                SimpleDateFormat ft = new SimpleDateFormat("yy-MM-dd");
                if (ft.parse(courseList.get(j).time).compareTo(ft.parse(courseList.get(j + 1).time)) > 0) {
                    Collections.swap(courseList, j, j + 1);
                }
            }
        }

        String allCourses = "";
        for (int i = 0; i < courseList.size(); i++) {
            allCourses = allCourses + "{\n";
            allCourses = allCourses + "\"title\": \"" + courseList.get(i).title + "\",\n";
            allCourses = allCourses + "\"content\": \"" + courseList.get(i).content + "\",\n";
            allCourses = allCourses + "\"time\": \"" + courseList.get(i).time + "\",\n";
            allCourses = allCourses + "\"type\": \"" + courseList.get(i).type + "\",\n";
            allCourses = allCourses + "\"teacher\": \"" + courseList.get(i).teacher + "\",\n";
            allCourses = allCourses + "\"grade\": \"" + courseList.get(i).grade + "\",\n";
            allCourses = allCourses + "\"credit\": \"" + courseList.get(i).credit + "\",\n";
            // @@

            if (i == courseList.size() - 1) {
                allCourses = allCourses + "}\n";
            } else {
                allCourses = allCourses + "},\n";
            }
        }
        allCourses = "[" + allCourses + "]";
        return allCourses;
        /*
         * try {
         * // 读取JSON文件并解析为JSONArray对象
         * JSONTokener tokener = new JSONTokener(new FileReader("course.json"));
         * JSONArray jsonArray = new JSONArray(tokener);
         * 
         * // 将JSONArray对象转换为Java List对象
         * List<JSONObject> list = new ArrayList<JSONObject>();
         * for (int i = 0; i < jsonArray.length(); i++) {
         * list.add(jsonArray.getJSONObject(i));
         * }
         * 
         * // 使用Collections.sort()方法对Java List对象进行排序
         * Collections.sort(list, new Comparator<JSONObject>() {
         * 
         * @Override
         * public int compare(JSONObject o1, JSONObject o2) {
         * // 根据对象的某个值进行排序，这里假设JSON对象中有一个名为"value"的属性
         * String val1 = o1.getInt("year");
         * String val2 = o2.getInt("year");
         * return val1.compareTo(val2);
         * }
         * });
         * 
         * // 将Java List对象转换回JSONArray对象
         * jsonArray = new JSONArray();
         * for (JSONObject obj : list) {
         * jsonArray.put(obj);
         * }
         * 
         * // 将JSONArray对象转换为JSON字符串并输出
         * System.out.println(jsonArray.toString(4));
         * } catch (Exception e) {
         * e.printStackTrace();
         * }
         */

    }

    /**
     * @param year
     * @param type
     * @return
     */
    public static String getCoursesByYearAndByTypeReverseSort(int year, String type)
            throws URISyntaxException, ParseException {
        String yearyear = String.valueOf(year);
        // JSONArray results = new JSONArray();

        java.net.URL classResource = Course.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path resourcesPath = classDirectory.getParent().getParent();
        Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
        // 获取resources的文件目录

        String jsonPath = mainResourcesPath.toString() + "/course.json";
        Path filePath = Paths.get(jsonPath);
        String pathStr = filePath.toString();
        String json = getStr(pathStr);
        Gson gson = new Gson();
        Course[] Courses = gson.fromJson(json, Course[].class);
        ArrayList<Course> courseList = new ArrayList<>(Arrays.asList(Courses));

        for (int i = 0; i < courseList.size(); i++) {
            for (int j = 0; j < courseList.size() - 1 - i; j++) {
                SimpleDateFormat ft = new SimpleDateFormat("yy-MM-dd");
                if (ft.parse(courseList.get(j).time).compareTo(ft.parse(courseList.get(j + 1).time)) < 0) {
                    Collections.swap(courseList, j, j + 1);
                }
            }
        }
        for (int i = courseList.size() - 1; i >= 0; i--) {
            if (!(courseList.get(i).getType().equals(type) && courseList.get(i).getTime().contains(yearyear))) {
                courseList.remove(i);
            }
        }

        String allCourses = "";
        for (int i = 0; i < courseList.size(); i++) {
            allCourses = allCourses + "{\n";
            allCourses = allCourses + "\"title\": \"" + courseList.get(i).title + "\",\n";
            allCourses = allCourses + "\"content\": \"" + courseList.get(i).content + "\",\n";
            allCourses = allCourses + "\"time\": \"" + courseList.get(i).time + "\",\n";
            allCourses = allCourses + "\"type\": \"" + courseList.get(i).type + "\",\n";
            allCourses = allCourses + "\"teacher\": \"" + courseList.get(i).teacher + "\",\n";
            allCourses = allCourses + "\"grade\": \"" + courseList.get(i).grade + "\",\n";
            allCourses = allCourses + "\"credit\": \"" + courseList.get(i).credit + "\",\n";
            // @@

            if (i == courseList.size() - 1) {
                allCourses = allCourses + "}\n";
            } else {
                allCourses = allCourses + "},\n";
            }
        }
        allCourses = "[" + allCourses + "]";
        return allCourses;
    }

    /**
     * @return
     */
    public static String getAllGradesAndCreditsAndType() throws URISyntaxException {
        java.net.URL classResource = Course.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path resourcesPath = classDirectory.getParent().getParent();
        Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
        // 获取resources的文件目录

        String jsonPath = mainResourcesPath.toString() + "/course.json";
        Path filePath = Paths.get(jsonPath);
        String pathStr = filePath.toString();
        String json = getStr(pathStr);
        Gson gson = new Gson();
        Course[] courses = gson.fromJson(json, Course[].class);
        ArrayList<Course> courseList = new ArrayList<>(Arrays.asList(courses));

        String allCourses = "";
        for (int i = 0; i < courseList.size(); i++) {
            allCourses = allCourses + "{\n";
            allCourses = allCourses + "\"grade\": \"" + courseList.get(i).grade + "\",\n";
            allCourses = allCourses + "\"credit\": \"" + courseList.get(i).credit + "\",\n";
            allCourses = allCourses + "\"type\": \"" + courseList.get(i).type + "\",\n";

            if (i == courseList.size() - 1) {
                allCourses = allCourses + "}\n";
            } else {
                allCourses = allCourses + "},\n";
            }
        }
        allCourses = "[" + allCourses + "]";
        return allCourses;
    }

    public static String getAllCourses() throws URISyntaxException {
        java.net.URL classResource = Course.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path resourcesPath = classDirectory.getParent().getParent();
        Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
        // 获取resources的文件目录

        String jsonPath = mainResourcesPath.toString() + "/course.json";
        Path filePath = Paths.get(jsonPath);
        String pathStr = filePath.toString();
        String json = getStr(pathStr);
        Gson gson = new Gson();
        Course[] courses = gson.fromJson(json, Course[].class);
        ArrayList<Course> courseList = new ArrayList<>(Arrays.asList(courses));

        String allCourses = "";
        for (int i = 0; i < courseList.size(); i++) {
            allCourses = allCourses + "{\n";
            allCourses = allCourses + "\"title\": \"" + courseList.get(i).title + "\",\n";
            allCourses = allCourses + "\"content\": \"" + courseList.get(i).content + "\",\n";
            allCourses = allCourses + "\"time\": \"" + courseList.get(i).time + "\",\n";
            allCourses = allCourses + "\"type\": \"" + courseList.get(i).type + "\",\n";
            allCourses = allCourses + "\"teacher\": \"" + courseList.get(i).teacher + "\",\n";
            allCourses = allCourses + "\"grade\": \"" + courseList.get(i).grade + "\",\n";
            allCourses = allCourses + "\"credit\": \"" + courseList.get(i).credit + "\",\n";

            if (i == courseList.size() - 1) {
                allCourses = allCourses + "}\n";
            } else {
                allCourses = allCourses + "},\n";
            }
        }
        allCourses = "[" + allCourses + "]";
        return allCourses;
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
                if (ch != 13) { // \r need to be eliminated
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

    // 任务3 ： 根据所给的JSON格式的String，获取所有title;根据一个title获取一组数据
    // public static String getRoleByTitle(String title){
    // return "";
    // }
    // 传入title3 返回不带[]的一整行

    // public static String[] getRolesTitles(String json_str){
    // //下面是一个输出结果的格式的示例
    // String[] results = {"title1", "title2", "title3", "title4", "title5"};
    // return results;
    // }
    public static String getCourseByTitle(String title) throws URISyntaxException {
        if (title == "")
            return "";

        
        java.net.URL classResource = Course.class.getProtectionDomain().getCodeSource().getLocation();
        
        Path classDirectory = Paths.get(classResource.toURI());
        
        Path resourcesPath = classDirectory.getParent().getParent();
        Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
        
        // 获取resources的文件目录

        String jsonPath = mainResourcesPath.toString() + "/course.json";
        Path filePath = Paths.get(jsonPath);
        String pathStr = filePath.toString();
        String json = getStr(pathStr);
        Gson gson = new Gson();
        Course[] courses = gson.fromJson(json, Course[].class);
        ArrayList<Course> courseList = new ArrayList<>(Arrays.asList(courses));
        

        String theCourse = "";
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).title.equals(title)) {
                theCourse = theCourse + "{\n";
                theCourse = theCourse + "\"title\": \"" + courseList.get(i).title + "\",\n";
                theCourse = theCourse + "\"content\": \"" + courseList.get(i).content + "\",\n";
                theCourse = theCourse + "\"time\": \"" + courseList.get(i).time + "\",\n";
                theCourse = theCourse + "\"type\": \"" + courseList.get(i).type + "\",\n";
                theCourse = theCourse + "\"teacher\": \"" + courseList.get(i).teacher + "\",\n";
                theCourse = theCourse + "\"grade\": \"" + courseList.get(i).grade + "\",\n";
                theCourse = theCourse + "\"credit\": \"" + courseList.get(i).credit + "\",\n";
                theCourse = theCourse + "}\n";
            }
        }

        return theCourse;
    }

    public static String getCoursesTitles(String json_str) {
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

        
        // input 一整个或好多行，输出{"title1", "title2", "title3", "title4", "title5"}
        // 下面是一个输出结果的格式的示例
        // String[] results = { "title1", "title2", "title3", "title4", "title5" };
        // return results;

        // [{"responsibility":"responsibility","time":"2022-5-25","team":"team","title":"title3","content":"111"},
        // {"responsibility":"responsibility","time":"2022-6-9","team":"team","title":"title1","content":"222"},
        // {"responsibility":"responsibility","time":"2022-12-21","team":"team","title":"title5","content":"333"}]

    }
}