package test.com.lti.test;
import static org.junit.Assert.assertEquals;

import org.junit.*;

import com.lti.code.PracticeTest;

public class TestCalc {
private PracticeTest cal;
@Before
public void init() {
	cal=new PracticeTest();
}
@Test
public void TestDiv() {
	assertEquals(25,cal.divide(100, 5));
	
}
}
