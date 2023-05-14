package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.io.output.*;

class CVTest {
    private CV cvGenerator;

    @BeforeEach
    void setUp() {
        cvGenerator = new CV();
    }

    @Test
    void createCVTest() throws URISyntaxException, InvalidFormatException {
        String basic_information = "{\"major\":\"major_content\",\"school\":\"school_content\",\"image_path\":\"/Users/mac/Desktop/CV Generator/studenthub/src/main/resources/image.jpg\",\"name\":\"name_content\",\"graduation_time\":\"graduation_time_content\",\"admission_time\":\"admission_time_content\",\"age\":0}";
        String skills = "[{\"title\": \"title_content\", \"content\": \"content_content\", \"proficiency\": \"Advanced(for example)\", \"project\": \"java(for example)\"},{\"title2\": \"hahahaha22\", \"content\": \"conten22\", \"proficiency\": \"Advanced\", \"project\": \"java22\"}]";
        String activities = "[{\"title\": \"title_content\", \"content\": \"content_detail\", \"time\": \"xxxx-xx-xx\", \"type\": \"type_detail\", \"location\": \"beijing\"},{\"title\": \"title_content\", \"content\": \"content_detail\", \"time\": \"xxxx-xx-xx\", \"type\": \"type_detail\", \"location\": \"beijing(for example)\"}]";
        String roles = "[{\"title\": \"title_content\", \"content\": \"content_content\", \"time\": \"xxxx-xx-xx\"},{\"title\": \"title_detail\", \"content\": \"content_content\", \"time\": \"xxxx-xx-xx\"}]";
        String achievements = "[{\"title\": \"title_content\", \"content\": \"content_content\", \"time\": \"xxxx-xx-xx\", \"team\": \"111(for example)\", \"responsibility\": \"beijing\"},{\"title\": \"title_content\", \"content\": \"content_content\", \"time\": \"xxxx-xx-xx\", \"team\": \"222(example\", \"responsibility\": \"beijing(example)\"}]";

        String expectedFilePath = Paths.get(System.getProperty("user.dir"), "src", "main", "java", "model", "CV.docx").toString();
        String actualFilePath = cvGenerator.createCV(basic_information, skills, activities, roles, achievements);
        assertEquals(expectedFilePath, actualFilePath);
    }
}
