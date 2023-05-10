package model
import org.apache.poi.xwpf.usermodel.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CVGenerator {

    public static void main(String[] args) {
        // 提供您的输入字符串。
        String basic_information = "Your basic_information string";
        String skills = "Your skills string";
        String activities = "Your activities string";
        String roles = "Your roles string";
        String achievements = "Your achievements string";

        CVGenerator cvGenerator = new CVGenerator();
        cvGenerator.generateCV(basic_information, skills, activities, roles, achievements);
    }

    public void generateCV(String basic_information, String skills, String activities, String roles, String achievements) {
        try {
            XWPFDocument document = new XWPFDocument();

            // 基本信息
            JSONObject basicInfoJson = new JSONObject(basic_information);
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
        java.net.URL classResource = BasicInformation.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path resourcesPath = classDirectory.getParent().getParent();
        Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
        //获取resources的文件目录

        String filePath = mainResourcesPath.toString() + "/CV.docx";

            // 生成Word文件
            FileOutputStream out = new FileOutputStream(new File(filePath));
            document.write(out);
            out.close();

            System.out.println("CV.docx 文件已生成");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addBasicInformation(XWPFDocument document, JSONObject basicInfo) {
        XWPFParagraph title = document.createParagraph();
        title.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun titleRun = title.createRun();
        titleRun.setText("简历");
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

    private void addSection(XWPFDocument document, String sectionTitle, JSONArray jsonArray) {
        XWPFParagraph sectionHeader = document.createParagraph();
        sectionHeader.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun sectionHeaderRun = sectionHeader.createRun();
        sectionHeaderRun.setText(sectionTitle);
        sectionHeaderRun.setColor("000000");
        sectionHeaderRun.setFontSize(18);
        sectionHeaderRun.setBold(true);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            XWPFParagraph itemParagraph = document.createParagraph();
            XWPFRun itemRun = itemParagraph.createRun();
            itemRun.setFontSize(14);
    
            jsonObject.keys().forEachRemaining(key -> {
                itemRun.setText(key + ": " + jsonObject.getString(key) + "\n");
                itemRun.addBreak();
            });
        }
    }
}
