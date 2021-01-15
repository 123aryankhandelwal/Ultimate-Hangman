import java.io.*;
import java.util.*;
class Leaderboard
{
	void DisplayLB(int cat, int diff)
	{
		Users u = null;
		FileIO f = null;
		List<Users> Ulist = new ArrayList<>();
		List<Users> U = new ArrayList<>();
		try
		{
			f = new FileIO();
			while(true)
			{
				u = f.read();
				Ulist.add(u);
			}
			
		}
		catch(EOFException e)
		{
			try
			{
				f.din.close();
				f.dout.close();
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
		QuickSort qs = new QuickSort(Ulist, cat, diff);
		System.out.println("before sort");
		qs.partition(0, Ulist.size()-1);
		System.out.println("after sort");
		U=qs.getSortedArray();
		Collections.reverse(U);
		GamePlay.clrscr();
		System.out.println("\t\t\tLeader Board");
		System.out.println("Name\t\t\tUsername\t\t\t\tPersonal Best");
		for(Users u1 : U)
		{
			System.out.println(u1.getName()+"\t\t\t"+u1.getUsername()+"\t\t\t\t"+u1.getPB(cat, diff));
		}
		GamePlay.getch();
	}
}
