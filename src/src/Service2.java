import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/metrics")
public class Service2 {

	@GET
	@Path("/kelvintoF/{k}")
	@Produces("application/xml")
	public String calculateFahrenheit(@PathParam("k")Double a)
	{
		Double Fahrenheit = (a - 273.15) * 1.8 + 32.0;
		Fahrenheit = (double) Math.round(Fahrenheit);
		return "<Fahrenheit>" + Fahrenheit + "</Fahrenheit>";
	}
	
	@GET
	@Path("/kelvintoC/{k}")
	@Produces("application/xml")
	public String calculateCelcius(@PathParam("k")Double a)
	{
		Double Celcius = (a - 273.15);
		return "<Celcius>" + Celcius + "</Celcius>";
	}
}
