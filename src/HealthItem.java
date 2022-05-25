public class HealthItem implements Item {
	private String itemName; 
    private double itemIncrease;
    private int itemCost;
    /**
	 * Class Constructor that specifies name, increase percentage and cost of item
	 * @param name String name of item
	 * @param increase Double increase percentage of item that is to be applied to user
	 * @param cost int cost of item 
	 */
    public HealthItem(String name, double increase , int cost){
		itemName = name;
		itemIncrease = increase;
		itemCost = cost;
	}
	/**
	 * Applys item to a given monster
	 * @param monster Monster the monster that is getting the item
	 */
	public void applyItem(Monster monster) {
		double currentHealth = monster.getMonsterCurrentHealth();
		double maxHealth = monster.getMonsterMaxHealth();

		double newHealth = (currentHealth + (currentHealth*itemIncrease));

		if(newHealth > maxHealth) {
			newHealth = maxHealth;
		}
		
		monster.setCurrentHealth(newHealth);
		
	}
	/**
	 * gets Item name to be displayed to user
	 * @return String item name
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * gets Item increase percentage to be displayed to user
	 * @return Double item increase percentage
	 */
	public double getItemIncrease() {
		return itemIncrease;
	}
	/**
	 * gets Item cost to be displayed to user
	 * @return Int item cost
	 */
	public int getItemCost() {
		return itemCost;
	}
	/**
	 * Sets the items name
	 * @param newItemName String new items name
	 */
	public void setItemName(String newItemName) {
		itemName = newItemName;
	}
	/**
	 * Sets the items increase percentage
	 * @param newItemIncrease Double new increase percentage
	 */
	public void setItemIncrease(double newItemIncrease) {
		itemIncrease = newItemIncrease;
	}
	/**
	 * Sets the items cost
	 * @param newItemCost Int new cost of item
	 */
	public void setItemCost(int newItemCost) {
		itemCost = newItemCost;
	}
}
