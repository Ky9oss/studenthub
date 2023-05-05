import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SkillTest {
    private Skill skill;
    @TempDir
    Path tempDir;

    @BeforeEach
    void setUp() {
        skill = new Skill("Sam", "aaa", "bbb", "ccc");
    }

    @Test
    void obtainedPath() throws URISyntaxException {
        // 获取程序文件所在的目录
        java.net.URL classResource = BasicInformation.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path RootPath = classDirectory.getParent().getParent();
        assertEquals("/Users/mac/Desktop/Java软工/studenthub", RootPath.toString()); //改成你们文档的地址
    }

    @Test
    void TestsaveSkill() throws URISyntaxException{
        java.net.URL classResource = BasicInformation.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path RootPath = classDirectory.getParent().getParent();

        skill = new Skill("Roger", "ddd","eee","fff");
        boolean result = skill.saveSkill();
        assertEquals(true, result);
    }

    @Test
    void TestdeleteSkill(){
        skill = new Skill("Roger", "ddd","eee","fff");
        boolean result = skill.deleteSkill("Jay");
        assertEquals(false, result);
        assertTrue(result,"Title not exist!");
        result = skill.deleteSkill("Roger");
        assertEquals(true, result);
        assertTrue(result,"Successfully delete Skill: " + skill.getTitle());
    }

    @Test
    void TestgetSkillsByProficiency(){
        String result = null;
        try {
            result = skill.getSkillsByProficiency("bbb");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result, "Proficiency should not be null");
        assertNotEquals("error", result, "JSON file should be successfully read");
    }

    @Test
    void TestgetSkillsByTitles(){
        String result = null;
        try {
            result = skill.getSkillsByTitles("Roger");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result, "Title should not be null");
        assertNotEquals("error", result, "JSON file should be successfully read");
    }

    @Test
    void TestgetAllSkills(){
        String result = null;
        try {
            result = skill.getAllSkills();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result, "Skill should not be null");
        assertNotEquals("error", result, "JSON file should be successfully read");
    }
}
