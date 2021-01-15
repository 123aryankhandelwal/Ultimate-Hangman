import java.util.Scanner;

public class Ultimate_Hangman 
{
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) 
	{
		int op;
		do
		{
			GamePlay.clrscr();
			System.out.println("\t\t\t   Main Menu");
			System.out.println("1.)Login");
			System.out.println("2.)Signup");
			System.out.println("3.)Play as Guest");
			System.out.println("4.)Instructions");
			System.out.println("5.)Exit");
			op = sc.nextInt();
			switch(op)
			{
				case 1: UserIO.userio(LoginPage.Login());
						break;
				case 2: UserIO.userio(LoginPage.signup(null));
						break;
				case 3: UserIO.userio(new Guest());
						break;
				case 4:
					System.out.println("\t\t\tInstructions");
					System.out.println("ONLY USER'S PROGRESS WILL BE SAVED");
					System.out.println("To Play as a User First You need Sign up with 3 credentials");
					System.out.println("a.)Name");
					System.out.println("b.)Username (which should be unique)");
					System.out.println("c.)Password ");
					System.out.println("After Signup, ");
					System.out.println("Remeber your Username and Password which will be used for Logging in");
					System.out.println("Enjoy the Game");
					GamePlay.getch();
					break;
				case 5: return;					
				
				default: System.out.println("Enter A valid option");
			}
		}while(true);
	}

}
