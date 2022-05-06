public class HealthItem implements Item {
	private String itemName; 
    private double itemIncrease;
    private int itemCost;
    
    public HealthItem(String name, double increase , int cost){
		itemName = name;
		itemIncrease = increase;
		itemCost = cost;
	}

	public void applyItem(Monster monster) {
		int currentHealth = monster.getMonsterCurrentHealth();
		int maxHealth = monster.getMonsterMaxHealth();

		int newHealth = (int) (currentHealth + (currentHealth*itemIncrease));

		if(newHealth > maxHealth) {
			newHealth = maxHealth;
		}
		
		monster.setCurrentHealth(newHealth);
		
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
