import java.util.ArrayList;

public class StoreSetUp {
    private ArrayList<Monster> availableMonsters;
    private ArrayList<HealthItem> availableItems;
	private MainGame manager;
    
    public StoreSetUp(MainGame incomingManager) {
    	manager = incomingManager;
    	
    }

	public ArrayList<Monster> getAvailableMonsters() {
		return availableMonsters;
	}

	public void setAvailableMonsters(ArrayList<Monster> newAvailableMonsters) {
		availableMonsters = newAvailableMonsters;
	}

	public ArrayList<HealthItem> getAvailableItems() {
		return availableItems;
	}

	public void setAvailableItems(ArrayList<HealthItem> newAvailableItems) {
		availableItems = newAvailableItems;
	}
}
