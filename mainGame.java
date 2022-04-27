import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class mainGame {
    private gameDifficulty.difficulties difficulty = gameDifficulty.difficulties.MEDIUM;
    private int currentDay = 0;
    private int maxDay = 5;
    private static ArrayList<Monster> allMonsters;

    public void setDifficulty(gameDifficulty.difficulties newDifficulty) {
        difficulty = newDifficulty;
    }

    public mainGame(){
        try {
            setMonsters();
        } catch (Exception e) {
            //TODO: handle exception
            
        }
        
    }

    private void setMonsters() throws FileNotFoundException {
        File file = new File("Text Files/monsters.txt");
        Scanner sc = new Scanner(file);
        String monster;
        while (sc.hasNextLine()){
            monster = sc.nextLine();
            String[] values = monster.split(",");
            Monster obj = new Monster(values[0],Integer.parseInt(values[1]),Integer.parseInt(values[2]),Integer.parseInt(values[3]));
            allMonsters.add(obj);

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
    public static ArrayList<Monster> getMonsters() {
        return allMonsters;
    }
    
    public static void main(String[] args) {
        mainGame gamer = new mainGame();

    }
    
}
