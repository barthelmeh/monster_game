import java.util.ArrayList;
import java.util.Random;

public class Battle {
    private ArrayList<Monster> enemyTeam = new ArrayList<Monster>();
    private ArrayList<Monster> playerTeam = new ArrayList<Monster>();
    private boolean playerTurn = true; // Player goes first.
    private int coinsGained;
    private double coinMult = 1;
    private MainGame manager;

    public Battle(ArrayList<Monster> team, Player playerManager, MainGame mainManager) {
    	enemyTeam = team;
        playerTeam = playerManager.getTeam();
        manager = mainManager;
        int totalHealthDam = 0;
        for(Monster m : enemyTeam) {
        	totalHealthDam += m.getMonsterCurrentHealth();
        	totalHealthDam += m.getDamage();
        }
        coinsGained = totalHealthDam / 7;
    	resetLevels(playerTeam);
    }
    
    public void resetLevels(ArrayList<Monster> team) {
		for (Monster monster : team) {
			monster.resetLevel();
		}
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
    
    public int getCoinsGained() {
    	GameDifficulty.difficulties currDifficulty = manager.getDifficulty();
    	int currDay = manager.getCurrentDay();
    	switch(currDifficulty) {
    		case HARD:
    			coinMult += 0.5;
    			break;
    		case MEDIUM:
    			coinMult += 0.75;
    			break;
    		case EASY:
    			coinMult += 1;
    			break;
    	};
    	
    	if(currDay < 2) {
    		coinMult += 0.25;
    	} else if(currDay < 5) {
    		coinMult += 0.5;
    	} else if(currDay < 8) {
    		coinMult += 1;
    	} else {
    		coinMult += 1.25;
    	}
    	
    	return (int) (Double.valueOf(coinsGained) * coinMult);
    	
    }
    
    
    public void runBattle(BattleScreen bsManager){
    	
    	Random rand = new Random(); // For critical chance
    	
    	Monster enemyMonster = enemyTeam.get(0);
        Monster playerMonster = playerTeam.get(0);
        
        int enemyCurrentHealth = enemyMonster.getMonsterCurrentHealth();
        int playerCurrentHealth = playerMonster.getMonsterCurrentHealth();
        int enemyDamage = enemyMonster.getDamage();
        int playerDamage = playerMonster.getDamage();
        double playerCritChance = playerMonster.getCriticalStrike();
        final double critMul = 1.75;
    	
    	if(playerTurn) {
    		
    		// Player Crits 
    		double critChance = rand.nextDouble(); // Random int between 0 and 100 inclusive
    		if(critChance < playerCritChance) {
    			playerDamage *= critMul;
    		}
    		
    		enemyCurrentHealth -= playerDamage;
            enemyMonster.setCurrentHealth(enemyCurrentHealth);
            
            if(enemyCurrentHealth <= 0) {
            	enemyTeam.remove(0);
            	if(enemyTeam.size() == 0) {
            		// Player has won the battle
            		bsManager.winWindow();
            	}
            }
            
            // Update the labels
            bsManager.updateMonsters("Enemy");
            
            // Change turn
            setCurrentTurn(false);
            
    	} else { // Enemy turn
    		playerCurrentHealth -= enemyDamage;
            playerMonster.setCurrentHealth(playerCurrentHealth);
            if(playerCurrentHealth <= 0) {
                playerTeam.remove(0);
                if(playerTeam.size() == 0) {
                	// Player has lost
                	bsManager.loseWindow();
                }
            }
            
            // Update the labels
            bsManager.updateMonsters("Player");
            
            // Change turn
            setCurrentTurn(true);
    	}
    }
}
