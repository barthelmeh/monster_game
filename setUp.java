import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class setUp {
    

    private ArrayList<Monster> starterMonsters = new ArrayList<Monster>();
    private ArrayList<Monster> avaiableMonsters = new ArrayList<Monster>();
    public static String getPlayerName(){
        String name = "Name: " + System.console().readLine();
        return name;
    }
    public gameDifficulty.difficulties getDifficulty(){
        String user_input = System.console().readLine();
        gameDifficulty.difficulties dif;
        switch(user_input) {
            case "easy":
                dif = gameDifficulty.difficulties.EASY;
                break;
            case "medium":
                dif = gameDifficulty.difficulties.MEDIUM;
                break;
            case "hard":
                dif = gameDifficulty.difficulties.HARD;
                break;
            default:
                dif = gameDifficulty.difficulties.MEDIUM;
        }

        return dif;
    }
    public Monster chooseMonster(){
        Random rand = new Random();
        for (int i=0; i<3;  i++){
            int randomIndex = rand.nextInt(avaiableMonsters.size());
            Monster randomElemet = avaiableMonsters.get(randomIndex);
            avaiableMonsters.remove(randomIndex);
            starterMonsters.add(randomElemet);
        }
    }
    public static void main(String[] args) {
        System.out.println(getPlayerName());
    }
}