package propertiesFileParser;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PropertiesFileParserTest {

	private PropertiesFileParser pp;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		pp=new PropertiesFileParser();
	}

	@After
	public void tearDown() throws Exception {
	}

	/*@Test
	public void testParseProperties() {
		fail("Not yet implemented");
	}*/

	@Test
	public void testRemoveComment() {
		String origString="abv #abv";
		String result=pp.removeComment(origString);
		assertEquals("abv ",result);
	}

}
