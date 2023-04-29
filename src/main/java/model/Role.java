package model;
import java.util.*;
import java.time.LocalTime;
import java.util.Arrays;
/**
 * 
 */
public class Role {



    public Role(String title, String content, String time) {
        this.title = title;
        this.content = content;
        this.time = time;
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
     * @return
     */
    public boolean saveRoles() {
        String path = "C:/Users/28950/Desktop/2.json";
        String json = getStr(path);
	    Gson gson = new Gson();
        Role[] roles = gson.fromJson(json, Role[].class);
        ArrayList<Role> roleList = new ArrayList<>(Arrays.asList(roles));

        // Constructor
        Role newRole = new Role(this.title, this. year, this.year,this.roles_titles);
        RollList.add(newRole);

        String savedRoles = gson.toJson(RoleList);
        return setStr(path, savedRoles);
    }

    /**
     * @param title 
     * @return
     */
    public static boolean deleteRoles(String title) {
        String path = "C:/Users/28950/Desktop/2.json";
        String json = getStr(path);
	    Gson gson = new Gson();
        Role[] roles = gson.fromJson(json, Role[].class);
        ArrayList<Role> roleList = new ArrayList<>(Arrays.asList(roles));

        for(int i = 0; i < roleList.size(); i++){
            // skillList.get(i).title == title ?
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
     */
    public ArrayList<Role> getRolesByYearForwardSort(int yearlow, int yearhigh) {
        yearyear1 = String.valueOf(yearlow);
        yearyear2 = String.valueOf(yearhigh);
        ArrayList<Role> results = new ArrayList<>();
        File folder = new File(".");
        for (File file : folder.listFiles()) {
            if (file.getName().endsWith(".json")) {
                try {
                    String json = new String(Files.readAllBytes(file.toPath()));
                    JSONObject jsonObject = new JSONObject(json);
                    Role Role = new Role(
                            jsonObject.getString("title"),
                            jsonObject.getInteger("year"),
                            jsonObject.getInteger("year"),
                            jsonObject.getString("roles_titles")); 
                          

                    if ((Role.year<=yearhigh)&&(Role.year>=yearlow)) {
                        results.add(roles_titles);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        results.sort(Comparator.comparing(Role::year));

        return results;
    }

    /**
     * @param year 
     * @return
     */
    public static String getRolesByYearReverseSort(int year) {
        // TODO implement here
        yearyear1 = String.valueOf(yearlow);
        yearyear2 = String.valueOf(yearhigh);
        ArrayList<Role> results = new ArrayList<>();
        File folder = new File(".");
        for (File file : folder.listFiles()) {
            if (file.getName().endsWith(".json")) {
                try {
                    String json = new String(Files.readAllBytes(file.toPath()));
                    JSONObject jsonObject = new JSONObject(json);
                    Role Role = new Role(
                            jsonObject.getString("title"),
                            jsonObject.getInteger("year"),
                            jsonObject.getInteger("year"),
                            jsonObject.getString("roles_titles")); 
                          

                    if ((Role.year<=yearhigh)&&(Role.year>=yearlow)) {
                        results.add(roles_titles);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        results.sort(Comparator.comparing(Role::year).reversed());

        return results;
    }

    /**
     * @param roles_titles 
     * @return
     */
    public static String getRolesByTitles(String roles_titles) {
        if (roles_titles == "") return "";

        String[] proes =roles_titles .split(",");
        ArrayList<String> proesList = new ArrayList<>(Arrays.asList(proes));

        String json = getStr("");
	    Gson gson = new Gson();
        Role[] roles = gson.fromJson(json, Role[].class);
        ArrayList<Role> skillList = new ArrayList<>(Arrays.asList(roles));

        for (int i = roleList.size() - 1; i >= 0; i--) {
            if( !proesList.contains(roleList.get(i).roles_titles) ) {
                roleList.remove(i);
            }
        }

        String allRoles = "";
        for(int i = 0; i < roleList.size(); i++) {
            allRoles = allRoles + "{\n";
            allRoles = allRoles + "\"title\": \"" + roleList.get(i).title + "\",\n";
            allRoles = allRoles + "\"year\": \"" + roleList.get(i).year + "\",\n";
            allRoles = allRoles + "\"year\": \"" + roleList.get(i).year + "\",\n";
            allRoles = allRoles + "\"roles_titles\": \"" + roleList.get(i).roles_titles+ "\",\n";
            
            if (i == roleList.size() - 1) {
                allRoles = allRoles + "}\n";
            }
            else {
                allRole = allRoles + "},\n";
            }
        }
        return allRoles;
    }



    public static String getAllRoles(){
	    String json = getStr("C:/Users/Hanxi/Documents/WeChat Files/wxid_df2qbfla549x22/FileStorage/File/2023-04/studenthub-main/src/main/java/model/1.json");
	    Gson gson = new Gson();
        Skill[] skillList = gson.fromJson(json, Skill[].class);

        String allRoles = "";
        for(int i = 0; i < roleList.size(); i++) {
            allRoles = allRoles + "{\n";
            allRoles = allRoles + "\"title\": \"" + roleList.get(i).title + "\",\n";
            allRoles = allRoles + "\"year\": \"" + roleList.get(i).year + "\",\n";
            allRoles = allRoles + "\"year\": \"" + roleList.get(i).year + "\",\n";
            allRoles = allRoles + "\"roles_titles\": \"" + roleList.get(i).roles_titles+ "\",\n";
            
            if (i == roleList.size() - 1) {
                allRoles = allRoles + "}\n";
            }
            else {
                allRole = allRoles + "},\n";
            }
        }
        return allRoles;

    }

}
