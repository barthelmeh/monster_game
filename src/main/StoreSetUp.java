package main;
import java.util.ArrayList;
import java.util.Random;

public class StoreSetUp {

	private MainGame manager;
    /**
	 * Class Constructor Specifying MainGame 
	 * @param incomingManager MainGame runnning in the background
	 */
    public StoreSetUp(MainGame incomingManager) {
    	manager = incomingManager;
    	setAvailableMonsters();
    	setAvailableItems();
    	resetLevels(manager.getPlayer().getTeam());
    }
	/**
	 * Resets all monsters hasLevelledUp check 
	 * @param team ArrayList<Monster> of player's current team
	 */
    public void resetLevels(ArrayList<Monster> team) {
		for (Monster monster : team) {
			monster.resetLevel();
		}
	}
	/**
	 * Sets the avaiable monsters that can be seen for that day 3 random monsters
	 */
	public void setAvailableMonsters() {
		ArrayList<Monster> avaiableMonsters = new ArrayList<Monster>(manager.getAllMonsters());
        Random rand = new Random();
        for (int i = 0; i < 3; i++){
            int randomIndex = rand.nextInt(avaiableMonsters.size());
            try {
				 Monster randomMonster = avaiableMonsters.get(randomIndex).clone();
				 manager.getStoreMonsters().add(randomMonster);
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}
            avaiableMonsters.remove(randomIndex); // Remove current monster from list so no duplicates
        }
	}
	/**
	 * Sets the avaiable items in store for that day 3 random items
	 */
	public void setAvailableItems() {
		ArrayList<Item> avaiableItems = new ArrayList<Item>(manager.getAllItems());
        Random rand = new Random();
        for (int i = 0; i < 3; i++){
            int randomIndex = rand.nextInt(avaiableItems.size());
			Item randomItem = avaiableItems.get(randomIndex);
			manager.getStoreItems().add(randomItem);
            avaiableItems.remove(randomIndex); // No duplictes
        }
	}
}
