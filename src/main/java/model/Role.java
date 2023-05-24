package model;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.*;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 Represents a role with its title, content, and time.
@author YiruLi
@since 2023-05-24
Constructs a new Role object with the specified title, content, and time.
@param title The title of the role.
@param content The content of the role.
@param time The time of the role.
*/
public class Role {
    public Role(String title, String content, String time) {
        this.title = title;

        this.content = content;
        this.time = time;
    }

    public Role() {

    }

    /**
     *
     */
    private String title;

    /**
     *
     */
    private String time;

    /**
     *
     */
    private String content;

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    public String getRoles_titles() {
        return content;
    }
    

    /**
     * @return
     */
    // 任务1 ： 存之前判断：输入的数据是否为空，如果为空，返回-1;输入的标题是否重复，如果重复，返回-2。如果成功，return
    // 1,如果因为其他原因失败，return 0
    /*
     * 这是一个示例
     * public int saveRoles() {
     * String path =
     * "/home/kadrex/Study/codes/java/jiti_lab/studenthub/src/main/resources/role.json";
     * String json = getStr(path);
     * Gson gson = new Gson();
     * Role[] roles = gson.fromJson(json, Role[].class);
     * ArrayList<Role> roleList = new ArrayList<>(Arrays.asList(roles));
     * 
     * // Constructor
     * Role newRole = new Role(this.title, this.year, this.roles_titles);
     * roleList.add(newRole);
     * 
     * String savedRoles = gson.toJson(roleList);
     * if(setStr(path, savedRoles)==true){
     * return 1;
     * }
     * else{
     * return 0;
     * }
     * //再加return-1和return-2的情况
     * xxx
     * return -1
     * xxx
     * return -2
     * }
     */
    // 相应的，ControllerTest所对应的每一项测试也要全部更改
    // 任务2 ： 取出三组数据，JSON格式的String
    // 任务3 ： 根据所给的JSON格式的String，获取所有title;根据一个title获取一组数据
    // public static String getRoleByTitle(String title){
    // return "";
    // }
    // public static String[] getRolesTitles(String json_str){
    // //下面是一个输出结果的格式的示例
    // String[] results = {"title1", "title2", "title3", "title4", "title5"};
    // return results;
    // }
    

    private String rolepath;

