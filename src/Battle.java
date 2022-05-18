import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Battle {
    private ArrayList<Monster> enemyTeam = new ArrayList<Monster>();
    private ArrayList<Monster> playerTeam = new ArrayList<Monster>();

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
    
    public void runBattle(BattleScreen bsManager){
    	do {
            Monster enemyMonster = enemyTeam.get(0);
            Monster playerMonster = playerTeam.get(0);
            
            int enemyCurrentHealth = enemyMonster.getMonsterCurrentHealth();
            int playerCurrentHealth = playerMonster.getMonsterCurrentHealth();
            int enemyDamage = enemyMonster.getDamage();
            int playerDamage = playerMonster.getDamage();

            // Player Attacks First
            enemyCurrentHealth -= playerDamage;
            enemyMonster.setCurrentHealth(enemyCurrentHealth);
            
            if(enemyCurrentHealth > 0) {
                // Now Enemy Attacks
                playerCurrentHealth -= enemyDamage;
                playerMonster.setCurrentHealth(playerCurrentHealth);
                if(playerCurrentHealth < 0) {
                    playerTeam.remove(0);
                    bsManager.updateMonsters("Player");
                    
                }
            } else {
                enemyTeam.remove(0);
                bsManager.updateMonsters("Enemy");
            }


        } while(enemyTeam.size() > 0 && playerTeam.size() > 0);
        System.out.println("finished battle");
    }

    
}
