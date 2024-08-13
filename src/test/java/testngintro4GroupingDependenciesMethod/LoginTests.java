package testngintro4GroupingDependenciesMethod;
/*

loginByfacebook - sanity
loginby emial  -sanity
login by twitter  -sanity

signupbyfacebook -regression
signupbytwitter  -regression
signupbyemail   - regression

paymentinrupees   - sanity, regression (functional)
paymentindollars   - sanity, regression  (functional)

1) all sanity tests
2) all regression tests
3) all sanity but not regression
4) all regression but not sanity
5) all methods which are belongs to both sanity & regression: WE NEED TO ADD SEPARATE NAME
 */
import org.testng.annotations.Test;

/*
 Arraniging the TC(class) based upon group
 can be done through xml only
 */
public class LoginTests {

	@Test(priority=1, groups= {"sanity"})
	void loginByEmail()
	{
		System.out.println("This is login by Email");
	}
	
	@Test(priority=2,groups= {"sanity"})
	void loginByFacebook()
	{
		System.out.println("This is login by Facebook");
	}
	
	@Test(priority=3,groups= {"sanity"})
	void loginByTwitter()
	{
		System.out.println("This is login by Twitter");
	}
	
}
