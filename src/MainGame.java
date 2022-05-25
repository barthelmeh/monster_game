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
			if(getCurrentDay() == 0) {
				int randomSize = rand.nextInt(1, 2);
				for (int j=0; j < randomSize; j++){
					int randomIndex = rand.nextInt(avaiable.size());
					try {
					 Monster randomMonster = avaiable.get(randomIndex).clone();
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
	 * gets all items that are initialsed from the text file
	 * @return ArrayList<Item> all items from text file
	 */
	public ArrayList<Item> getAllItems() {
		return allItems;
	}
	/**
	 * sets a new list of items for user to apply 
	 * @param newAllItems ArrayList<Item> a list of new items
	 */
	public void setAllItems(ArrayList<Item> newAllItems) {
		allItems = newAllItems;
	}
	/**
	 * Gets the current days battles
	 * @return ArrayList<Battle> a list of the current days battles
	 */
	public ArrayList<Battle> getBattles() {
		return battles;
	}
	/**
	 * Sets the current days battles
	 * @param newBattles ArrayList<Battle> a new list of current days battles
	 */
	public void setBattles(ArrayList<Battle> newBattles) {
		battles = newBattles;
	}
	/**
	 * launches the setup screen to the user
	 */
	public void launchSetupScreen() {
		new SetupScreen(this);
	}
	/**
	 * launches Battle screen to the user
	 * @param battle int index of the battle to get from getBattles list
	 */
	public void launchBattleScreen(int battle){
		new BattleScreen(this,getBattles().get(battle));
	}
	/**
	 * launches move team screen to user
	 */
	public void launchMoveTeamScreen() {
		MoveTeamScreen moveTeam = new MoveTeamScreen(this);
	}
	/**
	 * sets up the days store and then launches the store screen
	 */
	public void setUpStore(){
		new StoreSetUp(this);
		launchStoreScreen();
	}
	/**
	 * launches the store screen
	 */
	public void launchStoreScreen(){
		StoreScreen store = new StoreScreen(this, this.getPlayer());
	}
	/**
	 * launches the game over screen
	 */
	public void launchGameOverScreen() {
		GameOverScreen gameOver = new GameOverScreen(this);
	}
	/**
	 * launches random event, resets days battles and then launches main screen with strings if monster has entered/left
	 */
	public void launchRandomEvent() {
		RandomEvent random = new RandomEvent(this);
		setDaysBattles();
		launchMainScreen(random.getMonsterLeave(), random.getMonsterEnter());
	}
	/**
	 * Close setup screen to user and sets days battles then launches main screen
	 * @param SetupWindow SetUpScreen this is the screen the user has previously on
	 */
	public void closeSetupScreen(SetupScreen SetupWindow) {
		SetupWindow.closeWindow();
		setDaysBattles();
        launchMainScreen();
	}
	/**
	 * Closes store screen and if string recieved starts with g then launches game over else launch main screen 
	 * @param storeScreen StoreScreen that user was previously on
	 * @param s String to determine if game is over
	 */
	public void closeStoreScreen(StoreScreen storeScreen, String s) {
		storeScreen.closeWindow();
		getStoreItems().clear();
		getStoreMonsters().clear();
		if (s.toLowerCase().startsWith("g")){
			launchGameOverScreen();
		} else {
			launchRandomEvent();
		}
    }
	/**
	 * relaunches store screen
	 * @param screen screen that user was just on
	 * @param b check if user is done or not
	 */
	public void closeStoreScreen(StoreScreen screen, boolean b) {
		screen.closeWindow();
		if (b){
			launchStoreScreen();
		}
	}
	/**
	 * Launches win battle screen to user
	 * @param currBattle Battle to get score and coins recieved from battle
	 */
	public void launchWinScreen(Battle currBattle) {
		WinBattleScreen winScreen = new WinBattleScreen(this, currBattle);
	}
	/**
	 * launches main screen to user
	 */
	public void launchMainScreen() {
		MainScreen mainScreen = new MainScreen(this);
	}
	/**
	 * launches main screen to user
	 * @param s String text to be displayed to user if true
	 * @param s2 String text to be displayed to user if true
	 */
	public void launchMainScreen(String s, String s2) {
		MainScreen mainScreen = new MainScreen(this, s, s2);
	}
	/**
	 * Launches Apply Item Screen to user
	 */
	public void launchApplyItemScreen() {
		ApplyItemScreen apply = new ApplyItemScreen(this);
	}
	/**
	 * Closes apply item screen if user is done else relaunch screen
	 * @param screen ApplyItemScreen the user was just on
	 * @param b boolean to determine if user is done applying items
	 */
	public void closeApplyItemScreen(ApplyItemScreen screen, boolean b) {
		screen.closeWindow();
		if (b) {
			launchMainScreen();
			
		} else {
			launchApplyItemScreen();
		}
		
	}
	/**
	 * Closes move team screen if user is done else relaunch screen
	 * @param moveTeamScreen MoveTeamScreen that the user was just on
	 * @param b boolean to determine if user is done moving team around
	 */
	public void closeMoveTeamScreen(MoveTeamScreen moveTeamScreen, boolean b) {
		moveTeamScreen.closeWindow();
		if (b) {
			launchMainScreen();
		} else {
			launchMoveTeamScreen();
		}
	}
	/**
	 * Closes current battle screen to user and launches win screen if battle is won else go to game over screen
	 * @param BattleScreen BattleScreen that the user was just on
	 * @param b boolean to determine if user won the battle or not.
	 */
	public void closeBattleScreen(BattleScreen BattleScreen, boolean b) {
		BattleScreen.closeWindow();
		Battle currBattle = BattleScreen.getCurrentBattle();
		if(b) {
			launchWinScreen(currBattle);
		} else {
			launchGameOverScreen();
		}
	
	}
	/**
	 * closes the game over screen
	 * @param gameOverScreen GameOverScreen the users was just on
	 */
	public void closeGameOverScreen(GameOverScreen gameOverScreen) {
		gameOverScreen.closeWindow();
	}
	/**
	 * closes the win battle screen and launches setting up the store
	 * @param winBattleScreen WinBattleScreen that the user was just on
	 */
	public void closeWinBattleScreen(WinBattleScreen winBattleScreen) {
		winBattleScreen.closeWindow();
		setUpStore();
	}
	/**
	 * Closes the main screen to the user
	 * @param mainScreen MainScreen that the user was just on
	 */
	public void closeMainScreen(MainScreen mainScreen) {
        mainScreen.closeWindow();
    }
	/**
	 * Closes the main screen to the user and launches battle
	 * @param mainScreen MainScreen that the user was just on
	 * @param i index of the button of the battle group to deterimen that battle the user is going to fight in
	 */
	public void closeMainScreen(MainScreen mainScreen, int i) {
		mainScreen.closeWindow();
		launchBattleScreen(i);
    }  
	/**
	 * Closes the main screen to the user and launches either apply item screen or move team screen
	 * @param mainScreen MainScreen that the user was just on
	 * @param s String to determine if the button was to move team or to apply item screen
	 */
	public void closeMainScreen(MainScreen mainScreen, String s) {
		mainScreen.closeWindow();
		increaseDay();
		if (s.startsWith("a")) {
			launchApplyItemScreen();
		} else if (s.startsWith("m")) {
			launchMoveTeamScreen();
		}
	}
    public static void main(String[] args) {
        MainGame gamer = new MainGame();   
    }	
}
