import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random; 

public class Difficulty {
	File file;
	String WordChooser(int cat, int diff)
	{
		if(cat == 1)
		{
			if(diff == 1)
				file=new File("D:\\Java\\Country\\Easy.txt");
			else if(diff == 2)
				file=new File("D:\\Java\\Country\\Medium.txt");
			else if(diff == 3)
				file=new File("D:\\Java\\Country\\Hard.txt");
			else if(diff == 4)
				file=new File("D:\\Java\\Country\\Impossible.txt");
			else
				return null;
		}
		else if(cat == 2)
		{
			if(diff == 1)
				file=new File("D:\\Java\\Sports\\Easy.txt");
			else if(diff == 2)
				file=new File("D:\\Java\\Sports\\Medium.txt");
			else if(diff == 3)
				file=new File("D:\\Java\\Sports\\Hard.txt");
			else if(diff == 4)
				file=new File("D:\\Java\\Sports\\Impossible.txt");
			else
				return null;
		}
		else if(cat == 3)
		{
			if(diff == 1)
				file=new File("D:\\Java\\Animals\\Easy.txt");
			else if(diff == 2)
				file=new File("D:\\Java\\Animals\\Medium.txt");
			else if(diff == 3)
				file=new File("D:\\Java\\Animals\\Hard.txt");
			else if(diff == 4)
				file=new File("D:\\Java\\Animals\\Impossible.txt");
			else
				return null;
		}
		else if(cat == 4)
		{
			if(diff == 1)
				file=new File("D:\\Java\\Movies\\Easy.txt");
			else if(diff == 2)
				file=new File("D:\\Java\\Movies\\Medium.txt");
			else if(diff == 3)
				file=new File("D:\\Java\\Movies\\Hard.txt");
			else if(diff == 4)
				file=new File("D:\\Java\\Movies\\Impossible.txt");
			else
				return null;
		}
		else if(cat == 5)
		{
			if(diff == 1)
				file=new File("D:\\Java\\Food\\Easy.txt");
			else if(diff == 2)
				file=new File("D:\\Java\\Food\\Medium.txt");
			else if(diff == 3)
				file=new File("D:\\Java\\Food\\Hard.txt");
			else if(diff == 4)
				file=new File("D:\\Java\\Food\\Impossible.txt");
			else
				return null;
		}
		else
			return null;
		int Totallines=-1;
		BufferedReader br=null;
		String Word = null;
		try {
			br=new BufferedReader(new FileReader(file));
			while(br.readLine()!=null) {
				Totallines++;
				}
			br.close();
			br=new BufferedReader(new FileReader(file));
			Random ra=new Random();
			int raint=ra.nextInt(Totallines);
			int count=1;
			
			while((Word=br.readLine())!=null) {
				if(count==raint) {
					
					br.close();
				}
				count++;
			}
			br.close();
		}
		catch (FileNotFoundException e) {
	        System.out.println("File not found: " + file.toString());
	    } catch (IOException e) {} 
		return Word;
	}
}
	
	