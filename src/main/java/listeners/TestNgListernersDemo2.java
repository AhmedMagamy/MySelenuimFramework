package listeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

// add annotaions  that make the listenesr work  that refer to the listeners class(added in xml file )
//@Listeners(listeners.TestNgListeners.class)

public class TestNgListernersDemo2 {
	
	
	@Test
	public void test5( )
	{
		System.out.println("this is test 5");
	}
	@Test
	public void test6( )
	{
		System.out.println("this is test 6");
		Assert.assertTrue(false);
	}
	@Test
	public void test7( )
	{
		System.out.println("this is test 7");
		
		throw new SkipException("this test is skiped") ; 
	}
	@Test
	public void test8( )
	{
		System.out.println("this is test 8");
	}
	

}
