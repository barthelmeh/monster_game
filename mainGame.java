import java.util.ArrayList;

public class mainGame {
    private gameDifficulty.difficulties difficulty = gameDifficulty.difficulties.MEDIUM;
    private int currentDay = 0;
    private int maxDay = 5;
    private ArrayList<Monsters> allMonsters;

    public void setDifficulty(difficulties newDifficulty) {
        difficulty = newDifficulty;
    }
    
    public difficulties getDifficulty() {
        return difficulty;
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


    public static void main(String[] args) {
        System.out.println("TEST");
    }
}
