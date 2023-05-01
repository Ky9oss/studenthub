package controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URISyntaxException;

import static org.junit.Assert.*;
import java.nio.file.Files;
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

class ControllerTest {

    private static Controller controllerUnderTest;

    @BeforeEach
    void setUp() {
        controllerUnderTest = new Controller();
    }

    @Test
    void testCreateBasicInformation() throws URISyntaxException {
        // Setup
        final File head = new File("src/test/resources/C-tdd1.png");

        // Run the test
        final String result = controllerUnderTest.createBasicInformation("name", 0, "school", "major",
                "admission_time", "graduation_time", head);

        // Verify the results
        assertEquals(result, "/home/kadrex/Study/codes/java/jiti_lab/studenthub/src/main/resources/image.png");
        
        // Verify getBasicInformation()
        final String result2 = controllerUnderTest.getBasicInformation();
        assertEquals(result2, "{\"major\":\"major\",\"school\":\"school\",\"image_path\":\"/home/kadrex/Study/codes/java/jiti_lab/studenthub/src/main/resources/image.png\",\"name\":\"name\",\"graduation_time\":\"graduation_time\",\"admission_time\":\"admission_time\",\"age\":0}");
    }

    public static void main(String args[]) throws URISyntaxException {
        controllerUnderTest = new Controller();
        final String result2 = controllerUnderTest.getBasicInformation();
        System.out.println(result2);
        JSONObject jsonObj = new JSONObject(result2);
        System.out.println(jsonObj);
        String activities = "[{\"title\": \"hahahaha\", \"content\": \"contentetetete\"},{\"title\": \"hahahaha\", \"content\": \"contentetetete\"}]";
        JSONArray jsonObj2 = new JSONArray(activities);
        System.out.println(jsonObj2);
    }

    @Test
    void testChangeBasicInformation() throws URISyntaxException {
        // Setup
        final File head = new File("src/test/resources/C-tdd1.png");

        // Run the test
        final String result = controllerUnderTest.changeBasicInformation("name2", 0, "school2", "major2",
                "admission_time2", "graduation_time2", head);

        // Verify the results
        assertEquals(result, "/home/kadrex/Study/codes/java/jiti_lab/studenthub/src/main/resources/image.png");
        
        final String result2 = controllerUnderTest.getBasicInformation();
        assertEquals(result2, "{\"major\":\"major2\",\"school\":\"school2\",\"image_path\":\"/home/kadrex/Study/codes/java/jiti_lab/studenthub/src/main/resources/image.png\",\"name\":\"name2\",\"graduation_time\":\"graduation_time2\",\"admission_time\":\"admission_time2\",\"age\":0}");
    }

    @Test
    void testCreateSkill() {
        boolean istrue = controllerUnderTest.createSkill("title", "content", "proficiency", "project");
        assertEquals(istrue, false);
    }

    @Test
    void testChangeSkill() {
        boolean istrue = controllerUnderTest.changeSkill("title", "content", "proficiency", "project");
        assertEquals(istrue, false);
    }

    @Test
    void testDeleteSkill() {
        boolean istrue = controllerUnderTest.deleteSkill("title");
        assertEquals(istrue, false);
    }

    @Test
    void testGetSkillsByProficiency() {
        String json_str = controllerUnderTest.getSkillsByProficiency("proficiency");
        assertEquals(json_str, "");
    }

    @Test
    void testCreateAchievement() {
        boolean istrue = controllerUnderTest.createAchievement("title", "content", "xxxx-xx-xx", "team", "responsibility");
        assertEquals(istrue, false);
    }

    @Test
    void testChangeAchievement() {
        boolean istrue = controllerUnderTest.changeAchievement("title", "content", "time", "team", "responsibility");
        assertEquals(istrue, false);
    }


    @Test
    void testDeleteAchievement() {
        boolean istrue = controllerUnderTest.deleteAchievement("title");
        assertEquals(istrue, false);
    }

    @Test
    void testGetAchievementsByYearForwardSort() {
        String json_str = controllerUnderTest.getAchievementsByYearForwardSort(2020);
        assertEquals(json_str, "");
    }

    @Test
    void testGetAchievementsByYearReverseSort() {
        String json_str = controllerUnderTest.getAchievementsByYearReverseSort(2020);
        assertEquals(json_str, "");
    }

