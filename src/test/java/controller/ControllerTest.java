package controller;

import static org.junit.Assert.*;
import org.junit.Test;

public class ControllerTest {

    private Controller c = new Controller();
	@Test
	public void testGetSkillsTitles(){
        assertEquals("Alice,Bob",c.getSkillsTitles());

	}
}
