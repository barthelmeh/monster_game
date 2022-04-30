
import java.util.ArrayList;


public class mainGame {
    private gameDifficulty.difficulties difficulty = gameDifficulty.difficulties.MEDIUM;
    private int currentDay = 0;
    private int maxDay = 5;
    private ArrayList<Monster> allMonsters = new ArrayList<Monster>();
    private ArrayList<Monster> starterMonsters = new ArrayList<Monster>();
    private player newPlayer = new player();

    public mainGame(){
        new setUp(this);
    }
    public int getDaysLeft() {
    	return getMaxDay()-getCurrentDay();
    }
    public player getPlayer(){
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
	public gameDifficulty.difficulties getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(gameDifficulty.difficulties newDifficulty) {
        difficulty = newDifficulty;
    }
	public ArrayList<Monster> getAllMonsters() {
		return allMonsters;
	}
	public ArrayList<Monster> getStarterMonsters() {
		return starterMonsters;
	}
	public void increaseDay() {
        currentDay++;
    }
    public void addToAllMonsters(Monster monster){
        allMonsters.add(monster);
    }
	public void launchSetupScreen() {
		setupScreen setupWindow = new setupScreen(this);
	}
    public void closeSetupScreen(setupScreen SetupWindow) {
		SetupWindow.closeWindow();
        launchMainScreen();
	}
    public void launchMainScreen(){
        mainScreen mainWindow = new mainScreen(this);
    }
	
    public void closeMainScreen(mainScreen mainScreen) {
        mainScreen.closeWindow();
    }
      
    public static void main(String[] args) {
        mainGame gamer = new mainGame();
        System.out.println(gamer.getAllMonsters());
        
    }
}
