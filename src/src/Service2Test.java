import static org.junit.Assert.*;

import org.junit.Test;

public class Service2Test {
	Service2 testService = new Service2();
	String fahrenheit = testService.calculateFahrenheit(280.0);
	String result_F = "<Fahrenheit>44.0</Fahrenheit>";
	String celcius = testService.calculateCelcius(290.0);
	String result_C = "<Celcius>16.850000000000023</Celcius>";
	
	@Test
	public void testCalculateFahrenheit() {
		System.out.println("Result: "+fahrenheit+" = "+result_F);
		assertEquals(result_F, fahrenheit);
	}

	@Test
	public void testCalculateCelcius() {
		System.out.println("Result: "+celcius+" = "+result_C);
		assertEquals(result_C, celcius);
	}

}
