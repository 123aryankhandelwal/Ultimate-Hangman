class Players
{
	protected String Name;
	final protected String [] Achievements; //Decide if you need to make it final
	protected int [][] PB; // Personal Best
	protected int noOfGames;  //Record no. of games played by the player
	protected int noOfGamesWon;//Records no. of games won
	protected boolean achieved[], playedCategories [], playedImpossible[],wonCategory[],won1Gleft[];//Records No. of categories played;
	final int C = 5, D = 4;
	String getName()
	{
		return Name;
	}
	String[] getAchievements()
	{
		return Achievements;
	}
	int getPB(int cat, int diff)
	{
		return PB[cat-1][diff-1];
	}
	void setName(String N)
	{
		Name = N;
	}
	void setPB(int cat, int diff, int score)
	{
		PB[cat-1][diff-1] = score;
	}
	int getNoOfGamesWon() {
		return noOfGamesWon;
	}
	void setNoOfGamesWon(int noOfGamesWon) {
		this.noOfGamesWon = noOfGamesWon;
	}
	int getNoOfGames() {
		return noOfGames;
	}
	void setNoOfGames(int noOfGames) {
		this.noOfGames = noOfGames;
	}
	boolean getPlayedImpossible(int i) {
		return playedImpossible[i];
	}
	void setPlayedImpossible(int i, boolean key) {
		this.playedImpossible[i] = key;
	}
	void setAchieved(int i, boolean key) {
		achieved[i] = key;
	}
	boolean getAchieved(int i)
	{
		return achieved[i];
	}
	boolean getPlayedCategories(int i) {
		return playedCategories[i];
	}
	void setPlayedCategories(int i, boolean key) {
		this.playedCategories[i] = key;
	}
	boolean getWonCategories(int i) {
		return wonCategory[i];
	}
	void setWonCategories(int i, boolean key) {
		this.wonCategory[i] = key;
	}
	boolean getWon1Gleft(int i) {
		return won1Gleft[i];
	}
	void setWon1Gleft(int i, boolean key) {
		this.won1Gleft[i] = key;
	}
	Players()
	{
		achieved = new boolean[10]; //Will decide whether the corresponding achievement is achieved or not
		for(int i = 0; i<10; i++)
			achieved[i] = false;
		PB = new int[C][D];
		Achievements = new String[10];
		Achievements[0] = "Won 1st Game";
		Achievements[1] = "Won a Game with no wrong guesses";
		Achievements[2] = "Won with just 1 guess left";
		Achievements[3] = "Top 3 in LeaderBoard";
		Achievements[4] = "Won an Impossible Level Game";
		Achievements[5] = "Completed Impossible Difficulty in any one of the Categories";
		Achievements[6] = "Played all the Categories";
		Achievements[7] = "Won in all Categories";
		Achievements[8] = "Won all Impossible Levels (all categories)";
		Achievements[9] = "Won in all categories with with just 1 guess left";
		playedCategories = new boolean[5];
		playedImpossible = new boolean[5];
		wonCategory = new boolean[5];
		won1Gleft = new boolean[5];
		
		for(int i = 0; i<5; i++)
			playedCategories[i] = false;
		for(int i = 0; i<5; i++)
			playedImpossible[i] = false;
		for(int i = 0; i<5; i++)
			wonCategory[i] = false;
		for(int i = 0; i<5; i++)
			won1Gleft[i] = false;
	}
	void DisplayAchievements()
	{
		for(int i = 0; i<10; i++)
		{
			if(achieved[i])
			{
				System.out.print("Achievement : ");
				System.out.println(Achievements[i]);
			}
		}
		
	}
}
