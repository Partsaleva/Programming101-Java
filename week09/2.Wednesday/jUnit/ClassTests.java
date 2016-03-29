package jUnit;

public class ClassTests {

	private static ClassForTest testObject = new ClassForTest();

	
	
	@Test
	public static void testAdd() {
		Assert.assertEquals("Test if addition works.", 150, testObject.add(100, 50));
	}

	@Test
	public void testSubtract() {
		Assert.assertEquals("Test if subtraction works.", 7, testObject.subtract(15, 8));
	}

	@Test
	public void testMultiply(){
		Assert.assertEquals("Test if multiplication works", 15, testObject.multiply(3, 5));
	}
	
	@Test
	public void testDivision() {
		Assert.assertEquals("Test if division works.", 7.5, testObject.divide(15, 2));
	}
	
	 @Test (expected = IllegalArgumentException.class)
	 public void testCatchesZeroDivision() {
		 testObject.divide(2, 0);
	 }
}
