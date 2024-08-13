package testngintro4GroupingDependenciesMethod;
/*
 
 */
import org.testng.annotations.Test;

public class PaymentTests {

	@Test(priority=1,groups= {"regression","sanity", "functional"})
	void paymentinRupees()
	{
		System.out.println("Payment in Rupees");
	}
	
	@Test(priority=2,groups= {"regression","sanity","functional"})
	void paymentinDollars()
	{
		System.out.println("Payment in Dolloars");
	}
}
