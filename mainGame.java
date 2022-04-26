import java.util.ArrayList;

public class mainGame {
    private gameDifficulty.difficulties difficulty = gameDifficulty.difficulties.MEDIUM;
    private int currentDay = 0;
    private int maxDay = 5;
    private static ArrayList<Monster> allMonsters;

    public void setDifficulty(gameDifficulty.difficulties newDifficulty) {
        difficulty = newDifficulty;
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
        while (getCurrentDay() < maxDay){

        }
    }

    
}
