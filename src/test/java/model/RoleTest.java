import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoleTest {
    private Role role;

    @TempDir
    Path tempDir;

    @BeforeEach
    void setUp() {
        role = new Role("abc", "2023-5-5", "leader");
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
    void TestsaveRoles() throws URISyntaxException{
        java.net.URL classResource = BasicInformation.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path RootPath = classDirectory.getParent().getParent();

        role = new Role("abc", "2023-5-5", "member");
        boolean result = role.saveRoles();
        assertEquals(true, result);
    }

    @Test
    void TestdeleteRoles(){
        role = new Role("abc", "2023-5-5", "member");
        boolean result = role.deleteRoles("");
        assertEquals(false, result);
        assertTrue(result,"Title not exist!");
        result = role.deleteRoles("abc");
        assertEquals(true, result);
        assertTrue(result,"Successfully delete Roles: " + role.getTitle());
    }

    @Test
    void TestgetRolesByYearReverseSort() throws ParseException{
        String result = null;
        try {
            result = role.getRolesByYearReverseSort(2013);
            result = role.getRolesByYearReverseSort(2014);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result, "Roles should not be null");
        assertNotEquals("error", result, "JSON file should be successfully read");
    }
    @Test
    void TestgetRolesByYearForwardSort() throws ParseException{
        String result = null;
        try {
            result = role.getRolesByYearReverseSort(2013);
            result = role.getRolesByYearReverseSort(2014);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result, "Roles should not be null");
        assertNotEquals("error", result, "JSON file should be successfully read");
    }

    @Test
    void TestgetRolesByTitles(){
        String result = null;
        try {
            result = role.getRolesByTitles("member");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result, "Roles should not be null");
        assertNotEquals("error", result, "JSON file should be successfully read");
    }
    @Test
    void TestgetAllRoles(){
        String result = null;
        try {
            result = role.getAllRoles();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result, "Roles should not be null");
        assertNotEquals("error", result, "JSON file should be successfully read");
    }
}