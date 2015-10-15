package Lista1;

import org.junit.*;

/** A test class for the Number class. */
public class NumberTest
{
	@Before
	/** Set up each test. */
	public void setUp()
	{
		System.out.println("Mogłoby tego tutaj nie być, ale polecenie każe nam użyć adnotacji @Before...");
	}
	
	@After
	/** Clean after each test. */
	public void tearDown()
	{
		System.out.println("Tego też mogłoby nie być, ale musimy użyć adnotacji @After");
	}
	
	@Test @Ignore
	/** A failed test that is ignored. */
	public void blowUpTheUniverse()
	{
		Assert.fail();
	}
	
	@Test(timeout=1000)
	/** Test whether the Number.inBase() method works correctly when the number is constructed correctly. */
	public void convertsNumberCorrectly()
	{
		Number num = new Number(14);
		Assert.assertNotNull(num.inBase(16));
		Assert.assertEquals(num.inBase(2), "1110");
		Assert.assertNotEquals(num.inBase(3), "123");
		Assert.assertNotSame(num.inBase(5), num.inBase(7));
		Assert.assertTrue("All is OK", num.inBase(10).equals(Long.toString(num.getValue())));
	}
	
	@Test(expected = IllegalArgumentException.class)
	/** Test whether an appropriate exception is thrown when one attempts to construct the number with a negative
	 * 	value. */
	public void testValueNotNatural()
	{
		@SuppressWarnings("unused")
		Number num = new Number(-5);
	}
}