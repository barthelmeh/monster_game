package main;
import java.util.ArrayList;
import java.util.Random;

public class Battle {
    private ArrayList<Monster> enemyTeam = new ArrayList<Monster>();
    private ArrayList<Monster> playerTeam = new ArrayList<Monster>();
    private boolean playerTurn = true; // Player goes first.
    private int coinsGained;
    private int scoreGained;
    private double scoreMult;
    private double coinMult = 1;
    private MainGame manager;
    private int totalHealthDam;
	/**
	 * Class Constructor specifying the Enemy Team, Player and MainGame as well as setting the battles score and coins and resets whether monster has levelled up.
	 * @param newEnemyTeam the enemy team play is versing
	 * @param playerManager the user
	 * @param mainManager the main game running everything
	 */
    public Battle(ArrayList<Monster> newEnemyTeam, Player playerManager, MainGame mainManager) {
    	enemyTeam = newEnemyTeam;
        playerTeam = playerManager.getTeam();
        manager = mainManager;
		setCoinAndScore();
    	manager.getPlayer().resetLevels();
    }
	/**
	 * Sets coins and score that can be received from this battle.
	 */
    public void setCoinAndScore(){
		totalHealthDam = 0;
        for(Monster m : enemyTeam) {
        	totalHealthDam += m.getMonsterCurrentHealth();
        	totalHealthDam += m.getDamage();
        }
        coinsGained = totalHealthDam / 7;
        scoreGained += totalHealthDam / 3;
        manager.getPlayer().resetLevels();
    }
    
	/**
	 * Gets the enemy team to use in battle.
	 * @return enemy team that user is fighting.
	 */
	public ArrayList<Monster> getEnemyTeam() {
        return enemyTeam;
    }
	/**
	 * Sets the enemy team that is used in battle.
	 * @param newEnemyTeam enemy team that user is fighting.
	 */
    public void setTeam(ArrayList<Monster> newEnemyTeam) {
        enemyTeam = newEnemyTeam;
    }
    /**
	 * Gets whether or not it is the users turn.
	 * @return a boolean true if is players turn false if not.
	 */
    public boolean getPlayerTurn() {
    	return playerTurn;
    }
    /**
	 * Sets player turn whether to start or not.
	 * @param isPlayersTurn boolean that sets who attacks first.
	 */
    public void setCurrentTurn(boolean isPlayersTurn) {
    	playerTurn = isPlayersTurn;
    }
    /**
	 * Gets difficulty and day and returns a multiplier to determine receive and coins from this battle.
	 * @return integer to be used to be multiplied by enemy teams total damage.
	 */
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
    	// Send coins gained info to player	
    	int gainedCoins = (int) (Double.valueOf(coinsGained) * coinMult);
    	manager.getPlayer().addMoney(gainedCoins);
    	return gainedCoins;
    	
    }
    /**
	 * Gets difficulty and current day to determine the score multiplier to be used to determine the score for this battle.
	 * @return integer that is multiplied by enemy teams total damage to get score.
	 */
    public int getScoreGained() {
    	GameDifficulty.difficulties currDifficulty = manager.getDifficulty();
    	int currDay = manager.getCurrentDay();
    	switch(currDifficulty) {
    		case HARD:
    			scoreMult += 5;
    			break;
    		case MEDIUM:
    			scoreMult += 3;
    			break;
    		case EASY:
    			scoreMult += 1.5;
    			break;
    	};
    	
    	if(currDay < 2) {
    		scoreMult += 1;
    	} else if(currDay < 5) {
    		scoreMult += 2;
    	} else if(currDay < 8) {
    		scoreMult += 3;
    	} else {
    		scoreMult += 4;
    	}
    	// Send score gained info to player
    	int gainedScore = (int) (Double.valueOf(scoreGained) * scoreMult);
    	manager.getPlayer().increaseScore(gainedScore);
    	return gainedScore;
    }
    
    /**
	 * Runs battle behind the battle screen.
	 * @param bsManager battle screen used to update labels to simulate fight.
	 */
    public void runBattle(BattleScreen bsManager){
    	
    	Random rand = new Random(); // For critical chance
    	
    	Monster enemyMonster = enemyTeam.get(0);
        Monster playerMonster = playerTeam.get(0);
        
        double enemyCurrentHealth = enemyMonster.getMonsterCurrentHealth();
        double playerCurrentHealth = playerMonster.getMonsterCurrentHealth();
        double enemyDamage = enemyMonster.getDamage();
        double playerDamage = playerMonster.getDamage();
        double playerCritChance = playerMonster.getCriticalStrike();
        final double critMul = 1.75;
    	
    	if(playerTurn) {
    		
    		// Player Crits 
    		double critChance = rand.nextDouble(); // Random int between 0 and 100 inclusive
    		if(critChance < playerCritChance) {
    			bsManager.updateCritLabel(true, playerMonster.getName());
    			playerDamage *= critMul;
    		} else {
    			bsManager.updateCritLabel(false, playerMonster.getName());
    		}
    		
    		enemyCurrentHealth -= playerDamage;
            enemyMonster.setCurrentHealth(enemyCurrentHealth);
            
            if(enemyCurrentHealth <= 0) {
            	enemyTeam.remove(0);
            	if(enemyTeam.size() == 0) {
            		// Player has won the battle
            		bsManager.checkDay();
            	}
            }
            
            // Update the labels
            bsManager.updateMonsters("Enemy");
            
            // Change turn
            setCurrentTurn(false);
            
    	} else { // Enemy turn
    		bsManager.updateCritLabel(false, playerMonster.getName());
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
