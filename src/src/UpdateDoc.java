import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;

import org.bson.types.ObjectId;
import org.json.JSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.WriteResult;

@Path("/doc")
public class UpdateDoc extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UpdateDoc() {
		super();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MongoClientURI uri = new MongoClientURI("mongodb://pr3mdb:pr3mdpr3md@ds019688.mlab.com:19688/pr3mdlab7");
		MongoClient client = new MongoClient(uri);
		
		DB db = client.getDB(uri.getDatabase());
		DBCollection zipcodes = db.getCollection("zipcodes");
		
		//Fetch parameters
		String id = request.getParameter("id");
		String zip = request.getParameter("zip");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		
		//Find the document with matching OID
		BasicDBObject query = new BasicDBObject();
		query.put("_id", new ObjectId(id));
		
		//DBCursor docs = zipcodes.find(query);
		
		
		BasicDBObject updateField = new BasicDBObject();
		updateField.append("zip", zip);
		updateField.append("city", city);
		updateField.append("state", state);
		
		BasicDBObject setQuery = new BasicDBObject();
		setQuery.append("$set", updateField);
		
		zipcodes.update(query, updateField);
		
		//response.getWriter().write(docs.toArray().toString());
		
		//response.getWriter().write(id.toString());
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "PUT, POST, GET, DELETE, OPTIONS, HEAD");
		response.setHeader("Access-Control-Allow-Headers", "ContentType");
		response.setHeader("Access-Control-Max-Age", "86400");
		//response.getWriter().write(result.toString());
	}
	
	@Override
	protected void doOptions(HttpServletRequest arg0, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doOptions(arg0, response);

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "PUT, POST, GET, DELETE, OPTIONS, HEAD");
		
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		response.setHeader("Access-Control-Max-Age", "86400");
	}

}
