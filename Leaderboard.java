import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
class Leaderboard
{
	@SuppressWarnings({ "deprecation", "null" })
	void DisplayLB(int cat, int diff)
	{
		Users u = null;
		List<Users> U = new ArrayList<>();
		GamePlay.clrscr();
		System.out.println("\t\t\tLeader Board");
		System.out.println("Name\t\t\tUsername\t\t\t\tPersonal Best");
		Logger mongoLogger = Logger.getLogger( "org.mongodb.driver" );
		mongoLogger.setLevel(Level.SEVERE);
		MongoClient mg = new MongoClient("localhost", 27017);
		DB mdb = mg.getDB("anvay");
		DBCollection mc = mdb.getCollection("Hangman");
		BasicDBObject allQuery = new BasicDBObject();
	    DBCursor cursor = mc.find(allQuery).sort(new BasicDBObject(("PB."+(cat-1)+"."+(diff-1)), -1));
    	while(cursor.hasNext())
	    {
	    	DBObject oneDetails = cursor.next();
	    	DBObject a, b;
			u.setName((String)oneDetails.get("Name"));
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
			System.out.println(a);
			a = (DBObject)oneDetails.get("Played_Category");
			System.out.println(a);
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
			U.add(u);
	    }    
		for(Users u1 : U)
		{
			System.out.println(u1.getName()+"\t\t\t"+u1.getUsername()+"\t\t\t\t"+u1.getPB(cat, diff));
		}
		GamePlay.getch();
	}
}
