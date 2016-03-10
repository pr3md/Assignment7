import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.json.*;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.WriteResult;

@Path("/doc")
public class DeleteDoc extends HttpServlet {
	
	public DeleteDoc() {
		super();
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String docId = request.getParameter("id");
		MongoClientURI uri = new MongoClientURI("mongodb://pr3mdb:pr3mdpr3md@ds019688.mlab.com:19688/pr3mdlab7");
		MongoClient client = new MongoClient(uri);

		DB db = client.getDB(uri.getDatabase());
		DBCollection zip = db.getCollection("zipcodes");
		BasicDBObject query = new BasicDBObject();
		
		query.put("zip", docId);
		
		zip.remove(query);
		
		//response.getWriter().write(docs.toArray().toString());
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "DELETE");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		response.setHeader("Access-Control-Max-Age", "86400");
	}
	@Override
	protected void doOptions(HttpServletRequest arg0, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doOptions(arg0, response);

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, HEAD, OPTIONS");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		response.setHeader("Access-Control-Max-Age", "86400");
	}

}