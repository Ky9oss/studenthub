package model;

import java.util.*;

/**
 * 
 */
public class Achievement {

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
    private String team;

    /**
     * 
     */
    private String responsibility;

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }

    public String getTeam() {
        return team;
    }

    public String getResponsibility() {
        return responsibility;
    }

    private String actievementpath;

    public void setAchievementPath(String path) {
        this.achievement_path = path;
    }

    public Achievement(String title, String content, String time, String team, String responsibility) {
        this.title = title;
        this.content = content;
        this.time = time;
        this.team = team;
        this.responsibility = responsibility;
    }

    /**
     * @return
     */
    public boolean saveAchievement() {
        try {
            // 获取程序文件所在的目录
            java.net.URL classResource = BasicInformation.class.getProtectionDomain().getCodeSource().getLocation();
            Path classDirectory = Paths.get(classResource.toURI());
            Path resourcesPath = classDirectory.getParent().getParent();
            Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");

            // 获取resources的文件目录
            String activityPath = mainResourcesPath.toString() + "achievement.json";

            // 设置achievement_path变量

            this.setAchievementPath(achievementPath);
            // 将Achievement对象转换成JSON格式
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
            FileWriter writer = new FileWriter("achivevement.json");
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
    public static boolean deleteAchievement(String title) {
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
     * @return
     */
    public static string getAchievementsByYearForwardSort(int year) {
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
     * @return
     */
    public static String getAchievementsByYearReverseSort(int year) {
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
     * @param achievements_titles
     * @return
     */
    public static String getAchievementsByTitles(String achievements_titles) {
        try {
            // 根据标题获取文件路径
            String filePath = achievements_titles + ".json";

            // 读取文件内容并转换成achievements对象
            String json = new String(Files.readAllBytes(Paths.get(filePath)));
            JSONObject jsonObject = new JSONObject(json);
            Achievement achievement = new Achievement(
                    jsonObject.getString("title"),
                    jsonObject.getString("content"),
                    jsonObject.getString("time"),
                    jsonObject.getString("team"),
                    jsonObject.getString("responsibility"));

            return achievements; // 返回读取到的achievements对象
        } catch (IOException e) {
            e.printStackTrace();
            return null; // 表示读取失败
        }
    }

    public static string getAllAchivements(){
	    List<Achivement> results = new ArrayList<>();
        
            // 遍历当前目录下的所有文件
            File folder = new File(".");
            for (File file : folder.listFiles()) {
              // 如果文件是一个Achivement文件，读取文件内容并检查关键字是否匹配
              if (file.getName().endsWith(".json")) {
                try {
                  String json = new String(Files.readAllBytes(file.toPath()));
                  JSONObject jsonObject = new JSONObject(json);
                  Achivement achivement = new Achivement(
                    jsonObject.getString("title"),
                    jsonObject.getString("content"),
                    jsonObject.getString("time"),
                    jsonObject.getString("team"),
                    jsonObject.getString("responsibility")
                  );
                    results.add(Achivement);
              }
            }
        
            String str = String.join(",", results);// StringUtils.join(list, ",");
            return str;
          }
          }
}