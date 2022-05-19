import java.util.ArrayList;
import java.util.Random;

public class StoreSetUp {

	private MainGame manager;
    
    public StoreSetUp(MainGame incomingManager) {
    	manager = incomingManager;
    	setAvailableMonsters();
    	setAvailableItems();
    }
	

	public void setAvailableMonsters() {
		ArrayList<Monster> avaiableMonsters = manager.getAllMonsters();
        Random rand = new Random();
        for (int i = 0; i < 3; i++){
            int randomIndex = rand.nextInt(avaiableMonsters.size());
            Monster randomMonster = avaiableMonsters.get(randomIndex);
            manager.getStoreMonsters().add(randomMonster);
            avaiableMonsters.remove(randomIndex);
        }
	}

	public void setAvailableItems() {
		ArrayList<Item> avaiableItems = manager.getAllItems();
        Random rand = new Random();
        for (int i = 0; i < 3; i++){
        	System.out.println(avaiableItems.size());
            int randomIndex = rand.nextInt(avaiableItems.size());
            Item randomItem = avaiableItems.get(randomIndex);
            System.out.println(randomItem.getItemName());
            manager.getStoreItems().add(randomItem);
            avaiableItems.remove(randomIndex);
        }
	}
}
