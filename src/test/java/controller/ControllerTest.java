package controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import static org.junit.Assert.*;


class ControllerTest {

    private Controller controllerUnderTest;

    @BeforeEach
    void setUp() {
        controllerUnderTest = new Controller();
    }

    @Test
    void testCreateBasicInformation() {
        // Setup
        final File head = new File("filename.txt");

        // Run the test
        final boolean result = controllerUnderTest.createBasicInformation("name", 0, "school", "major",
                "admission_time", "graduation_time", head);

        // Verify the results
        assertEquals(result, false);
    }

    @Test
    void testChangeBasicInformation() {
        // Setup
        final File head = new File("filename.txt");

        // Run the test
        final boolean result = controllerUnderTest.changeBasicInformation("name", 0, "school", "major",
                "admission_time", "graduation_time", head);

        // Verify the results
        assertEquals(result, false);
    }

    @Test
    void testGetBasicInformation() {
        final String result = controllerUnderTest.getBasicInformation();
        assertEquals(result, "");
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
        boolean istrue = controllerUnderTest.createAchievement("title", "content", "time", "team", "responsibility");
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
