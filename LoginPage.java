import java.io.Console;
import java.util.Scanner;

class LoginPage
{
	static Console console = System.console();
	static Users signup(Players P)
	{
		char[] p1, p2;
		Users u = new Users();
		String pass, cp, usrnm;
		Console console = System.console();
		GamePlay.clrscr();
		System.out.println("\t\t\tSignup");
		if(P == null)
		{
			System.out.println("Enter Name :");
			String x = System.console().readLine();
			u.setName(x);
		}
		else
		{
			u.setName(P.getName());
			for(int i = 1; i<=5; i++)
			{
				for(int j = 1; j<=4; j++)
				{
					u.setPB(i, j, P.getPB(i, j));
				}
			}
			for(int i = 0; i<10; i++)
			{
				u.setAchieved(i, P.getAchieved(i));
			}
			for(int i = 0; i<5; i++)
			{
				u.setPlayedCategories(i, P.getPlayedCategories(i));
			}
			for(int i = 0; i<5; i++)
			{
				u.setPlayedImpossible(i, P.getPlayedImpossible(i));
			}
			for(int i = 0; i<5; i++)
			{
				u.setWon1Gleft(i, P.getWon1Gleft(i));
			}
			for(int i = 0; i<5; i++)
			{
				u.setWonCategories(i, P.getWonCategories(i));
			}
			u.setNoOfGames(P.getNoOfGames());
			u.setNoOfGamesWon(P.getNoOfGamesWon());
		}
		do
		{
			System.out.println("Enter Username");
			usrnm = System.console().readLine();
			if(checkusrnm(usrnm))
				System.out.println("Pick Different Username\n This is already in use");
		}while(checkusrnm(usrnm));
		u.setUsername(usrnm);
		do
		{
			System.out.println("Enter Password");
			p1 = console.readPassword();
			pass = new String(p1);
			System.out.println("Confirm Password");
			p2 = console.readPassword();
			cp = new String(p2);
			if(!pass.equals(cp))
			{
				System.out.println("Passwords don't match");
			}
		}while(!pass.equals(cp));
		u.setPassword(new String(pass));
		MongoIO mout = new MongoIO();
		mout.write(u);
		return u;
	}

	private static boolean checkusrnm(String u)
	{
		MongoIO min = new MongoIO();
		if(min.read(u) == null)
			return false;
		return true;
	}
	static Users Login()
    {
		Scanner sc = new Scanner(System.in);
        Users u = new Users();
        String usrnm, pass;
        MongoIO min=new MongoIO();
        GamePlay.clrscr();
        System.out.println("\n\n\t\t\tLogin");
        System.out.println("Enter Username");
        usrnm = sc.nextLine();
        u = min.read(usrnm);
        GamePlay.getch();
        if(u != null)
        {
            do
            {
                GamePlay.clrscr();
                System.out.println("Enter Password");
                char p[] = new char[32];
                p =    console.readPassword();
                pass = new String(p);
                if(u.getPassword().equals(pass))
                {
                    break;
                }
                do
                {
                    System.out.println("Password does not match\n Enter 1 to Re-Enter password\n Enter 2 to Go back to Main Menu");
                    String s = System.console().readLine();
                    if(s.matches("[1-2]"))
                    {
                        if(s.equals("1"))
                            break;
                        else return null;
                    }
                }while(true);
                GamePlay.getch();
            }while(true);
        }
        else
        {
        	do
			{
				GamePlay.clrscr();
				System.out.println("Username does not exist\n Please Enter again\n Or Sign up\n \n1.) Enter Username again\n2.) Signup");
				String i = System.console().readLine();
				i.strip();
				switch(i)
				{
					case "1" : break;
					case "2" : return signup(null);
					default : System.out.println("Enter Valid Symbol");
				}
				if(i.equals("1"))
					break;
				GamePlay.getch();
			}while(true);
        }
		return u;
    }
}