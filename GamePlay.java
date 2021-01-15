import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class GamePlay
{
	static int a, cat, diff;
	static void play(Users P)
	{
		boolean f;
		String word, Usrgs, star, yn;
		int b, i, score, r, j, c, gleft, ccu[], ctu[];//ccu -> counter for current userguess, ctu -> counter for total userguess
		ctu = new int[27];
		ccu = new int[27];
		char Userguess[], wrd[], buffer[];
		
		Difficulty d = new Difficulty();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		do
		{      
			b = score  = 0;
			gleft=6;
			c = P.getNoOfGames();
			P.setNoOfGames(c++);
			do
			{
				clrscr();
				f = false;
				System.out.println("\t\t\tCategory Menu");
				System.out.println("1.)Country");
				System.out.println("2.)Sports");
				System.out.println("3.)Animals");
				System.out.println("4.)Movies");
				System.out.println("5.)Food");
				cat = sc.nextInt();
				clrscr();
				System.out.println("\t\t\tDifficulty Level Menu");
				System.out.println("1.)Easy");
				System.out.println("2.)Moderate");
				System.out.println("3.)Hard");
				System.out.println("4.)Impossible");
				diff = sc.nextInt();
				word = d.WordChooser(cat, diff);
			
				if(word == null)
				{
					System.out.println("Enter Valid Category/Difficulty");
					getch();
					f = true;
				}
			}
			while(f);
			P.setPlayedCategories(cat-1, true);
			if(diff==4)
				P.setPlayedImpossible(cat-1, true);
			clrscr();
			Drawman(0);
			star = toStar(word);
			wrd = word.toCharArray();
			buffer = star.toCharArray();
			System.out.println(star);
		for(i = 0; i < 26; i++)
		{
			ctu[i] = 0;
		}
		do
		{
			System.out.println("Enter Your Guess");
			Usrgs=System.console().readLine();
			Userguess = Usrgs.toCharArray();
			for(i = 0; i < 26; i++)
			{
				ccu[i] = 0;
			}
			for(i = 0; i<Userguess.length; i++)
			{
				ccu[ati(Userguess[i])]++;
				ctu[ati(Userguess[i])]++;
			}
			for(i = 0; i<Userguess.length; i++)
			{
				a = 0;
				for(j = 0; j<wrd.length; j++)
				{
					if((((byte)wrd[j] == (byte)Userguess[i]) || ((byte)wrd[j] == (byte)Userguess[i]+32) || ((byte)wrd[j] == (byte)Userguess[i]-32)) && ctu[ati(Userguess[i])] == ccu[ati(Userguess[i])])
					{
						score+=50;
						a = 1;
						buffer[j] = wrd[j];
						clrscr();  
						Drawman(b);
						//System.out.print(buffer);
						star = String.valueOf(buffer);
						System.out.println(star);
						System.out.println("\nYour Guess is correct\nYour score is "+score);
						System.out.println("\nNumber of guesses left: "+gleft);
					}
					else if(ctu[ati(Userguess[i])] != ccu[ati(Userguess[i])])
					{
						a = 2;
					}
				}
				if(a == 0)
				{
					b++;
					score -=10;
					gleft--;
					if(gleft <= 0)
						break;
				}
			}
				if(a == 0)
				{
					clrscr();
					Drawman(b);
					System.out.println(star);
					if(b<6)
					{
						System.out.println("\nYour Guess is incorrect\nYour score is " + score);
						System.out.println("\nNumber of guesses left: " + gleft);
					}
					else
					{
						System.out.println("\nAlas! You lose. Your Score is " + score + "\nThe Answer is " + word);
						break;
					}
				}
				else if(a == 2)
				{
					score-=3;
					clrscr();
					Drawman(b);
					System.out.println(star);
					System.out.println("\nEnter a new character\nThis has already been guessed.\n3 Point Penalty\n");
					System.out.println("\nYour score is " + score + "\nNumber of guesses left: " + gleft);
				}
				star.strip();
				word.strip();
				if(star.equalsIgnoreCase(word))
				{
					clrscr();
					Drawman(-1);
					System.out.println("\nBravo!! You Win!!\nYour Score is " + score + "\nThe Answer is " + word);
					if(gleft == 1)
					{
						P.setAchieved(2, true);
						P.setWon1Gleft(cat-1, true);
					}
						
					else if(gleft==6)
						P.setAchieved(1, true);
					if(diff == 4)
					{
						P.setPlayedImpossible(cat-1, true);
						P.setAchieved(4, true);
					}
					P.setWonCategories(cat-1, true);
					r = P.getNoOfGamesWon();
					P.setNoOfGamesWon(r++);
					P.setAchieved(0, true);
					break;
				}
		 }	while((b < 6) && !star.equalsIgnoreCase(word));
			if(P.getPB(cat, diff)<score)
			{
				P.setPB(cat, diff, score);
			}
			do
			{
				System.out.println("\nDo you want to continue?(Y/N):");
				yn = System.console().readLine();
				if(!yn.matches("[ynYN]"))
				{
					System.out.println("Invalid Option\nEnter Again\n");
					getch();
				}
				else
					break;
					
			}while(true);
			FileIO fio;
			try
			{
				fio = new FileIO();
				fio.update(P);
			}
			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}		
		} while(yn.matches("[yY]"));
	}
	static void play(Guest P)
	{
		boolean f;
		String word, Usrgs, star, yn;
		int b, i, score, r, j, c, gleft, ccu[], ctu[];//ccu -> counter for current userguess, ctu -> counter for total userguess
		ctu = new int[26];
		ccu = new int[26];
		char Userguess[], wrd[], buffer[];
		
		Difficulty d = new Difficulty();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		do
		{      
			b = score  = 0;
			gleft=6;
			c = P.getNoOfGames();
			P.setNoOfGames(c++);
			do
			{
				f = false;
				System.out.println("\t\t\tCategory Menu");
				System.out.println("1.)Country");
				System.out.println("2.)Sports");
				System.out.println("3.)Animals");
				System.out.println("4.)Movies");
				System.out.println("5.)Food");
				cat = sc.nextInt();
				clrscr();
				System.out.println("\t\t\tDifficulty Level Menu");
				System.out.println("1.)Easy");
				System.out.println("2.)Moderate");
				System.out.println("3.)Hard");
				System.out.println("4.)Impossible");
				diff = sc.nextInt();
				word = d.WordChooser(cat, diff);
			
				if(word == null)
				{
					System.out.println("Enter Valid Category/Difficulty");
					f = true;
				}
			}
			while(f);
			P.setPlayedCategories(cat-1, true);
			if(diff==4)
				P.setPlayedImpossible(cat-1, true);
			clrscr();
			Drawman(0);
			star = toStar(word);
			wrd = word.toCharArray();
			buffer = star.toCharArray();
			System.out.println(star);
		for(i = 0; i < 26; i++)
		{
			ctu[i] = 0;
		}
		do
		{
			System.out.println("Enter Your Guess");
			Usrgs=System.console().readLine();
			Userguess = Usrgs.toCharArray();
			for(i = 0; i < 26; i++)
			{
				ccu[i] = 0;
			}
			for(i = 0; i<Userguess.length; i++)
			{
				ccu[ati(Userguess[i])]++;
				ctu[ati(Userguess[i])]++;
			}
			for(i = 0; i<Userguess.length; i++)
			{
				a = 0;
				for(j = 0; j<wrd.length; j++)
				{
					if((((byte)wrd[j] == (byte)Userguess[i]) || ((byte)wrd[j] == (byte)Userguess[i]+32) || ((byte)wrd[j] == (byte)Userguess[i]-32)) && ctu[ati(Userguess[i])] == ccu[ati(Userguess[i])])
					{
						score+=50;
						a = 1;
						buffer[j] = wrd[j];
						clrscr();  
						Drawman(b);
						//System.out.print(buffer);
						star = String.valueOf(buffer);
						System.out.println(star);
						System.out.println("\nYour Guess is correct\nYour score is "+score);
						System.out.println("\nNumber of guesses left: "+gleft);
					}
					else if(ctu[ati(Userguess[i])] != ccu[ati(Userguess[i])])
					{
						a = 2;
					}
				}
				if(a == 0)
				{
					b++;
					score -=10;
					gleft--;
					if(gleft <= 0)
						break;
				}
			}
				if(a == 0)
				{
					clrscr();
					Drawman(b);
					System.out.println(star);
					if(b<6)
					{
						System.out.println("\nYour Guess is incorrect\nYour score is " + score);
						System.out.println("\nNumber of guesses left: " + gleft);
					}
					else
					{
						System.out.println("\nAlas! You lose. Your Score is " + score + "\nThe Answer is " + word);
						getch();
						break;
					}
				}
				else if(a == 2)
				{
					score-=3;
					clrscr();
					Drawman(b);
					System.out.println(star);
					System.out.println("\nEnter a new character\nThis has already been guessed.\n3 Point Penalty\n");
					System.out.println("\nYour score is " + score + "\nNumber of guesses left: " + gleft);
				}
				star.strip();
				word.strip();
				if(star.equalsIgnoreCase(word))
				{
					clrscr();
					Drawman(-1);
					System.out.println("\nBravo!! You Win!!\nYour Score is " + score);
					getch();
					if(gleft == 1)
					{
						P.setAchieved(2, true);
						P.setWon1Gleft(cat-1, true);
					}
						
					else if(gleft==6)
						P.setAchieved(1, true);
					for(int k=0;k<5;k++)
					{
						if(P.getPlayedImpossible(k))
						{
							P.setAchieved(8, true);
						}
					}
					P.setWonCategories(cat-1, true);
					r = P.getNoOfGamesWon();
					P.setNoOfGamesWon(r++);
					P.setAchieved(0, true);
					break;
				}
		 }	while((b < 6) && !star.equalsIgnoreCase(word));
			if(P.getPB(cat, diff)<score)
			{
				P.setPB(cat, diff, score);
			}
			do
			{
				System.out.println("\nDo you want to continue?(Y/N):");
				yn = System.console().readLine();
				if(!yn.matches("[ynYN]"))
				{
					System.out.println("Invalid Option\nEnter Again\n");
					getch();
				}
				else
					break;
					
			}while(true);
		} while(yn.matches("[yY]"));
	}

	static void clrscr()
	{
		try
		{
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	static void getch()
	{
		try
		{
			new ProcessBuilder("cmd", "/c", "pause").inheritIO().start().waitFor();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	static void Drawman(int a) {
		
		if(a==0)
		{       System.out.println("");
				System.out.println("\t+------+");
				System.out.println("\t|      |");
				System.out.println("\t|    (O_O)");
				System.out.println("\t|         ");
				System.out.println("\t|         ");
				System.out.println("\t|   	 ");
				System.out.println("\t|  	 ");
				System.out.println("\t|            ");
				System.out.println("\t=============");
		}
		else if(a==1)
		{       System.out.println("");
			System.out.println("\t+------+");
			System.out.println("\t|      |");
			System.out.println("\t|    (a_a)");
			System.out.println("\t|       	 ");
			System.out.println("\t|   	 ");
			System.out.println("\t|    	 ");
			System.out.println("\t|  	 ");
			System.out.println("\t|            ");
			System.out.println("\t=============");
		}
		else if(a==2)
		{       System.out.println("");
			System.out.println("\t+------+");
			System.out.println("\t|      |");
			System.out.println("\t|    ('_')");
			System.out.println("\t|      |  ");
			System.out.println("\t|      |  ");
			System.out.println("\t|      |  ");
			System.out.println("\t|         ");
			System.out.println("\t|            ");
			System.out.println("\t=============");
		}
		else if(a==3)
		{       System.out.println("");
			System.out.println("\t+------+");
			System.out.println("\t|      |");
			System.out.println("\t|    (*_*)");
			System.out.println("\t|     /|  ");
			System.out.println("\t|    / |  ");
			System.out.println("\t|      |  ");
			System.out.println("\t|         ");
			System.out.println("\t|            ");
			System.out.println("\t=============");
		}
		else if(a==4)
		{       System.out.println("");
			System.out.println("\t+------+");
			System.out.println("\t|      |");
			System.out.println("\t|    (^o^)");
			System.out.println("\t|     /|\\  ");
			System.out.println("\t|    / | \\ ");
			System.out.println("\t|      |  ");
			System.out.println("\t|          ");
			System.out.println("\t|            ");
			System.out.println("\t=============");
		}
		else if(a==5)
		{       System.out.println("");
			System.out.println("\t+------+");
			System.out.println("\t|      |");
			System.out.println("\t|    (!o!)");
			System.out.println("\t|     /|\\");
			System.out.println("\t|    / | \\");
			System.out.println("\t|    / |    ");
			System.out.println("\t|   /        ");
			System.out.println("\t|            ");
			System.out.println("\t=============");
		}
		else if(a == 6)
		{   System.out.println("");
			System.out.println("\t+------+");
			System.out.println("\t|      |");
			System.out.println("\t|    (#x#)");
			System.out.println("\t|     /|\\");
			System.out.println("\t|    / | \\");
			System.out.println("\t|    / | \\");
			System.out.println("\t|   /     \\");
			System.out.println("\t|            ");
			System.out.println("\t=============");
		}
		else
		{
			System.out.println("");
			System.out.println("\t   (*^_^*)");
			System.out.println("\t     /|\\");
			System.out.println("\t    / | \\");
			System.out.println("\t    / | \\");
			System.out.println("\t   /     \\");
			System.out.println("\t=============");
		}	
	}
	
	static String toStar(String w)
	{
		String x;
		int i;
		char [] code = w.toCharArray();
		for(i = 0; i<code.length; i++)
		{	
			if(!(w.charAt(i) == 'a' || w.charAt(i) == 'e' || w.charAt(i) == 'i' || w.charAt(i) == 'o' || w.charAt(i) == 'u' || w.charAt(i) == 'A' || w.charAt(i) == 'E' || w.charAt(i) == 'I' || w.charAt(i) == 'O' || w.charAt(i) == 'U') && Character.isLetter(w.charAt(i)))
			{
				code[i] = '*';
			}
		}
		x = new String(code);
		return x;
	}
	static int ati(char ch)
	{
		if(ch == 'a' || ch == 'A')
		{
			return 0;
		}
		else if(ch == 'b' || ch == 'B')
		{
			return 1;
		}
		else if(ch == 'c' || ch == 'C')
		{
			return 2;
		}
		else if(ch == 'd' || ch == 'D')
		{
			return 3;
		}
		else if(ch == 'e' || ch == 'E')
		{
			return 4;
		}
		else if(ch == 'f' || ch == 'F')
		{
			return 5;
		}
		else if(ch == 'g' || ch == 'G')
		{
			return 6;
		}
		else if(ch == 'h' || ch == 'H')
		{
			return 7;
		}
		else if(ch == 'i' || ch == 'I')
		{
			return 8;
		}
		else if(ch == 'j' || ch == 'J')
		{
			return 9;
		}
		else if(ch == 'k' || ch == 'K')
		{
			return 10;
		}
		else if(ch == 'l' || ch == 'L')
		{
			return 11;
		}
		else if(ch == 'm' || ch == 'M')
		{
			return 12;
		}
		else if(ch == 'n' || ch == 'N')
		{
			return 13;
		}
		else if(ch == 'o' || ch == 'O')
		{
			return 14;
		}
		else if(ch == 'p' || ch == 'P')
		{
			return 15;
		}
		else if(ch == 'q' || ch == 'Q')
		{
			return 16;
		}
		else if(ch == 'r' || ch == 'R')
		{
			return 17;
		}
		else if(ch == 's' || ch == 'S')
		{
			return 18;
		}
		else if(ch == 't' || ch == 'T')
		{
			return 19;
		}
		else if(ch == 'u' || ch == 'U')
		{
			return 20;
		}
		else if(ch == 'v' || ch == 'V')
		{
			return 21;
		}
		else if(ch == 'w' || ch == 'W')
		{
			return 22;
		}
		else if(ch == 'x' || ch == 'X')
		{
			return 23;
		}
		else if(ch == 'y' || ch == 'Y')
		{
			return 24;
		}
		else if(ch == 'z' || ch == 'Z')
		{
			return 25;
		}
		else
		return 26;
	}
}