    @Test
    void testCreateRole() {
        boolean istrue = controllerUnderTest.createRole("title", "content", "time");
        assertEquals(istrue, false);
    }

    @Test
    void testChangeRole() {
        boolean istrue = controllerUnderTest.changeRole("title", "content", "time");
        assertEquals(istrue, false);
    }

    @Test
    void testDeleteRole() {
        boolean istrue = controllerUnderTest.deleteRole("title");
        assertEquals(istrue, false);
    }

    @Test
    void testGetRolesByYearForwardSort() {
        String json_str = controllerUnderTest.getRolesByYearForwardSort(2020);
        assertEquals(json_str, "");
    }

    @Test
    void testGetRolesByYearReverseSort() {
        String json_str = controllerUnderTest.getRolesByYearReverseSort(2020);
        assertEquals(json_str, "");
    }

    @Test
    void testCreateActivity() {
        boolean istrue = controllerUnderTest.createActivity("title", "content", "time", "type", "location");
        assertEquals(istrue, false);
    }

    @Test
    void testChangeActivity() {
        boolean istrue = controllerUnderTest.changeActivity("title", "content", "time", "type", "location");
        assertEquals(istrue, false);
    }

    @Test
    void testDeleteActivity() {
        boolean istrue = controllerUnderTest.deleteActivity("title");
        assertEquals(istrue, false);
    }

    @Test
    void testGetActivitiesByYearAndByTypeForwardSort() {
        String json_str = controllerUnderTest.getActivitiesByYearAndByTypeForwardSort(2020, "type");
        assertEquals(json_str, "");
    }

    @Test
    void testGetActivitiesByYearAndByTypeReverseSort() {
        String json_str = controllerUnderTest.getActivitiesByYearAndByTypeReverseSort(2020, "type");
        assertEquals(json_str, "");
    }

    @Test
    void testCreateCourse() {
        boolean istrue = controllerUnderTest.createCourse("title", "content", "time", "type", "teacher", 0, 0);
        assertEquals(istrue, false);
    }

    @Test
    void testChangeCourse() {
        boolean istrue = controllerUnderTest.changeCourse("title", "content", "time", "type", "teacher", 0, 0);
        assertEquals(istrue, false);
    }

    @Test
    void testDeleteCourse() {
        boolean istrue = controllerUnderTest.deleteCourse("title");
        assertEquals(istrue, false);
    }

    @Test
    void testGetCoursesByYearAndByTypeForwardSort() {
        String json_str = controllerUnderTest.getCoursesByYearAndByTypeForwardSort(2020, "type");
        assertEquals(json_str, "");
    }

    @Test
    void testGetCoursesByYearAndByTypeReverseSort() {
        String json_str = controllerUnderTest.getCoursesByYearAndByTypeReverseSort(2020, "type");
        assertEquals(json_str, "");
    }

    @Test
    void testCalculateGradePointAverage() {
        double result = controllerUnderTest.calculateGradePointAverage(4);
        assertEquals(result, 0.0, 0.000001);
        double result1 = controllerUnderTest.calculateGradePointAverage(1);
        assertEquals(result1, 0.1, 0.000001);
        double result2 = controllerUnderTest.calculateGradePointAverage(2);
        assertEquals(result2, 0.2, 0.000001);
        double result3 = controllerUnderTest.calculateGradePointAverage(3);
        assertEquals(result3, 0.3, 0.000001);
    }

    @Test
    void testCreateCV() {
        String json_str = controllerUnderTest.createCV("skills_titles", "achievements_titles", "roles_titles",
                "activities_titles");
        assertEquals(json_str, "");
    }

    @Test
    void testGetSkillsTitles() {
        String json_str = controllerUnderTest.getSkillsTitles();
        assertEquals(json_str, "");
    }

    @Test
    void testGetRolesTitles() {
        String json_str = controllerUnderTest.getRolesTitles();
        assertEquals(json_str, "");
    }

    @Test
    void testGetActivitiesTitles() {
        String json_str = controllerUnderTest.getActivitiesTitles();
        assertEquals(json_str, "");
    }

    @Test
    void testGetAchievementsTitles() {
        String json_str = controllerUnderTest.getAchievementsTitles();
        assertEquals(json_str, "");
    }
}
