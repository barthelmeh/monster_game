import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class mainGame {
    private gameDifficulty.difficulties difficulty = gameDifficulty.difficulties.MEDIUM;
    private int currentDay = 0;
    private int maxDay = 5;
    private ArrayList<Monster> allMonsters = new ArrayList<Monster>();
    private ArrayList<Monster> starterMonsters = new ArrayList<Monster>();
    private player newPlayer = new player();
    public mainGame(){
        try {
            setMonsters();
            setStarterMonsters();
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    private void setMonsters() throws FileNotFoundException {
        BufferedReader br = null;
        try {
            File file = new File("Text Files/monsters.txt");
            br = new BufferedReader(new FileReader(file));

            String monster;

            while ((monster = br.readLine()) != null){
                String[] values = monster.split(",");
                Monster obj = new Monster(values[0],Integer.parseInt(values[1]),Integer.parseInt(values[2]),Double.parseDouble(values[3]));
                allMonsters.add(obj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally { // Close the file
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void setStarterMonsters(){
        ArrayList<Monster> avaiableMonsters = getAllMonsters();
        Random rand = new Random();
        for (int i = 0; i < 3; i++){
            int randomIndex = rand.nextInt(avaiableMonsters.size());
            Monster randomMonster = avaiableMonsters.get(randomIndex);
            starterMonsters.add(randomMonster);
            avaiableMonsters.remove(randomIndex);
        }
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
        gamer.launchSetupScreen();
    }
}
