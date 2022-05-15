import java.util.*;

public class Battle {
    private ArrayList<Monster> enemyTeam = new ArrayList<Monster>();

    public Battle(ArrayList<Monster> team) {
    	enemyTeam = team;
    	runBattle();
    }
    
    public ArrayList<Monster> getTeam() {
        return enemyTeam;
    }

    public void setTeam(ArrayList<Monster> team) {
        enemyTeam = team;
    }
    
    public void runBattle() {
    	
    }

    
}
