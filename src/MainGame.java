import java.awt.Button;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;


public class MainGame {
    private GameDifficulty.difficulties difficulty = GameDifficulty.difficulties.MEDIUM;
    private int currentDay = 0;
    private int maxDay = 5;
    private ArrayList<Monster> allMonsters = new ArrayList<Monster>();
    private ArrayList<Item> allItems = new ArrayList<Item>();
    private ArrayList<Item> starterItems = new ArrayList<Item>();
    private ArrayList<Monster> starterMonsters = new ArrayList<Monster>();
    private Player newPlayer = new Player();
    private ArrayList<Battle> battles = new ArrayList<Battle>();

    public MainGame(){
        new SetUp(this);
    }
    public int getDaysLeft() {
    	return getMaxDay()-getCurrentDay();
    }
    public Player getPlayer(){
        return newPlayer;
    }
    public int getCurrentDay() {
		return currentDay;
	}
	public void setCurrentDay(int currentDay) {
		this.currentDay = currentDay;
	}
	public int getMaxDay() {
		return maxDay;
	}
	public void setMaxDay(int maxDay) {
		this.maxDay = maxDay;
	}
	public GameDifficulty.difficulties getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(GameDifficulty.difficulties newDifficulty) {
        difficulty = newDifficulty;
    }
	public ArrayList<Monster> getAllMonsters() {
		return allMonsters;
	}
	public ArrayList<Monster> getStarterMonsters() {
		return starterMonsters;
	}
	public ArrayList<Item> getStarterItems() {
		return starterItems;
	}
	public void increaseDay() {
        currentDay++;
    }
    public void setAllMonsters(ArrayList<Monster> allMonsters){
        this.allMonsters = allMonsters;
    }
	public ArrayList<Item> getAllItems() {
		return allItems;
	}
	public void setAllItems(ArrayList<Item> allItems) {
		this.allItems = allItems;
	}
	public ArrayList<Battle> getBattles() {
		return battles;
	}
	public void setBattles(ArrayList<Battle> newBattles) {
		battles = newBattles;
	}
	public void launchSetupScreen() {
		new SetupScreen(this);
	}
	public void launchBattleScreen(int battle){
		new BattleScreen(this,getBattles().get(battle));
	}
	public void launchMoveTeamScreen(JButton btnMoveTeam) {
		btnMoveTeam.setEnabled(false);
		MoveTeamScreen moveTeam = new MoveTeamScreen(this, btnMoveTeam);
	}
	public void closeSetupScreen(SetupScreen SetupWindow) {
		SetupWindow.closeWindow();
        launchMainScreen();
	}
	private void launchMainScreen() {
		MainScreen mainScreen = new MainScreen(this);
	}
	public void closeMoveTeamScreen(MoveTeamScreen moveTeamScreen, JButton button) {
		moveTeamScreen.closeWindow();
		button.setEnabled(true);
	}

	public void closeBattleScreen(BattleScreen BattleScreen) {
		BattleScreen.closeWindow();
	}
    public String toPercentage(double n){
		return String.format("%.0f",n*100)+"%";
	}
    private void setDaysBattles() {
		Random rand = new Random();
    	for (int i=0; i<4; i++ ){
			ArrayList<Monster> team = new ArrayList<Monster>();
			if (getCurrentDay() < 5) {
				int randomSize = rand.nextInt(2);
				for (int j=0; j < randomSize; j++){
					int randomIndex = rand.nextInt(getAllMonsters().size());
            		Monster randomMonster = getAllMonsters().get(randomIndex);
					team.add(randomMonster);
				}

    		} else if (getCurrentDay() >= 5 && getCurrentDay() < 10){
				int randomSize = rand.nextInt(2,3);
				for (int j=0; j < randomSize; j++){
					int randomIndex = rand.nextInt(getAllMonsters().size());
            		Monster randomMonster = getAllMonsters().get(randomIndex);
					team.add(randomMonster);
				}
			} else {
				int randomSize = rand.nextInt(2, 4);
				for (int j=0; j < randomSize; j++){
					int randomIndex = rand.nextInt(getAllMonsters().size());
            		Monster randomMonster = getAllMonsters().get(randomIndex);
					team.add(randomMonster);
				}
			}
			Battle battle = new Battle(team);
			getBattles().add(battle);
		}
	}
	public void closeMainScreen(MainScreen mainScreen) {
        mainScreen.closeWindow();
    }
	public void closeMainScreen(MainScreen mainScreen, int i) {
		mainScreen.closeWindow();
		launchBattleScreen(i);
    }
     
    public static void main(String[] args) {
        MainGame gamer = new MainGame();
        System.out.println(gamer.getAllMonsters());
        
    }
    
	
	
	
}
