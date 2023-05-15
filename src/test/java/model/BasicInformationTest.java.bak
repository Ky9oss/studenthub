package model;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class BasicInformationTest {

    private BasicInformation basicInfo;

    @TempDir
    Path tempDir;

    @BeforeEach
    void setUp() {
        basicInfo = new BasicInformation("John Doe", 25, "Example University", "Computer Science", "2017-09", "2021-06");
    }

    @Test
    void obtainedPath() throws URISyntaxException{
                    // 获取程序文件所在的目录
            java.net.URL classResource = BasicInformation.class.getProtectionDomain().getCodeSource().getLocation();
            Path classDirectory = Paths.get(classResource.toURI());
            Path RootPath = classDirectory.getParent().getParent();
            assertEquals("/Users/mac/Desktop/Java软工/studenthub", RootPath.toString());

    }

    @Test
    void testSaveBasicInformation() throws IOException, URISyntaxException {
            java.net.URL classResource = BasicInformation.class.getProtectionDomain().getCodeSource().getLocation();
            Path classDirectory = Paths.get(classResource.toURI());
            Path RootPath = classDirectory.getParent().getParent();

                basicInfo = new BasicInformation("John Doe", 25, "Example University", "美术", "2017-09", "2021-06");
        // 将C-tdd1.png作为图片文件传入
        File imageFile = new File(RootPath.toString(), "C-tdd1.png");
    
        String result = basicInfo.saveBasicInformation(imageFile);
        assertEquals("/Users/mac/Desktop/Java软工/studenthub/src/main/resources", result);
    }
    

    @Test
    void testGetBasicInformation() {
        String result = null;
        try {
            result = basicInfo.getBasicInformation();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        assertNotNull(result, "Basic information should not be null");
        assertNotEquals("error", result, "JSON file should be successfully read");
    }
    


    @Test
    void testDeleteBasicInformation() {
        boolean result = basicInfo.deleteBasicInformation();
        assertTrue(result, "Both JSON and image files should be deleted");
    }

    @Test
    void testPath() throws URISyntaxException {
        String path = basicInfo.path();
        assertEquals("/Users/mac/Desktop/Java软工/studenthub/src/main/resources/basicInformation.json",path);

    }
}
