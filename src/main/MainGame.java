package main;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;


public class MainGame {
    private GameDifficulty.difficulties difficulty = GameDifficulty.difficulties.MEDIUM;
    private int currentDay = 0;
    private int maxDay = 5;
    private ArrayList<Monster> allMonsters = new ArrayList<Monster>();
    private ArrayList<Monster> starterMonsters = new ArrayList<Monster>();
    private ArrayList<Monster> storeMonsters = new ArrayList<Monster>();
    private ArrayList<Item> allItems = new ArrayList<Item>();
    private ArrayList<Item> starterItems = new ArrayList<Item>();
    private ArrayList<Item> storeItems = new ArrayList<Item>();
    private Player newPlayer = new Player();
    private ArrayList<Battle> battles = new ArrayList<Battle>();
	/**
	 * Class constructor to set up monsters and items from text files
	 */
    public MainGame(){
        new SetUp(this);
    }
	/**
	 * sets the days battles for the user to choose from
	 */
    public void setDaysBattles() {
    	getBattles().clear();
		Random rand = new Random();
		ArrayList<Monster> avaiable = new ArrayList<Monster>(getAllMonsters());
		
    	for (int i=0; i<4; i++ ){
			ArrayList<Monster> team = new ArrayList<Monster>();
			if(getCurrentDay() == 0) { // Makes sure on the first day you fight teams with 1 enemy
				int randomSize = rand.nextInt(1, 2);
				for (int j=0; j < randomSize; j++){
					int randomIndex = rand.nextInt(avaiable.size());
					try {
					 Monster randomMonster = avaiable.get(randomIndex).clone(); // Clone so that we don't fight the only instance of the monster
					 team.add(randomMonster);
					} catch (CloneNotSupportedException e) {
						e.printStackTrace();
					}
					
				}
			} else if (getCurrentDay() < 5) {
				int randomSize = rand.nextInt(2, 4);
				for (int j=0; j < randomSize; j++){
					int randomIndex = rand.nextInt(avaiable.size());
					try {
					 Monster randomMonster = avaiable.get(randomIndex).clone();
					 team.add(randomMonster);
					} catch (CloneNotSupportedException e) {
						e.printStackTrace();
					}
				}

    		} else if (getCurrentDay() >= 5 && getCurrentDay() < 10){
				int randomSize = rand.nextInt(4, 5);
				for (int j=0; j < randomSize; j++){
					int randomIndex = rand.nextInt(avaiable.size());
					try {
					 Monster randomMonster = avaiable.get(randomIndex).clone();
					 team.add(randomMonster);
					} catch (CloneNotSupportedException e) {
						e.printStackTrace();
					}
				}
			} else {
				int randomSize = rand.nextInt(5, 6);
				for (int j=0; j < randomSize; j++){
					int randomIndex = rand.nextInt(avaiable.size());
					try {
					 Monster randomMonster = avaiable.get(randomIndex).clone();
					 team.add(randomMonster);
					} catch (CloneNotSupportedException e) {
						e.printStackTrace();
					}
				}
			}
			
			Battle battle = new Battle(team, newPlayer, this);
			getBattles().add(battle);
		}
	}
	/**
	 * gets the text from a button and returns the text and integer in the button group
	 * @param buttonGroup ButtonGroup the buttons that are in a particular button group
	 * @return ArrayList<String> first value is the text of the selected button and second is the index of the selected button
	 */
    public ArrayList<String> getSelectedButtonText(ButtonGroup buttonGroup) {
    	int index = 0;
    	ArrayList<String> list = new ArrayList<String>();
    	// Enumerate through all buttons to check which one was selected.
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                list.add(button.getText());
                list.add(Integer.toString(index));
                return list;
            }
        index++;
        }
        return null;
    }
	/**
	 * turns a double in to a percentage sign for the user to easily read
	 * @param n Double the amount that needs to be formated
	 * @return String the amount in percentage form for the user to be easily read
	 */
	public String toPercentage(double n){
		return String.format("%.0f",n*100)+"%";
	}
	/**
	 * turns a int into a dollar sign for the user to eaily read
	 * @param n int the amount that needs to be formated
	 * @return String the amount in dollar form
	 */
	public String toDollar(int n) {
		return "$"+n;
	}
    /**
	 * gets the amount of days left in the game
	 * @return int the amount of days left in the game
	 */
    public int getDaysLeft() {
    	return getMaxDay()-getCurrentDay();
    }
	/**
	 * gets the current player in the game
	 * @return Player the current Player
	 */
    public Player getPlayer(){
        return newPlayer;
    }
	/**
	 * gets the current day of the game
	 * @return int current day of game
	 */
    public int getCurrentDay() {
		return currentDay;
	}
	/**
	 * sets the current days of the game
	 * @param currentDay int new current day to set
	 */
	public void setCurrentDay(int currentDay) {
		this.currentDay = currentDay;
	}
	/**
	 * gets the max amount of days wanted to be played
	 * @return int max amount of days to be played
	 */
	public int getMaxDay() {
		return maxDay;
	}
	/**
	 * sets the max amount of days wanted to be played
	 * @param maxDay int new max days to be set
	 */
	public void setMaxDay(int maxDay) {
		this.maxDay = maxDay;
	}
	/**
	 * gets the current difficulty of the game
	 * @return GameDifficulty.difficulties current difficulty of game
	 */
	public GameDifficulty.difficulties getDifficulty() {
		return difficulty;
	}
	/**
	 * sets the current difficulyu of the game
	 * @param newDifficulty GameDifficulty.difficulties new current difficulty of game
	 */
	public void setDifficulty(GameDifficulty.difficulties newDifficulty) {
        difficulty = newDifficulty;
    }
	/**
	 * gets all the monster initialased from text file
	 * @return ArrayList<Monster> all monsters that are in file
	 */
	public ArrayList<Monster> getAllMonsters() {
		return allMonsters;
	}
	/**
	 * sets all the monsters that can be picked 
	 * @param newMonsters ArrayList<Monster> new all monsters
	 */
	public void setAllMonsters(ArrayList<Monster> newMonsters) {
		allMonsters = newMonsters;
	}
	/**
	 * gets starter monsters which are 3 random monsters from all monsters
	 * @return ArrayList<Monster> 3 random monsters from all monsters
	 */
	public ArrayList<Monster> getStarterMonsters() {
		return starterMonsters;
	}
	/**
	 * gets starter items which are 3 random items from all items
	 * @return ArrayList<Item> 3 random items from all items
	 */
	public ArrayList<Item> getStarterItems() {
		return starterItems;
	}
	/**
	 * gets store monsters from that current day
	 * @return ArrayList<Monster> 3 random monsters from all monsters
	 */
	public ArrayList<Monster> getStoreMonsters() {
		return storeMonsters;
	}
	/**
	 * gets store items from that current day
	 * @return ArrayList<item> 3 random item from all items
	 */
	public ArrayList<Item> getStoreItems() {
		return storeItems;
	}
	/**
	 * increase the day after player has slept
	 */
	public void increaseDay() {
        currentDay++;
    }
	/**
	 * gets all items that are initialised from the text file
	 * @return ArrayList<Item> 
	 */
	public ArrayList<Item> getAllItems() {
		return allItems;
	}
	public void setAllItems(ArrayList<Item> newAllItems) {
		allItems = newAllItems;
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
	public void launchMoveTeamScreen() {
		MoveTeamScreen moveTeam = new MoveTeamScreen(this);
	}
	public void setUpStore(){
		new StoreSetUp(this);
		launchStoreScreen();
	}
	public void launchStoreScreen(){
		StoreScreen store = new StoreScreen(this, this.getPlayer());
	}
	public void launchGameOverScreen() {
		GameOverScreen gameOver = new GameOverScreen(this);
	}
	public void launchRandomEvent() {
		RandomEvent random = new RandomEvent(this);
		setDaysBattles();
		launchMainScreen(random.getMonsterLeave(), random.getMonsterEnter());
	}
	public void closeSetupScreen(SetupScreen SetupWindow) {
		SetupWindow.closeWindow();
		setDaysBattles();
        launchMainScreen();
	}
	public void closeStoreScreen(StoreScreen storeScreen, String s) {
		storeScreen.closeWindow();
		getStoreItems().clear();
		getStoreMonsters().clear();
		if (s.toLowerCase().startsWith("g")){ // Check whether it is game over or not
			launchGameOverScreen();
		} else {
			launchRandomEvent();
		}
    }
	public void launchWinScreen(Battle currBattle) {
		WinBattleScreen winScreen = new WinBattleScreen(this, currBattle);
	}
	
	public void launchMainScreen() {
		MainScreen mainScreen = new MainScreen(this);
	}
	public void launchMainScreen(String s, String s2) {
		MainScreen mainScreen = new MainScreen(this, s, s2);
	}
	public void launchApplyItemScreen() {
		ApplyItemScreen apply = new ApplyItemScreen(this);
	}
	public void closeApplyItemScreen(ApplyItemScreen screen, boolean b) {
		screen.closeWindow();
		if (b) {
			launchMainScreen();
			
		} else {
			launchApplyItemScreen();
		}
		
	}
	public void closeMoveTeamScreen(MoveTeamScreen moveTeamScreen, boolean b) {
		moveTeamScreen.closeWindow();
		if (b) {
			launchMainScreen();
		} else {
			launchMoveTeamScreen();
		}
	}

	public void closeBattleScreen(BattleScreen BattleScreen, boolean b) {
		BattleScreen.closeWindow();
		Battle currBattle = BattleScreen.getCurrentBattle();
		if(b) {
			launchWinScreen(currBattle);
		} else {
			launchGameOverScreen();
		}
	}
	public void closeStoreScreen(StoreScreen screen, boolean b) {
		screen.closeWindow();
		if (b) {
			launchStoreScreen();
		}
	}
	public void closeGameOverScreen(GameOverScreen gameOverScreen) {
		gameOverScreen.closeWindow();
	}
	public void closeWinBattleScreen(WinBattleScreen winBattleScreen) {
		winBattleScreen.closeWindow();
		setUpStore();
	}
	public void closeMainScreen(MainScreen mainScreen) {
        mainScreen.closeWindow();
    }
	public void closeMainScreen(MainScreen mainScreen, int i) {
		mainScreen.closeWindow();
		launchBattleScreen(i);
    }  
	public void closeMainScreen(MainScreen mainScreen, String s) {
		mainScreen.closeWindow();
		increaseDay();
		if (s.startsWith("a")) { // Check if apply item or move monster button has been pressed
			launchApplyItemScreen();
		} else if (s.startsWith("m")) {
			launchMoveTeamScreen();
		}
	}
    public static void main(String[] args) {
        MainGame gamer = new MainGame();   
    }
	
	
}
