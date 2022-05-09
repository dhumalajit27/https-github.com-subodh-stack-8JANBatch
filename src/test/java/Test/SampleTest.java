package Test;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ListnerTest.class)
public class SampleTest {
	
	@Test
	public void test()
	{
		System.out.println("hello");
	}

	@Test
	public void test1()
	{
		Assert.assertTrue(false);
	}
	
	@Test(dependsOnMethods= {"test1"})
	public void test2()
	{
		
	}
	

}
