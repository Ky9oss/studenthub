package model;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.json.JSONException;
import org.json.JSONObject;
/**
 * 
 */
public class BasicInformation {



    public BasicInformation(String name, int age, String school, String major, String admission_time,
            String graduation_time) {
        this.name = name;
        this.age = age;
        this.school = school;
        this.major = major;
        this.admission_time = admission_time;
        this.graduation_time = graduation_time;
    }

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private int age;

    /**
     * 
     */
    private String school;

    /**
     * 
     */
    private String major;

    /**
     * 
     */
    private String admission_time;

    /**
     * 
     */
    private String graduation_time;


    private String image_path;


    public void setImagePath(String path) {
        this.image_path = path;
    }
    
    /**
     * @return
     * @throws URISyntaxException
     */


    public static String getBasicInformation() throws URISyntaxException {
        try {
            // 获取程序文件所在的目录
            java.net.URL classResource = BasicInformation.class.getProtectionDomain().getCodeSource().getLocation();
            Path classDirectory = Paths.get(classResource.toURI());
            Path resourcesPath = classDirectory.getParent().getParent();
            Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
            //获取resources的文件目录

            String jsonPath = mainResourcesPath.toString() + "/basicInformation.json";      
            //检查文件是否存在
            Path filePath = Paths.get(jsonPath);
            if (!Files.exists(filePath)) {
                throw new FileNotFoundException("JSON file not found at path: " + jsonPath);
            }

            //读取文件内容
            byte[] encoded = Files.readAllBytes(filePath);
            return new String(encoded, StandardCharsets.UTF_8);


        } catch (IOException e) {
            e.printStackTrace();
            return null; // 读取失败时返回空字符串
        }
    }

    public String path() throws URISyntaxException {
        java.net.URL classResource = BasicInformation.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path resourcesPath = classDirectory.getParent().getParent();
        Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
        //获取resources的文件目录

        String jsonPath = mainResourcesPath.toString() + "/basicInformation.json";        


        return jsonPath;


    }

    

    /**
     * @return
     * @throws JSONException
     */
    public String saveBasicInformation(File image) throws JSONException {
        try {
            // 获取程序文件所在的目录
            java.net.URL classResource = BasicInformation.class.getProtectionDomain().getCodeSource().getLocation();
            Path classDirectory = Paths.get(classResource.toURI());
            Path resourcesPath = classDirectory.getParent().getParent();
            Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
            //获取resources的文件目录

            String imagePath = mainResourcesPath.toString() + "/image.png";

            //设置image_path变量

            this.setImagePath(imagePath);


            // 将BasicInformation对象的private变量转换成JSON格式
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", this.name);
            jsonObject.put("age", this.age);
            jsonObject.put("school", this.school);
            jsonObject.put("major", this.major);
            jsonObject.put("admission_time", this.admission_time);
            jsonObject.put("graduation_time", this.graduation_time);
            jsonObject.put("image_path", this.image_path);
            String json = jsonObject.toString();
    

    
            // 创建resources目录
            File resourcesDirectory = new File(mainResourcesPath.toString());
            if (!resourcesDirectory.exists()) {
                resourcesDirectory.mkdir();
            }
    
            // 将JSON字符串写入basicInformation.json文件
            File jsonFile = new File(resourcesDirectory, "basicInformation.json");
            if (jsonFile.exists()) {
                // 如果文件已存在，删除它
                jsonFile.delete();
            }
            if (jsonFile.createNewFile()) {
                FileWriter writer = new FileWriter(jsonFile);
                writer.write(json);
                writer.close();
            }
    
            // 尝试保存图片
            File imageFile = new File(resourcesDirectory, "image.png");
            if (imageFile.exists()) {
                // 如果文件已存在，删除它
                imageFile.delete();
            }
            if (image != null && imageFile.createNewFile()) {
                // 如果传入了文件并且成功创建了新文件，则将传入的文件保存为新文件
                Files.copy(image.toPath(), imageFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
    
            // 返回相对路径
            return resourcesDirectory.getPath();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return null; // 表示保存失败
        }
    }
    
    public String newSaveBasicInformation(int selection) throws JSONException {
        try {
            // 获取程序文件所在的目录
            java.net.URL classResource = BasicInformation.class.getProtectionDomain().getCodeSource().getLocation();
            Path classDirectory = Paths.get(classResource.toURI());
            Path resourcesPath = classDirectory.getParent().getParent();
            Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
            //获取resources的文件目录

            if(selection==1){
                this.image_path = mainResourcesPath.toString() + "/head1.png";
            }
            if(selection==2){
                this.image_path = mainResourcesPath.toString() + "/head2.png";
            }
            if(selection==3){
                this.image_path = mainResourcesPath.toString() + "/head3.png";
            }
            if(selection==4){
                this.image_path = mainResourcesPath.toString() + "/head4.png";
            }





            // 将BasicInformation对象的private变量转换成JSON格式
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", this.name);
            jsonObject.put("age", this.age);
            jsonObject.put("school", this.school);
            jsonObject.put("major", this.major);
            jsonObject.put("admission_time", this.admission_time);
            jsonObject.put("graduation_time", this.graduation_time);
            jsonObject.put("image_path", this.image_path);
            String json = jsonObject.toString();
    

    
            // 创建resources目录
            File resourcesDirectory = new File(mainResourcesPath.toString());
            if (!resourcesDirectory.exists()) {
                resourcesDirectory.mkdir();
            }
    
            // 将JSON字符串写入basicInformation.json文件
            File jsonFile = new File(resourcesDirectory, "basicInformation.json");
            if (jsonFile.exists()) {
                // 如果文件已存在，删除它
                jsonFile.delete();
            }
            if (jsonFile.createNewFile()) {
                FileWriter writer = new FileWriter(jsonFile);
                writer.write(json);
                writer.close();
            }    
    
            // 返回相对路径
            return this.image_path ;
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
            return null; // 表示保存失败
        }
    }


    /**
     * @return
     */
    public boolean deleteBasicInformation() {
        try {

            // 获取程序文件所在的目录
            // 获取程序文件所在的目录
            java.net.URL classResource = BasicInformation.class.getProtectionDomain().getCodeSource().getLocation();
            Path classDirectory = Paths.get(classResource.toURI());
            Path resourcesPath = classDirectory.getParent().getParent();
            Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
            //获取resources的文件目录

             File jsonFile = new File(mainResourcesPath.toString() + "/basicInformation.json");
             File imageFile = new File(mainResourcesPath.toString() + "/image.png");
             

            boolean jsonDeleted = false;
            boolean imageDeleted = false;

            if (jsonFile.exists()) {
                jsonDeleted = jsonFile.delete();
            }
            if (imageFile.exists()) {
                imageDeleted = imageFile.delete();
            }

            return jsonDeleted && imageDeleted;
        } catch (Exception e) {
            e.printStackTrace();
            return false; // 表示删除失败
        }
    }




}