    public void setRolePath(String path) {
        this.rolepath = path;
    }

/**
@author YiruLi
@since 2023-05-24+
Saves the role to the role.json file in the resources directory.

<p>
This method retrieves the path of the role.json file in the resources directory and saves the current role object to it in JSON format.

</p>
<p>
Note: The role.json file must exist in the resources directory prior to calling this method.

</p>
@return 1 if the role is successfully saved, 0 if an error occurs while saving, -1 if the title, content, or time is empty, -2 if a role with the same title already exists.

@throws URISyntaxException If the URL of the class resource cannot be converted to a URI.
*/
    public int saveRoles() throws URISyntaxException {
        java.net.URL classResource = Achievement.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path resourcesPath = classDirectory.getParent().getParent();
        Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
        // 获取resources的文件目录

        String RolePath = mainResourcesPath.toString() + "/role.json";

        this.setRolePath(RolePath);

        // 将Achievement对象转换成JSON格式
        JSONObject jsonObject = new JSONObject(this);
        String json = jsonObject.toString();

        // 创建resources目录
        File resourcesDirectory = new File(mainResourcesPath.toString());
        if (!resourcesDirectory.exists()) {
            resourcesDirectory.mkdir();
        }
        String achjson = getStr(RolePath);
        Gson gson = new Gson();
        Role[] roles = gson.fromJson(achjson, Role[].class);
        ArrayList<Role> roleList = new ArrayList<>(Arrays.asList(roles));
        if(this.title.isEmpty()||this.content.isEmpty()||this.time.isEmpty()){
            return -1;
        }

        // Constructor
        Role newRole = new Role(this.title, this.content, this.time);
        for(int i = 0; i < roleList.size(); i++){
            if(roleList.get(i).title.equals(newRole.title)){
               return -2;
            }
          }
        roleList.add(newRole);

        String savedRoles = gson.toJson(roleList);
        if (setStr(RolePath, savedRoles) == true) {
            return 1;
        } else {
            return 0;
        }
        // 再加return-1和return-2的情况
    }
    /**

    Deletes roles based on the specified title.

    <p>
    This method allows you to delete roles from a JSON file based on their title. The JSON file should be located in the "src/main/resources" directory of the project.

    </p>
    @param title the title of the roles to be deleted

    @return {@code true} if the roles were successfully deleted, {@code false} otherwise

    @throws URISyntaxException if the URI syntax is incorrect

    @see Role

    @see Gson

    @see java.net.URL

    @see java.nio.file.Path

    @author YiruLi

    @version 1.0
    */
    public static boolean deleteRoles(String title) throws URISyntaxException {
        java.net.URL classResource = Achievement.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path resourcesPath = classDirectory.getParent().getParent();
        Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
        // 获取resources的文件目录

        String jsonPath = mainResourcesPath.toString() + "/role.json";
        Path filePath = Paths.get(jsonPath);
        String pathStr = filePath.toString();
        String json = getStr(pathStr);
        Gson gson = new Gson();
        Role[] roles = gson.fromJson(json, Role[].class);
        ArrayList<Role> roleList = new ArrayList<>(Arrays.asList(roles));

        for (int i = 0; i < roleList.size(); i++) {
            if (roleList.get(i).title.equals(title)) {
                roleList.remove(i);
                break;
            }
        }
        String deletedRoles = gson.toJson(roleList);
        return setStr(pathStr, deletedRoles);
    }

   /**

    Retrieves roles from a JSON file based on the specified year and returns them in reverse chronological order.

    <p>
    This method retrieves roles from a JSON file located in the "src/main/resources" directory of the project. The roles are filtered based on the specified year and sorted in reverse chronological order based on their time.

    </p>
    @param year the year to filter the roles

    @return a JSON string representing the roles in reverse chronological order

    @throws ParseException if an error occurs while parsing the role's time

    @throws URISyntaxException if the URI syntax is incorrect

    @see Role

    @see Gson

    @see java.net.URL

    @see java.nio.file.Path

    @see java.text.SimpleDateFormat

    @see java.util.Collections

    @author YiruLi

    @version 1.0
    */
    public static String getRolesByYearReverseSort(int year) throws ParseException, URISyntaxException {
        java.net.URL classResource = Achievement.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path resourcesPath = classDirectory.getParent().getParent();
        Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
        // 获取resources的文件目录

        String jsonPath = mainResourcesPath.toString() + "/role.json";
        Path filePath = Paths.get(jsonPath);
        String pathStr = filePath.toString();
        String json = getStr(pathStr);
        Gson gson = new Gson();
        Role[] roles = gson.fromJson(json, Role[].class);
        ArrayList<Role> roleList = new ArrayList<>(Arrays.asList(roles));
        
        String yearyear = String.valueOf(year);
        for (int i = roleList.size() - 1; i >= 0; i--) {
            if (!roleList.get(i).getTime().contains(yearyear)) {
                roleList.remove(i);
            }
        }

        for (int i = 0; i < roleList.size(); i++) {
            for (int j = 0; j < roleList.size() - 1 - i; j++) {
                SimpleDateFormat ft = new SimpleDateFormat("yy-MM-dd");
                if (ft.parse(roleList.get(j).time).compareTo(ft.parse(roleList.get(j + 1).time)) < 0) {
                    Collections.swap(roleList, j, j + 1);
                }
            }
        }

        String allRoles = "";
        for (int i = 0; i < roleList.size(); i++) {
            allRoles = allRoles + "{\n";
            allRoles = allRoles + "\"title\": \"" + roleList.get(i).title + "\",\n";
            allRoles = allRoles + "\"content\": \"" + roleList.get(i).content + "\",\n";
            allRoles = allRoles + "\"time\": \"" + roleList.get(i).time + "\",\n";

            if (i == roleList.size() - 1) {
                allRoles = allRoles + "}\n";
            } else {
                allRoles = allRoles + "},\n";
            }
        }
        allRoles = "["+allRoles+"]";
        return allRoles;
    }

