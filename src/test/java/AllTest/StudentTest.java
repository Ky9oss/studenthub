package AllTest;
import for_understanding_TDD.*;

import static org.junit.Assert.*;
import org.junit.Test;

public class StudentTest{

	@Test
	public void testCreate(){
		Student student = new Student("KaixuanHou");
		assertEquals("KaixuanHou",student.getName());
		Student student2 = new Student("WenxuanWu");
		assertEquals("WenxuanWu",student2.getName());
	}
}
