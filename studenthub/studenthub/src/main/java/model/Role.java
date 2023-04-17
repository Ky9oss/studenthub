package model;
import java.util.*;

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
    private static String title;

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
        return false;
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
        return setStr(path, deletedRoles);}
    }

    /**
     * @param year 
     * @return
     */
    public static String getRolesByYearForwardSort(int year) {
        yearyear = String.valueOf(year);
        List<Achievement> results = new ArrayList<>();

        // 遍历当前目录下的所有文件
        File folder = new File(".");
        for (File file : folder.listFiles()) {
            // 如果文件是一个Achievement文件，读取文件内容并检查关键字是否匹配
            if (file.getName().endsWith(".json")) {
                try {
                    String json = new String(Files.readAllBytes(file.toPath()));
                    JSONObject jsonObject = new JSONObject(json);
                    Achievement achievement = new Achievement(
                            jsonObject.getString("title"),
                            jsonObject.getString("content"),
                            jsonObject.getString("time"),
                            jsonObject.getString("team"),
                            jsonObject.getString("responsibility"));

                    if (achievement.getTime().contains(yearyear)) {
                        results.add(achievement);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return results;
    }

    /**
     * @param year 
     * @return
     */
    public static String getRolesByYearReverseSort(int year) {
        // TODO implement here
        return "";
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
