/**
 * This class represents a CV generator that creates a CV document based on provided information.
 * The CV generator uses Apache POI library for creating the Word document.
 * 
 * @author Wenxuan Wu
 *
 * Usage:
 * To generate a CV, call the createCV() method and provide the necessary information.
 */

package model;

import org.apache.poi.xwpf.usermodel.*;
import org.apache.commons.io.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import org.apache.commons.io.output.*;


import java.util.Iterator;


public class CV {

    /**
     * Main method for testing CV generation.
     * 
     * @param args Command-line arguments (unused).
     * @throws URISyntaxException If there is an error with the URI syntax.
     */

    public static void main(String[] args) throws URISyntaxException {
        // 提供您的输入字符串。
        String basic_information = "Your basic_information string";
        String skills = "Your skills string";
        String activities = "Your activities string";
        String roles = "Your roles string";
        String achievements = "Your achievements string";
        

        CV cvGenerator = new CV();
        cvGenerator.createCV(basic_information, skills, activities, roles, achievements);
    }

    private String filePath1;


    /**
     * This method generates a CV document based on the provided information.
     * The CV document includes sections like basic information, skills, activities, roles, and achievements.
     *
     * @param basic_information Basic information in JSON format.
     * @param skills Skills information in JSON format.
     * @param achievements Achievements information in JSON format.
     * @param roles Roles information in JSON format.
     * @param activities Activities information in JSON format.
     * @return String The file path of the generated CV document.
     * @throws URISyntaxException If there is an error with the file path URI.
     */

    public String createCV(String basic_informations, String skills, String achievements, String roles, String activities) throws URISyntaxException {
        try {
            XWPFDocument document = new XWPFDocument();

            // 基本信息
            JSONObject basicInfoJson = new JSONObject(basic_informations);
            addBasicInformation(document, basicInfoJson);

            // 技能
            JSONArray skillsJsonArray = new JSONArray(skills);
            addSection(document, "技能", skillsJsonArray);

            // 活动
            JSONArray activitiesJsonArray = new JSONArray(activities);
            addSection(document, "活动", activitiesJsonArray);

            // 角色
            JSONArray rolesJsonArray = new JSONArray(roles);
            addSection(document, "角色", rolesJsonArray);

            // 成就
            JSONArray achievementsJsonArray = new JSONArray(achievements);
            addSection(document, "成就", achievementsJsonArray);


        //创建新路径
        java.net.URL classResource = CV.class.getProtectionDomain().getCodeSource().getLocation();
        java.nio.file.Path classDirectory = Paths.get(classResource.toURI());
        java.nio.file.Path resourcesPath = classDirectory.getParent().getParent();
        java.nio.file.Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
        //获取resources的文件目录

        String filePath = mainResourcesPath.toString() + "/CV.docx";

        filePathSetter(filePath);

            // 生成Word文件
            FileOutputStream out = new FileOutputStream(new File(filePath));
            document.write(out);
            out.close();

            System.out.println("CV.docx 文件已生成");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return filePath1;
    }
    /**
     * Adds basic information to the document.
     *
     * @param document The XWPFDocument object to add the basic information to.
     * @param basicInfo A JSONObject containing the basic information.
     */
    private void addBasicInformation(XWPFDocument document, JSONObject basicInfo) {
        XWPFParagraph title = document.createParagraph();
        title.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun titleRun = title.createRun();
        titleRun.setText("个人简历");
        titleRun.setColor("009933");
        titleRun.setFontSize(24);
        titleRun.setBold(true);

        XWPFParagraph basicInfoPara = document.createParagraph();
        XWPFRun basicInfoRun = basicInfoPara.createRun();
        basicInfoRun.setFontSize(14);

        basicInfoRun.setText("姓名: " + basicInfo.getString("name") + "\n");
        basicInfoRun.addBreak();
        basicInfoRun.setText("专业: " + basicInfo.getString("major") + "\n");
        basicInfoRun.addBreak();
        basicInfoRun.setText("学校: " + basicInfo.getString("school") + "\n");
        basicInfoRun.addBreak();
        basicInfoRun.setText("入学时间: " + basicInfo.getString("admission_time") + "\n");
        basicInfoRun.addBreak();
        basicInfoRun.setText("毕业时间: " + basicInfo.getString("graduation_time") + "\n");
        basicInfoRun.addBreak();
        basicInfoRun.setText("年龄: " + basicInfo.getInt("age") + "\n");
    }
    
    /**
     * Adds a section to the document.
     *
     * @param document The XWPFDocument object to add the section to.
     * @param sectionTitle The title of the section.
     * @param jsonArray A JSONArray containing the section items.
     */

    private void addSection(XWPFDocument document, String sectionTitle, JSONArray jsonArray) {
        XWPFParagraph sectionHeader = document.createParagraph();
        sectionHeader.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun sectionHeaderRun = sectionHeader.createRun();
        sectionHeaderRun.setText(sectionTitle);
        sectionHeaderRun.setColor("000000");
        sectionHeaderRun.setFontSize(18);
        sectionHeaderRun.setBold(true);
        for (int i = 0; i < jsonArray.length(); i++) {
            final JSONObject jsonObject = jsonArray.getJSONObject(i);
            XWPFParagraph itemParagraph = document.createParagraph();
            final XWPFRun itemRun = itemParagraph.createRun();
            itemRun.setFontSize(14);
    
            Iterator<String> keysIterator = jsonObject.keys();
            while (keysIterator.hasNext()) {
                String key = keysIterator.next();
                itemRun.setText(key + ": " + jsonObject.getString(key) + "\n");
                itemRun.addBreak();
            }
        }
    }

    /**
    /**
     * Sets the file path for the generated CV document.
     *
     * @param filepath The desired file path for the CV document.
     */

    public void filePathSetter(String filepath){
        this.filePath1 = filepath;
    }

    /**
     * Retrieves the file path of the generated CV document.
     *
     * @return String The file path of the generated CV document.
     */

    public String filePathGetter(){
        return filePath1;
    }
    
}
