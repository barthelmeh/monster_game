import java.util.ArrayList;
import java.util.Random;

public class StoreSetUp {

	private MainGame manager;
    
    public StoreSetUp(MainGame incomingManager) {
    	manager = incomingManager;
    	setAvailableMonsters();
    	setAvailableItems();
    	resetLevels(manager.getPlayer().getTeam());
    }
	
    public void resetLevels(ArrayList<Monster> team) {
		for (Monster monster : team) {
			monster.resetLevel();
		}
	}
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
            avaiableMonsters.remove(randomIndex);
        }
	}

	public void setAvailableItems() {
		ArrayList<Item> avaiableItems = manager.getAllItems();
        Random rand = new Random();
        for (int i = 0; i < 3; i++){
            int randomIndex = rand.nextInt(avaiableItems.size());
            Item randomItem = avaiableItems.get(randomIndex);
            manager.getStoreItems().add(randomItem);
            avaiableItems.remove(randomIndex);
        }
	}
}
