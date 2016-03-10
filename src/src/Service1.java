import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/calculate")
public class Service1 {

	@GET
	@Path("/si/{p}/{t}/{r}")
	@Produces("application/xml")
	public String calculateSimpleInterest(@PathParam("p")double d,@PathParam("t")double e, @PathParam("r")double f)
	{
		double simpleInterest = d*e*f;
		simpleInterest = simpleInterest / 100;
		return "<SimpleInterest>" + simpleInterest + "</SimpleInterest>";
	}
	
	@GET
	@Path("/ci/{p}/{r}/{n}/{t}")
	@Produces("application/xml")
	public String calculateCompound(@PathParam("p")double i, @PathParam("r")double d, @PathParam("n")double j, @PathParam("t")double e)
	{
		double compoundInterest = (double) (i * (1 + d/j));
		compoundInterest = (double) Math.pow(compoundInterest, j*e);
		compoundInterest = Math.round(compoundInterest);
		return "<CompoundInterest>" + compoundInterest + "</CompoundInterest>";
	}
}