  /**

    Retrieves roles from a JSON file based on the specified year and returns them in chronological order.

    <p>
    This method retrieves roles from a JSON file located in the "src/main/resources" directory of the project. The roles are filtered based on the specified year and sorted in chronological order based on their time.

    </p>
    @param year the year to filter the roles

    @return a JSON string representing the roles in chronological order

    @throws ParseException if an error occurs while parsing the role's time

    @throws URISyntaxException if the URI syntax is incorrect

    @see Role

    @see Gson

    @see java.net.URL

    @see java.nio.file.Path

    @see java.text.SimpleDateFormat

    @see java.util.Collections

    @author YiruLi

    @version 1.0
    */
    public static String getRolesByYearForwardSort(int year) throws ParseException, URISyntaxException {
        java.net.URL classResource = Achievement.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path resourcesPath = classDirectory.getParent().getParent();
        Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
        // 获取resources的文件目录

        String jsonPath = mainResourcesPath.toString() + "/role.json";
        Path filePath = Paths.get(jsonPath);
        String pathStr = filePath.toString();
        String json = getStr(pathStr);
        Gson gson = new Gson();
        Role[] roles = gson.fromJson(json, Role[].class);
        ArrayList<Role> roleList = new ArrayList<>(Arrays.asList(roles));

        String yearyear = String.valueOf(year);
        for (int i = roleList.size() - 1; i >= 0; i--) {
            if (!roleList.get(i).getTime().contains(yearyear)) {
                roleList.remove(i);
            }
        }

        for (int i = 0; i < roleList.size(); i++) {
            for (int j = 0; j < roleList.size() - 1 - i; j++) {
                SimpleDateFormat ft = new SimpleDateFormat("yy-MM-dd");
                if (ft.parse(roleList.get(j).time).compareTo(ft.parse(roleList.get(j + 1).time)) > 0) {
                    Collections.swap(roleList, j, j + 1);
                }
            }
        }

        String allRoles = "";
        for (int i = 0; i < roleList.size(); i++) {
            allRoles = allRoles + "{\n";
            allRoles = allRoles + "\"title\": \"" + roleList.get(i).title + "\",\n";
            allRoles = allRoles + "\"content\": \"" + roleList.get(i).content + "\",\n";
            allRoles = allRoles + "\"time\": \"" + roleList.get(i).time + "\",\n";

            if (i == roleList.size() - 1) {
                allRoles = allRoles + "}\n";
            } else {
                allRoles = allRoles + "},\n";
            }
        }
        allRoles = "["+allRoles+"]";
        return allRoles;
    }

