package model;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import java.io.*;
import com.google.gson.Gson;

 import java.io.File;
 import java.io.FileWriter;
 import java.io.IOException;



public class Role {
    public Role(String title, String year, String roles_titles) {
        this.title = title;
        this.year = year;
        this.roles_titles = roles_titles;
    }

    public Role(){

    }

    /**
     *
     */
    private String title;

    /**
     *
     */
    private String year;

    /**
     *
     */
    private String roles_titles;

    

    public String getTitle(){
        return title;
    }
    public String getYear(){
        return year;
    }
    public String getRoles_titles() {
        return roles_titles;
    }



    /**
     * @return
     */
    //任务1 ： 存之前判断：输入的数据是否为空，如果为空，返回-1;输入的标题是否重复，如果重复，返回-2。如果成功，return 1,如果因为其他原因失败，return 0
    /*  这是一个示例  
        public int saveRoles() {
        String path = "/home/kadrex/Study/codes/java/jiti_lab/studenthub/src/main/resources/role.json";
        String json = getStr(path);
        Gson gson = new Gson();
        Role[] roles = gson.fromJson(json, Role[].class);
        ArrayList<Role> roleList = new ArrayList<>(Arrays.asList(roles));

        // Constructor
        Role newRole = new Role(this.title, this.year, this.roles_titles);
        roleList.add(newRole);

        String savedRoles = gson.toJson(roleList);
        if(setStr(path, savedRoles)==true){
            return 1;
        }
        else{
            return 0;
        }
        //再加return-1和return-2的情况
        xxx
        return -1
        xxx
        return -2
    } */
    //相应的，ControllerTest所对应的每一项测试也要全部更改
    //任务2 ： 取出三组数据，JSON格式的String
    //任务3 ： 根据所给的JSON格式的String，获取所有title;根据一个title获取一组数据
    //public static String getRoleByTitle(String title){
    //    return "";
    //}
    //public static String[] getRolesTitles(String json_str){
    //    //下面是一个输出结果的格式的示例
    //    String[] results = {"title1", "title2", "title3", "title4", "title5"};
    //    return results;
    //}
    public static String getRolesForCV(){
        return "";
    }



    public int saveRoles() {
        String path = "/home/kadrex/Study/codes/java/jiti_lab/studenthub/src/main/resources/role.json";
        String json = getStr(path);
        Gson gson = new Gson();
        Role[] roles = gson.fromJson(json, Role[].class);
        ArrayList<Role> roleList = new ArrayList<>(Arrays.asList(roles));

        // Constructor
        Role newRole = new Role(this.title, this.year, this.roles_titles);
        roleList.add(newRole);

        String savedRoles = gson.toJson(roleList);
        if(setStr(path, savedRoles)==true){
            return 1;
        }
        else{
            return 0;
        }
        //再加return-1和return-2的情况
    }

    /**
     * @param title
     * @return
     */
    public static boolean deleteRoles(String title) {
        String path = "/home/kadrex/Study/codes/java/jiti_lab/studenthub/src/main/resources/role.json";
        String json = getStr(path);
        Gson gson = new Gson();
        Role[] roles = gson.fromJson(json, Role[].class);
        ArrayList<Role> roleList = new ArrayList<>(Arrays.asList(roles));

        for(int i = 0; i < roleList.size(); i++){
            if(roleList.get(i).title.equals(title)){
                roleList.remove(i);
                break;
            }
        }
        String deletedRoles = gson.toJson(roleList);
        return setStr(path, deletedRoles);
    }

    /**
     * @param year
     * @return
     * @throws ParseException
     */
    public static String getRolesByYearReverseSort(int year) throws ParseException {
        String path = "/home/kadrex/Study/codes/java/jiti_lab/studenthub/src/main/resources/role.json";
        String json = getStr(path);
        Gson gson = new Gson();
        Role[] roles = gson.fromJson(json, Role[].class);
        ArrayList<Role> roleList = new ArrayList<>(Arrays.asList(roles));

        for(int i = roleList.size() - 1; i >= 0 ; i--){
            if(!roleList.get(i).year.substring(0, 4).equals(String.valueOf(year))){
                roleList.remove(i);
            }
        }

        for(int i = 0; i < roleList.size(); i++){
            for(int j = 0; j < roleList.size() - 1 - i; j++){
                SimpleDateFormat ft = new SimpleDateFormat("yy-MM-dd");
                if (ft.parse(roleList.get(j).year).compareTo(ft.parse(roleList.get(j + 1).year)) < 0){
                    Collections.swap(roleList, j, j+1);
                }
            }
        }

        String allRoles = "";
        for(int i = 0; i < roleList.size(); i++) {
            allRoles = allRoles + "{\n";
            allRoles = allRoles + "\"title\": \"" + roleList.get(i).title + "\",\n";
            allRoles = allRoles + "\"content\": \"" + roleList.get(i).roles_titles+ "\",\n";
            allRoles = allRoles + "\"time\": \"" + roleList.get(i).year + "\",\n";

            if (i == roleList.size() - 1) {
                allRoles = allRoles + "}\n";
            }
            else {
                allRoles = allRoles + "},\n";
            }
        }
        return allRoles;
    }

