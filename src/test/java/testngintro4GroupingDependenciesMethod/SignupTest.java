package testngintro4GroupingDependenciesMethod;
/*

 */
import org.testng.annotations.Test;

public class SignupTest {

	@Test(priority=1,groups= {"regression"})
	void signupbyemail()
	{
		System.out.println("This is signup by Email");
	}
	
	@Test(priority=2,groups= {"regression"})
	void signupbyfacebook()
	{
		System.out.println("This is signup by fb");
	}
	
	@Test(priority=3,groups= {"regression"})
	void signupbytwitter()
	{
		System.out.println("This is signup by twitter");
	}
}