    /**

    Retrieves roles from a JSON file based on the specified role titles and returns them as a JSON string.

    <p>
    This method retrieves roles from a JSON file located in the "src/main/resources" directory of the project. The roles are filtered based on the provided role titles and returned as a JSON string.

    </p>
    @param roles_titles a comma-separated string of role titles

    @return a JSON string representing the matching roles

    @throws URISyntaxException if the URI syntax is incorrect

    @see Role

    @see Gson

    @see java.net.URL

    @see java.nio.file.Path

    @author YiruLi

    @version 1.0
    */
    public static String getRolesByTitles(String roles_titles) throws URISyntaxException {
        if (roles_titles == "")
            return "";

        String[] titles = roles_titles.split(",");
        ArrayList<String> titlesList = new ArrayList<>(Arrays.asList(titles));

        java.net.URL classResource = Achievement.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path resourcesPath = classDirectory.getParent().getParent();
        Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
        // 获取resources的文件目录

        String jsonPath = mainResourcesPath.toString() + "/role.json";
        Path filePath = Paths.get(jsonPath);
        String pathStr = filePath.toString();
        String json = getStr(pathStr);
        Gson gson = new Gson();
        Role[] roles = gson.fromJson(json, Role[].class);
        ArrayList<Role> roleList = new ArrayList<>(Arrays.asList(roles));

        for (int i = titlesList.size() - 1; i >= 0; i--) {
            if (!titlesList.contains(roleList.get(i).title)) {
                roleList.remove(i);
            }
        }

        String allRoles = "";
        for (int i = 0; i < roleList.size(); i++) {
            allRoles = allRoles + "{\n";
            allRoles = allRoles + "\"title\": \"" + roleList.get(i).title + "\",\n";
            allRoles = allRoles + "\"content\": \"" + roleList.get(i).content + "\",\n";
            allRoles = allRoles + "\"time\": \"" + roleList.get(i).time + "\",\n";

            if (i == roleList.size() - 1) {
                allRoles = allRoles + "}\n";
            } else {
                allRoles = allRoles + "},\n";
            }
        }
        allRoles = "["+allRoles+"]";
        return allRoles;
    }
    