    /**
     * @param year
     * @return
     * @throws ParseException
     */
    public static String getRolesByYearForwardSort(int year) throws ParseException {
        String path = "/home/kadrex/Study/codes/java/jiti_lab/studenthub/src/main/resources/role.json";
        String json = getStr(path);
        Gson gson = new Gson();
        Role[] roles = gson.fromJson(json, Role[].class);
        ArrayList<Role> roleList = new ArrayList<>(Arrays.asList(roles));

        for(int i = roleList.size() - 1; i >= 0 ; i--){
            if(!roleList.get(i).year.substring(0, 4).equals(String.valueOf(year))){
                roleList.remove(i);
            }
        }

        for(int i = 0; i < roleList.size(); i++){
            for(int j = 0; j < roleList.size() - 1 - i; j++){
                SimpleDateFormat ft = new SimpleDateFormat("yy-MM-dd");
                if (ft.parse(roleList.get(j).year).compareTo(ft.parse(roleList.get(j + 1).year)) > 0){
                    Collections.swap(roleList, j, j+1);
                }
            }
        }

        String allRoles = "";
        for(int i = 0; i < roleList.size(); i++) {
            allRoles = allRoles + "{\n";
            allRoles = allRoles + "\"title\": \"" + roleList.get(i).title + "\",\n";
            allRoles = allRoles + "\"content\": \"" + roleList.get(i).roles_titles+ "\",\n";
            allRoles = allRoles + "\"time\": \"" + roleList.get(i).year + "\",\n";

            if (i == roleList.size() - 1) {
                allRoles = allRoles + "}\n";
            }
            else {
                allRoles = allRoles + "},\n";
            }
        }
        return allRoles;
    }

    /**
     * @param roles_titles
     * @return
     */
    public static String getRolesByTitles(String roles_titles) {
        if (roles_titles == "") return "";

        String[] titles = roles_titles.split(",");
        ArrayList<String> titlesList = new ArrayList<>(Arrays.asList(titles));

        String path = "/home/kadrex/Study/codes/java/jiti_lab/studenthub/src/main/resources/role.json";
        String json = getStr(path);
        Gson gson = new Gson();
        Role[] roles = gson.fromJson(json, Role[].class);
        ArrayList<Role> roleList = new ArrayList<>(Arrays.asList(roles));

        for (int i = titlesList.size() - 1; i >= 0; i--) {
            if(!titlesList.contains(roleList.get(i).title) ) {
                roleList.remove(i);
            }
        }

        String allRoles = "";
        for(int i = 0; i < roleList.size(); i++) {
            allRoles = allRoles + "{\n";
            allRoles = allRoles + "\"title\": \"" + roleList.get(i).title + "\",\n";
            allRoles = allRoles + "\"content\": \"" + roleList.get(i).roles_titles+ "\",\n";
            allRoles = allRoles + "\"time\": \"" + roleList.get(i).year + "\",\n";

            if (i == roleList.size() - 1) {
                allRoles = allRoles + "}\n";
            }
            else {
                allRoles = allRoles + "},\n";
            }
        }
        return allRoles;
    }



    public static String getAllRoles(){
        String json = getStr("/home/kadrex/Study/codes/java/jiti_lab/studenthub/src/main/resources/role.json");
        Gson gson = new Gson();
        Role[] roleList = gson.fromJson(json, Role[].class);

        String allRoles = "";
        for(int i = 0; i < roleList.length; i++) {
            allRoles = allRoles + "{\n";
            allRoles = allRoles + "\"title\": \"" + roleList[i].title + "\",\n";
            allRoles = allRoles + "\"content\": \"" + roleList[i].roles_titles+ "\",\n";
            allRoles = allRoles + "\"time\": \"" + roleList[i].year + "\",\n";


            if (i == roleList.length - 1) {
                allRoles = allRoles + "}\n";
            }
            else {
                allRoles = allRoles + "},\n";
            }
        }
        return allRoles;

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
