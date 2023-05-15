package model;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RoleTest {
    private Role role;

    Path tempDir;

    void setUp() {
        role = new Role("abc", "2023-5-5", "leader");
    }

    void obtainedPath() throws URISyntaxException {
        java.net.URL classResource = BasicInformation.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path RootPath = classDirectory.getParent().getParent();
        assertEquals("/studenthub", RootPath.toString()); 
    }

    void TestsaveRoles() throws URISyntaxException{
        java.net.URL classResource = BasicInformation.class.getProtectionDomain().getCodeSource().getLocation();
        Path classDirectory = Paths.get(classResource.toURI());
        Path RootPath = classDirectory.getParent().getParent();

        role = new Role("abc", "2023-5-5", "member");
        int result = role.saveRoles();
        assertEquals(true, result);
    }

    void TestdeleteRoles() throws URISyntaxException{
        role = new Role("abc", "2023-5-5", "member");
        boolean result = Role.deleteRoles("");
        assertTrue(result);
        result = Role.deleteRoles("abc");
        assertEquals(true, result);
    }


    void TestgetRolesByYearReverseSort() throws ParseException{
        String result = null;
        try {
            result = Role.getRolesByYearReverseSort(2013);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result);
    }


    void TestgetRolesByYearForwardSort() throws ParseException{
        String result = null;
        try {
            result = Role.getRolesByYearReverseSort(2013);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result);
    }


    void TestgetRolesByTitles(){
        String result = null;
        try {
            result = Role.getRolesByTitles("member");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result);
    }


    void TestgetAllRoles(){
        String result = null;
        try {
            result = Role.getAllRoles();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result);
    }   
    
    public static void main(String[] args) throws URISyntaxException, ParseException {
        RoleTest r = new RoleTest();
        r.TestsaveRoles();
        r.TestdeleteRoles();
        r.TestgetAllRoles();
        r.TestgetRolesByYearForwardSort();
        r.TestgetRolesByYearReverseSort();
        r.TestgetRolesByTitles();
        System.out.println("succeed");
    }
}
