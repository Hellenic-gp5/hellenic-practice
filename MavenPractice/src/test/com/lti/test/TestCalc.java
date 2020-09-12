package test.com.lti.test;
import static org.junit.Assert.assertEquals;

import java.com.lti.test.PracticeTest;

import org.junit.*;

public class TestCalc {
private PracticeTest cal;
@Before
public void init() {
	cal=new PracticeTest();
}
@Test
public void TestDiv() {
	assertEquals(20,cal.divide(100, 5));
}
}