    /**

    Retrieves all roles from a JSON file and returns them as a JSON string.

    <p>
    This method retrieves all roles from a JSON file located in the "src/main/resources" directory of the project and returns them as a JSON string.

    </p>
    @return a JSON string representing all the roles

    @throws URISyntaxException if the URI syntax is incorrect

    @see Role

    @see Gson

    @see java.net.URL

    @see java.nio.file.Path

    @author YiruLi

    @version 1.0
    */
    public static String getAllRoles() throws URISyntaxException {
        java.net.URL classResource = Achievement.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path resourcesPath = classDirectory.getParent().getParent();
        Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
        // 获取resources的文件目录

        String jsonPath = mainResourcesPath.toString() + "/role.json";
        Path filePath = Paths.get(jsonPath);
        String pathStr = filePath.toString();
        String json = getStr(pathStr);
        Gson gson = new Gson();
        Role[] roleList = gson.fromJson(json, Role[].class);

        String allRoles = "";
        for (int i = 0; i < roleList.length; i++) {
            allRoles = allRoles + "{\n";
            allRoles = allRoles + "\"title\": \"" + roleList[i].title + "\",\n";
            allRoles = allRoles + "\"content\": \"" + roleList[i].content + "\",\n";
            allRoles = allRoles + "\"time\": \"" + roleList[i].time + "\",\n";

            if (i == roleList.length - 1) {
                allRoles = allRoles + "}\n";
            } else {
                allRoles = allRoles + "},\n";
            }
        }
        allRoles = "["+allRoles+"]";
        return allRoles;

    }
    /**

    Retrieves the roles needed for a CV (Curriculum Vitae) from a JSON file and returns them as a JSON string.

    <p>
    This method retrieves the roles needed for a CV from a JSON file located in the "src/main/resources" directory of the project and returns them as a JSON string. The method selects the first three roles from the list and includes their title, content, and time.

    </p>
    @return a JSON string representing the roles for the CV

    @throws URISyntaxException if the URI syntax is incorrect

    @see Role

    @see Gson

    @see java.net.URL

    @see java.nio.file.Path

    @author YiruLi

    @version 1.0
    */
    public static String getRolesForCV() throws URISyntaxException {
        java.net.URL classResource = Achievement.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path resourcesPath = classDirectory.getParent().getParent();
        Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
        // 获取resources的文件目录

        String jsonPath = mainResourcesPath.toString() + "/role.json";
        Path filePath = Paths.get(jsonPath);
        String pathStr = filePath.toString();
        String json = getStr(pathStr);
        Gson gson = new Gson();
        Role[] roleList = gson.fromJson(json, Role[].class);

        String allRoles = "";
        if(roleList.length<3)
        {
            return null;
        }
        for (int i = 0; i < 3; i++) {
            allRoles = allRoles + "{\n";
            allRoles = allRoles + "\"title\": \"" + roleList[i].title + "\",\n";
            allRoles = allRoles + "\"content\": \"" + roleList[i].content + "\",\n";
            allRoles = allRoles + "\"time\": \"" + roleList[i].time + "\",\n";

            if (i == roleList.length - 1) {
                allRoles = allRoles + "}\n";
            } else {
                allRoles = allRoles + "},\n";
            }
        }
        allRoles = "["+allRoles+"]";
        return allRoles;

    }
    /**

Reads the content of a JSON file and returns it as a string.
<p>
This method reads the content of a JSON file specified by the file path and returns it as a string. The file is expected to be encoded in UTF-8 format. The method eliminates any carriage return characters ("\r") present in the content.
</p>
@param jsonFile the path of the JSON file
@return a string representation of the JSON content
@throws IOException if an I/O error occurs while reading the file
@author YiruLi
@version 1.0
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
/**

Sets the content of a JSON file with the provided text.
<p>
This method sets the content of a JSON file specified by the file path with the provided text. The existing content of the file will be replaced with the new text. The method returns {@code true} if the operation is successful, and {@code false} otherwise.
</p>
@param jsonFile the path of the JSON file
@param text the text to be written to the file
@return {@code true} if the file content is successfully set, {@code false} otherwise
@throws IOException if an I/O error occurs while writing to the file
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

Retrieves a role from the JSON file based on the provided title.

<p>
This method retrieves a role from the JSON file by searching for a matching title. The title is compared case-sensitive. If the provided title is an empty string, an empty string will be returned.

</p>
@param title the title of the role to retrieve

@return the role information in JSON format if a matching title is found, or an empty string if the title is not found or an empty string is provided

@throws URISyntaxException if a URI syntax error occurs while accessing the JSON file

@author YiruLi

@version 1.0
*/
    public static String getRoleByTitle(String title) throws URISyntaxException {
        if (title == "")
            return "";
    
        
        java.net.URL classResource = Course.class.getProtectionDomain().getCodeSource().getLocation();
        
        Path classDirectory = Paths.get(classResource.toURI());
        
        Path resourcesPath = classDirectory.getParent().getParent();
        Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
        
        // 获取resources的文件目录
    
        String jsonPath = mainResourcesPath.toString() + "/role.json";
        Path filePath = Paths.get(jsonPath);
        String pathStr = filePath.toString();
        String json = getStr(pathStr);
        Gson gson = new Gson();
        Role[] activities = gson.fromJson(json, Role[].class);
        ArrayList<Role> courseList = new ArrayList<>(Arrays.asList(activities));
        
    
        String theActivity = "";
        for (int i = 0; i < courseList.size(); i++) {
            if (courseList.get(i).title.equals(title)) {
                theActivity = theActivity + "{\n";
                theActivity = theActivity + "\"title\": \"" + courseList.get(i).title + "\",\n";
                theActivity = theActivity + "\"content\": \"" + courseList.get(i).content + "\",\n";
                theActivity = theActivity + "\"time\": \"" + courseList.get(i).time + "\",\n";
                theActivity = theActivity + "}\n";
            }
        }
    
        return theActivity;
    }
    /**

Extracts titles from a JSON string.

<p>
This method takes a JSON string as input and extracts the titles from it. The JSON string should be in valid JSON array format. The titles are returned as a JSON object containing an array of strings. If the input JSON string is empty or not in valid JSON array format, an empty JSON object is returned.

</p>
@param json_str the JSON string containing the role information

@return a JSON object containing an array of titles, or an empty JSON object if the input is empty or not in valid JSON array format

@see org.json.JSONArray

@author YiruLi

@version 1.0
*/
    public static String getRolesTitles(String json_str) {
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
        //新导入了JSONArray
        
    
    }
}


