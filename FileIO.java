import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


class FileIO
{
	DataOutputStream dout = null;
	DataInputStream din = null;
	File file = null;
	FileIO() throws FileNotFoundException, IOException
	{
		
		file = new File("Users.dat");
		file.createNewFile();
		din = new DataInputStream(new FileInputStream(file));
		dout = new DataOutputStream(new FileOutputStream(file, true));
	}
	void write(Users u1) throws IOException
	{
		dout.writeUTF(u1.getName());
        dout.writeUTF(u1.getUsername());
        dout.writeUTF(u1.getPassword());
        for(int i = 1; i<=5; i++)
        {
        	for(int j = 1; j<=4; j++)
        	{
        		dout.writeInt(u1.getPB(i,j));
        	}
        }
        for(int i = 0; i<10; i++)
        {
        	dout.writeBoolean(u1.getAchieved(i));
        }
        for(int i = 0; i<5; i++)
        {
        	dout.writeBoolean(u1.getPlayedCategories(i));
        }
        for(int i = 0; i<5; i++)
        {
        	dout.writeBoolean(u1.getPlayedImpossible(i));
        }
        for(int i = 0; i<5; i++)
        {
        	dout.writeBoolean(u1.getWon1Gleft(i));
        }
        for(int i = 0; i<5; i++)
        {
        	dout.writeBoolean(u1.getWonCategories(i));
        }
        dout.writeInt(u1.getNoOfGames());
        dout.writeInt(u1.getNoOfGamesWon());
        
	}
	
	Users read() throws IOException
	{
		Users u = new Users();
		u.setName(din.readUTF());	
		u.setUsername(din.readUTF());
		u.setPassword(din.readUTF());
		for(int i = 1; i<=5; i++)
		{
			for(int j = 1; j<=4; j++)
			{
				u.setPB(i, j, din.readInt());
			}
		}
		for(int i = 0; i<10; i++)
		{
			u.setAchieved(i, din.readBoolean());
		}
		for(int i = 0; i<5; i++)
		{
			u.setPlayedCategories(i, din.readBoolean());
		}
		for(int i = 0; i<5; i++)
		{
			u.setPlayedImpossible(i, din.readBoolean());
		}
		for(int i = 0; i<5; i++)
		{
			u.setWon1Gleft(i, din.readBoolean());
		}
		for(int i = 0; i<5; i++)
		{
			u.setWonCategories(i, din.readBoolean());
		}
		u.setNoOfGames(din.readInt());
		u.setNoOfGamesWon(din.readInt());
		return u;
		
	}
	void update(Users P)
	{
		Users u = null;
		List<Users> Ulist = new ArrayList<>();
		try
		{
			while(true)
			{
				u = read();
				Ulist.add(u);
			}
		}
		catch(EOFException e)
		{
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		for(Users u1 : Ulist)
		{
			if(u1.getUsername().equals(P.getUsername()))
			{
				Collections.replaceAll(Ulist, u1, P);
			}
		}
		try
		{
			dout = new DataOutputStream(new FileOutputStream(file, false));
			for(Users u1 : Ulist)
			{
				dout.writeUTF(u1.getName());
		        dout.writeUTF(u1.getUsername());
		        dout.writeUTF(u1.getPassword());
		        for(int i = 1; i<=5; i++)
		        {
		        	for(int j = 1; j<=4; j++)
		        	{
		        		dout.writeInt(u1.getPB(i,j));
		        	}
		        }
		        for(int i = 0; i<10; i++)
		        {
		        	dout.writeBoolean(u1.getAchieved(i));
		        }
		        for(int i = 0; i<5; i++)
		        {
		        	dout.writeBoolean(u1.getPlayedCategories(i));
		        }
		        for(int i = 0; i<5; i++)
		        {
		        	dout.writeBoolean(u1.getPlayedImpossible(i));
		        }
		        for(int i = 0; i<5; i++)
		        {
		        	dout.writeBoolean(u1.getWon1Gleft(i));
		        }
		        for(int i = 0; i<5; i++)
		        {
		        	dout.writeBoolean(u1.getWonCategories(i));
		        }
		        dout.writeInt(u1.getNoOfGames());
		        dout.writeInt(u1.getNoOfGamesWon());
			}
		}
		catch(EOFException e)
		{
			try
			{
				dout.close();
			}
			catch (IOException e1)
			{
				e1.printStackTrace();
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
}