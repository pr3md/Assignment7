import static org.junit.Assert.*;

import org.junit.Test;

public class Service1Test {
	Service1 testService = new Service1();
	String SI = testService.calculateSimpleInterest(1000.0, 12.5, 3.4);
	String result_si = "<SimpleInterest>425.0</SimpleInterest>";
	String CI = testService.calculateCompound(1500, 3.4, 2, 12.5);
	String result_ci = "<CompoundInterest>9.22337203854776E18</CompoundInterest>";
	
	
	@Test
	public void testCalculateSimpleInterest() {
		System.out.println("@Test calculateSimpleInterest(): "+SI+" = "+result_si);
		assertEquals(SI, result_si);
	}

	@Test
	public void testCalculateCompound() {
		System.out.println("@Test calculateCompoundInterest(): "+CI+" = "+result_ci);
		assertEquals(CI, result_ci);
	}

}
