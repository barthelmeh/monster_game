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
    public Difficulty getDifficulty(){
        Difficulty dif = "Difficulty " + System.console().readLine();
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