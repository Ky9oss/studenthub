package model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CVGeneratorTest {

    private CVGenerator cvGenerator;

    @BeforeEach
    public void setUp() {
        cvGenerator = new CVGenerator();
    }

    @Test
    public void testGenerateCV() throws URISyntaxException {
        // 提供输入字符串
        String basic_information = "{\"major\":\"major_content\",\"school\":\"school_content\",\"image_path\":\"/home/kadrex/Study/codes/java/jiti_lab/studenthub/src/main/resources/image.png\",\"name\":\"name_content\",\"graduation_time\":\"graduation_time_content\",\"admission_time\":\"admission_time_content\",\"age\":0}";
        String skills = "[{\"title\": \"title_content\", \"content\": \"content_content\", \"proficiency\": \"Advanced(for example)\", \"project\": \"java(for example)\"},{\"title2\": \"hahahaha22\", \"content\": \"conten22\", \"proficiency\": \"Advanced\", \"project\": \"java22\"}]";
        String activities = "[{\"title\": \"title_content\", \"content\": \"content_detail\", \"time\": \"xxxx-xx-xx\", \"type\": \"type_detail\", \"location\": \"beijing\"},{\"title\": \"title_content\", \"content\": \"content_detail\", \"time\": \"xxxx-xx-xx\", \"type\": \"type_detail\", \"location\": \"beijing(for example)\"}]";
        String roles = "[{\"title\": \"title_content\", \"content\": \"content_content\", \"time\": \"xxxx-xx-xx\"},{\"title\": \"title_detail\", \"content\": \"content_content\", \"time\": \"xxxx-xx-xx\"}]";
        String achievements = "[{\"title\": \"title_content\", \"content\": \"content_content\", \"time\": \"xxxx-xx-xx\", \"team\": \"111(for example)\", \"responsibility\": \"beijing\"},{\"title\": \"title_content\", \"content\": \"content_content\", \"time\": \"xxxx-xx-xx\", \"team\": \"222(example\", \"responsibility\": \"beijing(example)\"}]";

        // 调用generateCV方法
        cvGenerator.generateCV(basic_information, skills, activities, roles, achievements);

        //创建新路径
        java.net.URL classResource = BasicInformation.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path resourcesPath = classDirectory.getParent().getParent();
        Path mainResourcesPath = resourcesPath.resolve("src").resolve("main").resolve("resources");
        //获取resources的文件目录

        String filePath = mainResourcesPath.toString() + "/CV.docx";

        // 检查是否生成了Word文件
        File generatedFile = new File(filePath);
        assertTrue(generatedFile.exists(), "Generated CV.docx file should exist");

        // 在测试完成后删除生成的文件
        try {
            Files.deleteIfExists(Paths.get("CV.docx"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
