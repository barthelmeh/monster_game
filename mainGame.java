import gameDifficulty.difficulties;
import java.util.ArrayList;

public class mainGame {
    private difficulties difficulty = MEDIUM;
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
        return current_day;
    }

    public void increaseDay() {
        current_day++;
    }


    public static void main(String[] args) {
        System.out.println("TEST");
    }
}
