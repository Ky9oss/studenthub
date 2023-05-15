package controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Course;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;

import static org.junit.Assert.*;


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
        System.out.println("lalala");
        assertEquals(result2, "{\"major\":\"major\",\"school\":\"school\",\"image_path\":\"/home/kadrex/Study/codes/java/jiti_lab/studenthub/src/main/resources/image.png\",\"name\":\"name\",\"graduation_time\":\"graduation_time\",\"admission_time\":\"admission_time\",\"age\":0}");
    }

    public static void main(String args[]) throws URISyntaxException {
        controllerUnderTest = new Controller();
        final String result2 = controllerUnderTest.getBasicInformation();
        System.out.println(result2);
        JSONObject jsonObj = new JSONObject(result2);
        System.out.println(jsonObj);
        String activities = "[{\"title\":\"hahahaha\",\"content\":\"contentetetete\"},{\"title\":\"hahahaha\",\"content\":\"contentetetete\"}]";
        JSONArray jsonObj2 = new JSONArray(activities);
        System.out.println(jsonObj2);
    }

    @Test
    void testChangeBasicInformation() throws URISyntaxException {
        // Setup
        final File head = new File("src/test/resources/C-tdd1.png");

        // Run the test
        final String result = controllerUnderTest.changeBasicInformation("name3", 0, "school2", "major2",
                "admission_time2", "graduation_time2", head);

        // Verify the results
        assertEquals(result, "/home/kadrex/Study/codes/java/jiti_lab/studenthub/src/main/resources/image.png");
        
        final String result2 = controllerUnderTest.getBasicInformation();
        assertEquals(result2, "{\"major\":\"major2\",\"school\":\"school2\",\"image_path\":\"/home/kadrex/Study/codes/java/jiti_lab/studenthub/src/main/resources/image.png\",\"name\":\"name3\",\"graduation_time\":\"graduation_time2\",\"admission_time\":\"admission_time2\",\"age\":0}");
    }

    @Test
    void testSkill() throws URISyntaxException{
        int istrue = controllerUnderTest.createSkill("title", "111", "proficiency11", "project");
        assertEquals(istrue, 1);
        int istrue2 = controllerUnderTest.createSkill("title22", "content22", "proficiency22", "project22");
        assertEquals(istrue2, 1);
        int istrue3 = controllerUnderTest.createSkill("title33", "111", "proficiency11", "project33");
        assertEquals(istrue3, 1);
        int istrue4 = controllerUnderTest.changeSkill("title22", "111", "proficiency11", "project555");
        assertEquals(istrue4, 1);
        int istrue5 = controllerUnderTest.createSkill("title55", "content", "proficiency11", "project555");
        assertEquals(istrue5, 1);
        boolean istrue6 = controllerUnderTest.deleteSkill("title55");
        assertEquals(istrue6, true);
        String json_str = controllerUnderTest.getSkillsByProficiency("proficiency11");
        JSONArray json_array = new JSONArray(json_str);
        System.out.println(json_array);

        String json_str3 = Controller.getSkillsForCV();
        JSONArray json_array3 = new JSONArray(json_str3);
        System.out.println(json_array3);

        controllerUnderTest.deleteSkill("title");
        controllerUnderTest.deleteSkill("title22");
        controllerUnderTest.deleteSkill("title33");
    }



    @Test
    void testAchievement() throws URISyntaxException, ParseException, IOException{
        int istrue = controllerUnderTest.createAchievement("title1", "content", "2022-11-15", "team", "responsibility");
        assertEquals(istrue, 1);
        int istrue2 = controllerUnderTest.createAchievement("title2", "content", "2023-1-21", "team", "responsibility");
        assertEquals(istrue2, 1);
        int istrue3 = controllerUnderTest.createAchievement("title3", "111", "2022-5-25", "team", "responsibility");
        assertEquals(istrue3, 1);
        int istrue4 = controllerUnderTest.changeAchievement("title1", "222", "2022-6-9", "team", "responsibility");
        assertEquals(istrue4, 1);
        int istrue5 = controllerUnderTest.createAchievement("title5", "333", "2022-12-21", "team", "responsibility");
        assertEquals(istrue5, 1);
        int istrue6 = controllerUnderTest.createAchievement("title6", "content", "2022-12-21", "team", "responsibility");
        assertEquals(istrue6, 1);
        boolean istrue7 = controllerUnderTest.deleteAchievement("title6");
        assertEquals(istrue7, true);

        String json_str = controllerUnderTest.getAchievementsByYearForwardSort(2022);
        JSONArray json_array = new JSONArray(json_str);
        System.out.println(json_array);
        String json_str2 = controllerUnderTest.getAchievementsByYearReverseSort(2022);
        JSONArray json_array2 = new JSONArray(json_str2);
        System.out.println(json_array2);

        String json_str3 = Controller.getAchievementsForCV();
        JSONArray json_array3 = new JSONArray(json_str3);
        System.out.println(json_array3);

        controllerUnderTest.deleteAchievement("title1");
        controllerUnderTest.deleteAchievement("title2");
        controllerUnderTest.deleteAchievement("title3");
        controllerUnderTest.deleteAchievement("title4");
        controllerUnderTest.deleteAchievement("title5");
    }



    @Test
    void testRole() throws ParseException, URISyntaxException {
        int istrue = controllerUnderTest.createRole("title1", "content", "2022-11-15");
        assertEquals(istrue, 1);
        int istrue2 = controllerUnderTest.createRole("title2", "content", "2023-1-21");
        assertEquals(istrue2, 1);
        int istrue3 = controllerUnderTest.createRole("title3", "111", "2022-5-25");
        assertEquals(istrue3, 1);
        int istrue4 = controllerUnderTest.changeRole("title1", "222", "2022-6-9");
        assertEquals(istrue4, 1);
        int istrue5 = controllerUnderTest.createRole("title5", "333", "2022-12-21");
        assertEquals(istrue5, 1);
        int istrue6 = controllerUnderTest.createRole("title6", "content", "2022-12-21");
        assertEquals(istrue6,1);
        boolean istrue7 = controllerUnderTest.deleteRole("title6");
        assertEquals(istrue7, true);

        String json_str = controllerUnderTest.getRolesByYearForwardSort(2022);
        JSONArray json_array = new JSONArray(json_str);
        System.out.println(json_array);
        String json_str2 = controllerUnderTest.getRolesByYearReverseSort(2022);
        JSONArray json_array2 = new JSONArray(json_str2);
        System.out.println(json_array2);

        String json_str3 = Controller.getRolesForCV();
        JSONArray json_array3 = new JSONArray(json_str3);
        System.out.println(json_array3);

        controllerUnderTest.deleteRole("title1");
        controllerUnderTest.deleteRole("title2");
        controllerUnderTest.deleteRole("title3");
        controllerUnderTest.deleteRole("title5");
    }



    @Test
    void testActivity() throws URISyntaxException, ParseException, IOException{
        int istrue = controllerUnderTest.createActivity("title1", "content", "2022-11-15", "type", "location");
        assertEquals(istrue, 1);
        int istrue2 = controllerUnderTest.createActivity("title2", "content", "2023-1-21", "type", "location");
        assertEquals(istrue2, 1);
        int istrue3 = controllerUnderTest.createActivity("title3", "111", "2022-5-25", "type", "location");
        assertEquals(istrue3, 1);
        int istrue4 = controllerUnderTest.changeActivity("title1", "222", "2022-6-9", "type", "location");
        assertEquals(istrue4, 1);
        int istrue5 = controllerUnderTest.createActivity("title5", "333", "2022-12-21", "type", "location");
        assertEquals(istrue5, 1);
        int istrue6 = controllerUnderTest.createActivity("title6", "content", "2022-12-22", "type222", "location");
        assertEquals(istrue6, 1);
        int istrue7 = controllerUnderTest.createActivity("title7", "content", "2022-12-22", "type", "location");
        assertEquals(istrue7, 1);
        boolean istrue8 = controllerUnderTest.deleteActivity("title7");
        assertEquals(istrue8, true);
        String json_str = controllerUnderTest.getActivitiesByYearAndByTypeForwardSort(2022, "type");
        JSONArray json_array = new JSONArray(json_str);
        System.out.println(json_array);
        String json_str2 = controllerUnderTest.getActivitiesByYearAndByTypeReverseSort(2022, "type");
        JSONArray json_array2 = new JSONArray(json_str2);
        System.out.println(json_array2);

        String json_str3 = Controller.getActivitiesForCV();
        JSONArray json_array3 = new JSONArray(json_str3);
        System.out.println(json_array3);

        controllerUnderTest.deleteActivity("title1");
        controllerUnderTest.deleteActivity("title2");
        controllerUnderTest.deleteActivity("title3");
        controllerUnderTest.deleteActivity("title5");
        controllerUnderTest.deleteActivity("title6");
    }


 
    @Test
    void testCourse() throws URISyntaxException, ParseException {
        int istrue = controllerUnderTest.createCourse("title1", "content", "2022-11-15", "type", "teacher", 0, 0);
        assertEquals(istrue, 1);
        int istrue2 = controllerUnderTest.createCourse("title2", "content", "2023-1-21", "type", "teacher", 0, 0);
        assertEquals(istrue2, 1);
        int istrue3 = controllerUnderTest.createCourse("title3", "111", "2022-5-25", "type", "teacher", 0, 0);
        assertEquals(istrue3, 1);
        int istrue4 = controllerUnderTest.changeCourse("title1", "222", "2022-6-9", "type", "teacher", 0, 0);
        assertEquals(istrue4, 1);
        int istrue5 = controllerUnderTest.createCourse("title5", "333", "2022-12-21", "type", "teacher", 0, 0);
        assertEquals(istrue5, 1);
        int istrue6 = controllerUnderTest.createCourse("title6", "content", "2022-12-22", "type222", "teacher", 0, 0);
        assertEquals(istrue6, 1);
        int istrue7 = controllerUnderTest.createCourse("title7", "content", "2022-12-22", "type", "teacher", 0, 0);
        assertEquals(istrue7, 1);
        boolean istrue8 = controllerUnderTest.deleteCourse("title7");
        assertEquals(istrue8, true);

        String json_str = controllerUnderTest.getCoursesByYearAndByTypeForwardSort(2022, "type");
        JSONArray json_array = new JSONArray(json_str);
        System.out.println(json_array);
        String json_str2 = controllerUnderTest.getCoursesByYearAndByTypeReverseSort(2022, "type");
        JSONArray json_array2 = new JSONArray(json_str2);
        System.out.println(json_array2);

        String json_str333 = controllerUnderTest.getCourseByTitle("title1");
        //String json_array333 = new String(json_str333);
        System.out.println("1111"+json_str333);

        String json_str444 = Course.getCoursesTitles(json_str);
        //String json_array444 = new String(json_str444);
        System.out.println("2222"+json_str444);

        controllerUnderTest.deleteCourse("title1");
        controllerUnderTest.deleteCourse("title2");
        controllerUnderTest.deleteCourse("title3");
        controllerUnderTest.deleteCourse("title5");
        controllerUnderTest.deleteCourse("title6");
    }



    @Test
    void testCalculater() throws URISyntaxException {
        double result = controllerUnderTest.calculateGradePointAverage(4);
        assertEquals(result, 0, 0.01);


        int istrue = controllerUnderTest.createCourse("title1", "content", "2022-11-15", "type", "teacher", 85, 2);
        assertEquals(istrue, 1);
        int istrue2 = controllerUnderTest.createCourse("title2", "content", "2023-1-21", "type", "teacher", 82, 4);
        assertEquals(istrue2, 1);
        int istrue3 = controllerUnderTest.createCourse("title3", "content", "2022-5-25", "type", "teacher", 95, 3);
        assertEquals(istrue3, 1);
        int istrue4 = controllerUnderTest.changeCourse("title4", "content", "2022-6-9", "type", "teacher", 72, 3);
        assertEquals(istrue4, 1);
        int istrue5 = controllerUnderTest.createCourse("title5", "content", "2022-12-21", "type", "teacher", 86, 4);
        assertEquals(istrue5, 1);
        int istrue6 = controllerUnderTest.createCourse("title6", "content", "2022-12-22", "type222", "teacher", 60, 5);
        assertEquals(istrue6, 1);
        int istrue7 = controllerUnderTest.createCourse("title7", "content", "2022-12-22", "type222", "teacher", 98, 3);
        assertEquals(istrue7, 1);
        int istrue8 = controllerUnderTest.createCourse("title8", "content", "2022-12-22", "type222", "teacher", 84, 2);
        assertEquals(istrue8, 1);
        int istrue9 = controllerUnderTest.createCourse("title9", "content", "2022-12-22", "type222", "teacher", 86, 4);
        assertEquals(istrue9, 1);
        int istrue10 = controllerUnderTest.createCourse("title10", "content", "2022-12-22", "type222", "teacher", 86, 2);
        assertEquals(istrue10, 1);
        double result1 = controllerUnderTest.calculateGradePointAverage(1);
        assertEquals(result1, 2.77, 0.01);
        double result2 = controllerUnderTest.calculateGradePointAverage(2);
        assertEquals(result2, 3.13, 0.2);
        double result3 = controllerUnderTest.calculateGradePointAverage(3);
        assertEquals(result3, 3.31, 0.1);

        controllerUnderTest.deleteCourse("title1");
        controllerUnderTest.deleteCourse("title2");
        controllerUnderTest.deleteCourse("title3");
        controllerUnderTest.deleteCourse("title4");
        controllerUnderTest.deleteCourse("title5");
        controllerUnderTest.deleteCourse("title6");
        controllerUnderTest.deleteCourse("title7");
        controllerUnderTest.deleteCourse("title8");
        controllerUnderTest.deleteCourse("title9");
        controllerUnderTest.deleteCourse("title10");
    }

    @Test
    void testPanDuan1() throws URISyntaxException, IOException{
        int istrue = controllerUnderTest.createSkill("title", "111", "", "project");
        assertEquals(istrue, -1);
        int istrue3 = controllerUnderTest.createSkill("title", "", "111", "");
        assertEquals(istrue3, -1);
        int istrue2 = controllerUnderTest.createSkill("title22", "content22", "proficiency22", "project22");
        assertEquals(istrue2, 1);
        int istrue4 = controllerUnderTest.createSkill("title22", "content22", "proficiency22", "project22");
        assertEquals(istrue4, -2);

        controllerUnderTest.deleteSkill("title22");
    }

    @Test
    void testPanDuan2() throws URISyntaxException, IOException, ParseException{

        int istrue5 = controllerUnderTest.createAchievement("title1", "content", "2022-11-15", "", "");
        assertEquals(istrue5, -1);
        int istrue6 = controllerUnderTest.createAchievement("title2", "content", "2023-1-21", "team", "responsibility");
        assertEquals(istrue6, 1);
        int istrue7 = controllerUnderTest.createAchievement("title2", "content", "2023-1-21", "team", "responsibility");
        assertEquals(istrue7, -2);

        controllerUnderTest.deleteAchievement("title2");
    }

    @Test
    void testPanDuan3() throws URISyntaxException, IOException{
        int istrue8 = controllerUnderTest.createRole("title2", "content", "");
        assertEquals(istrue8, -1);
        int istrue9 = controllerUnderTest.createRole("title3", "111", "2022-5-25");
        assertEquals(istrue9, 1);
        int istrue10 = controllerUnderTest.createRole("title3", "111", "2022-5-25");
        assertEquals(istrue10, -2);

        controllerUnderTest.deleteRole("title3");

    }

    @Test
    void testPanDuan4() throws URISyntaxException, IOException{
        int istrue11 = controllerUnderTest.createActivity("title1", "", "2022-11-15", "type", "location");
        assertEquals(istrue11, -1);
        int istrue14 = controllerUnderTest.createActivity("title1", "11", "", "type", "location");
        assertEquals(istrue14, -1);
        int istrue12 = controllerUnderTest.createActivity("title2", "content", "2023-1-21", "type", "location");
        assertEquals(istrue12, 1);
        int istrue13 = controllerUnderTest.createActivity("title2", "content", "2023-1-21", "type", "location");
        assertEquals(istrue13, -2);

        controllerUnderTest.deleteActivity("title2");
    }

    //grade credit如果为0,则表示为空
    @Test
    void testPanDuan5() throws URISyntaxException{
        int istrue = controllerUnderTest.createCourse("title1", "", "2022-11-15", "type", "", 1, 1);
        assertEquals(istrue, -1);
        int istrue3 = controllerUnderTest.createCourse("title2", "content", "2023-1-21", "type", "teacher", 1, 1);
        assertEquals(istrue3, 1);
        int istrue4 = controllerUnderTest.createCourse("title2", "xxx", "2023-1-21", "type", "teacher", 1, 1);
        assertEquals(istrue4, -2);

        controllerUnderTest.deleteCourse("title2");
    }

}
