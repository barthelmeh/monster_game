import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Battle {
    private ArrayList<Monster> enemyTeam = new ArrayList<Monster>();
    private ArrayList<Monster> playerTeam = new ArrayList<Monster>();
    private boolean playerTurn = true; // Player goes first.

    public Battle(ArrayList<Monster> team, Player playerManager) {
    	enemyTeam = team;
        playerTeam = playerManager.getTeam();
    	
    }
    
    public ArrayList<Monster> getTeam() {
        return enemyTeam;
    }

    public void setTeam(ArrayList<Monster> team) {
        enemyTeam = team;
    }
    
    public boolean getPlayerTurn() {
    	return playerTurn;
    }
    
    public void setCurrentTurn(boolean isPlayersTurn) {
    	playerTurn = isPlayersTurn;
    }
    
    public void runBattle(BattleScreen bsManager){
    	
    	Monster enemyMonster = enemyTeam.get(0);
        Monster playerMonster = playerTeam.get(0);
        
        int enemyCurrentHealth = enemyMonster.getMonsterCurrentHealth();
        int playerCurrentHealth = playerMonster.getMonsterCurrentHealth();
        int enemyDamage = enemyMonster.getDamage();
        int playerDamage = playerMonster.getDamage();
    	
    	if(playerTurn) {
    		
    		enemyCurrentHealth -= playerDamage;
            enemyMonster.setCurrentHealth(enemyCurrentHealth);
            
            if(enemyCurrentHealth <= 0) {
            	enemyTeam.remove(0);
            	if(enemyTeam.size() == 0) {
            		// Player has won the battle
            	}
            }
            
            // Update the labels
            bsManager.updateMonsters("Enemy");
            
            // Change turn
            setCurrentTurn(false);
            
    	} else { // Enemy turn
    		playerCurrentHealth -= enemyDamage;
            playerMonster.setCurrentHealth(playerCurrentHealth);
            if(playerCurrentHealth < 0) {
                playerTeam.remove(0);
                if(playerTeam.size() == 0) {
                	// Player has lost
                }
            }
            
            // Update the labels
            bsManager.updateMonsters("Player");
            
            // Change turn
            setCurrentTurn(true);
    	}
    }
}
