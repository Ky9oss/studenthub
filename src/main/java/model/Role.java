import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Arrays;

import java.io.*;
import com.google.gson.Gson;
/**
 *
 */
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
    public boolean saveRoles() {
        String path = "C:/Users/A captain/Documents/Role/2.json";
        String json = getStr(path);
        Gson gson = new Gson();
        Role[] roles = gson.fromJson(json, Role[].class);
        ArrayList<Role> roleList = new ArrayList<>(Arrays.asList(roles));

        // Constructor
        Role newRole = new Role(this.title, this.year, this.roles_titles);
        roleList.add(newRole);

        String savedRoles = gson.toJson(roleList);
        return setStr(path, savedRoles);
    }

    /**
     * @param title
     * @return
     */
    public static boolean deleteRoles(String title) {
        String path = "C:/Users/A captain/Documents/Role/2.json";
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
        String path = "C:/Users/A captain/Documents/Role/2.json";
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
        String path = "C:/Users/A captain/Documents/Role/2.json";
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

        String path = "C:/Users/A captain/Documents/Role/2.json";
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
        String json = getStr("C:/Users/A captain/Documents/Role/2.json");
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

    public static void main(String[] args) throws ParseException {
        // System.out.println(Role.getRolesByYearReverseSort(2000));
        Role role = new Role();
        System.out.println(role.getRolesByYearForwardSort(1998));
    }
}