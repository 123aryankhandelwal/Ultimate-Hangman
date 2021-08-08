
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

@SuppressWarnings({ "unchecked", "resource", "deprecation"})
public class MongoIO
{
	void write(Users u)
	{
		Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
		mongoLogger.setLevel(Level.SEVERE);
		DBObject dbobj;
		JSONObject o = new JSONObject();
		try
		{
			o.put("Name", u.Name);
			o.put("No_of_Games", u.noOfGames);
			o.put("No_of_Games_Won", u.noOfGamesWon);
			JSONArray achieved = new JSONArray();
			for(int i = 0; i<10; i++)
			{
				achieved.put(i, u.achieved[i]);
			}
			o.put("Achieved", achieved);
			JSONArray plcat = new JSONArray();
			for(int i = 0; i<5; i++)
			{
				plcat.put(i, u.playedCategories[i]);
			}
			o.put("Played_Category", plcat);
			JSONArray plimp = new JSONArray();
			for(int i = 0; i<5; i++)
			{
				plimp.put(i, u.playedImpossible[i]);
			}
			o.put("Played_Impossible", plimp);
			JSONArray cat = new JSONArray();
			JSONArray diff= new JSONArray();
			
			for(int i = 0; i<5; i++)
			{
				for(int j = 0; j<4; j++)
				{
					diff.put(i,u.PB[i][j]);
				}
				cat.put(i, diff);
				diff= new JSONArray();
			}
			JSONArray wonCat = new JSONArray();
			for(int i = 0; i<5; i++)
			{
				wonCat.put(i,u.wonCategory[i]);
			}
			o.put("Won_Category", wonCat);
			JSONArray won1GLeft = new JSONArray();
			for(int i = 0; i<5; i++)
			{
				won1GLeft.put(i,u.won1Gleft[i]);
			}
			o.put("Won_1_Guess_Left", won1GLeft);
			o.put("PB", cat);
			o.put("Username", u.getUsername());
			o.put("Password", u.getPassword());
			MongoClient mg = new MongoClient("localhost", 27017);
			DB mdb = mg.getDB("anvay");
			DBCollection mc = mdb.getCollection("Hangman");
			dbobj = (DBObject) JSON.parse(o.toString());
			mc.insert(dbobj);		
		} catch (JSONException e)
		{
			System.exit(1);
		}
		
	}
	Users read(String usrnm)
	{
		Users u = new Users();
		Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
		mongoLogger.setLevel(Level.SEVERE);
		MongoClient mg = new MongoClient("localhost", 27017);
		DB mdb = mg.getDB("anvay");
		DBCollection mc = mdb.getCollection("Hangman");
		BasicDBObject fields = new BasicDBObject();
	    fields.put("Username", usrnm);
		DBObject oneDetails = mc.findOne(fields);
		if(oneDetails == null)
			return null;		
		DBObject a, b;
		u.Name = (String)oneDetails.get("Username");
		u.setNoOfGames((int)oneDetails.get("No_of_Games"));
		u.setNoOfGamesWon((int)oneDetails.get("No_of_Games_Won"));
		u.setUsername((String)oneDetails.get("Username"));
		u.setPassword((String)oneDetails.get("Password"));
		a = (DBObject) oneDetails.get("PB");
		for(int i = 0; i<5; i++)
		{
			b = (DBObject) a.get(""+i);
			for(int j = 0; j<4; j++)
			{
				u.PB[i][j] = (int)b.get(""+j);
			}
		}
		a = (DBObject)oneDetails.get("Achieved");
		for(int i = 0; i<10; i++)
		{
			u.achieved[i] = (boolean)a.get(""+i);
		}
		a = (DBObject)oneDetails.get("Played_Category");
		for(int i = 0; i<5; i++)
		{
			u.playedCategories[i] = (boolean)a.get(""+i);
		}
		a = (DBObject)oneDetails.get("Played_Impossible");
		for(int i = 0; i<5; i++)
		{
			u.playedImpossible[i] = (boolean)a.get(""+i);
		}
		a = (DBObject)oneDetails.get("Won_Category");
		for(int i = 0; i<5; i++)
		{
			u.wonCategory[i] = (boolean)a.get(""+i);
		}
		a = (DBObject)oneDetails.get("Won_1_Guess_Left");
		for(int i = 0; i<5; i++)
		{
			u.won1Gleft[i] = (boolean)a.get(""+i);
		}
		return u;
	}
	
	void update(Users u)
	{
		Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
		mongoLogger.setLevel(Level.SEVERE);
		DBObject dbobj, oneDetails;
		JSONObject o = new JSONObject();
		try
		{
			o.put("Name", u.Name);
			o.put("No_of_Games", u.noOfGames);
			o.put("No_of_Games_Won", u.noOfGamesWon);
			JSONArray achieved = new JSONArray();
			for(int i = 0; i<10; i++)
			{
				achieved.put(i,u.achieved[i]);
			}
			o.put("Achieved", achieved);
			JSONArray plcat = new JSONArray();
			for(int i = 0; i<5; i++)
			{
				plcat.put(i,u.playedCategories[i]);
			}
			o.put("Played_Category", plcat);
			JSONArray plimp = new JSONArray();
			for(int i = 0; i<5; i++)
			{
				plimp.put(i,u.playedCategories[i]);
			}
			o.put("Played_Impossible", plimp);
			JSONArray cat = new JSONArray();
			JSONArray diff= new JSONArray();
			
			for(int i = 0; i<5; i++)
			{
				for(int j = 0; j<4; j++)
				{
					diff.put(j,u.PB[i][j]);
				}
				cat.put(i,diff);
				diff= new JSONArray();
			}
			JSONArray wonCat = new JSONArray();
			for(int i = 0; i<5; i++)
			{
				wonCat.put(i,u.wonCategory[i]);
			}
			o.put("Won_Category", wonCat);
			JSONArray won1GLeft = new JSONArray();
			for(int i = 0; i<5; i++)
			{
				won1GLeft.put(i,u.won1Gleft[i]);
			}
			o.put("Won_1_Guess_Left", won1GLeft);
			o.put("PB", cat);
			o.put("Username", u.getUsername());
			o.put("Password", u.getPassword());
			MongoClient mg = new MongoClient("localhost", 27017);
			DB mdb = mg.getDB("anvay");
			DBCollection mc = mdb.getCollection("Hangman");
			dbobj = (DBObject) JSON.parse(o.toString());
			BasicDBObject fields = new BasicDBObject();
		    fields.put("Username", u.getUsername());
			oneDetails = mc.findOne(fields);
			mc.update(oneDetails, dbobj);	
		} catch (JSONException e)
		{
			System.exit(1);
		}

	}
}