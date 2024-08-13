package testngintro4GroupingDependenciesMethod;
/*
 -dependsOnMethods= {"method name1","method name2",....}
 -this dependOnMethods annotion only available for @Test annotion
adv
  - no need to exeecute all the methods
 */

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyMethod {

	@Test(priority=1)
	void openapp()
	{
		Assert.assertTrue(false);
	}
	
	@Test(priority=2, dependsOnMethods={"openapp"})
	void login()
	{
		Assert.assertTrue(true);
	}
	
	@Test(priority=3, dependsOnMethods={"login"})
	void search()
	{
		Assert.assertTrue(true);

	}

	@Test(priority=4, dependsOnMethods={"login","search"})   //adv search depend upon 2 method login & search
	void advsearch()
	{
		Assert.assertTrue(true);

	}
	
	@Test(priority=5,dependsOnMethods={"login"})
	void logout()
	{
		Assert.assertTrue(true);

	}
}

	


