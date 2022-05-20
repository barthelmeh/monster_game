public class MaxHealthItem implements Item {
    private String itemName; 
    private double itemIncrease;
    private int itemCost;
    
    public MaxHealthItem(String name, double increase , int cost){
		itemName = name;
		itemIncrease = increase;
		itemCost = cost;
	}

	public void applyItem(Monster monster) {
		double maxHealth = monster.getMonsterMaxHealth();
		double currentHealth = monster.getMonsterCurrentHealth();
		double newHealth = (maxHealth + (maxHealth*itemIncrease));
		monster.setCurrentHealth((currentHealth + (currentHealth*itemIncrease)));
		monster.setMaxHealth(newHealth);
	}

	public String getItemName() {
		return itemName;
	}

	public double getItemIncrease() {
		return itemIncrease;
	}

	public int getItemCost() {
		return itemCost;
	}

	public void setItemName(String newItemName) {
		itemName = newItemName;
	}

	public void setItemIncrease(double newItemIncrease) {
		itemIncrease = newItemIncrease;
	}

	public void setItemCost(int newItemCost) {
		itemCost = newItemCost;
	}
}
