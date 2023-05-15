package model;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SkillTest {
    private Skill skill;

    void setUp() {
        skill = new Skill("Sam", "aaa", "bbb", "ccc");
    }


    void obtainedPath() throws URISyntaxException {
        java.net.URL classResource = BasicInformation.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path RootPath = classDirectory.getParent().getParent();
        assertEquals("/studenthub", RootPath.toString());
    }


    void TestsaveSkill() throws URISyntaxException{
        java.net.URL classResource = BasicInformation.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path RootPath = classDirectory.getParent().getParent();

        skill = new Skill("Roger", "ddd","eee","fff");
        int result = skill.saveSkill();
        assertEquals(true, result);
    }


    void TestdeleteSkill() throws URISyntaxException{
        skill = new Skill("Roger", "ddd","eee","fff");
        boolean result = Skill.deleteSkill("Jay");
        assertTrue(result);
        result = Skill.deleteSkill("Roger");
        assertTrue(result);
    }


    void TestgetSkillsByProficiency(){
        String result = null;
        try {
            result = Skill.getSkillsByProficiency("bbb");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result);
    }

    void TestgetSkillsByTitles(){
        String result = null;
        try {
            result = Skill.getSkillsByTitles("Roger");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result);
    }


    void TestgetAllSkills(){
        String result = null;
        try {
            result = Skill.getAllSkills();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result);
    }

    public static void main(String[] args) throws URISyntaxException {
        SkillTest s = new SkillTest();
        s.TestsaveSkill();
        s.TestdeleteSkill();
        s.TestgetSkillsByProficiency();
        s.TestgetSkillsByTitles();
        s.TestgetAllSkills();
        System.out.println("succeed");
    }
}
