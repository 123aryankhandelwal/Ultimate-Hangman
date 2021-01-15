import java.util.Scanner;

class Guest extends Players
{
	Guest()
	{
		super();
		GamePlay.clrscr();
		System.out.println("Enter Name");
		Name = System.console().readLine();
	}
	void Exit()
	{
		GamePlay.clrscr();
		System.out.println("Are you Sure?\nYou will lose your Progress");
		System.out.println("Country : ");
		System.out.println("Easy : "+this.getPB(1, 1));
		System.out.println("Medium : "+this.getPB(1, 2));
		System.out.println("Hard : "+this.getPB(1, 3));
		System.out.println("Impossible : "+this.getPB(1, 4));
		GamePlay.getch();
		GamePlay.clrscr();
		System.out.println("Sports : ");
		System.out.println("Easy : "+this.getPB(2, 1));
		System.out.println("Medium : "+this.getPB(2, 2));
		System.out.println("Hard : "+this.getPB(2, 3));
		System.out.println("Impossible : "+this.getPB(2, 4));
		GamePlay.getch();
		GamePlay.clrscr();
		System.out.println("Animals : ");
		System.out.println("Easy : "+this.getPB(3, 1));
		System.out.println("Medium : "+this.getPB(3, 2));
		System.out.println("Hard : "+this.getPB(3, 3));
		System.out.println("Impossible : "+this.getPB(3, 4));
		GamePlay.getch();
		GamePlay.clrscr();
		System.out.println("Movies : ");
		System.out.println("Easy : "+this.getPB(4, 1));
		System.out.println("Medium : "+this.getPB(4, 2));
		System.out.println("Hard : "+this.getPB(4, 3));
		System.out.println("Impossible : "+this.getPB(4, 4));
		GamePlay.getch();
		GamePlay.clrscr();
		System.out.println("Food : ");
		System.out.println("Easy : "+this.getPB(5, 1));
		System.out.println("Medium : "+this.getPB(5, 2));
		System.out.println("Hard : "+this.getPB(5, 3));
		System.out.println("Impossible : "+this.getPB(5, 4));
		GamePlay.getch();
		GamePlay.clrscr();
		System.out.println("\t\t\t Achievements");
		DisplayAchievements();
		GamePlay.getch();
		GamePlay.clrscr();
		System.out.println("Do you still want to exit?\n You Can do the following\n1.) Sign up 2.) Exit");
		Scanner s = new Scanner(System.in);
		//Users u = new Users();
		int op = s.nextInt();
		if(op == 1)
			LoginPage.signup(this);
		else if(op == 2)
			System.exit(0);
		s.close();
	}
}
