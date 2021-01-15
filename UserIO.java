import java.io.EOFException;
import java.io.IOException;
import java.util.Scanner;

class UserIO
{
	static String input;
	static void userio(Users u)
	{
		if(u == null)
			return;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int cat, diff;
		boolean f3;
		do
		{
			f3 = true;
			for(int k=0;k<5;k++)
			{
				if(!u.getPlayedCategories(k))
				{
					f3 = false;
				}
			}	
			if(f3)
				u.setAchieved(6, true);
			f3=true;
			for(int k=0;k<5;k++)
			{
				if(!u.getWonCategories(k))
				{
					f3 = false;
				}
			}	
			if(f3)
				u.setAchieved(7, true);
			
			f3=true;
			for(int k=0;k<5;k++)
			{
				if(!u.getWon1Gleft(k))
				{
					f3 = false;
				}
			}	
			if(f3)
				u.setAchieved(9, true);
			f3 = true;
			for(int k=0;k<5;k++)
			{
				if(!u.getPlayedImpossible(k))
				{
					f3=false;
				}
			}
			if(f3)
				u.setAchieved(8, true);
			try {
				FileIO io=new FileIO();
				io.update(u);
				
			}catch(EOFException e){}
			catch (IOException e) {
				e.printStackTrace();
			}
			
			GamePlay.clrscr();
			System.out.println("\t\t\t   Menu");
			System.out.println("1.)Play Game");
			System.out.println("2.)Instruction");
			System.out.println("3.)Personal Best");
			System.out.println("4.)Leader Board");
			System.out.println("5.)Achievements");
			System.out.println("6.)Exit");
			input = System.console().readLine();
			GamePlay.clrscr();
			switch(input)
			{
			case "1":
				GamePlay.play(u);
				break;
			case "2":
				GamePlay.clrscr();
				System.out.println("\t\t\t Instruction");
				System.out.println("How to play:\n1. There will be a word acoording to the category selected.\n2. You put your guess.\n3. If the guess is correct, you will be awarded 50 points.\n4. If your guess is incorrect, your score will be deducted by 10 points & the\nMan will go to its next stage.\n5.If you Guess the same letter again then there will be a 3 point penalty.\n6. You will get a total of 6 guesses. \n7. If you guessed wrong even in the 6th time, your Man will be hanged!!");
				System.out.println("\n\nWarning: If you type any number or any special character, \nthen it will be considered as a wrong guess.");
				GamePlay.getch();
				break;
			case "3":
				boolean f1= false;
				do
				{
					f1 = false;
					GamePlay.clrscr();
					System.out.println("Enter Category");
					System.out.println("1.)Country");
					System.out.println("2.)Sports");
					System.out.println("3.)Animals");
					System.out.println("4.)Movies");
					System.out.println("5.)Food");
					input = System.console().readLine();
					GamePlay.clrscr();
					switch(input)
					{
					case "1" :
						System.out.println("Country : ");
						System.out.println("Easy : "+u.getPB(1, 1));
						System.out.println("Medium : "+u.getPB(1, 2));
						System.out.println("Hard : "+u.getPB(1, 3));
						System.out.println("Impossible : "+u.getPB(1, 4));
						break;
					case "2" :
						System.out.println("Sports : ");
						System.out.println("Easy : "+u.getPB(2, 1));
						System.out.println("Medium : "+u.getPB(2, 2));
						System.out.println("Hard : "+u.getPB(2, 3));
						System.out.println("Impossible : "+u.getPB(2, 4));
						break;
					case "3" :
						System.out.println("Animals : ");
						System.out.println("Easy : "+u.getPB(3, 1));
						System.out.println("Medium : "+u.getPB(3, 2));
						System.out.println("Hard : "+u.getPB(3, 3));
						System.out.println("Impossible : "+u.getPB(3, 4));
						break;
					case "4" :
						System.out.println("Movies : ");
						System.out.println("Easy : "+u.getPB(4, 1));
						System.out.println("Medium : "+u.getPB(4, 2));
						System.out.println("Hard : "+u.getPB(4, 3));
						System.out.println("Impossible : "+u.getPB(4, 4));
						break;
					case "5" :
						System.out.println("Food : ");
						System.out.println("Easy : "+u.getPB(5, 1));
						System.out.println("Medium : "+u.getPB(5, 2));
						System.out.println("Hard : "+u.getPB(5, 3));
						System.out.println("Impossible : "+u.getPB(5, 4));
						break;
					default:
						System.out.println("Entered Invalid Input\n Please Enter Valid Input");
						f1 = true;
					}
					GamePlay.getch();
				}while(f1);
				break;
			case "4":
				boolean f2 = false;
				Leaderboard l = new Leaderboard();
				do
				{
					GamePlay.clrscr();
					System.out.println("\t\t\tCategory Menu");
					System.out.println("1.)Country");
					System.out.println("2.)Sports");
					System.out.println("3.)Animals");
					System.out.println("4.)Movies");
					System.out.println("5.)Food");
					cat = sc.nextInt();
					GamePlay.clrscr();
					System.out.println("\t\t\tDifficulty Level Menu");
					System.out.println("1.)Easy");
					System.out.println("2.)Moderate");
					System.out.println("3.)Hard");
					System.out.println("4.)Impossible");
					diff = sc.nextInt();
					GamePlay.clrscr();
					if((cat<=5 && cat>=1) && (diff>=1 && diff<=4))
					{
						l.DisplayLB(cat, diff);
						break;
					}
					else
					{
						System.out.println("Enter Valid Option");
						f2 = true;
					}
					GamePlay.getch();
				}
				while(f2);
				break;
			case "5": 
				System.out.println("\t\t\t Achievements");
				u.DisplayAchievements();
				GamePlay.getch();
				break;
			case "6" :
				System.exit(0);
			default : 
				System.out.println("Invalid option\n Enter valid option");
				GamePlay.getch();
			
			}
		}while(true);
	}
	static void userio(Guest g)
	{
		do
		{
			boolean f3 = true;
			
			for(int k=0;k<5;k++)
			{
				if(!g.getPlayedCategories(k))
				{
					f3 = false;
				}
			}	
			if(f3)
				g.setAchieved(6, true);
			f3=true;
			for(int k=0;k<5;k++)
			{
				if(!g.getWonCategories(k))
				{
					f3 = false;
				}
			}	
			if(f3)
				g.setAchieved(7, true);
			f3=true;
			for(int k=0;k<5;k++)
			{
				if(!g.getWon1Gleft(k))
				{
					f3 = false;
				}
			}	
			if(f3)
				g.setAchieved(9, true);
			f3 = true;
			for(int k=0;k<5;k++)
			{
				if(!g.getPlayedImpossible(k))
				{
					f3=false;
				}
			}
			if(f3)
				g.setAchieved(8, true);
			GamePlay.clrscr();
			System.out.println("\t\t\t   Menu");
			System.out.println("1.)Play Game");
			System.out.println("2.)Instruction");
			System.out.println("3.)Personal Best");
			System.out.println("4.)Achievements");
			System.out.println("5.)Exit");
			input = System.console().readLine();
			GamePlay.clrscr();
			switch(input)
			{
			case "1":
				GamePlay.play(g);
				break;
			case "2":
				System.out.println("\t\t\t Instruction");
				System.out.println("How to play:\n1. There will be a word acoording to the category selected.\n2. You put your guess.\n3. If the guess is correct, you will be awarded 50 points.\n4. If your guess is incorrect, your score will be deducted by 10 points & the\nMan will go to its next stage.\n5. You will get a total of 6 guesses. \n6. If you guessed wrong even in the 6th time, your Man will be hanged!!");
				System.out.println("\n\nWarning: If you type any number or any special character, \nthen it will be considered as a wrong guess.");
				break;
			case "3":
				boolean f1= false;
				do
				{
					System.out.println("Enter Category");
					System.out.println("1.)Country");
					System.out.println("2.)Sports");
					System.out.println("3.)Animals");
					System.out.println("4.)Movies");
					System.out.println("5.)Food");
					input = System.console().readLine();
					GamePlay.clrscr();
					switch(input)
					{
					case "1" :
						System.out.println("Country : ");
						System.out.println("Easy : "+g.getPB(1, 1));
						System.out.println("Medium : "+g.getPB(1, 2));
						System.out.println("Hard : "+g.getPB(1, 3));
						System.out.println("Impossible : "+g.getPB(1, 4));
						break;
					case "2" :
						System.out.println("Sports : ");
						System.out.println("Easy : "+g.getPB(2, 1));
						System.out.println("Medium : "+g.getPB(2, 2));
						System.out.println("Hard : "+g.getPB(2, 3));
						System.out.println("Impossible : "+g.getPB(2, 4));
						break;
					case "3" :
						System.out.println("Animals : ");
						System.out.println("Easy : "+g.getPB(3, 1));
						System.out.println("Medium : "+g.getPB(3, 2));
						System.out.println("Hard : "+g.getPB(3, 3));
						System.out.println("Impossible : "+g.getPB(3, 4));
						break;
					case "4" :
						System.out.println("Movies : ");
						System.out.println("Easy : "+g.getPB(4, 1));
						System.out.println("Medium : "+g.getPB(4, 2));
						System.out.println("Hard : "+g.getPB(4, 3));
						System.out.println("Impossible : "+g.getPB(4, 4));
						break;
					case "5" :
						System.out.println("Food : ");
						System.out.println("Easy : "+g.getPB(5, 1));
						System.out.println("Medium : "+g.getPB(5, 2));
						System.out.println("Hard : "+g.getPB(5, 3));
						System.out.println("Impossible : "+g.getPB(5, 4));
						break;
					default:
						System.out.println("Entered Invalid Input\n Please Enter Valid Input");
						f1 = true;
					}
					GamePlay.getch();
				}while(f1);
				break;
			case "4": 
				System.out.println("\t\t\t Achievements");
				g.DisplayAchievements();
				break;
			case "5" :
				g.Exit();
				System.exit(0);
			default : 
				System.out.println("Invalid option\n Enter valid option");
			
			}
			GamePlay.getch();
		}while(true);
	}
	
}
