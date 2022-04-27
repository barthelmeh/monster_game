import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class mainGame {
    private gameDifficulty.difficulties difficulty = gameDifficulty.difficulties.MEDIUM;
    private int currentDay = 0;
    private int maxDay = 5;
    private static ArrayList<Monster> allMonsters = new ArrayList<Monster>();

    public void setDifficulty(gameDifficulty.difficulties newDifficulty) {
        difficulty = newDifficulty;
    }

    public mainGame(){
        try {
            setMonsters();
        } catch (Exception e) {
            //TODO: handle exception
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

    public gameDifficulty.difficulties getDifficulty() {
        return difficulty;
    }
    public int getMaxDay(){
        return maxDay;
    }
    public void setMaxDay(int day) {
        maxDay = day;
    }

    public int getCurrentDay() {
        return currentDay;
    }

    public void increaseDay() {
        currentDay++;
    }
    public ArrayList<Monster> getMonsters() {
        return allMonsters;
    }
	public void launchSetupScreen() {
		setupScreen setupWindow = new setupScreen(this);
	}
	public void closeSetupScreen(setupScreen SetupWindow) {
		SetupWindow.closeWindow();
	}
    public void closeMainScreen(mainScreen mainScreen) {
        mainScreen.closeWindow();
    }
    public static void main(String[] args) {
        mainGame gamer = new mainGame();
        System.out.println(gamer.getMonsters());
        gamer.launchSetupScreen();
    }

    
    
}
